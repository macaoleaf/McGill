package Users.zisheng.GitHub.McGill_COMP250.a1.out.production.a1;
import java.math.BigInteger;

public class TesterPosted {

 public static void main(String[] args) throws Exception {

  //  You can test the correctness of your NaturalNumber implementation 
  //  by using Java's BigInteger class.  

  //  Here is an example.  

  //String s1 = "42345614234561000343453440000343453440";
  //String s2 = "22320000423456100034345344000042";

  int base = 10;
  String s1 = "101010101011010010100101101011011010110101010011010101001011001011010100110110010101010101010101010101010101011010100111011101010010110111110011101010111010101110101010110111011010101010101010101010100101010101100101011010101010010101010011001110101010101010101010101010101010101010011010100101010001001100110100101";
  String s2 = "101001110110101101110011010111110101010101001111010010101100101000101010101001101010101001011110111111110111011101111111111010001010010111011111001101110111110001010101101011010101001010101010110111010100010011010111101010101010101100110101110111101011110010101101001010010101100100101010101101010";

  BigInteger big1 = new BigInteger(s1,base);
  BigInteger big2 = new BigInteger(s2,base);

  NaturalNumber n1 = new NaturalNumber(s1, base);
  System.out.println("n1 is    " + n1);
  NaturalNumber n2 = new NaturalNumber(s2, base);
  System.out.println("n2 is    " + n2);
  System.out.println("");

  //plus
  System.out.print("sum: big1+big2 =        (");
  System.out.println(big1.add(big2).toString(base) + ")_" + base );  // BigInteger
  System.out.print("sum: n1+n2     =        ");
  System.out.println(n1.plus(n2));                     // NaturalNumber
  System.out.println();

  //minus
  System.out.print("diff: big1-big2 =       (");
  System.out.println(big1.subtract(big2).toString(base)  + ")_" + base );  // BigInteger
  System.out.print("diff: n1-n2     =       ");
  System.out.println(n1.minus(n2));                         // NaturalNumber
  System.out.println();

  //multiply
  System.out.print("multiply: big1*big2   = ("  );              // BigInteger
  System.out.print(big1.multiply(big2).toString(base)  );
  System.out.println( ")_" + base);

  System.out.print("multiply: n1*n2       = ");               // NaturalNumber
  System.out.println(n1.times(n2));
  System.out.println();

//  System.out.print("slow multiply: n1*n2  = ");               // NaturalNumber
//  System.out.println(n1.slowTimes(n2));
//  System.out.println();

  //divide
  System.out.print("divide: big1/big2     = (");              // BigInteger  
  System.out.println(big1.divide(big2).toString(base)  + ")_" + base);
  System.out.println();

//  System.out.print("slow divide: n1/n2    = ");               // NaturalNumber
//  System.out.println(n1.slowDivide(n2));
//  System.out.println();

  System.out.print("divide: n1/n2         = ");                 // NaturalNumber
  System.out.println(n1.divide(n2));
  //mod

  System.out.print("mod = (");
  System.out.print(big1.subtract(big1.divide(big2).multiply(big2)).toString(base)  + ")_" + base);
  System.out.println(" (indirectly)");
  System.out.print("mod = (");
  System.out.println(big1.mod(big2).toString(base)  + ")_" + base);

 }

}