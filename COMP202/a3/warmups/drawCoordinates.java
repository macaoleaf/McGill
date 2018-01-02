public class drawCoordinates{
  public static void main(String[] args){
    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);
    if(x >= 0 && x <= 9 && y >= 0 && y <= 9){
      drawCoordinates(x, y);
    }else{
      System.out.println("Invalid inputs!");
    }
  }
  public static void drawCoordinates(int x, int y){
    System.out.println("^"); //draw the arrow of y-axis
    for(int yy = y; yy >= 1; yy--){
      System.out.print("|"); //draw the body of y-axis
      for(int xx = 1; xx <= x; xx++){
        System.out.print("(" + xx + "," + yy + ")"); //print the coordinates
      }
      System.out.println(); //go to the next row
    }
    System.out.print("+"); //draw the origin
    for(int n = 0; n < x; n++){
      System.out.print("-----"); //draw the body of x-axis
    }
    System.out.println(">"); //draw the arrow of x-axis
  }
}
