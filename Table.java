//Ioanna Maria Avanidi
//A.M. 4977

import java.util.ArrayList;

class Table{
    private Pile pile = new Pile();
    private ArrayList<Card> awayList = new ArrayList<Card>();
    private Card topCard;

    public Table(){
        pile.fill();
        topCard = pile.nextCard();
    }

    public void throwCard(Card card){
        awayList.add(card);
        topCard=card;
    }

    public Card drawCard(){
        if (!pile.isEmpty()){
            return pile.nextCard();
        }else{
            System.out.println("Its empty. Lets Refil!");
            pile.fill(awayList);
            return pile.nextCard();
        }
    }

    public Card getTopCard(){
        return topCard;
    }

    public static void main(String[] args) {
        Table table = new Table();

        for (int i = 0; i <79; i++) {
            System.out.println(table.drawCard());

            table.throwCard(table.getTopCard());
        }   
    }
}