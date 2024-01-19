import java.util.*;
import javax.swing.*;

public class MessageDisplay implements Runnable{
	
	private JLabel textLabel;
	private JPanel upperPanel;
	
	public MessageDisplay(JLabel textLabel, JPanel upperPanel){
		this.textLabel = textLabel;
		this.upperPanel = upperPanel;
	}

	@Override
	public void run(){
		for(int i=0; i<1;i++){
			if(i==0){
				for(int playtime2=0;playtime2<3;playtime2++){
					textLabel.setText("computer now is playing.");
					doNothing(700);
					textLabel.setText("computer now is playing..");
					doNothing(700);
					textLabel.setText("computer now is playing...");
					doNothing(700);
				}
			}
		// 	}else if(i==1){
		// 		for(int playtime3=0;playtime3<6;playtime3++){
		// 			textLabel.setText("player 3 is playing.");
		// 			doNothing(300);
		// 			textLabel.setText("player 3 is playing..");
		// 			doNothing(300);
		// 			textLabel.setText("player 3 is playing...");
		// 			doNothing(300);
		// 		}
		// 	}else if(i==2){
		// 		for(int playtime3=0;playtime3<6;playtime3++){
		// 			textLabel.setText("player 4 is playing.");
		// 			doNothing(300);
		// 			textLabel.setText("player 4 is playing..");
		// 			doNothing(300);
		// 			textLabel.setText("player 4 is playing...");
		// 			doNothing(300);
		// 		}
			// }
		}
		for(int playtime4=0;playtime4<2;playtime4++){
					textLabel.setText("now is your turn.");
					doNothing(300);
					textLabel.setText("now is your turn..");
					doNothing(300);
					textLabel.setText("now is your turn...");
					doNothing(300);
				}
	}

	public void doNothing(int millisecond) {
	        try {
	    	    Thread.sleep(millisecond);
	 	    } catch (InterruptedException e) {
	 	    	System.out.println("Unexpected interruption");
	 	    	System.exit(0);
	 	    }
	}

}

