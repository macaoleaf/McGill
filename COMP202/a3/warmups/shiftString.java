public class shiftString{
  public static void main(String[] args){
    String s = args[0];
    int n = Integer.parseInt(args[1]);
    System.out.println(shiftString(s, n));
  }
  public static String shiftString(String s, int n){
    String shift = "";
    if(n >= 0){
      for(int a = (s.length() - n % s.length()); a <= (s.length() - 1); a++){
        shift = shift + s.charAt(a);
      }
      for(int a = 0; a <= (s.length() - n % s.length() - 1); a++){
        shift = shift + s.charAt(a);
      }
    }else{
      for(int a = (-n % s.length()); a <= (s.length() - 1); a++){
        shift = shift + s.charAt(a);
      }
      for(int a = 0; a <= (-n % s.length() - 1); a++){
        shift = shift + s.charAt(a);
      }
    }
    return shift;
  }
}