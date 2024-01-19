import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Win extends JFrame implements WindowListener {
	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		dispose();
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	private RoleInfo roleInf;
	private int higher = 0;
	private int higherIndex = 0;
	private int lower = 0;
	private int lowerIndex = 0;
	private int second = 0;
	private int secondIndex = 0;
	private int third = 0;
	private int thirdIndex = 0;
	public Win(RoleInfo roleInf) {
		this.roleInf = roleInf;
		setSize(WIDTH, HEIGHT);
		setTitle("Result!");
		setLayout(null);
 		ImageIcon background=new ImageIcon("Resource/endgame.png");
                JLabel label = new JLabel(background);
                label.setBounds(0,0,WIDTH,HEIGHT);
                JPanel imagePanel = (JPanel) this.getContentPane();
                imagePanel.setOpaque(false);
                this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
                lower = roleInf.getScore(0);
                for(int i=0; i<4;i++){
                	if(roleInf.getScore(i)>higher){
                		higher = roleInf.getScore(i);
                		higherIndex = i;
                	}
                	if(roleInf.getScore(i)<lower){
                		lower = roleInf.getScore(i);
                		lowerIndex = i;
                	}
                }
                for(int k=0; k<4;k++){
                	if(k!=higherIndex && k!=lowerIndex){
                                if(roleInf.getScore(k)>second){
                                        second = roleInf.getScore(k);
                                        secondIndex = k;
                                }else if(roleInf.getScore(k)<second){
                			third = roleInf.getScore(k);
                			thirdIndex = k;
                		}else if(roleInf.getScore(k)==second){
                                        third = roleInf.getScore(k);
                                        thirdIndex = k;
                                }
                	}
                }
                System.out.println("higher: " + higherIndex);
                System.out.println("second: " + secondIndex);
                System.out.println("third: " + thirdIndex);
                System.out.println("lower: " + lowerIndex);
                System.out.println("higher: " + higher);
                System.out.println("second: " + second);
                System.out.println("third: " + third);
                System.out.println("lower: " + lower);
                Font font = new Font("SansSerif", Font.BOLD, 24);
                JTextField onePlayer = new JTextField("player"+Integer.toString(higherIndex+1));
                onePlayer.setOpaque(false); 
                onePlayer.setEditable(false);
                onePlayer.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                onePlayer.setBounds(550,230,100,60);
                onePlayer.setFont(font);
                add(onePlayer);
                JTextField twoPlayer = new JTextField("player"+Integer.toString(secondIndex+1));
                twoPlayer.setOpaque(false); 
                twoPlayer.setEditable(false);
                twoPlayer.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                twoPlayer.setBounds(550,320,100,60);
                twoPlayer.setFont(font);
                add(twoPlayer);
                JTextField threePlayer = new JTextField("player"+Integer.toString(thirdIndex+1));
                threePlayer.setOpaque(false); 
                threePlayer.setEditable(false);
                threePlayer.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                threePlayer.setBounds(550,420,100,60);
                threePlayer.setFont(font);
                add(threePlayer);
                JTextField fourPlayer = new JTextField("player"+Integer.toString(lowerIndex+1));
                fourPlayer.setOpaque(false); 
                fourPlayer.setEditable(false);
                fourPlayer.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                fourPlayer.setBounds(550,510,100,60);
                fourPlayer.setFont(font);
                add(fourPlayer);
                JTextField onePlayerScore = new JTextField(Integer.toString(roleInf.getScore(higherIndex)));
                onePlayerScore.setOpaque(false); 
                onePlayerScore.setEditable(false);
                onePlayerScore.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                onePlayerScore.setBounds(900,230,100,60);
                onePlayerScore.setFont(font);
                onePlayerScore.setHorizontalAlignment(JTextField.CENTER);
                add(onePlayerScore);
                JTextField twoPlayerScore = new JTextField(Integer.toString(roleInf.getScore(secondIndex)));
                twoPlayerScore.setOpaque(false); 
                twoPlayerScore.setEditable(false);
                twoPlayerScore.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                twoPlayerScore.setBounds(900,320,100,60);
                twoPlayerScore.setFont(font);
                twoPlayerScore.setHorizontalAlignment(JTextField.CENTER);
                add(twoPlayerScore);
                JTextField threePlayerScore = new JTextField(Integer.toString(roleInf.getScore(thirdIndex)));
                threePlayerScore.setOpaque(false); 
                threePlayerScore.setEditable(false);
                threePlayerScore.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                threePlayerScore.setBounds(900,420,100,60);
                threePlayerScore.setFont(font);
                threePlayerScore.setHorizontalAlignment(JTextField.CENTER);
                add(threePlayerScore);
                JTextField fourPlayerScore = new JTextField(Integer.toString(roleInf.getScore(lowerIndex)));
                fourPlayerScore.setOpaque(false); 
                fourPlayerScore.setEditable(false);
                fourPlayerScore.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                fourPlayerScore.setBounds(900,510,100,60);
                fourPlayerScore.setFont(font);
                fourPlayerScore.setHorizontalAlignment(JTextField.CENTER);
                add(fourPlayerScore);

	}
	
	
}