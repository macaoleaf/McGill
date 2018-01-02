public class Circle{
  public static void main(String[] args){
    int r = Integer.parseInt(args[0]);
    int a = Integer.parseInt(args[1]);
    int b = Integer.parseInt(args[2]);
    char symbol = args[3].charAt(0); //hint from StackOverflow
    drawCircle(r, a, b, symbol);
  }
  public static void drawCircle(int r, int a, int b, char symbol){
    verifyInput(r, a, b);
    //tests passed, start to draw
    System.out.print("^"); //draw the arrow of y-axis
    //if the circle fits in the 9 * 9 coordinates
    if((r + a) <= 9 && (r + b) <= 9){
      for(int y = 9; y >= 0; y--){
        System.out.println();
        for(int x = 0; x <= 9; x ++){
          boolean drawable = onCircle(r, a, b, x, y);
          if(drawable){
            System.out.print(symbol);
          }else if(x == 0 && y == 0){
            System.out.print("+");
          }else if(x == 0){
            System.out.print("|");
          }else if(y == 0){
            System.out.print("-");
          }else{
            System.out.print(" ");
          }
        }
      }
      System.out.println(">");
    }else{
      for(int y = (r + b); y >= 0; y--){
        System.out.println();
        for(int x = 0; x <= (r + a); x ++){
          boolean drawable = onCircle(r, a, b, x, y);
          if(drawable){
            System.out.print(symbol);
          }else if(x == 0 && y == 0){
            System.out.print("+");
          }else if(x == 0){
            System.out.print("|");
          }else if(y == 0){
            System.out.print("-");
          }else{
            System.out.print(" ");
          }
        }
      }
      System.out.println(">");
    }
  }
  public static boolean onCircle(int r, int a, int b, int x, int y){
    return (r * r <= ((x - a) * (x - a) + (y - b) * (y - b)) && ((x - a) * (x - a) + (y - b) * (y - b)) <= (r * r + 1));
  }
  public static void verifyInput(int r, int a, int b){
    if(a < r || b < r){
      throw new IllegalArgumentException("Circle must fit in upper right quadrant");
    }else if(r <= 0){
      throw new IllegalArgumentException("Circle must have positive radius");
    }
  }
}