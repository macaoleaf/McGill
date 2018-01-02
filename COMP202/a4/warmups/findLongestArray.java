public class findLongestArray{
  public static void main(String[] args){
    int[][] arr = {{1,2,1},{8,6}};
    int largestLength = longestSubArray(arr);
    System.out.println(largestLength);
  }
  public static int longestSubArray(int[][] arr){
    int length = 0;
    for(int n = 0; n < arr.length; n++){
      int num = arr[n].length;
      if(num > length){
        length = num;
      }
    }
    return length;
  }
}