//Ioanna Maria Avanidi
//A.M. 4977

import java.util.Scanner;

class Player {
    private String name;
    private Hand hand = new Hand();

    public Player(String name) {
        this.name = name;
    }

    public void draw(Table table) {
        hand.addCard(table.drawCard());
    }

    public void draw(Table table, int n) {
        for (int i = 0; i < n; i++) {
            hand.addCard(table.drawCard());
        }
    }

    public void throwCard(Table table, Card card) {
        table.throwCard(card);
        hand.removeCard(card);
    }

    public boolean isDone() {
        return (hand.isEmpty());
    }

    public String toString() {
        return name;
    }

    public Card selectCard(Table table) {
        hand.printHand();

        Scanner input = new Scanner(System.in);
        System.out.printf("\nSelect Card to throw or -1 to pass:");
        int printer = input.nextInt();
        

        if (printer == -1) {
            return null;
        } else if (hand.getCard(printer).isEight()) {
            System.out.println("Select Color:");
            String color = input.next();
            hand.getCard(printer).setColor(color);
        } else {
            if (hand.getCard(printer).matches(table.getTopCard())) {
                return hand.getCard(printer);
            } else {
                selectCard(table);
            }
        }

        return hand.getCard(printer);
    }

    public Card computerSelectCard(Table table) {
        hand.printHand();
        return hand.findMatchingCard(table.getTopCard());
    }

    public static void main(String[] args) {
        Player player = new Player("Iwanna");
        Table table = new Table();

        player.draw(table);

        player.draw(table, 2);

        while(!player.isDone()){
            System.out.println("Top Card: " +table.getTopCard());

            Card card = player.selectCard(table);

            if (card == null) {
                System.out.println();
                player.draw(table);
            }else{
                player.throwCard(table, card);
            }

            if (player.isDone()) {
                break;
            }
        }
    }
}