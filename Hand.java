//Ioanna Maria Avanidi
//A.M. 4977 

import java.util.HashMap;
import java.util.ArrayList;

class Hand{
    private ArrayList<Card> List = new ArrayList<Card>();
    private HashMap<String, Integer> colorCountMap = new HashMap<String, Integer>();

    public Hand(){
        colorCountMap.put("H", 0);
        colorCountMap.put("D", 0);
        colorCountMap.put("C", 0);
        colorCountMap.put("S", 0);
    }

    public void addCard(Card card){
        List.add(card);

        if (card.getColor()=="H"){
            colorCountMap.put("H", colorCountMap.get("H")+1);
        }else if(card.getColor()=="D"){
            colorCountMap.put("D", colorCountMap.get("D")+1);
        }else if(card.getColor()=="C"){
            colorCountMap.put("C", colorCountMap.get("C")+1);
        }else{
            colorCountMap.put("S", colorCountMap.get("S")+1);
        }
    }

    public void removeCard(Card card){
        List.remove(card);

        if (card.getColor()=="H"){
            colorCountMap.remove("H", colorCountMap.get("H")-1);
        }else if(card.getColor()=="D"){
            colorCountMap.remove("D", colorCountMap.get("D")-1);
        }else if(card.getColor()=="C"){
            colorCountMap.remove("C", colorCountMap.get("C")-1);
        }else{
            colorCountMap.remove("S", colorCountMap.get("S")-1);
        }
    }

    public Card getCard(int pos){
        return List.get(pos);
    }

    public void printHand(){
        for (int i = 0; i < List.size() ; i++) {
            System.out.print(i + "  ");
        }
        System.out.println(" ");
        for (int i = 0; i < List.size(); i++) {
            System.out.print(List.get(i) + " ");
        }
    }

    public boolean isEmpty(){
        return(List.size()==0);
    }

    public Card findMatchingCard(Card card){
        for (int i = 0; i < List.size(); i++) {
            if (card.matches(List.get(i))){
                return List.get(i);
            }         
        }

        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).isEight()){
                List.get(i).setColor(maxColor());
                return List.get(i);
            }
        }

        return null;
    }
    
    public String maxColor(){
        int maxValue=0;
        for (String k : colorCountMap.keySet()) {
            if(colorCountMap.get(k)>maxValue){
                maxValue=colorCountMap.get(k);
            }
        }

        for (String k : colorCountMap.keySet()) {
            if(colorCountMap.get(k)==maxValue){
                return k;
            }
        }
        return "Error 404: Color not found!";
    }

    public static void main(String[] args) {
        Pile pile = new Pile();

        pile.fill();

        Hand hand = new Hand();
        for (int i = 0; i < 8; i++) {
            hand.addCard(pile.nextCard());
        }

        hand.findMatchingCard(hand.getCard(2));

        hand.printHand();

        while(!hand.isEmpty()){
            hand.removeCard(hand.getCard(0));
        }
    }
}