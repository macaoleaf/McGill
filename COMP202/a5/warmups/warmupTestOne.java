//imports all the objects we need
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class warmupTestOne{
  public static void main(String[] args){ //question 1-3
    String filename = "dictionary.txt";
    ArrayList<String> list = new ArrayList<String>();
    try{
      //create the FileReader
      FileReader fr = new FileReader(filename);
      //create the BufferedReader
      BufferedReader br = new BufferedReader(fr);
      String currentLine = br.readLine();
      while(currentLine != null){
        list.add(currentLine);
        currentLine = br.readLine();
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
    }catch(IOException e){
      System.out.println("Error with file: " + filename);
    }
    writeWords(list, "AlphaGo", filename); //use the method created below to write in file
    //part below to print out the file is correct
    try{
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);
      String currentLine = br.readLine();
      while(currentLine != null){
        System.out.println(currentLine);
        currentLine = br.readLine();
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
    }catch(IOException e){
      System.out.println("Error with file: " + filename);
    }
    
    String newlist = "";
    for(int n = 0; n < list.size(); n++){
      if(n == 0){
        newlist += list.get(n);
      }else{
        newlist = newlist + " " + list.get(n);
      }
    }
    String[] tokens = newlist.split(" ");
    System.out.println("Number of words: " + tokens.length);
  }
  //question 4
  public static void writeWords(ArrayList<String> list, String wordInput, 
                                String filename){
    //very similar to reading a file
    //have to create two objects
    try{
      FileWriter fw = new FileWriter(filename);
      BufferedWriter bw = new BufferedWriter(fw);
      list.add(wordInput);
      for(int n = 0; n < list.size(); n++){
        bw.write(list.get(n) + "\n");
      }
      bw.close();
    }catch(IOException e){
      System.out.println("Cannot write to: " + filename);
    }
  }
}