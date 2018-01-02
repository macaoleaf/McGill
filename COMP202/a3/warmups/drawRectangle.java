public class drawRectangle{
  public static void main(String[] args){
    int length = Integer.parseInt(args[0]);
    int width = Integer.parseInt(args[1]);
    drawRectangle(length, width);
  }
  public static void drawRectangle(int length, int width){
    for(int l = 0; l < length; l++){
      if(l == 0 || l == (length - 1)){ //if it is at the top or bottom,
        for(int w = 0; w < width; w++){
          System.out.print("*"); //draw a line
        }
        System.out.println();
      }else{ //if in the middle,
        for(int w = 0; w < width; w++){
          if(w == 0 || w == (width - 1)){
          System.out.print("*"); //only draw boundaries
          }else{
            System.out.print(" ");
          }
        }
        System.out.println();
      }
    }
  }
}