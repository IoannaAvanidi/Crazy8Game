//Ioanna Maria Avanidi
//A.M. 4977

class CrazyEights{
    private Table table = new Table();
    private Player[] players;
    private int n;

    public CrazyEights(int n){
        this.n = n;
        this.players = new Player[n];
        for (int i = 0; i < n; i++) {
            if (i==0){
                Player player = new Player("Human");
                players[i] = player;

            }else {
                Player player = new Player("Computer" + i);
                players[i] = player;
            }
        }
    }

    //gia eykolia elegxou tou computer player
    private void delay(int sec){
        try {
            Thread.currentThread().sleep(1000*sec);
        } catch (InterruptedException e) {
            e.printStackTrace();            
        }
    }

    public void play(){
        boolean emptyHands = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                players[i].draw(table);
            }
        }

        while(!emptyHands){
            for (int i = 0; i < n; i++) {
                System.out.println("\n" +"Top Card: " +table.getTopCard());
                if(i==0){
                    System.out.println("Human's turn: ");
                    Card card = players[i].selectCard(table);
                    if (card == null) {
                        players[i].draw(table); 
                        System.out.println("Human drew a card");                       
                    }else{
                        players[i].throwCard(table, card);
                    }
                }else{
                    System.out.println(players[i] +"'s turn");
                    Card card = players[i].computerSelectCard(table);
                    if (card == null) {
                        players[i].draw(table);
                        System.out.println("\n"+players[i] +" drew a card");
                        delay(4);                        
                    }else{
                        players[i].throwCard(table, card);
                        delay(4);
                        System.out.println("\n" +players[i] +" threw card " +card);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (players[i].isDone()) {
                    emptyHands = true;
                    System.out.println();
                    System.out.println("The winner is " +players[i].toString() +"!" );
                    break;
                } else {
                    emptyHands = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        CrazyEights crazyEights = new CrazyEights(4);

        crazyEights.play();
    }
}
