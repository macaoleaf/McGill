import java.util.Arrays;
public class scalarMultiply{
  public static void main(String[] args){ //main method for tests
    double[] a = new double[3];
    a[0] = 1;
    a[1] = 2;
    a[2] = 3;
    System.out.println(Arrays.toString(a));
    scalarMultiply(a, 2);
    System.out.println(Arrays.toString(a));
  }
  public static void scalarMultiply(double[] a, double scale){
    for(int n = 0; n < a.length; n++){
      a[n] = a[n] * scale;
    }
    //this method should be static, otherwise it wouldn't be used in the main method.
    //if also change the main method into non-static, an error occurs
    /*java.lang.NullPointerException*/
  }
}