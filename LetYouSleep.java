import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class LetYouSleep implements Runnable{
	
	private int millisecond;
	private HashMap<Integer, Integer> computerDo;
	private ArrayList<Integer> deskTopCard;
	private JPanel centerPanel;
	private JButton center_1, center_2, center_3, center_4, center_5, center_6, center_7, center_8;
	public LetYouSleep(JPanel centerPanel, HashMap<Integer, Integer> computerDo, int millisecond, ArrayList<Integer> deskTopCard, JButton center_1, JButton center_2, JButton center_3, JButton center_4, JButton center_5, JButton center_6, JButton center_7, JButton center_8){
		this.millisecond = millisecond;
		this.centerPanel = centerPanel;
		this.computerDo = computerDo;
		this.deskTopCard = deskTopCard;
		this.center_1 = center_1;
		this.center_2 = center_2;
		this.center_3 = center_3;
		this.center_4 = center_4;
		this.center_5 = center_5;
		this.center_6 = center_6;
		this.center_7 = center_7;
		this.center_8 = center_8;

	}
	
	@Override
	public void run(){
		// for (Map.Entry<Integer, Integer> x : computerDo.entrySet()){
  //       	System.out.println("Key: " + x.getKey() + " Value: " + x.getValue());
  //       }
		for(int k=0;k<3;k++){
			System.out.println(k);
			while(k==0){
	        	if(computerDo.containsKey(20)){
		            Integer value = computerDo.get(20);
		            System.out.println("Value: " + value);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
		            	doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		            	center_2.setEnabled(false);
		            	doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		            	center_3.setEnabled(false);
		            	doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		            	center_4.setEnabled(false);
		            	doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		            	center_5.setEnabled(false);
		            	doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		            	center_6.setEnabled(false);
		            	doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		            	center_7.setEnabled(false);
		            	doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		            	center_8.setEnabled(false);
		            	doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);
		            }
		            System.out.println("Computer20 Sleeping");
		            computerDo.remove(20);
       			 }else if(computerDo.containsKey(21)){
		            Integer value = computerDo.get(21);
		            if((center_1.getActionCommand()).equals("0")){
		                center_1.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_1.setIcon(icon);
		                center_1.setVisible(true);
		                // centerPanel.add(center_1);
		            }else if((center_2.getActionCommand()).equals("0")){
		                center_2.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_2.setIcon(icon);
		                center_2.setVisible(true);
		                // center_2.addActionListener();
		                // centerPanel.add(center_2);
		            }else if((center_3.getActionCommand()).equals("0")){
		                center_3.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_3.setIcon(icon);
		                center_3.setVisible(true);
		                // centerPanel.add(center_3);
		            }else if((center_4.getActionCommand()).equals("0")){
		                center_4.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_4.setIcon(icon);
		                center_4.setVisible(true);
		                // centerPanel.add(center_4);
		            }else if((center_5.getActionCommand()).equals("0")){
		                center_5.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_5.setIcon(icon);
		                center_5.setVisible(true);
		                // centerPanel.add(center_5);
		            }else if((center_6.getActionCommand()).equals("0")){
		                center_6.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_6.setIcon(icon);
		                center_6.setVisible(true);
		                // centerPanel.add(center_6);
		            }else if((center_7.getActionCommand()).equals("0")){
		                center_7.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_7.setIcon(icon);
		                center_7.setVisible(true);
		                // centerPanel.add(center_7);
		            }else if((center_8.getActionCommand()).equals("0")){
		                center_8.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_8.setIcon(icon);
		                center_8.setVisible(true);
		                // centerPanel.add(center_8);
		            }
		            System.out.println("Computer21 Sleeping");
		            computerDo.remove(21);
		        }else if(computerDo.containsKey(211)){
		            Integer value = computerDo.get(211);
		            if((center_1.getActionCommand()).equals("0")){
		                center_1.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_1.setIcon(icon);
		                center_1.setVisible(true);
		                // centerPanel.add(center_1);
		            }else if((center_2.getActionCommand()).equals("0")){
		                center_2.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_2.setIcon(icon);
		                center_2.setVisible(true);
		                // centerPanel.add(center_2);
		            }else if((center_3.getActionCommand()).equals("0")){
		                center_3.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_3.setIcon(icon);
		                center_3.setVisible(true);
		                // centerPanel.add(center_3);
		            }else if((center_4.getActionCommand()).equals("0")){
		                center_4.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_4.setIcon(icon);
		                center_4.setVisible(true);
		                // centerPanel.add(center_4);
		            }else if((center_5.getActionCommand()).equals("0")){
		                center_5.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_5.setIcon(icon);
		                center_5.setVisible(true);
		                // centerPanel.add(center_5);
		            }else if((center_6.getActionCommand()).equals("0")){
		                center_6.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_6.setIcon(icon);
		                center_6.setVisible(true);
		                // centerPanel.add(center_6);
		            }else if((center_7.getActionCommand()).equals("0")){
		                center_7.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_7.setIcon(icon);
		                center_7.setVisible(true);
		                // centerPanel.add(center_7);
		            }else if((center_8.getActionCommand()).equals("0")){
		                center_8.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_8.setIcon(icon);
		                center_8.setVisible(true);
		                // centerPanel.add(center_8);
		            }
		            System.out.println("Computer211 Sleeping");
		            computerDo.remove(211);
		        }else if(computerDo.containsKey(201)){
		            Integer value = computerDo.get(201);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
	            		doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		                center_2.setEnabled(false);
	            		doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		                center_3.setEnabled(false);
	            		doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		                center_4.setEnabled(false);
	            		doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		                center_5.setEnabled(false);
	            		doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		                center_6.setEnabled(false);
	            		doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		                center_7.setEnabled(false);
	            		doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		                center_8.setEnabled(false);
	            		doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);

		            }
		            System.out.println("Computer201 Sleeping");
		            computerDo.remove(201);
		        }else if(computerDo.containsKey(202)){
		            Integer value = computerDo.get(202);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
	            		doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		                center_2.setEnabled(false);
	            		doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		                center_3.setEnabled(false);
	            		doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		                center_4.setEnabled(false);
	            		doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		                center_5.setEnabled(false);
	            		doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		                center_6.setEnabled(false);
	            		doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		                center_7.setEnabled(false);
	            		doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		                center_8.setEnabled(false);
	            		doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);

		            }
		            System.out.println("Computer202 Sleeping");
		            computerDo.remove(202);
		        }else{break;}
		    }
		    while(k==1){
		    	if(computerDo.containsKey(30)){
		            Integer value = computerDo.get(30);
		            System.out.println("Value: " + value);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
		            	doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		            	center_2.setEnabled(false);
		            	doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		            	center_3.setEnabled(false);
		            	doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		            	center_4.setEnabled(false);
		            	doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		            	center_5.setEnabled(false);
		            	doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		            	center_6.setEnabled(false);
		            	doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		            	center_7.setEnabled(false);
		            	doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		            	center_8.setEnabled(false);
		            	doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);
		            }
		            System.out.println("Computer30 Sleeping");
		            computerDo.remove(30);
       			 }else if(computerDo.containsKey(31)){
		            Integer value = computerDo.get(31);
		            if((center_1.getActionCommand()).equals("0")){
		                center_1.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_1.setIcon(icon);
		                center_1.setVisible(true);
		                // centerPanel.add(center_1);
		            }else if((center_2.getActionCommand()).equals("0")){
		                center_2.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_2.setIcon(icon);
		                center_2.setVisible(true);
		                // centerPanel.add(center_2);
		            }else if((center_3.getActionCommand()).equals("0")){
		                center_3.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_3.setIcon(icon);
		                center_3.setVisible(true);
		                // centerPanel.add(center_3);
		            }else if((center_4.getActionCommand()).equals("0")){
		                center_4.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_4.setIcon(icon);
		                center_4.setVisible(true);
		                // centerPanel.add(center_4);
		            }else if((center_5.getActionCommand()).equals("0")){
		                center_5.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_5.setIcon(icon);
		                center_5.setVisible(true);
		                // centerPanel.add(center_5);
		            }else if((center_6.getActionCommand()).equals("0")){
		                center_6.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_6.setIcon(icon);
		                center_6.setVisible(true);
		                // centerPanel.add(center_6);
		            }else if((center_7.getActionCommand()).equals("0")){
		                center_7.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_7.setIcon(icon);
		                center_7.setVisible(true);
		                // centerPanel.add(center_7);
		            }else if((center_8.getActionCommand()).equals("0")){
		                center_8.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_8.setIcon(icon);
		                center_8.setVisible(true);
		                // centerPanel.add(center_8);
		            }
		            System.out.println("Computer31 Sleeping");
		            computerDo.remove(31);
		    	}else if(computerDo.containsKey(311)){
		            Integer value = computerDo.get(311);
		            if((center_1.getActionCommand()).equals("0")){
		                center_1.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_1.setIcon(icon);
		                center_1.setVisible(true);
		                // centerPanel.add(center_1);
		            }else if((center_2.getActionCommand()).equals("0")){
		                center_2.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_2.setIcon(icon);
		                center_2.setVisible(true);
		                // centerPanel.add(center_2);
		            }else if((center_3.getActionCommand()).equals("0")){
		                center_3.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_3.setIcon(icon);
		                center_3.setVisible(true);
		                // centerPanel.add(center_3);
		            }else if((center_4.getActionCommand()).equals("0")){
		                center_4.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_4.setIcon(icon);
		                center_4.setVisible(true);
		                // centerPanel.add(center_4);
		            }else if((center_5.getActionCommand()).equals("0")){
		                center_5.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_5.setIcon(icon);
		                center_5.setVisible(true);
		                // centerPanel.add(center_5);
		            }else if((center_6.getActionCommand()).equals("0")){
		                center_6.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_6.setIcon(icon);
		                center_6.setVisible(true);
		                // centerPanel.add(center_6);
		            }else if((center_7.getActionCommand()).equals("0")){
		                center_7.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_7.setIcon(icon);
		                center_7.setVisible(true);
		                // centerPanel.add(center_7);
		            }else if((center_8.getActionCommand()).equals("0")){
		                center_8.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_8.setIcon(icon);
		                center_8.setVisible(true);
		                // centerPanel.add(center_8);
		            }
		            System.out.println("Computer311 Sleeping");
		            computerDo.remove(311);
		    	}else if(computerDo.containsKey(301)){
		            Integer value = computerDo.get(301);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
	            		doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		                center_2.setEnabled(false);
	            		doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		                center_3.setEnabled(false);
	            		doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		                center_4.setEnabled(false);
	            		doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		                center_5.setEnabled(false);
	            		doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		                center_6.setEnabled(false);
	            		doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		                center_7.setEnabled(false);
	            		doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		                center_8.setEnabled(false);
	            		doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);
		            }
		            System.out.println("Computer301 Sleeping");
		            computerDo.remove(301);
		        }else if(computerDo.containsKey(302)){
		            Integer value = computerDo.get(302);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
	            		doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		                center_2.setEnabled(false);
	            		doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		                center_3.setEnabled(false);
	            		doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		                center_4.setEnabled(false);
	            		doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		                center_5.setEnabled(false);
	            		doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		                center_6.setEnabled(false);
	            		doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		                center_7.setEnabled(false);
	            		doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		                center_8.setEnabled(false);
	            		doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);

		            }
		            System.out.println("Computer302 Sleeping");
		            computerDo.remove(302);
		        }else{break;}
		    }
		    while(k==2){
		    	if(computerDo.containsKey(40)){
		            Integer value = computerDo.get(40);
		            System.out.println("Value: " + value);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
		            	doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		            	center_2.setEnabled(false);
		            	doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		            	center_3.setEnabled(false);
		            	doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		            	center_4.setEnabled(false);
		            	doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		            	center_5.setEnabled(false);
		            	doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		            	center_6.setEnabled(false);
		            	doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		            	center_7.setEnabled(false);
		            	doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		            	center_8.setEnabled(false);
		            	doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);
		            }
		            System.out.println("Computer40 Sleeping");
		            computerDo.remove(40);
       			 }else if(computerDo.containsKey(41)){
		            Integer value = computerDo.get(41);
		            if((center_1.getActionCommand()).equals("0")){
		                center_1.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_1.setIcon(icon);
		                center_1.setVisible(true);
		                // centerPanel.add(center_1);
		            }else if((center_2.getActionCommand()).equals("0")){
		                center_2.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_2.setIcon(icon);
		                center_2.setVisible(true);
		                // centerPanel.add(center_2);
		            }else if((center_3.getActionCommand()).equals("0")){
		                center_3.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_3.setIcon(icon);
		                center_3.setVisible(true);
		                // centerPanel.add(center_3);
		            }else if((center_4.getActionCommand()).equals("0")){
		                center_4.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_4.setIcon(icon);
		                center_4.setVisible(true);
		                // centerPanel.add(center_4);
		            }else if((center_5.getActionCommand()).equals("0")){
		                center_5.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_5.setIcon(icon);
		                center_5.setVisible(true);
		                // centerPanel.add(center_5);
		            }else if((center_6.getActionCommand()).equals("0")){
		                center_6.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_6.setIcon(icon);
		                center_6.setVisible(true);
		                // centerPanel.add(center_6);
		            }else if((center_7.getActionCommand()).equals("0")){
		                center_7.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_7.setIcon(icon);
		                center_7.setVisible(true);
		                // centerPanel.add(center_7);
		            }else if((center_8.getActionCommand()).equals("0")){
		                center_8.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_8.setIcon(icon);
		                center_8.setVisible(true);
		                // centerPanel.add(center_8);
		            }
		            System.out.println("Computer41 Sleeping");
		            computerDo.remove(41);
		    	}else if(computerDo.containsKey(411)){
		            Integer value = computerDo.get(411);
		            if((center_1.getActionCommand()).equals("0")){
		                center_1.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_1.setIcon(icon);
		                center_1.setVisible(true);
		                // centerPanel.add(center_1);
		            }else if((center_2.getActionCommand()).equals("0")){
		                center_2.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_2.setIcon(icon);
		                center_2.setVisible(true);
		                // centerPanel.add(center_2);
		            }else if((center_3.getActionCommand()).equals("0")){
		                center_3.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_3.setIcon(icon);
		                center_3.setVisible(true);
		                // centerPanel.add(center_3);
		            }else if((center_4.getActionCommand()).equals("0")){
		                center_4.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_4.setIcon(icon);
		                center_4.setVisible(true);
		                // centerPanel.add(center_4);
		            }else if((center_5.getActionCommand()).equals("0")){
		                center_5.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_5.setIcon(icon);
		                center_5.setVisible(true);
		                // centerPanel.add(center_5);
		            }else if((center_6.getActionCommand()).equals("0")){
		                center_6.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_6.setIcon(icon);
		                center_6.setVisible(true);
		                // centerPanel.add(center_6);
		            }else if((center_7.getActionCommand()).equals("0")){
		                center_7.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_7.setIcon(icon);
		                center_7.setVisible(true);
		                // centerPanel.add(center_7);
		            }else if((center_8.getActionCommand()).equals("0")){
		                center_8.setActionCommand(Integer.toString(value));
		                ImageIcon icon = new ImageIcon(new ImageIcon("card/card_"+value+".png").getImage().getScaledInstance(140, 190, Image.SCALE_AREA_AVERAGING));
		                doNothing(700);
		                center_8.setIcon(icon);
		                center_8.setVisible(true);
		                // centerPanel.add(center_8);
		            }
		            System.out.println("Computer411 Sleeping");
		            computerDo.remove(411);
		    	}else if(computerDo.containsKey(401)){
		            Integer value = computerDo.get(401);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
	            		doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		                center_2.setEnabled(false);
	            		doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		                center_3.setEnabled(false);
	            		doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		                center_4.setEnabled(false);
	            		doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		                center_5.setEnabled(false);
	            		doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		                center_6.setEnabled(false);
	            		doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		                center_7.setEnabled(false);
	            		doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		                center_8.setEnabled(false);
	            		doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);

		            }
		            System.out.println("Computer401 Sleeping");
		            computerDo.remove(401);
		        }else if(computerDo.containsKey(402)){
		            Integer value = computerDo.get(402);
		            if(Integer.toString(value).equals(center_1.getActionCommand())){
		            	center_1.setEnabled(false);
	            		doNothing(700);
		                // center_1.setIcon(null);
		                center_1.setVisible(false);
		                center_1.setEnabled(true);
		                center_1.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_2.getActionCommand())){
		                center_2.setEnabled(false);
	            		doNothing(700);
		                // center_2.setIcon(null);
		                center_2.setVisible(false);
		                center_2.setEnabled(true);
		                center_2.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_3.getActionCommand())){
		                center_3.setEnabled(false);
	            		doNothing(700);
		                // center_3.setIcon(null);
		                center_3.setVisible(false);
		                center_3.setEnabled(true);
		                center_3.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_4.getActionCommand())){
		                center_4.setEnabled(false);
	            		doNothing(700);
		                // center_4.setIcon(null);
		                center_4.setVisible(false);
		                center_4.setEnabled(true);
		                center_4.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_5.getActionCommand())){
		                center_5.setEnabled(false);
	            		doNothing(700);
		                // center_5.setIcon(null);
		                center_5.setVisible(false);
		                center_5.setEnabled(true);
		                center_5.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_6.getActionCommand())){
		                center_6.setEnabled(false);
	            		doNothing(700);
		                // center_6.setIcon(null);
		                center_6.setVisible(false);
		                center_6.setEnabled(true);
		                center_6.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_7.getActionCommand())){
		                center_7.setEnabled(false);
	            		doNothing(700);
		                // center_7.setIcon(null);
		                center_7.setVisible(false);
		                center_7.setEnabled(true);
		                center_7.setActionCommand("0");
		                deskTopCard.add(0);
		            }else if(Integer.toString(value).equals(center_8.getActionCommand())){
		                center_8.setEnabled(false);
	            		doNothing(700);
		                // center_8.setIcon(null);
		                center_8.setVisible(false);
		                center_8.setEnabled(true);
		                center_8.setActionCommand("0");
		                deskTopCard.add(0);

		            }
		            System.out.println("Computer402 Sleeping");
		            computerDo.remove(402);
		        }else{break;}
		    }
		}
	}
	public void doNothing(int milliseconds){
        try {
    	    Thread.sleep(milliseconds);
 	    } catch(InterruptedException e) {
	 	    System.out.println("Unexpected interruption");
	 	    System.exit(0);
 	    }
    }
}