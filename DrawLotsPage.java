import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class DrawLotsPage extends JFrame{
	
	public static final int WIDTH = 460;
	public static final int HEIGHT = 280;
	private int FirstOrder=0;
	private JTextField remindtext;
	public DrawLotsPage() {
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setLocationRelativeTo(null);
		JPanel remindpanel= new JPanel();
		remindpanel.setOpaque(false);
		Font f = new Font("",Font.BOLD, 22);
		UIManager.put("TextField.font", f);
		
		remindtext = new JTextField("Please Click the Draw Lots Box...");
		remindtext.setOpaque(false);
		remindtext.setHorizontalAlignment(JTextField.CENTER);
		remindtext.setEditable(false);
		remindtext.setColumns(400);
		remindtext.setBorder(new EmptyBorder(0,0,0,0));
		
		remindpanel.add(remindtext);
		remindpanel.setBounds(0,0, 460,100);
		add(remindpanel);
		
		JPanel drawStrawPanel= new JPanel();
		drawStrawPanel.setOpaque(false);
		
		JButton strawbutton = new JButton();
		strawbutton.setOpaque(false);
		strawbutton.setBorder(null);
		strawbutton.setContentAreaFilled(false);
		strawbutton.setFocusPainted(false);
        Icon strawIcon = new ImageIcon("Resource/cardboard-box.png");
        strawbutton.setIcon(strawIcon);
        
        
        strawbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	String text = String.format("The result is...");
            	remindtext.setText(text);
            	String text1 = String.format("Player %d is the first",FirstOrder);
            	remindtext.setText(text1);
                
            }
        });
        drawStrawPanel.add(strawbutton);
        JButton startButton = new JButton();
        startButton.setOpaque(false);
		startButton.setBorder(null);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
        Icon startIcon = new ImageIcon(new ImageIcon("Resource/START.png").getImage().getScaledInstance(128, 50, Image.SCALE_SMOOTH));
        startButton.setIcon(startIcon);
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	Mainpage.game.setVisible(true);
            }
        });
        // startButton.setBounds(155,100,150,50);
        drawStrawPanel.setBounds(155,50, 128, 178);
        drawStrawPanel.add(startButton);
        add(drawStrawPanel);
	}
	// public static void main(String[] args){
	// 	DrawLotsPage gui = new DrawLotsPage();
	// 	gui.setVisible(true);
	// }
}
