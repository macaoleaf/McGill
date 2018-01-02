import java.util.Arrays;
public class deleteStringElement{
  public static void main(String[] args){ //for test
    String[] a = new String[5];
    a[0] = "a";
    a[1] = "j";
    a[2] = "q";
    a[3] = "a";
    a[4] = "k";
    String target = "a";
    String[] result = deleteElement(a, target);
    System.out.println(Arrays.toString(result));
  }
  public static String[] deleteElement(String[] a, String target){
    int count = 0;
    for(int n = 0; n < a.length; n++){
      if(!a[n].equals(target)){
        count++;
      }
    }
    String[] result = new String[count];
    int ruler = 0;
    for(int x = 0; x < a.length; x++){
      if(!a[x].equals(target)){
        result[ruler] = a[x];
        ruler++;
      }
    }
    return result;
  } //this could be static as well.
}
//I mean maybe I did this the wrong way, but I didn't find out the differences lol