import java.io.*;
import java.util.ArrayList;
public class FileIO{
  public static void writeCharacter(Character toWrite, String filename){
    //very similar to reading a file
    try{
    FileWriter fw = new FileWriter(filename);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(toWrite.getName() + "\n");
    bw.write(toWrite.getAttack() + "\n");
    bw.write(toWrite.getMaxHealth() + "\n");
    bw.write(toWrite.getNumOfWins() + "\n");
    bw.close();
    }catch(IOException e){
    System.out.println("Cannot write to: " + filename);
    }
  }
  public static Character readCharacter(String filename) 
                                        throws IOException{
    ArrayList<String> list = new ArrayList<String>();
    try{
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);
      String currentLine = br.readLine();
      while(currentLine != null){
        list.add(currentLine);
        currentLine = br.readLine();
      }
      br.close(); //put four lines of info into ArrayList
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
    }catch(IOException e){
      System.out.println("Error with file: " + filename);
    }
    String name = list.get(0);
    double attack = Double.parseDouble(list.get(1));
    double maxHealth = Double.parseDouble(list.get(2));
    int numOfWins = Integer.parseInt(list.get(3));
    Character role = new Character(name, attack, maxHealth, numOfWins);
    return role; //combine and make a new Character
  }
  public static ArrayList<Spell> readSpells(String filename){
  	  ArrayList<Spell> spellList = new ArrayList<Spell>();
  	  ArrayList<String> eachLine = new ArrayList<String>();
    try{
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);
      String currentLine = br.readLine();
      while(currentLine != null){
        eachLine.add(currentLine);
        currentLine = br.readLine();
      }
      br.close();
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
    }catch(IOException e){
      System.out.println("Error with file: " + filename);
    }
    for(int n = 0; n < eachLine.size(); n++) {
      String[] tokens = eachLine.get(n).split(" ");
      String name = tokens[0];
      double minDamage = Double.parseDouble(tokens[1]);
      double maxDamage = Double.parseDouble(tokens[2]);
      double spellChance = Double.parseDouble(tokens[3]);
      Spell newSpell = new Spell(name, minDamage, maxDamage, spellChance);
      spellList.add(newSpell);
    }
    return spellList;
  }
  
  //main method for tests
  public static void main(String[] args){
    String filename = "spells.txt";
    readSpells(filename);
  }
}