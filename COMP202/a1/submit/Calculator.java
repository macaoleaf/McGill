public class Calculator{
  //this is the main method
  public static void main(String[] args){       
    //input a, b and c and transfer them into certain forms
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    float c = Float.parseFloat(args[2]);
    //instructions to calculations and logical operations:
    //print the sum
    System.out.println("Sum of a and b: " + (a + b));       
    //print the product
    System.out.println("Product of a and b: " + (a * b));       
    //print the integer division
    System.out.println("Dividing a by b: " + (a / b));        
    //print the division
    System.out.println("Dividing a by c: " + (a / c));        
    //test if a > b is true or not
    boolean is_a_larger_than_b = a > b;
    System.out.println("Is a larger than b: " + is_a_larger_than_b);       
    //test if a is an odd number or not
    boolean is_a_odd = a % 2 != 0;
    System.out.println("Is a odd: " + is_a_odd);      
  }   
}

