import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;//don't forget to import objects!!!
public class BattleGame{
  public static void playGame(){
    //create the player and the enemy
    String playerFile = "player.txt";
    String monsterFile = "monster.txt";
    try{
      Character player = FileIO.readCharacter(playerFile);
      System.out.println(player);
      Character monster = FileIO.readCharacter(monsterFile);
      System.out.println(monster); //print info of both chars
      ArrayList<Spell> spells = FileIO.readSpells("spells.txt");
      for(Spell n : spells) {
        System.out.println(n);
      }
      Character.setSpells(spells);
      //take commands from the user
      Scanner sc = new Scanner(System.in);
      boolean keepLooping = true;
      while(keepLooping){
        System.out.println("Enter a command:");
        String input = sc.nextLine();
        input = input.trim(); 
        //removes whitespace at the beginning and the end
        if(input.equals("quit")){
          System.out.println("Goodbye!");
          keepLooping = false;
        }else if(input.equals("attack")){
          boolean doNextAttack = true;
          doAttack(player, monster);
          if(monster.getCurrHealth() <= 0){
            System.out.println(monster.getName() + " was knocked out!");
            doNextAttack = false; 
            //if knocked out, the monster could not attack
            player.increaseWins();
            keepLooping = false;
          }
          System.out.println(monster.roundInfo());
          if(doNextAttack){ //if the monster was not knocked out
            doAttack(monster, player);
            if(player.getCurrHealth() <= 0){
              System.out.println(player.getName() + " was knocked out!");
              monster.increaseWins();
              keepLooping = false;
            }
            System.out.println(player.roundInfo());
          }
        }else{          
          boolean doNextAttack = true;
          double damage = player.castSpell(input);
          monster.takeDamage(damage);
          System.out.println(monster.getName() + " takes " +
                             damage + " damage!");
          if(monster.getCurrHealth() <= 0){
            System.out.println(monster.getName() + " was knocked out!");
            doNextAttack = false; 
            //if knocked out, the monster could not attack
            player.increaseWins();
            keepLooping = false;
          }
          System.out.println(monster.roundInfo());
          if(doNextAttack){ //if the monster was not knocked out
            doAttack(monster, player);
            if(player.getCurrHealth() <= 0){
              System.out.println(player.getName() + " was knocked out!");
              monster.increaseWins();
              keepLooping = false;
            }
            System.out.println(player.roundInfo());
          }
        }
        if(player.getCurrHealth() <= 0) {
          System.out.println("Oh no! You lost!");
          System.out.println(monster.getName() + " has won: " + 
                             monster.getNumOfWins() + " times");
          FileIO.writeCharacter(monster, monsterFile);
        }else if(monster.getCurrHealth() <= 0) {
          System.out.println("Hurray! You win!");
          System.out.println(player.getName() + " has won: " + 
                             player.getNumOfWins() + " times");
          FileIO.writeCharacter(player, playerFile);
        }
      }
      sc.close();
    }catch(IOException e){
      System.out.println("Error with Character files!");
    }
  }
  public static void doAttack(Character a, Character b){
    double aAttack = a.calcAttack();
    String aAttackStr = String.format("%1$.2f", aAttack);
    System.out.println(a.getName() + " attacks for " +
                       aAttackStr + " damage!");
    System.out.println(b.getName() + " takes for " +
                       aAttackStr + " damage!");
    b.takeDamage(aAttack);
    //System.out.println(b.roundInfo());
  }
  
  //main method for tests
  public static void main(String[] args){
    playGame();
  }
}