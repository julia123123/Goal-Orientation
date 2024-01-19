import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
public class Collections extends JFrame implements WindowListener{
	public void windowOpened(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		dispose();
	}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public static final int WIDTH = 900;
	public static final int HEIGHT = 800;
	private int currentscore;//cut=rrent score
	private int pairnum=-1; // the number of pair
	private Container cp;
	private JPanel cardspanel,Framepanel;
	public Collections() {
		setSize(WIDTH, HEIGHT);
		setTitle("Collected");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		setLayout(new BorderLayout());
		Container cp=getContentPane();
		JScrollPane js = new JScrollPane();
		getContentPane().add(js);
		setLocationRelativeTo(null);
		
		JPanel Framepanel= new JPanel();
		Framepanel.setLayout(new BorderLayout());
		Framepanel.setBackground(Color.WHITE);
		
		JPanel Scorepanel= new JPanel();
		Scorepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		Scorepanel.setOpaque(false);
		
		Font f = new Font("",Font.BOLD, 22);
		UIManager.put("TextField.font", f);
		currentscore=GamePage.roleInf.getScore(GamePage.roleIndex);
		JTextField scoretext = new JTextField("Current Points : "+currentscore+" points  ");
		
		scoretext.setHorizontalAlignment(JTextField.RIGHT);
		scoretext.setBackground(Color.WHITE);
		scoretext.setEditable(false);
		scoretext.setBorder(new EmptyBorder(0,0,0,0));
		Scorepanel.add(scoretext);
		Framepanel.add(Scorepanel,BorderLayout.NORTH);
		
		cardspanel= new JPanel();
		cardspanel.setOpaque(false);
		cardspanel.setLayout(new GridLayout(pairnum,1));
		cardspanel.removeAll();
		JPanel cardspair1= new JPanel();
		cardspair1.setOpaque(false);
		cardspair1.setLayout(new FlowLayout());
		
		JPanel cardspair2= new JPanel();
		cardspair2.setOpaque(false);
		cardspair2.setLayout(new FlowLayout());
		
		JPanel cardspair3= new JPanel();
		cardspair3.setOpaque(false);
		cardspair3.setLayout(new FlowLayout());
		
		JPanel cardspair4= new JPanel();
		cardspair4.setOpaque(false);
		cardspair4.setLayout(new FlowLayout());
		
		JPanel cardspair5= new JPanel();
		cardspair5.setOpaque(false);
		cardspair5.setLayout(new FlowLayout());
		
		JPanel cardspair6= new JPanel();
		cardspair6.setOpaque(false);
		cardspair6.setLayout(new FlowLayout());
		
		JPanel cardspair7= new JPanel();
		cardspair7.setOpaque(false);
		cardspair7.setLayout(new FlowLayout());
		
		JPanel cardspair8= new JPanel();
		cardspair8.setOpaque(false);
		cardspair8.setLayout(new FlowLayout());
		
		JPanel cardspair9= new JPanel();
		cardspair9.setOpaque(false);
		cardspair9.setLayout(new FlowLayout());
		
		JPanel cardspair10= new JPanel();
		cardspair10.setOpaque(false);
		cardspair10.setLayout(new FlowLayout());
		
		JPanel cardspair11= new JPanel();
		cardspair11.setOpaque(false);
		cardspair11.setLayout(new FlowLayout());
		
		JPanel cardspair12= new JPanel();
		cardspair12.setOpaque(false);
		cardspair12.setLayout(new FlowLayout());
		
		JPanel cardspair= new JPanel();
		cardspair.setOpaque(false);
		cardspair.setLayout(new FlowLayout());
		
		int i,j,k;
		pairnum=GamePage.player1Collected.size();
		System.out.println("pairnu : "+pairnum);
		for(i=0;i<pairnum;i++) {
			j=GamePage.player1Collected.get(i)[0];
			k=GamePage.player1Collected.get(i)[1];
			if(i==0) {
				
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair1.add(Collected1);
				
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair1.add(Collected2);
				cardspanel.add(cardspair1);
			}
			if(i==1) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair2.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair2.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==2) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair3.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair3.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==3) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair4.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair4.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==4) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair5.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair5.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==5) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair6.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair6.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==6) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair7.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair7.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==7) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair7.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair7.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==8) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair7.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair7.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==9) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair10.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair10.add(Collected2);
				cardspanel.add(cardspair2);
			}if(i==10) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair11.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair11.add(Collected2);
				cardspanel.add(cardspair2);
			}
			if(i==11) {
				JLabel Collected1 = new JLabel(new ImageIcon("Ccard/card_"+j+".png"));
				cardspair12.add(Collected1);
				
				JLabel Collected2 = new JLabel(new ImageIcon("Ccard/card_"+k+".png"));
				cardspair12.add(Collected2);
				cardspanel.add(cardspair2);
			}
//			Framepanel.add(cardspanel,BorderLayout.CENTER);
			if(Menupage.pressRESTART==false) {
				Framepanel.add(cardspanel,BorderLayout.CENTER);
			}else{
				Framepanel.remove(cardspanel);
				cardspanel.removeAll();
//				Framepanel.repaint();
				
				cardspanel.repaint();
				Menupage.pressRESTART=false;
			}
		}

		JScrollPane scrollpane =new JScrollPane(Framepanel);
	    scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		cp.add(scrollpane,BorderLayout.CENTER);

	}
}