public class subArraySame{
  public static void main(String[] args){
    int[][] arr = {{1,1,4}, {6,6}};
    boolean result = subArraySame(arr);
    System.out.println(result);
  }
  public static boolean subArraySame(int[][] arr){
    boolean same = true;
    for(int n = 0; n < arr.length; n++){
      int ruler = arr[n][0];
      for(int x = 0; x < arr[n].length; x++){
        if(arr[n][x] != ruler){
          same = false;
        }
      }
    }
    return same;
  }
}