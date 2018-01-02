public class Gambling{
  public static void main(String[] args){
    double deposit = Double.parseDouble(args[0]);
    double wager = Double.parseDouble(args[1]); //input total money and one single bet
    double remain = passLineBet(deposit, wager);
    System.out.println("You now have:  $" + remain);
  }
  //pass line bet
  public static double passLineBet(double deposit, double wager){
    boolean canPlay = canPlay(deposit, wager); //determine if the player is allowed to play
    double remain = deposit; //set the initial value of remaining money
    if(canPlay == false){
      System.out.println("Insufficient funds.  You cannnot play.");
    }else{
      int point = diceRoll(); //get the first rolling value
      if(point == 7 || point == 11){ //when win,
        System.out.println("A " + point + " has been rolled.  You win!");
        remain += wager;
      }else if(point == 2 || point == 3 || point == 12){ //when lose,
        System.out.println("A " + point + " has been rolled.  You lose!");
        remain -= wager;
      }else{ //when need to roll again,
        System.out.println("A " + point + " has been rolled.  Roll again!");
        int endPoint = secondStage(point); //take another roll
        System.out.println(""); //print the result to next line
        if(endPoint == point){
          System.out.println("You win!");
          remain += wager;
        }else{
          System.out.println("You lose!");
          remain -= wager;
        }
      }
    }
    return remain;
  }
  //show the result of the dice rolls
  public static int diceRoll(){
    int diceOne = (int) (1 + Math.random() * 6); //the result of first dice
    int diceTwo = (int) (1 + Math.random() * 6); //the result of second dice
    int diceRoll = diceOne + diceTwo; //sum - final point
    return diceRoll;
  }
  //simulate the second stage of the bet
  public static int secondStage(int point){
    int finalNumber = diceRoll(); //get the first rolling
    System.out.print(finalNumber);
    while(finalNumber != 7 && finalNumber != point){
      finalNumber = diceRoll();
      System.out.print(", " + finalNumber); //print all results
    }
    return finalNumber;
  }
  //check if the player has enough money
  public static boolean canPlay(double deposit, double wager){
    boolean canPlay = deposit >= wager && deposit > 0;
    return canPlay;
  }
}