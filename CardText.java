import java.util.*;
import java.io.*;
public class CardText {
    private String path;
    private ArrayList<String> cardMessage = new ArrayList<String>();
    public CardText(String path){
        this.path = path;
        try{
            StringBuffer sb = new StringBuffer("");
            FileInputStream fileName = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileName, "Big5"));
            String str = null;

            while ((str = br.readLine()) != null){
                sb.append(str + "\n");
                cardMessage.add(str);
                // System.out.println(str);
            }

            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCardText(){
        return this.cardMessage;
    }

    // public static void main(String[] args){
    //     CardText ct = new CardText("cardText.txt");
    //     ArrayList cm = new ArrayList();
    //     cm = ct.getCardText();
    //     System.out.println(cm.get(0));
    // }
}