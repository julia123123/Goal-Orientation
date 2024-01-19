import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


public class GamePage extends JFrame{
    
    // public static final int WIDTH = 1280;
    // public static final int HEIGHT = 720;
    // public static final int WIDTH = 700;
    // public static final int HEIGHT = 500;
    // public static final int SMALL_WIDTH = 700;
    // public static final int SMALL_HEIGHT = 500;
    public static final int WIDTH = 1400;
    public static final int HEIGHT = 720;
    public static final int SMALL_WIDTH = 1300;
    public static final int SMALL_HEIGHT = 720;
    private JButton center_1, center_2, center_3, center_4, center_5, center_6, center_7, center_8, down_1, down_2, down_3, down_4, down_5, down_6, down_7;
    private JTextField _score;
    private JLabel textLabel;
    private JPanel gamePanel;
    private JPanel topPanel; //function
    private JPanel upperPanel;
    private JPanel centerPanel; //sea
    private JPanel downPanel; //player
    // private JPanel drawStrawPanel;//straw
    // private CardLayout switchPanel;
    private ArrayList<String> cardText = new ArrayList<String>();
    private ArrayList<Integer> result = new ArrayList<Integer>();
    // private ArrayList<Integer> deck = new ArrayList<Integer>();
    private ArrayList<Integer> deskTopCard = new ArrayList<Integer>();
    private ArrayList<Integer> deckCard = new ArrayList<Integer>(); //the card that player turn on.
    private ArrayList<Integer> handCard = new ArrayList<Integer>(); //use to pair
    private ArrayList<Integer> deskCard = new ArrayList<Integer>(); //use to pair
    private ArrayList<Integer> handCardNum = new ArrayList<Integer>();
    private ArrayList<Integer> deskCardNum = new ArrayList<Integer>(); //whole deck
    private ArrayList<Integer> role1Hand = new ArrayList<Integer>();
    private ArrayList<Integer> role1Num = new ArrayList<Integer>();
    private ArrayList<Integer> haNum = new ArrayList<Integer>();
    private ArrayList<Integer> deNum = new ArrayList<Integer>();
    public static ArrayList<Integer[]> player1Collected = new ArrayList<Integer[]>();
    private DrawStraw strawResult;
    public static RoleInfo roleInf;
    private CardInfo cardInf;
    private CardText cardMessage;
    // private MakeButton makeBtn = new MakeButton();
    public static int roleIndex = 0;
    private boolean draw = false;
    private boolean handClick = false;
    private boolean deskClick = false;
    private boolean isDeck = false;
    private boolean emptyClick = false;

    private class CheckExit implements WindowListener{
        public void windowOpened(WindowEvent e){
        }
        public void windowClosing(WindowEvent e){
            ConfirmWindow checker = new ConfirmWindow();
            checker.setVisible(true);
        }
        public void windowClosed(WindowEvent e){
        }
        public void windowIconified(WindowEvent e){
        }
        public void windowDeiconified(WindowEvent e){
        }
        public void windowActivated(WindowEvent e){
        }
        public void windowDeactivated(WindowEvent e){
        }
    }

    /*************************************************
    The window will pop-up when you close the game.
    *************************************************/
    public class ConfirmWindow extends JFrame implements ActionListener{

        public ConfirmWindow(){
        
            setSize(SMALL_WIDTH, SMALL_HEIGHT); 
//          getContentPane().setBackground(Color.PINK); //do somthing more
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            ImageIcon background=new ImageIcon("Resource/exitpage.png");
            JLabel label1 = new JLabel(background);
            label1.setBounds(0,0,WIDTH,HEIGHT);
            add(label1);

            JPanel confirmButtonPanel = new JPanel();
            confirmButtonPanel.setOpaque(false);
            confirmButtonPanel.setLayout(new FlowLayout());

            JButton confirmExitButton = new JButton("Exit");
            confirmExitButton.addActionListener(this);
            confirmButtonPanel.add(confirmExitButton);

            JButton confirmCancelButton = new JButton("Cancel");
            confirmCancelButton.addActionListener(this);
            confirmButtonPanel.add(confirmCancelButton);

            add(confirmButtonPanel, BorderLayout.SOUTH);
        }

        public void actionPerformed(ActionEvent e){
            String actionCommand = e.getActionCommand();

            if(actionCommand.equals("Exit")){
                System.exit(0);
            }else if(actionCommand.equals("Cancel")){
                dispose();
            }else{
                System.out.println("Unexpected Error in Confirm Window.");
            }
        }
    }
    /*************************************************
    GamePage constructor.
    *************************************************/
    public GamePage(){
        setSize(WIDTH, HEIGHT);
        // setResizable(false);
        setTitle("Poker Card Chinese Rummy");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new CheckExit());

        ImageIcon imageIcon = new ImageIcon("Resource/images.png"); // background pic
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(1400, 720,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);

        JLabel la=new JLabel(imageIcon);
        // JPanel la=new JPanel();
        // la.setBackground(Color.BLACK);
        add(la);

        this.roleInf = new RoleInfo();
        System.out.println(roleInf.getRole(0)+", "+roleInf.getScore(0)+", "+roleInf.getCardList(0));
        this.cardInf = new CardInfo();
        try {
            cardInf.Load("card.txt");
        }catch(IOException e){
            e.printStackTrace();
        }
        this.cardMessage = new CardText("cardText.txt");
        cardText = cardMessage.getCardText();


        // System.out.println("cardValue"+cardInf.getCid(0));
        /**/
        // this.gamePanel = new JPanel();
        // gamePanel.setLayout(switchPanel);
        /**/
        la.setLayout(new BorderLayout());
        la.add(this.createTopPanel());
        la.add(topPanel, BorderLayout.NORTH);

        JPanel jp=new JPanel();
        jp.setOpaque(false);
        jp.setLayout(new GridLayout(3,1));
        
        this.strawResult = new DrawStraw(result, deskCardNum);
        // this.switchPanel = new CardLayout();
        // System.out.println(strawResult.getRole1Order());
        // while(true){
            // if(!draw){
                // add(this.createDrawStrawPanel(), BorderLayout.CENTER);
                // add(drawStrawPanel);
            // }else if(draw){

        jp.add(this.createUpperPanel());
        jp.add(upperPanel);
        upperPanel.setOpaque(false);
        // JPanel newey = new JPanel();
        // jp.add(newey);
        // newey.setOpaque(false);
        jp.add(this.createCenterPanel());
        jp.add(centerPanel);
        centerPanel.setOpaque(false);
        jp.add(this.createDownPanel());
        jp.add(downPanel);
        downPanel.setOpaque(false);

        la.add(jp,BorderLayout.CENTER);
                // break;
            // }
        // }
        // center_1.setEnabled(false);
        

    }

    /**********************************************************************
    The gamePanel
    **********************************************************************/
    // public JPanel createGamePanel(){
    //     GridBagConstraints c = new GridBagConstraints();
    // }
    /**********************************************************************
    The upPanel include of Menu Button and Score textArea(editable(false)).
    **********************************************************************/
    public JPanel createTopPanel(){
        this.topPanel = new JPanel();
        // upPanel.setBackground(Color.LIGHT_GRAY);// set color
        
        // topPanel.setBackground(Color.YELLOW);
        // add(topPanel);
        topPanel.setOpaque(false);
        // topPanel.setLayout(null);
        topPanel.setLayout(new GridLayout(1,8));

        
        
        JButton top1 = new JButton("MENU");
        top1.setBackground(new Color(255, 255, 204));
        // top1.setBorder(null);
        // top1.setContentAreaFilled(false);
        top1.setFocusPainted(false);
        top1.setBounds(0,0,15,3);
        top1.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) {    
                Menupage menu=new Menupage();
                menu.setVisible(true);
            }
        } );         
        topPanel.add(top1);

        JButton topwin = new JButton("Win");
        topwin.setBackground(new Color(255, 255, 210));
        topwin.setFocusPainted(false);
        topwin.setBounds(0,15,15,3);
        topwin.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) {    
                Win menu1=new Win(roleInf);
                menu1.setVisible(true);
            }
        } );         
        topPanel.add(topwin);

        JPanel top2 = new JPanel();
        top2.setOpaque(false);      
        // top2.setBackground(Color.GREEN);     
        topPanel.add(top2);
        
        JPanel top3 = new JPanel();
        top3.setOpaque(false);      
        // top3.setBackground(Color.BLUE);      
        topPanel.add(top3);
        
        JPanel top4 = new JPanel();
        top4.setOpaque(false);      
        // top4.setBackground(Color.BLACK);     
        topPanel.add(top4);
        
        JPanel top5 = new JPanel();
        top5.setOpaque(false);      
        // top5.setBackground(Color.BLUE);      
        topPanel.add(top5);

        JPanel top6 = new JPanel();
        top6.setOpaque(false);      
        // top5.setBackground(Color.BLUE);      
        topPanel.add(top6);

        JPanel top7 = new JPanel();
        top7.setOpaque(false);      
        // top5.setBackground(Color.BLUE);      
        topPanel.add(top7);

        // JPanel up8 = new JPanel();
        // up8.setOpaque(false);      
        // // up5.setBackground(Color.BLUE);      
        // upPanel.add(up8);
        JPanel text = new JPanel();
        // text.add(new JLabel("Score"));
        text.setBackground(new Color(255, 255, 204));
        _score = new JTextField("0 points", 12);
        _score.setBackground(new Color(255, 255, 204));
        _score.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font f = new Font("",Font.BOLD, 15);
        // UIManager.put("TextField.font", f);
        _score.setFont(f);
        _score.setHorizontalAlignment(JTextField.CENTER);
        // _score.setBounds(0,0,15,3);
        _score.setEditable(false);
        text.add(_score);
        topPanel.add(text, BorderLayout.CENTER);

        return topPanel;
    }
    /*************************************************************************
    The upperPanel include of the deck of cards, the card that ready to pair.
    *************************************************************************/
    public JPanel createUpperPanel() {
        this.upperPanel = new JPanel();
        upperPanel.setLayout(new GridBagLayout());//the distance between cards
        // upperPanel.setBackground(new Color(0,0,255));
        upperPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        textLabel = new JLabel();
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Verdana",1,20));
        // textLabel.setText("Player2 is playing...");
        upperPanel.add(textLabel);

        return upperPanel;
    }

    /*************************************************************************
    The centerPanel include of the deck of cards, the card that ready to pair.
    *************************************************************************/
    public JPanel createCenterPanel() {
        this.centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 8,10,0));//the distance between cards
        centerPanel.setBackground(new Color(0,0,255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        System.out.println("raw deck: " + deskCardNum);
        for(int zero = 0; zero<4; zero++){
            deskTopCard.add(0);
        }
        for(int i = 0; i<4; i++){
            deskTopCard.add(deskCardNum.get(0));
            System.out.println("desk Card "+i+" : "+deskTopCard.get(i+4));
            deskCardNum.remove(0);
        }
        // }
        System.out.println("deskCard" + deskTopCard);
        System.out.println("whole deck: " + deskCardNum);

        JButton deckButton = new JButton();
        deckButton.setActionCommand("Deck");
        Icon deckIcon = new ImageIcon(new ImageIcon("Resource/deck.png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        deckButton.setIcon(deckIcon);
        deckButton.setBorderPainted(false);
        deckButton.setContentAreaFilled(false);
        deckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = e.getActionCommand();
                isDeck = true;
                deskTopCard.add(deskCardNum.get(0));
                System.out.println(deskTopCard);
                deskCardNum.remove(0);
                System.out.println(action);
            }
        });
        centerPanel.add(deckButton);

        center_1 = new JButton();
        // center_1.setFocusPainted(false);
        // center_1.setOpaque(false);
        center_1.setBorderPainted(false);
        center_1.setContentAreaFilled(false);
        center_1.addActionListener(new buttonListenerCard());
        // center_1.addActionListener(new buttonListenerCard2());
        center_1.setActionCommand("0");
        // Icon icon1 = new ImageIcon("Resource/card_1.png");
        // center_1.setIcon(icon1);
        centerPanel.add(center_1);
        // System.out.println("Add center_1");

        center_2 = new JButton();
        center_2.setBorderPainted(false);
        center_2.setContentAreaFilled(false);
        center_2.addActionListener(new buttonListenerCard());
        // center_2.addActionListener(new buttonListenerCard2());
        center_2.setActionCommand("0");
        // Icon icon2 = new ImageIcon("Resource/card_1.png");
        // center_2.setIcon(icon1);
        centerPanel.add(center_2);
        // System.out.println("Add center_2");

        center_3 = new JButton();
        center_3.setBorderPainted(false);
        center_3.setContentAreaFilled(false);
        center_3.addActionListener(new buttonListenerCard());
        // center_3.addActionListener(new buttonListenerCard2());
        center_3.setActionCommand("0");
        // Icon icon3 = new ImageIcon("Resource/card_1.png");
        // center_3.setIcon(icon1);
        centerPanel.add(center_3);
        // System.out.println("Add center_3");

        center_4 = new JButton();
        center_4.setBorderPainted(false);
        center_4.setContentAreaFilled(false);
        center_4.addActionListener(new buttonListenerCard());
        // center_4.addActionListener(new buttonListenerCard2());
        center_4.setActionCommand("0");
        // Icon icon4 = new ImageIcon("Resource/card_1.png");
        // center_4.setIcon(icon1);
        centerPanel.add(center_4);
        // System.out.println("Add center_4");

        center_5 = new JButton();
        center_5.setBorderPainted(false);
        center_5.setContentAreaFilled(false);
        center_5.addActionListener(new buttonListenerCard());
        // center_5.addActionListener(new buttonListenerCard2());
        center_5.setActionCommand(Integer.toString(deskTopCard.get(4)));
        Icon icon5 = new ImageIcon(new ImageIcon("card/card_"+deskTopCard.get(4)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        center_5.setIcon(icon5);
        centerPanel.add(center_5);
        // System.out.println("Add center_5");

        center_6 = new JButton();
        center_6.setBorderPainted(false);
        center_6.setContentAreaFilled(false);
        center_6.addActionListener(new buttonListenerCard());
        // center_6.addActionListener(new buttonListenerCard2());
        center_6.setActionCommand(Integer.toString(deskTopCard.get(5)));
        Icon icon6 = new ImageIcon(new ImageIcon("card/card_"+deskTopCard.get(5)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        center_6.setIcon(icon6);
        centerPanel.add(center_6);
        // System.out.println("Add center_6");

        center_7 = new JButton();
        center_7.setBorderPainted(false);
        center_7.setContentAreaFilled(false);
        center_7.addActionListener(new buttonListenerCard());
        // center_7.addActionListener(new buttonListenerCard2());
        center_7.setActionCommand(Integer.toString(deskTopCard.get(6)));
        Icon icon7 = new ImageIcon(new ImageIcon("card/card_"+deskTopCard.get(6)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        center_7.setIcon(icon7);
        centerPanel.add(center_7);
        // System.out.println("Add center_7");

        center_8 = new JButton();
        center_8.setBorderPainted(false);
        center_8.setContentAreaFilled(false);
        center_8.addActionListener(new buttonListenerCard());
        // center_8.addActionListener(new buttonListenerCard2());
        center_8.setActionCommand(Integer.toString(deskTopCard.get(7)));
        Icon icon8 = new ImageIcon(new ImageIcon("card/card_"+deskTopCard.get(7)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        center_8.setIcon(icon8);
        centerPanel.add(center_8);
        // System.out.println("Add center_8");

        
        return centerPanel;
    }

    /*********************************************************************************
    The downPanel include of the deck of collected cards, the card that player have.
    *********************************************************************************/
    public JPanel createDownPanel(){
        this.downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1, 8,10,0));//the disatnce between cards
        downPanel.setBackground(new Color(0,0,255));
        downPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // downPanel.setLayout(new GridLayout());
        // GridBagConstraints gbc = new GridBagConstraints();
        // gbc.gridth()
        JButton collectButton = new JButton("");
        collectButton.setActionCommand("Collected_Box");
        Icon collectIcon = new ImageIcon(new ImageIcon("Resource/COLLECTION_BOX.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        collectButton.setIcon(collectIcon);
        collectButton.setBorderPainted(false);
        collectButton.setContentAreaFilled(false);
        collectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collections gui = new Collections();
                gui.setVisible(true);
            }
        });
        downPanel.add(collectButton);
        ArrayList<JButton> down = new ArrayList<JButton>();
        down.add(down_1);
        down.add(down_2);
        down.add(down_3);
        down.add(down_4);
        down.add(down_5);
        down.add(down_6);
        down.add(down_7);
        // ArrayList<Integer> role1Hand = this.strawResult.getRole1Deck();
        
        // int role1Index = 0;
        // System.out.println(role1Hand);
        this.role1Hand = this.strawResult.getRole1Deck();
        for(int role1card = 0; role1card<role1Hand.size(); role1card++){
            handCardNum.add(role1Hand.get(role1card));
        }
        System.out.println("ROLE 1 Card Num: "+handCardNum);
        System.out.println("ROLE 1 Card: "+role1Hand);
       
        down_1 = new JButton();
        down_1.setBorderPainted(false);
        down_1.setContentAreaFilled(false);
        down_1.addActionListener(new buttonListenerCard());
        down_1.setActionCommand(Integer.toString(handCardNum.get(0)));
        Icon icon1 = new ImageIcon(new ImageIcon("card/card_"+handCardNum.get(0)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        down_1.setIcon(icon1);
        downPanel.add(down_1);
        // System.out.println("Add down_1");

        down_2 = new JButton();
        down_2.setBorderPainted(false);
        down_2.setContentAreaFilled(false);
        down_2.addActionListener(new buttonListenerCard());
        down_2.setActionCommand(Integer.toString(handCardNum.get(1)));
        Icon icon2 = new ImageIcon(new ImageIcon("card/card_"+handCardNum.get(1)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        down_2.setIcon(icon2);
        downPanel.add(down_2);
        // System.out.println("Add down_2");

        down_3 = new JButton();
        down_3.setBorderPainted(false);
        down_3.setContentAreaFilled(false);
        down_3.addActionListener(new buttonListenerCard());
        down_3.setActionCommand(Integer.toString(handCardNum.get(2)));
        Icon icon3 = new ImageIcon(new ImageIcon("card/card_"+handCardNum.get(2)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        down_3.setIcon(icon3);
        downPanel.add(down_3);
        // System.out.println("Add down_3");

        down_4 = new JButton();
        down_4.setBorderPainted(false);
        down_4.setContentAreaFilled(false);
        down_4.addActionListener(new buttonListenerCard());
        down_4.setActionCommand(Integer.toString(handCardNum.get(3)));
        Icon icon4 = new ImageIcon(new ImageIcon("card/card_"+handCardNum.get(3)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        down_4.setIcon(icon4);
        downPanel.add(down_4);
        // System.out.println("Add down_4");

        down_5 = new JButton();
        down_5.setBorderPainted(false);
        down_5.setContentAreaFilled(false);
        down_5.addActionListener(new buttonListenerCard());
        down_5.setActionCommand(Integer.toString(handCardNum.get(4)));
        Icon icon5 = new ImageIcon(new ImageIcon("card/card_"+handCardNum.get(4)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        down_5.setIcon(icon5);
        downPanel.add(down_5);
        // System.out.println("Add down_5");

        down_6 = new JButton();
        down_6.setBorderPainted(false);
        down_6.setContentAreaFilled(false);
        down_6.addActionListener(new buttonListenerCard());
        down_6.setActionCommand(Integer.toString(handCardNum.get(5)));
        Icon icon6 = new ImageIcon(new ImageIcon("card/card_"+handCardNum.get(5)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        down_6.setIcon(icon6);
        downPanel.add(down_6);
        // System.out.println("Add down_6");

        down_7 = new JButton();
        down_7.setBorderPainted(false);
        down_7.setContentAreaFilled(false);
        down_7.addActionListener(new buttonListenerCard());
        down_7.setActionCommand(Integer.toString(handCardNum.get(6)));
        Icon icon7 = new ImageIcon(new ImageIcon("card/card_"+handCardNum.get(6)+".png").getImage().getScaledInstance(140, 190, Image.SCALE_SMOOTH));
        down_7.setIcon(icon7);
        downPanel.add(down_7);
        // System.out.println("Add down_7");


       
        // downPanel.add(card8);
        return downPanel;
    }
    /******************************************************************
    Listener class to make the desk cards action correctly.
    ******************************************************************/
    class buttonListenerCard implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String actionCommand = e.getActionCommand();
            int deindex = -1;
            int haindex = -1;
            int prevHaindex = -1;
            //hand
            for(int n=0;n<role1Hand.size();n++){
                if(actionCommand.equals(Integer.toString(role1Hand.get(n)))){
                    prevHaindex = n;
                    System.out.println("whole role 1 card:" + role1Hand);
                    System.out.println("prev hand:"+prevHaindex);
                }
            }
            for(int i=0;i<handCardNum.size();i++){
                if(actionCommand.equals(Integer.toString(handCardNum.get(i)))){
                    haindex = i;
                    System.out.println("hand:"+haindex);
                }
            }
            //desk
            //if ==0 take the last one.
            for(int j=0;j<8;j++){
                if(actionCommand.equals(Integer.toString(deskTopCard.get(j)))){
                    if(actionCommand.equals("0")){
                        if(e.getSource()==center_1){
                            deindex = j;
                            System.out.println("deindex for 01:"+deindex);
                            emptyClick = true;
                        }else if(e.getSource()==center_2){
                            deindex = j;
                            System.out.println("deindex for 02:"+deindex);
                            emptyClick = true;
                        }else if(e.getSource()==center_3){
                            deindex = j;
                            System.out.println("deindex for 03:"+deindex);
                            emptyClick = true;
                        }else if(e.getSource()==center_4){
                            deindex = j;
                            System.out.println("deindex for 04:"+deindex);
                            emptyClick = true;
                        }else if(e.getSource()==center_5){
                            deindex = j;
                            System.out.println("deindex for 05:"+deindex);
                            emptyClick = true;
                        }else if(e.getSource()==center_6){
                            deindex = j;
                            System.out.println("deindex for 06:"+deindex);
                            emptyClick = true;
                        }else if(e.getSource()==center_7){
                            deindex = j;
                            System.out.println("deindex for 07:"+deindex);
                            emptyClick = true;
                        }else if(e.getSource()==center_8){
                            deindex = j;
                            System.out.println("deindex for 08:"+deindex);
                            emptyClick = true;
                        }
                    }else{
                        deindex = j;
                        System.out.println("deindex for equal:"+deindex);
                    }
                }
                
            }
            //desk
            if(deindex!=-1 && (Integer.parseInt(actionCommand)!=0)){
                deskCard.add(Integer.parseInt(actionCommand));
                deNum.add(deindex);
                deindex = -1;
                System.out.println("you choose deskCard: "+deskCard);
                deskClick = true;
            }else if(haindex!=-1 && (Integer.parseInt(actionCommand)!=0)){
                handCard.add(Integer.parseInt(actionCommand));
                haNum.add(haindex);
                role1Num.add(prevHaindex);
                haindex = -1;
                prevHaindex = -1;
                System.out.println("you choose handCard: "+handCard);
                handClick = true;
            }
            /********************************************************************
            *********************************************************************
            Turn a new card and pair with it.

            1.check if deck button onclick or not.
            2.
            *********************************************************************
            ********************************************************************/
            if(isDeck){
                    
                    if(actionCommand.equals("0")){
                        if(e.getSource()==center_5){
                            deskTopCard.remove(deskTopCard.get(deindex));
                            deindex = -1;
                            center_5.setEnabled(true);
                            center_5.addActionListener(new buttonListenerCard());
                            center_5.setActionCommand(Integer.toString(deskTopCard.get(deskTopCard.size()-1)));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(deskTopCard.get(deskTopCard.size()-1))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_5.setIcon(icon);
                            centerPanel.add(center_5);
                            System.out.println(center_5.getActionCommand());
                            // if(Integer.toString(deskTopCard.get(deskTopCard.size()-1))==53 || Integer.toString(deskTopCard.get(deskTopCard.size()-1))==54 || Integer.toString(deskTopCard.get(deskTopCard.size()-1))==55 || Integer.toString(deskTopCard.get(deskTopCard.size()-1))==56 ){
                            //     SpecialCard sp =new SpecialCard((deskTopCard.get(deskTopCard.size()-1)), deskTopCard, roleInf, )
                            // }
                        }else if(e.getSource()==center_6){
                            deskTopCard.remove(deskTopCard.get(deindex));
                            deindex = -1;
                            center_6.setEnabled(true);
                            center_6.addActionListener(new buttonListenerCard());
                            center_6.setActionCommand(Integer.toString(deskTopCard.get(deskTopCard.size()-1)));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(deskTopCard.get(deskTopCard.size()-1))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_6.setIcon(icon);
                            centerPanel.add(center_6);
                            System.out.println(center_6.getActionCommand());
                        }else if(e.getSource()==center_7){
                            deskTopCard.remove(deskTopCard.get(deindex));
                            deindex = -1;
                            center_7.setEnabled(true);
                            center_7.addActionListener(new buttonListenerCard());
                            center_7.setActionCommand(Integer.toString(deskTopCard.get(deskTopCard.size()-1)));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(deskTopCard.get(deskTopCard.size()-1))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_7.setIcon(icon);
                            centerPanel.add(center_7);
                            System.out.println(center_7.getActionCommand());
                        }else if(e.getSource()==center_8){
                            deskTopCard.remove(deskTopCard.get(deindex));
                            deindex = -1;
                            center_8.setEnabled(true);
                            center_8.addActionListener(new buttonListenerCard());
                            center_8.setActionCommand(Integer.toString(deskTopCard.get(deskTopCard.size()-1)));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(deskTopCard.get(deskTopCard.size()-1))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_8.setIcon(icon);
                            centerPanel.add(center_8);
                            System.out.println(center_8.getActionCommand());
                        }else if(e.getSource()==center_1){
                            deskTopCard.remove(deskTopCard.get(deindex));
                            deindex = -1;
                            center_1.setEnabled(true);
                            center_1.addActionListener(new buttonListenerCard());
                            center_1.setActionCommand(Integer.toString(deskTopCard.get(deskTopCard.size()-1)));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(deskTopCard.get(deskTopCard.size()-1))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_1.setIcon(icon);
                            centerPanel.add(center_1);
                            System.out.println(center_1.getActionCommand());
                        }else if(e.getSource()==center_2){
                            deskTopCard.remove(deskTopCard.get(deindex));
                            deindex = -1;
                            center_2.setEnabled(true);
                            center_2.addActionListener(new buttonListenerCard());
                            center_2.setActionCommand(Integer.toString(deskTopCard.get(deskTopCard.size()-1)));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(deskTopCard.get(deskTopCard.size()-1))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_2.setIcon(icon);
                            centerPanel.add(center_2);
                            System.out.println(center_2.getActionCommand());
                        }else if(e.getSource()==center_3){
                            deskTopCard.remove(deskTopCard.get(deindex));
                            deindex = -1;
                            center_3.setEnabled(true);
                            center_3.addActionListener(new buttonListenerCard());
                            center_3.setActionCommand(Integer.toString(deskTopCard.get(deskTopCard.size()-1)));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(deskTopCard.get(deskTopCard.size()-1))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_3.setIcon(icon);
                            centerPanel.add(center_3);
                            System.out.println(center_3.getActionCommand());
                        }else if(e.getSource()==center_4){
                            deskTopCard.remove(deskTopCard.get(deindex));
                            deindex = -1;
                            center_4.setEnabled(true);
                            center_4.addActionListener(new buttonListenerCard());
                            center_4.setActionCommand(Integer.toString(deskTopCard.get(deskTopCard.size()-1)));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(deskTopCard.get(deskTopCard.size()-1))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_4.setIcon(icon);
                            centerPanel.add(center_4);
                            System.out.println(center_4.getActionCommand());
                        }
                        // isDeck=false;
                        emptyClick = false;
                        deindex = -1;
                        deckCard.add(deskTopCard.get(deskTopCard.size()-1));
                        System.out.println("Your desktop card: " + deskTopCard);
                        System.out.println("You Deck it.");
                        System.out.println("Deck Card List: " + deckCard);

                    }

                    AutoPairCard autoPairDeck = new AutoPairCard(deckCard, deskTopCard, cardInf, roleInf, roleIndex);
                    Thread autoPairingDeck = new Thread(autoPairDeck);
                    autoPairingDeck.start();
                    try{
                        autoPairingDeck.join();
                    }catch(InterruptedException exceptions){
                        exceptions.printStackTrace();
                    }
                    if((autoPairDeck.getMatch())==true){
                    
                        if(deskClick==true){
                            PairCard pairDeck = new PairCard(deckCard, deskCard, cardInf, roleInf, player1Collected, roleIndex);
                            Thread pairingDeck = new Thread(pairDeck);
                            pairingDeck.start();
                            try{
                                pairingDeck.join();
                            }
                            catch(InterruptedException exceptions){
                                exceptions.printStackTrace();
                            }
                            if(pairDeck.getMatch()==true){
                                if(deskTopCard.get(deskTopCard.size()-1)==Integer.parseInt(center_5.getActionCommand())){
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_5.getActionCommand())));
                                    center_5.setIcon(null);
                                    center_5.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deskTopCard.size()-1)==Integer.parseInt(center_6.getActionCommand())){
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_6.getActionCommand())));
                                    center_6.setIcon(null);
                                    center_6.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deskTopCard.size()-1)==Integer.parseInt(center_7.getActionCommand())){
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_7.getActionCommand())));
                                    center_7.setIcon(null);
                                    center_7.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deskTopCard.size()-1)==Integer.parseInt(center_8.getActionCommand())){
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_8.getActionCommand())));
                                    center_8.setIcon(null);
                                    center_8.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deskTopCard.size()-1)==Integer.parseInt(center_1.getActionCommand())){
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_1.getActionCommand())));
                                    center_1.setIcon(null);
                                    center_1.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deskTopCard.size()-1)==Integer.parseInt(center_2.getActionCommand())){
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_2.getActionCommand())));
                                    center_2.setIcon(null);
                                    center_2.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deskTopCard.size()-1)==Integer.parseInt(center_3.getActionCommand())){
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_3.getActionCommand())));
                                    center_3.setIcon(null);
                                    center_3.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deskTopCard.size()-1)==Integer.parseInt(center_4.getActionCommand())){
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_4.getActionCommand())));
                                    center_4.setIcon(null);
                                    center_4.setActionCommand("0");
                                    deskTopCard.add(0);
                                }

                                if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_5.getActionCommand())){
                                    // center_5.setEnabled(false);
                                    System.out.println(center_5.getActionCommand());
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_5.getActionCommand())));
                                    center_5.setIcon(null);
                                    center_5.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_6.getActionCommand())){
                                    // center_6.setEnabled(false);
                                    System.out.println(center_6.getActionCommand());
                                    // deskTopCard.remove(5);
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_6.getActionCommand())));
                                    center_6.setIcon(null);
                                    center_6.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_7.getActionCommand())){
                                    // center_7.setEnabled(false);
                                    System.out.println(center_7.getActionCommand());
                                    // deskTopCard.remove(6);
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_7.getActionCommand())));
                                    center_7.setIcon(null);
                                    center_7.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_8.getActionCommand())){
                                    // center_8.setEnabled(false);
                                    System.out.println(center_8.getActionCommand());
                                    // deskTopCard.remove(7);
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_8.getActionCommand())));
                                    center_8.setIcon(null);
                                    center_8.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_1.getActionCommand())){
                                    // center_1.setEnabled(false);
                                    System.out.println(center_1.getActionCommand());
                                    // deskTopCard.remove(0);
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_1.getActionCommand())));
                                    center_1.setIcon(null);
                                    center_1.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_2.getActionCommand())){
                                    // center_2.setEnabled(false);
                                    System.out.println(center_2.getActionCommand());
                                    // deskTopCard.remove(1);
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_2.getActionCommand())));
                                    center_2.setIcon(null);
                                    center_2.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_3.getActionCommand())){
                                    // center_3.setEnabled(false);
                                    System.out.println(center_3.getActionCommand());
                                    // deskTopCard.remove(2);
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_3.getActionCommand())));
                                    center_3.setIcon(null);
                                    center_3.setActionCommand("0");
                                    deskTopCard.add(0);
                                }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_4.getActionCommand())){
                                    // center_4.setEnabled(false);
                                    System.out.println(center_4.getActionCommand());
                                    // deskTopCard.remove(3);
                                    deskTopCard.remove(deskTopCard.indexOf(Integer.parseInt(center_4.getActionCommand())));
                                    center_4.setIcon(null);
                                    center_4.setActionCommand("0");
                                    deskTopCard.add(0);
                                }
                                isDeck=false;
                                deskClick=false;
                                deNum.clear();
                                deckCard.clear();
                            }
                            MessageDisplay playerMessage2 = new MessageDisplay(textLabel, upperPanel);
                            Thread playerMessageThread2 = new Thread(playerMessage2);
                            playerMessageThread2.start();
                            ComputerPlayer computerResult = new ComputerPlayer(strawResult, deskTopCard, deskCardNum, cardInf, roleInf);
                            HashMap<Integer, Integer> computerDo = computerResult.getChangeCard();
                            for (Map.Entry<Integer, Integer> x : computerDo.entrySet()){
                                System.out.println("Key: " + x.getKey() + " Value: " + x.getValue());
                            }
                            LetYouSleep ly = new LetYouSleep(centerPanel, computerDo, 50, deskTopCard, center_1, center_2, center_3, center_4, center_5, center_6, center_7, center_8);
                            Thread lyt = new Thread(ly);
                            lyt.start();
                            try{
                                lyt.join();
                            }catch(InterruptedException eee){
                                eee.printStackTrace();
                            }
                        }
                    }else{
                        isDeck = false;
                        deckCard.clear();
                        // MessageDisplay playerMessage2 = new MessageDisplay(textLabel, upperPanel);
                        // Thread playerMessageThread2 = new Thread(playerMessage2);
                        // playerMessageThread2.start();
                        // ComputerPlayer computerResult = new ComputerPlayer(strawResult, deskTopCard, deskCardNum, cardInf, roleInf);
                        // HashMap<Integer, Integer> computerDo = computerResult.getChangeCard();
                        // // for (Map.Entry<Integer, Integer> x : computerDo.entrySet()){
                        // //     System.out.println("Key: " + x.getKey() + " Value: " + x.getValue());
                        // // }
                        // LetYouSleep ly = new LetYouSleep(centerPanel, computerDo, 50, deskTopCard, center_1, center_2, center_3, center_4, center_5, center_6, center_7, center_8);
                        // Thread lyt = new Thread(ly);
                        // lyt.start();
                    }
                    // MessageDisplay playerMessage = new MessageDisplay(textLabel, upperPanel);
                    // Thread playerMessageThread = new Thread(playerMessage);
                    // playerMessageThread.start();
                    /******************************************************************
                    Computer Player things.
                     20 -> player2 have a pair on hand. Remove desk card that pair with it.
                    201 -> 
                     21 -> player2 does not have a pair on hand, so throw a card to the desk.
                     30 -> player3 have a pair on hand. Remove desk card that pair with it.
                    301 -> 
                     31 -> 
                     40 -> player4 have a pair on hand. Remove desk card that pair with it.
                    401 -> 
                     41 -> 
                    ******************************************************************/
                    MessageDisplay playerMessage2 = new MessageDisplay(textLabel, upperPanel);
                    Thread playerMessageThread2 = new Thread(playerMessage2);
                    playerMessageThread2.start();
                    ComputerPlayer computerResult = new ComputerPlayer(strawResult, deskTopCard, deskCardNum, cardInf, roleInf);
                    HashMap<Integer, Integer> computerDo = computerResult.getChangeCard();
                    for (Map.Entry<Integer, Integer> x : computerDo.entrySet()){
                        System.out.println("Key: " + x.getKey() + " Value: " + x.getValue());
                    }
                    LetYouSleep ly = new LetYouSleep(centerPanel, computerDo, 50, deskTopCard, center_1, center_2, center_3, center_4, center_5, center_6, center_7, center_8);
                    Thread lyt = new Thread(ly);
                    lyt.start();
                    try{
                        lyt.join();
                    }catch(InterruptedException eee){
                        eee.printStackTrace();
                    }
                    
            }
            /***********************************************************************************************
            //check if the player can pair card or not
            ***********************************************************************************************/
            AutoPairCard autoPair = new AutoPairCard(handCardNum, deskTopCard, cardInf, roleInf, roleIndex);
            Thread autoPairing = new Thread(autoPair);
            autoPairing.start();
            try{
                autoPairing.join();
            }catch(InterruptedException exceptions){
                exceptions.printStackTrace();
            }
            System.out.println("AutoPair: "+autoPair.getMatch());
            System.out.println("handClick: " + handClick);
            System.out.println("deskClick: "+ deskClick);
            System.out.println("emptyClick: "+ emptyClick);
            //if player cannot pair the card, player need to put one hand card on the desk.
            if((autoPair.getMatch())==false){
                // boolean nothingToPairPlayer = false;
                // boolean nothingToPairDesk = false;
                if((handClick==true) && (emptyClick==true)){
                    System.out.println("handClick: "+handClick);
                    System.out.println("emptyClick: "+emptyClick);
                    if(actionCommand.equals("0")){
                        
                        if(e.getSource()==center_5){
                            // center_5.setEnabled(false);
                            deskTopCard.remove(deindex);
                            deskTopCard.add((handCardNum.get(haNum.get((haNum.size()-1)))));
                            center_5.setActionCommand(Integer.toString(handCardNum.get(haNum.get((haNum.size()-1)))));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(handCardNum.get(haNum.get((haNum.size()-1))))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_5.setIcon(icon);
                            centerPanel.add(center_5);
                        }else if(e.getSource()==center_6){
                            // center_6.setEnabled(false);
                            deskTopCard.remove(deindex);
                            deskTopCard.add((handCardNum.get(haNum.get((haNum.size()-1)))));
                            center_6.setActionCommand(Integer.toString(handCardNum.get(haNum.get((haNum.size()-1)))));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(handCardNum.get(haNum.get((haNum.size()-1))))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_6.setIcon(icon);
                            centerPanel.add(center_6);
                        }else if(e.getSource()==center_7){
                            // center_7.setEnabled(false);
                            deskTopCard.remove(deindex);
                            deskTopCard.add((handCardNum.get(haNum.get((haNum.size()-1)))));
                            center_7.setActionCommand(Integer.toString(handCardNum.get(haNum.get((haNum.size()-1)))));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(handCardNum.get(haNum.get((haNum.size()-1))))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_7.setIcon(icon);
                            centerPanel.add(center_7);
                        }else if(e.getSource()==center_8){
                            // center_8.setEnabled(false);
                            deskTopCard.remove(deindex);
                            deskTopCard.add((handCardNum.get(haNum.get((haNum.size()-1)))));
                            center_8.setActionCommand(Integer.toString(handCardNum.get(haNum.get((haNum.size()-1)))));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(handCardNum.get(haNum.get((haNum.size()-1))))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_8.setIcon(icon);
                            centerPanel.add(center_8);
                        }else if(e.getSource()==center_1){
                            // center_1.setEnabled(false);
                            deskTopCard.remove(deindex);
                            deskTopCard.add((handCardNum.get(haNum.get((haNum.size()-1)))));
                            center_1.setActionCommand(Integer.toString(handCardNum.get(haNum.get((haNum.size()-1)))));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(handCardNum.get(haNum.get((haNum.size()-1))))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_1.setIcon(icon);
                            centerPanel.add(center_1);
                        }else if(e.getSource()==center_2){
                            // center_2.setEnabled(false);
                            deskTopCard.remove(deindex);
                            deskTopCard.add((handCardNum.get(haNum.get((haNum.size()-1)))));
                            center_2.setActionCommand(Integer.toString(handCardNum.get(haNum.get((haNum.size()-1)))));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(handCardNum.get(haNum.get((haNum.size()-1))))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_2.setIcon(icon);
                            centerPanel.add(center_2);
                        }else if(e.getSource()==center_3){
                            // center_3.setEnabled(false);
                            deskTopCard.remove(deindex);
                            deskTopCard.add((handCardNum.get(haNum.get((haNum.size()-1)))));
                            center_3.setActionCommand(Integer.toString(handCardNum.get(haNum.get((haNum.size()-1)))));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(handCardNum.get(haNum.get((haNum.size()-1))))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_3.setIcon(icon);
                            centerPanel.add(center_3);
                        }else if(e.getSource()==center_4){
                            deskTopCard.remove(deindex);
                            deskTopCard.add((handCardNum.get(haNum.get((haNum.size()-1)))));
                            center_4.setActionCommand(Integer.toString(handCardNum.get(haNum.get((haNum.size()-1)))));
                            ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+(handCardNum.get(haNum.get((haNum.size()-1))))+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
                            center_4.setIcon(icon);
                            centerPanel.add(center_4);
                        }
                        if(role1Num.get((role1Num.size()-1))==0){
                            handCardNum.remove(handCardNum.get(haNum.get(haNum.size()-1)));
                            down_1.setEnabled(false);
                        }else if(role1Num.get((role1Num.size()-1))==1){
                            handCardNum.remove(handCardNum.get(haNum.get(haNum.size()-1)));
                            down_2.setEnabled(false);
                        }else if(role1Num.get((role1Num.size()-1))==2){
                            handCardNum.remove(handCardNum.get(haNum.get(haNum.size()-1)));
                            down_3.setEnabled(false);
                        }else if(role1Num.get((role1Num.size()-1))==3){
                            handCardNum.remove(handCardNum.get(haNum.get(haNum.size()-1)));
                            down_4.setEnabled(false);
                        }else if(role1Num.get((role1Num.size()-1))==4){
                            handCardNum.remove(handCardNum.get(haNum.get(haNum.size()-1)));
                            down_5.setEnabled(false);
                        }else if(role1Num.get((role1Num.size()-1))==5){
                            handCardNum.remove(handCardNum.get(haNum.get(haNum.size()-1)));
                            down_6.setEnabled(false);
                        }else if(role1Num.get((role1Num.size()-1))==6){
                            handCardNum.remove(handCardNum.get(haNum.get(haNum.size()-1)));
                            down_7.setEnabled(false);
                        }
                        
                    }
                    emptyClick = false;
                    handClick = false;
                    deindex = -1;
                    haindex = -1;
                    prevHaindex = -1;
                    deNum.clear();
                    haNum.clear();
                    role1Num.clear();
                    System.out.println("Now emptyClick: " + emptyClick);
                    System.out.println("Now handClick: " + handClick);
                    System.out.println("Your raw hand card: " + prevHaindex);
                    System.out.println("Now your hand card: " + handCardNum);
                    System.out.println("Now your desk card: " + deskTopCard);
                    System.out.println("You put a card on the desk.");

                }
            }

            if(handClick == true && deskClick == true){
                    handClick = false;
                    deskClick = false;
                    emptyClick = false;
                    PairCard pair = new PairCard(handCard, deskCard, cardInf, roleInf, player1Collected, roleIndex);
                    Thread pairing = new Thread(pair);
                    pairing.start();
                    try{
                        pairing.join();
                    }catch(InterruptedException exceptions){
                        exceptions.printStackTrace();
                    }
                    if(pair.getMatch()==true){

                        if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_5.getActionCommand())){
                            // center_5.setEnabled(false);
                            System.out.println(center_5.getActionCommand());
                            deskTopCard.remove(4);
                            center_5.setIcon(null);
                            center_5.setActionCommand("0");
                            deskTopCard.add(0);
                        }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_6.getActionCommand())){
                            // center_6.setEnabled(false);
                            System.out.println(center_6.getActionCommand());
                            deskTopCard.remove(5);
                            center_6.setIcon(null);
                            center_6.setActionCommand("0");
                            deskTopCard.add(0);
                        }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_7.getActionCommand())){
                            // center_7.setEnabled(false);
                            System.out.println(center_7.getActionCommand());
                            deskTopCard.remove(6);
                            center_7.setIcon(null);
                            center_7.setActionCommand("0");
                            deskTopCard.add(0);
                        }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_8.getActionCommand())){
                            // center_8.setEnabled(false);
                            System.out.println(center_8.getActionCommand());
                            deskTopCard.remove(7);
                            center_8.setIcon(null);
                            center_8.setActionCommand("0");
                            deskTopCard.add(0);
                        }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_1.getActionCommand())){
                            // center_1.setEnabled(false);
                            System.out.println(center_1.getActionCommand());
                            deskTopCard.remove(0);
                            center_1.setIcon(null);
                            center_1.setActionCommand("0");
                            deskTopCard.add(0);
                        }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_2.getActionCommand())){
                            // center_2.setEnabled(false);
                            System.out.println(center_2.getActionCommand());
                            deskTopCard.remove(1);
                            center_2.setIcon(null);
                            center_2.setActionCommand("0");
                            deskTopCard.add(0);
                        }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_3.getActionCommand())){
                            // center_3.setEnabled(false);
                            System.out.println(center_3.getActionCommand());
                            deskTopCard.remove(2);
                            center_3.setIcon(null);
                            center_3.setActionCommand("0");
                            deskTopCard.add(0);
                        }else if(deskTopCard.get(deNum.get((deNum.size()-1)))==Integer.parseInt(center_4.getActionCommand())){
                            // center_4.setEnabled(false);
                            System.out.println(center_4.getActionCommand());
                            deskTopCard.remove(3);
                            center_4.setIcon(null);
                            center_4.setActionCommand("0");
                            deskTopCard.add(0);
                        }
                        int rmvs = haNum.size()-1;
                        int rmv = haNum.get(rmvs);
                        System.out.println("size: "+rmvs+", index: "+rmv);
                        if(role1Num.get(role1Num.size()-1)==0){
                            handCardNum.remove(rmv);
                            down_1.setEnabled(false);
                        }else if(role1Num.get(role1Num.size()-1)==1){
                            handCardNum.remove(rmv);
                            down_2.setEnabled(false);
                        }else if(role1Num.get(role1Num.size()-1)==2){
                            handCardNum.remove(rmv);
                            down_3.setEnabled(false);
                        }else if(role1Num.get(role1Num.size()-1)==3){
                            handCardNum.remove(rmv);
                            down_4.setEnabled(false);
                        }else if(role1Num.get(role1Num.size()-1)==4){
                            handCardNum.remove(rmv);
                            down_5.setEnabled(false);
                        }else if(role1Num.get(role1Num.size()-1)==5){
                            handCardNum.remove(rmv);
                            down_6.setEnabled(false);
                        }else if(role1Num.get(role1Num.size()-1)==6){
                            handCardNum.remove(rmv);
                            down_7.setEnabled(false);
                        }
                        if(rmv==1 || rmv==14 || rmv==35 || rmv==48){
                            // textLabel.setText(cardText.get(0));
                            // String s = "\u6d88"+"\u9664"+"\u5404"+"\u5730"+"\u4e00"+"\u5207"+"\u8ca7"+"\u7aae"+"\u3002";
                            // textLabel.setText(s);
                            // textLabel.setText("\u6d88"+"\u9664"+"\u5404"+"\u5730"+"\u4e00"+"\u5207"+"\u8ca7"+"\u7aae"+"\u3002");
                            textLabel.setText("End poverty in all its forms everywhere.");
                        }else if(rmv==2 || rmv==15 || rmv==34 || rmv==47){
                            // textLabel.setText(cardText.get(1));
                            // textLabel.setText("\u6d88"+"\u9664"+"\u98e2"+"\u9913"+"\uff0c"+"\u9054"+"\u6210"+"\u7ce7"+"\u98df"+"\u5b89"+"\u5168"+"\uff0c"+"\u6539"+"\u5584"+"\u71df"+"\u990a"+"\u53ca"+"\u4fc3"+"\u9032"+"\u6c38"+"\u7e8c"+"\u8fb2"+"\u696d"+"\u3002");
                            textLabel.setText("End hunger, achieve food security and improved nutrition and promote sustainable agriculture.");
                        }else if(rmv==3 || rmv==16 || rmv==33 || rmv==46){
                            // textLabel.setText(cardText.get(2));
                            textLabel.setText("Ensure healthy lives and promote wellJbeing for all at all ages.");
                        }else if(rmv==4 || rmv==17 || rmv==32 || rmv==45){
                            // textLabel.setText(cardText.get(3));
                            textLabel.setText("Ensure inclusive and equitable quality education and promote lifelong learning opportunities for all.");
                        }else if(rmv==5 || rmv==18 || rmv==31 || rmv==44){
                            // textLabel.setText(cardText.get(4));
                            textLabel.setText("Achieve gender equality and empower all women and girls.");
                        }else if(rmv==6 || rmv==19 || rmv==30 || rmv==43){
                            // textLabel.setText(cardText.get(5));
                            textLabel.setText("Ensure availability and sustainable management of water and sanitation for all.");
                        }else if(rmv==7 || rmv==20 || rmv==29 || rmv==42){
                            // textLabel.setText(cardText.get(6));
                            textLabel.setText("Ensure access to affordable, reliable, sustainable and modern energy for all.");
                        }else if(rmv==8 || rmv==21 || rmv==28 || rmv==41){
                            // textLabel.setText(cardText.get(7));
                            textLabel.setText("Promote sustained, inclusive and sustainable economic growth, full and productive employment and decent work for all.");
                        }else if(rmv==9 || rmv==22 || rmv==27 || rmv==40){
                            // textLabel.setText(cardText.get(8));
                            textLabel.setText("Build resilient infrastructure, promote inclusive and sustainable industrialization and foster innovation.");
                        }else if(rmv==10 || rmv==23 || rmv==36 || rmv==49){
                            // textLabel.setText(cardText.get(9));
                            textLabel.setText(" Reduce inequality within and among countries.");
                        }else if(rmv==11 || rmv==24 || rmv==37 || rmv==50){
                            // textLabel.setText(cardText.get(10));
                            textLabel.setText("Make cities and human settlements inclusive, safe, resilient and sustainable.");
                        }else if(rmv==12 || rmv==25 || rmv==38 || rmv==51){
                            // textLabel.setText(cardText.get(11));
                            textLabel.setText("Ensure sustainable consumption and production patterns.");
                        }else if(rmv==13 || rmv==26 || rmv==39 || rmv==52){

                            // textLabel.setText(cardText.get(12));
                            textLabel.setText("Take urgent action to combat climate change and its impacts.");
                        }
                        System.out.println("You pair it "+pair.getMatch());
                        System.out.println("Now your hand Card: " + handCardNum);
                        System.out.println("Now the desk Card: " + deskTopCard);
                        deindex = -1;
                        haindex = -1;
                        deNum.clear();
                        haNum.clear();

                    }
            }
            _score.setText(Integer.toString(roleInf.getScore(roleIndex))+" points");
        }   
    }    
}