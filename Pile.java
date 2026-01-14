//Ioanna Maria Avanidi
//A.M. 4977

import java.util.ArrayList;
import java.util.Random;

class Pile{
    private int capacity=40;
    private int size=0;
    private Card[] stack = new Card[capacity];
    Random rand = new Random();

    public void push(Card card){
        if (size == capacity){
            System.out.println("Cannot enter any more Cards");
            return;
        }

        stack[size] = card;
        size ++;
        capacity = stack.length;
        }

    public void fill(){
        for (int i = 0; i < 10; i++) {
            Card card = new Card("H", i);
            push(card);
        }

        for (int i = 0; i < 10; i++) {
            Card card = new Card("C", i);
                push(card);
        }

        for (int i = 0; i < 10; i++) {
            Card card = new Card("S", i);
                push(card);
        }

        for (int i = 0; i < 10; i++) {
            Card card = new Card("D", i);
                push(card);
        }
        
        shuffle();
    }

    public void fill(ArrayList<Card> cardArray){

        size=0;

        for (int i = 0; i < stack.length; i++) {
            cardArray.add(i, stack[i]);
            size++;
        }
        capacity = cardArray.size();
        //shuffle
        for (int i = 0; i < cardArray.size(); i++) {
            int rndPos = rand.nextInt(cardArray.size());
            Card temp = cardArray.get(i);
            
            cardArray.set(i, cardArray.get(rndPos));
            cardArray.set(rndPos, temp);
        }
    }

    private void shuffle(){
        for (int i = 0; i < stack.length; i++) {
            int rndPos = rand.nextInt(size);
            Card temp = stack[i];
            
            stack[i] = stack[rndPos];
            stack[rndPos] = temp;
        }
    }

    public Card nextCard(){
        size -- ;
        capacity = stack.length;
        return stack[size];    
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public void print(){
        for (int i = 0; i < stack.length; i++) {
           System.out.print(stack[i]+" "); 
        }
    }

    public static void main(String[] args) {
        
        Pile pile = new Pile();

        pile.fill();

        pile.print();
    }
} 