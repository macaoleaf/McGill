import java.util.Arrays;

public class Cipher{
  public static void main(String[] args){
    String message = args[0];
    String keyword = args[1];
    System.out.println(vigenereEncode(message, keyword));
  }
  //encoding and decoding a char
  public static char charShift(char a, int n, boolean shiftLeft){
    char result = 0;
    if(n >= 0 && n <= 25){
      if(a >= 'a' && a <= 'z'){
        if(shiftLeft){
          result = (char) (a - n);
        }else{
          result = (char) (a + n);
        }
      }else{
        result = a;
      }
    }else{
      System.out.println("Invalid number entered!");
    }
    if(result > 'z'){
      result -= 26;
    }else if(result < 'a'){
      result += 26;
    }
    return result;
  }
  //Ccipher encoding
  public static String caesarEncode(String message, int key){
    String result = "";
    if(key >= 0 && key <= 25){
      for(int n = 0; n < message.length(); n++){
        char eachChar = message.charAt(n);
        char newChar = charShift(eachChar, key, false);
        result += newChar;
      }
    }else{
      System.out.println("Invalid key number entered!");
    }
    return result;
  }
  //Ccipher decoding
  public static String caesarDecode(String message, int key){
    String result = "";
    if(key >= 0 && key <= 25){
      for(int n = 0; n < message.length(); n++){
        char eachChar = message.charAt(n);
        char newChar = charShift(eachChar, key, true);
        result += newChar;
      }
    }else{
      System.out.println("Invalid key number entered!");
    }
    return result;
  }
  //return any lower case alphabets to the numbered positions
  public static int[] obtainKeys(String input){
    int[] keys = new int[input.length()];
    for(int n = 0; n < input.length(); n++){
      int eachKey = ((int) input.charAt(n)) - 97;
      keys[n] = eachKey;
    }
    return keys;
  }
  //Vcipher encoding
  public static String vigenereEncode(String message, String keyword){
    String result = "";
    int[] keys = obtainKeys(keyword);
    for(int n = 0; n < message.length(); n++){
      int key = keys[n % keyword.length()];
      char eachChar = message.charAt(n);
      char newChar = charShift(eachChar, key, false);
      result += newChar;
    }
    return result;
  }
  //Vcipher decoding
  public static String vigenereDecode(String message, String keyword){
    String result = "";
    int[] keys = obtainKeys(keyword);
    for(int n = 0; n < message.length(); n++){
      int key = keys[n % keyword.length()];
      char eachChar = message.charAt(n);
      char newChar = charShift(eachChar, key, true);
      result += newChar;
    }
    return result;
  }
}