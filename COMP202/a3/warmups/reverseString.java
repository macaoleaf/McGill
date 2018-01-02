public class reverseString{
  public static void main(String[] args){
    String phrase = args[0];
    System.out.println(reverseString(phrase));
  }
  public static String reverseString(String str){
    String reverse = "";
    for(int n = (str.length() - 1); n >= 0; n--){
      reverse = reverse + str.charAt(n);
    }
    return reverse;
  }
}