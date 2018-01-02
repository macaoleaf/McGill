//my first version:
/*public class getRandomNumber{
  public static void main(String[] args){
    int min = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);
    if(min >= max){
      System.out.println("Invalid inputs!");
    }else{
      System.out.println(getRandomNumber(min, max));
    }
  }
  public static int getRandomNumber(int min, int max){
    int num = (int) (Math.random() * max);
    while(num < min){
      num = (int) (Math.random() * max);
    }
    return num;
  }
}*/
  
  /*first bug is missing the parentheses btw random num * max
   so that all results are zero - typical problem mentioned in slides!*/
  
  
//second version:
  public class getRandomNumber{
  public static void main(String[] args){
    int min = Integer.parseInt(args[0]);
    int max = Integer.parseInt(args[1]);
    if(min >= max){
      System.out.println("Invalid inputs!");
    }else{
      System.out.println(getRandomNumber(min, max));
    }
  }
  
  public static int getRandomNumber(int min, int max){
    int num = (int) (min + Math.random() * (max - min));
    return num;
  }
}

//this works very well.
/*the second version is much better than the first one, 
 for it doesn't waste computing resource
 by skipping loops for determining which to choose.*/