//Ioanna-Maria Avanidi
//A.M. 4977

class Card{
    private String color;
    private int number;
    
    public Card(String color, int number){
        this.color = color;
        this.number = number;
    }

    public String getColor(){
        return color;
    }

    public int getNumber(){
        return number;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String toString(){
        return number+color;
    }

    public boolean isEight(){
        if (number == 8){ 
            return true;
        }
        return false;
    }

    public boolean matches(Card card){
        if ((card.getNumber()==number)||(card.getColor().equals(color))){
            return true;
        }
        return false;
    }
}