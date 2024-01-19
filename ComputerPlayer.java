import java.util.*;
import java.io.*;
import java.util.Collections;

public class ComputerPlayer{
	private DrawStraw strawResult;
	private CardInfo cardInf;
	private RoleInfo roleInf;
	private ArrayList<Integer> deskTopCard;
	private ArrayList<Integer> deckCardNum;
	private ArrayList<Integer> player2Deck;
	private ArrayList<Integer> player3Deck;
	private ArrayList<Integer> player4Deck;
	private HashMap<Integer, Integer> changeCard = new HashMap<>(); // 0(pair), 01, 02(deck pair) -> remove, 1 -> add
	// private JButton upper_1, upper_2, upper_3, upper_4, upper_5, upper_6, upper_7, upper_8, center_1, center_2, center_3, center_4, center_5, center_6, center_7, center_8, down_1, down_2, down_3, down_4, down_5, down_6, down_7;

	public ComputerPlayer(DrawStraw strawResult, ArrayList<Integer> deskTopCard, ArrayList<Integer> deskCardNum,  CardInfo cardInf, RoleInfo roleInf){
		this.strawResult = strawResult;
		this.deskTopCard = deskTopCard;
		this.deckCardNum = deskCardNum;
		this.cardInf = cardInf;
		this.roleInf = roleInf;
		player2Deck = strawResult.getRole2Deck();
		player3Deck = strawResult.getRole3Deck();
		player4Deck	= strawResult.getRole4Deck();

		AutoPairCard autoPlayer2 = new AutoPairCard(player2Deck, deskTopCard, cardInf, roleInf, 1);
		Thread autoThreadPlayer2 = new Thread(autoPlayer2);
		AutoPairCard autoPlayer3 = new AutoPairCard(player3Deck, deskTopCard, cardInf, roleInf, 2);
		Thread autoThreadPlayer3 = new Thread(autoPlayer3);
		AutoPairCard autoPlayer4 = new AutoPairCard(player4Deck, deskTopCard, cardInf, roleInf, 3);
		Thread autoThreadPlayer4 = new Thread(autoPlayer4);
		autoThreadPlayer2.start();
		try{
			System.out.println("Current Thread 2: " + Thread.currentThread().getName());
            autoThreadPlayer2.join();
           	if(autoPlayer2.getMatch()==true){
           		ArrayList<Integer[]> player2Pair = new ArrayList<Integer[]>();
           		player2Pair = autoPlayer2.getPair();
           		Collections.shuffle(player2Pair);
           		System.out.println("Computer2 HandCard: " + player2Pair.get(0)[0]); //handCard
           		changeCard.put(20, player2Pair.get(0)[1]); //remove deskCard on desk
           		roleInf.addScore(1, cardInf.getPoint(autoPlayer2.getHandNum()-1) + cardInf.getPoint(autoPlayer2.getDeskNum()-1));
           		System.out.println("Computer2 DeskCard: " + player2Pair.get(0)[1]); //deskCard
              // roleInf.addScore(1, cardInf.getPoint(player2Pair.get(0)[0]-1) + cardInf.getPoint(player2Pair.get(0)[1]-1));
           		for(int handNum2=0; handNum2<player2Deck.size(); handNum2++){
           			if(player2Deck.get(handNum2)==player2Pair.get(0)[0]){
           				player2Deck.remove(handNum2);
           				break;
           			}
           		}
           		for(int deskNum2=0; deskNum2<deskTopCard.size(); deskNum2++){
           			if(deskTopCard.get(deskNum2)==player2Pair.get(0)[1]){
           				deskTopCard.remove(deskNum2);
           				break;
           			}
           		}
           	}else{
           		ArrayList<Integer> player2Throw = new ArrayList<Integer>();
           		// for(int player2D = 0; player2D<player2Deck.size(); player2D++){
           		// 	player2Throw.add(player2Deck.get(player2D));
           		// }
           		
           		Collections.shuffle(player2Deck);
           		System.out.println("Throw2: " + player2Deck.get(0));
           		player2Throw.add(player2Deck.get(0));
           		deskTopCard.add(player2Deck.get(0));
           		changeCard.put(21, player2Throw.get(0)); //add card to the desk
           		player2Throw.remove(0);
           	}
           	//deck
       		ArrayList<Integer> deckNum = new ArrayList<Integer>();
       		deckNum.add(deckCardNum.get(0));
       		deckCardNum.remove(0);
       		changeCard.put(211, deckNum.get(0));
       		deskTopCard.add(deckNum.get(0));
       		AutoPairCard autoThrowPlayer2 = new AutoPairCard(deckNum, deskTopCard, cardInf, roleInf, 1);
       		Thread autoThrowThreadPlayer2 = new Thread(autoThrowPlayer2);
       		if(autoThrowPlayer2.getMatch()==true){
       			//remove the deckNum on desk (deskTopCard)
            roleInf.addScore(1, cardInf.getPoint(deckNum.get(0)-1) + cardInf.getPoint(autoThrowPlayer2.getPair().get(0)[1]-1));
       			for(int throw2=0; throw2<deskTopCard.size(); throw2++){
       				if(deckNum.get(0)==deskTopCard.get(throw2)){
       					changeCard.put(201, deskTopCard.get(throw2)); //remove card from desk
       					System.out.println("Throw2 pair 1 of deck : " + deskTopCard.get(throw2));
       					deskTopCard.remove(throw2); //the throw card on the desk
       					break;
       				}
       			}
       			//remove the pair card on desk (deskTopCard)
       			for(int throwPair2=0; throwPair2<deskTopCard.size(); throwPair2++){
       				if(autoThrowPlayer2.getPair().get(0)[1]==deskTopCard.get(throwPair2)){
       					changeCard.put(202, deskTopCard.get(throwPair2)); //remove card from desk
       					System.out.println("Throw2 pair 1 : " + deskTopCard.get(throwPair2));
       					deskTopCard.remove(throwPair2);
       					break;
       				}
       			}
       		}
		}catch(InterruptedException e2){
			e2.printStackTrace();
		}
		autoThreadPlayer3.start();
		try{
			System.out.println("Current Thread 2: " + Thread.currentThread().getName());
            autoThreadPlayer3.join();
           	if(autoPlayer3.getMatch()==true){
           		ArrayList<Integer[]> player3Pair = new ArrayList<Integer[]>();
           		player3Pair = autoPlayer3.getPair();
           		Collections.shuffle(player3Pair);
           		System.out.println("Computer3 HandCard: " + player3Pair.get(0)[0]); //handCard
           		changeCard.put(30, player3Pair.get(0)[1]); //remove deskCard on desk
           		roleInf.addScore(2, cardInf.getPoint(player3Pair.get(0)[0]-1) + cardInf.getPoint(player3Pair.get(0)[1]-1));
           		System.out.println("Computer3 DeskCard: " + player3Pair.get(0)[1]); //deskCard
           		for(int handNum3=0; handNum3<player3Deck.size(); handNum3++){
           			if(player3Deck.get(handNum3)==player3Pair.get(0)[0]){
           				player3Deck.remove(handNum3);
           				break;
           			}
           		}
           		for(int deskNum3=0; deskNum3<deskTopCard.size(); deskNum3++){
           			if(deskTopCard.get(deskNum3)==player3Pair.get(0)[1]){
           				deskTopCard.remove(deskNum3);
           				break;
           			}
           		}
           	}else{
           		ArrayList<Integer> player3Throw = new ArrayList<Integer>();
           		// for(int player2D = 0; player2D<player3Deck.size(); player2D++){
           		// 	player3Throw.add(player3Deck.get(player2D));
           		// }
           		
           		Collections.shuffle(player3Deck);
           		System.out.println("Throw3: " + player3Deck.get(0));
           		player3Throw.add(player3Deck.get(0));
           		deskTopCard.add(player3Deck.get(0));
           		changeCard.put(31, player3Throw.get(0)); //add card to the desk
           		player3Throw.remove(0);
           	}
           	//deck
       		ArrayList<Integer> deckNum = new ArrayList<Integer>();
       		deckNum.add(deckCardNum.get(0));
       		deckCardNum.remove(0);
       		changeCard.put(311, deckNum.get(0));
       		deskTopCard.add(deckNum.get(0));
       		AutoPairCard autoThrowPlayer3 = new AutoPairCard(deckNum, deskTopCard, cardInf, roleInf, 2);
       		Thread autoThrowThreadPlayer3 = new Thread(autoThrowPlayer3);
       		if(autoThrowPlayer3.getMatch()==true){
       			//remove the deckNum on desk (deskTopCard)
       			roleInf.addScore(2, cardInf.getPoint(deckNum.get(0)-1) + cardInf.getPoint(autoThrowPlayer3.getPair().get(0)[1]-1));
       			for(int throw3=0; throw3<deskTopCard.size(); throw3++){
       				if(deckNum.get(0)==deskTopCard.get(throw3)){
       					changeCard.put(301, deskTopCard.get(throw3)); //remove card from desk
       					System.out.println("Throw3 pair 1 of deck : " + deskTopCard.get(throw3));
       					deskTopCard.remove(throw3); //the throw card on the desk
       					break;
       				}
       			}
       			//remove the pair card on desk (deskTopCard)
       			for(int throwPair3=0; throwPair3<deskTopCard.size(); throwPair3++){
       				if(autoThrowPlayer3.getPair().get(0)[1]==deskTopCard.get(throwPair3)){
       					changeCard.put(302, deskTopCard.get(throwPair3)); //remove card from desk
       					System.out.println("Throw3 pair 1 : " + deskTopCard.get(throwPair3));
       					deskTopCard.remove(throwPair3);
       					break;
       				}
       			}
       		}
		}catch(InterruptedException e3){
			e3.printStackTrace();
		}
		autoThreadPlayer4.start();
		try{
        System.out.println("Current Thread 2: " + Thread.currentThread().getName());
        autoThreadPlayer4.join();
       	if(autoPlayer3.getMatch()==true){
       		ArrayList<Integer[]> player4Pair = new ArrayList<Integer[]>();
       		player4Pair = autoPlayer4.getPair();
       		Collections.shuffle(player4Pair);
       		System.out.println("Computer4 HandCard: " + player4Pair.get(0)[0]); //handCard
       		changeCard.put(40, player4Pair.get(0)[1]); //remove deskCard on desk
       		roleInf.addScore(3, cardInf.getPoint(player4Pair.get(0)[0]-1) + cardInf.getPoint(player4Pair.get(0)[1]-1));
       		System.out.println("Computer4 DeskCard: " + player4Pair.get(0)[1]); //deskCard
       		for(int handNum4=0; handNum4<player4Deck.size(); handNum4++){
       			if(player4Deck.get(handNum4)==player4Pair.get(0)[0]){
       				player4Deck.remove(handNum4);
       				break;
       			}
       		}
       		for(int deskNum4=0; deskNum4<deskTopCard.size(); deskNum4++){
       			if(deskTopCard.get(deskNum4)==player4Pair.get(0)[1]){
       				deskTopCard.remove(deskNum4);
       				break;
       			}
       		}
       	}else{
       		ArrayList<Integer> player4Throw = new ArrayList<Integer>();
       		// for(int player2D = 0; player2D<player4Deck.size(); player2D++){
       		// 	player4Throw.add(player4Deck.get(player2D));
       		// }
       		
       		Collections.shuffle(player4Deck);
       		System.out.println("Throw4: " + player4Deck.get(0));
       		player4Throw.add(player4Deck.get(0));
       		deskTopCard.add(player4Deck.get(0));
       		changeCard.put(41, player4Throw.get(0)); //add card to the desk
       		player4Throw.remove(0);
       	}
       	//deck
   		ArrayList<Integer> deckNum = new ArrayList<Integer>();
   		deckNum.add(deckCardNum.get(0));
   		deckCardNum.remove(0);
   		changeCard.put(411, deckNum.get(0));
   		deskTopCard.add(deckNum.get(0));
   		AutoPairCard autoThrowPlayer4 = new AutoPairCard(deckNum, deskTopCard, cardInf, roleInf, 3);
   		Thread autoThrowThreadPlayer4 = new Thread(autoThrowPlayer4);
   		if(autoThrowPlayer4.getMatch()==true){
   			//remove the deckNum on desk (deskTopCard)
   			roleInf.addScore(3, cardInf.getPoint(deckNum.get(0)-1) + cardInf.getPoint(autoThrowPlayer4.getPair().get(0)[1]-1));
   			for(int throw4=0; throw4<deskTopCard.size(); throw4++){
   				if(deckNum.get(0)==deskTopCard.get(throw4)){
   					changeCard.put(401, deskTopCard.get(throw4)); //remove card from desk
   					System.out.println("Throw4 pair 1 of deck : " + deskTopCard.get(throw4));
   					deskTopCard.remove(throw4); //the throw card on the desk
   					break;
   				}
   			}
   			//remove the pair card on desk (deskTopCard)
   			for(int throwPair4=0; throwPair4<deskTopCard.size(); throwPair4++){
   				if(autoThrowPlayer4.getPair().get(0)[1]==deskTopCard.get(throwPair4)){
   					changeCard.put(402, deskTopCard.get(throwPair4)); //remove card from desk
   					System.out.println("Throw4 pair 1 : " + deskTopCard.get(throwPair4));
   					deskTopCard.remove(throwPair4);
   					break;
   				}
   			}
   		}
		}catch(InterruptedException e4){
			e4.printStackTrace();
		}

		// autoThreadPlayer3.start();
		// try{
		// 	System.out.println("Current Thread 3: " + Thread.currentThread().getName());
		// 	System.out.println("Ohh lalalala");
  //           autoThreadPlayer3.join();
		// }catch(InterruptedException e3){
		// 	e3.printStackTrace();
		// }
		// autoThreadPlayer4.start();
		// try{
		// 	System.out.println("Current Thread 4: " + Thread.currentThread().getName());
		// 	System.out.println("Ohh lalalalalala");
  //           autoThreadPlayer4.join();
		// }catch(InterruptedException e4){
		// 	e4.printStackTrace();
		// }
		
	}

	// public static void main(String[] args){
	// 	ArrayList<Integer> deskTopCard = new ArrayList<Integer>();
	// 	ArrayList<Integer> result = new ArrayList<Integer>();
 //        ArrayList<Integer> deskCardNum = new ArrayList<Integer>();
 //        ArrayList<String> cardText = new ArrayList<String>();
	// 	RoleInfo roleInf = new RoleInfo();
	// 	CardInfo cardInf = new CardInfo();
 //        try {
 //            cardInf.Load("card.txt");
 //        }catch(IOException e){
 //            e.printStackTrace();
 //        }
 //        CardText cardMessage = new CardText("cardText.txt");
 //        cardText = cardMessage.getCardText();
 //        DrawStraw strawResult = new DrawStraw(result, deskCardNum);
 //        ComputerPlayer cp = new ComputerPlayer(strawResult, deskTopCard, cardInf, roleInf);
 //        // Integer[] x =new Integer[]{1,2};
 //        // Integer[] y =new Integer[]{3,4};
 //        // Integer[] z =new Integer[]{5,6};
 //        // ArrayList<Integer[]> player2Pair = new ArrayList<Integer[]>();
 //        // player2Pair.add(x);
 //        // player2Pair.add(y);
 //        // player2Pair.add(z);
 //        // Collections.shuffle(player2Pair);
 //        // System.out.println(player2Pair.get(0)[0] +", "+ player2Pair.get(0)[1]);

	// }

	public HashMap<Integer, Integer> getChangeCard(){
		return this.changeCard;
	}

}

// public class ComputerPlayer implements Runnable{

// 	private DrawStraw strawResult;
// 	private ArrayList<Integer> player2Deck;
// 	private ArrayList<Integer> player3Deck;
// 	private ArrayList<Integer> player4Deck;

// 	public ComputerPlayer(DrawStraw strawResult, ){
// 		this.strawResult = strawResult;

// 	}
	
// 	@Override
// 	public void run(){
// 		player2Deck = strawResult.getRole2Deck;
// 		player3Deck = strawResult.getRole3Deck;
// 		player4Deck	= strawResult.getRole4Deck;

// 	}
// }