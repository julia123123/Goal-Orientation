import java.awt.*;
import java.lang.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Mainpage extends JFrame {
    public static final int WIDTH=1280;
    public static final int HEIGHT=720;
    public static GamePage game;

    public Mainpage(){
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon background=new ImageIcon("Resource/ENTRY.png");
        JLabel label = new JLabel(background);
        label.setBounds(0,0,WIDTH,HEIGHT);
        JPanel imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//        JFrame frame = new JFrame();
//        frame.getLayeredPane().add(label,10);
//        JPanel jp=(JPanel)frame.getContentPane();
//        jp.setOpaque(false);
        
        JPanel wt=new JPanel();
        wt.setOpaque(false);
        BoxLayout box=new BoxLayout(wt,BoxLayout.Y_AXIS);
        wt.setLayout(box);
        setTitle("SDGSGOALMATCH");
        setLayout(new BorderLayout());
        wt.add(Box.createVerticalStrut(300));

        JButton startbutton=new JButton();
        startbutton.setOpaque(false);
        startbutton.setBorder(null);
        startbutton.setContentAreaFilled(false);
        startbutton.setFocusPainted(false);
        startbutton.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) { 
                new start();
                dispose();
            }
        } );
        ImageIcon starticon = new ImageIcon("Resource/START.png");
        startbutton.setIcon(starticon);
        startbutton.setBorderPainted(false);
        startbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wt.add(startbutton);
        wt.add(Box.createVerticalStrut(5));
        
        JButton helpbutton=new JButton();
        helpbutton.setOpaque(false);
        helpbutton.setBorder(null);
        helpbutton.setContentAreaFilled(false);
        helpbutton.setFocusPainted(false);
        helpbutton.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) { 
                new help();
            }
        } );
        
        ImageIcon helpicon = new ImageIcon("Resource/HELP.png");
        helpbutton.setIcon(helpicon);
        helpbutton.setBorderPainted(false);
        helpbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wt.add(helpbutton);
        wt.add(Box.createVerticalStrut(5)); 
        
        JButton endbutton=new JButton();
        endbutton.setOpaque(false);
        endbutton.setBorder(null);
        endbutton.setContentAreaFilled(false);
        endbutton.setFocusPainted(false);
        endbutton.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) { 
                System.exit(0);
            }
        } );
        
        ImageIcon exiticon = new ImageIcon("Resource/EXIT.png");
        endbutton.setIcon(exiticon);
        endbutton.setBorderPainted(false);
        endbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wt.add(endbutton);

        add(wt);
    }


     class start extends JFrame{
         public start(){
            DrawLotsPage drawLotsWindow = new DrawLotsPage();
            drawLotsWindow.setVisible(true);
            game=new GamePage();
            game.setVisible(false);
         }
     }
     class help extends JFrame{
         public help(){
            Rulepage rule=new Rulepage();
            rule.setVisible(true);
         }
     }

  }
