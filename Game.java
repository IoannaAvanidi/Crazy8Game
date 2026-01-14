//Ioanna Maria Avanidi
//A.M. 4977

import java.util.Scanner;

class Game{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give number of players: ");
        int number = input.nextInt();

        CrazyEights crazyEights = new CrazyEights(number);

        crazyEights.play();

    }
}