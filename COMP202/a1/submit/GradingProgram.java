public class GradingProgram{
  //this is the main method
  public static void main(String[] args){
    double a = Double.parseDouble(args[0]);
    double b = Double.parseDouble(args[1]);
    double c = Double.parseDouble(args[2]);
    printInput(a, b, c); //print entered numbers
    double result = finalGrade(a, b, c);
    System.out.println(result); //print the final grade
  }    
  //method of printing out numbers entered
  public static void printInput(double a, double b, double c){
    System.out.println("You entered " + a + ", " + b + ", and " + c);
  }    
  //method divide
  public static double divide(double d, double e){
    if (e == 0){ //see if the second parameter is zero        
      System.out.println("Error occurs! The second parameter cannot be zero.");
      return 0;
    }else{
      return d / e;
    }
  }
  //method getMax
  public static double getMax(double f, double g){
    if (f > g){
      return f;
    }else{
      return g;
    } //return the number which is no smaller than another
  }
  //final grade calculation
  public static double finalGrade(double a, double b, double c){
    double mid = divide((a + b + c), 100); //when midterm is better
    double non_mid = divide((a + c), 80);  //when final is better
    double finalpercentage = getMax(mid, non_mid);  //determine which one is larger
    double finalgrade = finalpercentage * 100; //calculate the final grade
    return finalgrade;
  }
}