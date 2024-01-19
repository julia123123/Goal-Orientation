import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menupage extends JFrame{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 350;
	public static boolean pressRESTART=false;
	
	public Menupage() {
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		JPanel buttonPanel=new JPanel();
        BoxLayout box=new BoxLayout(buttonPanel,BoxLayout.Y_AXIS);
        buttonPanel.setLayout(box);
        setLocationRelativeTo(null);
        buttonPanel.add(Box.createVerticalStrut(50));
        JButton HELP =new JButton();
        HELP.setOpaque(false);
        HELP.setBorder(null);
        HELP.setContentAreaFilled(false);
        HELP.setFocusPainted(false);
        HELP.setAlignmentX(Component.CENTER_ALIGNMENT);
		HELP.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) {    
            	Rulepage rule=new Rulepage();
    			rule.setVisible(true);
    			dispose(); 
            }
        } );
		ImageIcon helpicon = new ImageIcon("Resource/HELP2.png");
		HELP.setIcon(helpicon);
		HELP.setBorderPainted(false);
		buttonPanel.add(HELP);
		buttonPanel.add(Box.createVerticalStrut(10));
		JButton Restart=new JButton();
		Restart.setOpaque(false);
		Restart.setBorder(null);
		Restart.setContentAreaFilled(false);
		Restart.setFocusPainted(false);
		Restart.setAlignmentX(Component.CENTER_ALIGNMENT);
		Restart.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) { 
                Mainpage.game.dispose();
                Mainpage.game=new GamePage();
                Mainpage.game.setVisible(true);
            	dispose();
            }
		} );
		ImageIcon restarticon = new ImageIcon("Resource/RESTART.png");
		Restart.setIcon(restarticon);
		Restart.setBorderPainted(false);
		buttonPanel.add(Restart);
		buttonPanel.add(Box.createVerticalStrut(10));
		JButton Quit=new JButton();
		Quit.setOpaque(false);
		Quit.setBorder(null);
		Quit.setContentAreaFilled(false);
		Quit.setFocusPainted(false);
		Quit.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) { 
            	Mainpage.game.dispose();
            	Mainpage gui =new Mainpage();
            	gui.setVisible(true);
            	dispose();
            }
		} );
		ImageIcon quiticon = new ImageIcon("Resource/QUIT.png");
		Quit.setIcon(quiticon);
		Quit.setBorderPainted(false);
		Quit.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(Quit);
	
        add(buttonPanel,BorderLayout.CENTER);
	}

}