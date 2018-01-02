public class Counting{
  public static void main(String[] args){
    int boundary = Integer.parseInt(args[0]);
    int step = Integer.parseInt(args[1]);
    counting(boundary, step);
  }
  public static void counting(int boundary, int step){
    System.out.println("I am counting to " + boundary + " with a step size of " + step + ":");
    for(int n = 1; (n < boundary + 1) ; n += step){
      System.out.print(n + " ");
    }
  }
}