import java.util.Arrays;

public class largestAverage{
  public static void main(String[] args){
    double[][] arr = {{1.5, 2.3, 5.7}, {12.5, -50.25}};
    double[] largest = largestAverage(arr);
    System.out.println(Arrays.toString(largest));
  }
  public static double[] largestAverage(double[][] arr){
    double[] largest = {};
    double average = -Double.MAX_VALUE;
    for(int n = 0; n < arr.length; n++){
      double sum = 0;
      for(int x = 0; x < arr[n].length; x++){
        sum += arr[n][x];
      }
      if((sum / arr[n].length) > average){
      average = sum / arr[n].length;
      largest = arr[n];
      }
    }
    return largest;
  }
}