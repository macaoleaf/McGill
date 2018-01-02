import java.util.ArrayList;
public class ArrayListExample{
  public static void main(String[] args){
    //how to create an ArrayList that stores Strings
    ArrayList<String> list = new ArrayList<String>();
    
    //you put the type the ArrayList will store in angle bracket
    System.out.println("Size: " + list.size()); //0
    list.add("COMP");
    list.add("202");
    System.out.println("Size: " + list.size()); //2
    System.out.println(list); //[COMP, 202]
    String s = list.get(0); 
    System.out.println("First element: " + s); //COMP
    list.remove(0);
    System.out.println(list); //[202]
    list.clear();
    System.out.println(list); //[]
  }
}