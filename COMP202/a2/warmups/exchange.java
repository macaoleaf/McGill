public class exchange{
  public static void main(String[] args){
    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);
    swap(x, y);
    System.out.println("outside swap:  x is: " + x + " y is: " + y);
  }
  public static void swap(int x, int y){
    System.out.println("inside swap:  x is: " + x + " y is: " + y);
    int z = x;
    x = y;
    y = z;
    System.out.println("inside swap:  x is: " + x + " y is: " + y);
  }
}

//The values of x and y are not different than before.
//Because variables are independent in each braces.