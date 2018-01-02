package Users.zisheng.GitHub.McGill_COMP250.a1.out.production.a1;

/*
 *   STUDENT NAME      : Zisheng Ye
 *   STUDENT ID        : 260714548
 *
 *   If you have any issues that you wish the T.A.s to consider, then you
 *   should list them here.   If you discussed on the assignment in depth
 *   with another student, then you should list that student's name here.
 *   We insist that you each write your own code.   But we also expect
 *   (and indeed encourage) that you discuss some of the technical
 *   issues and problems with each other, in case you get stuck.
  Issue(s):

  Slow multiply too slow (about 5 minutes) when two numbers are 9-digit * 9-digit at base 10;

  My codes are written in Intellij IDEA with Tab,
  so there might be some improper indentation when you examine it.
  However I'm sure that it looked good when I uploaded it.
  If there is any issue about this, please feel free to contact me. I'll show you my GitHub commits.

  Discussion:

  I had some discussions with Ian Tsai.
  He asked me some ideas at:
  plus - how to put them into the list and print it out
  multiplication - how to write the helper method, and I told him simple * is allowed;
                   how to combine the helper method to the main multi part
  We discussed about:
  divide - which algorithm is simple to write and not too slow to run
 *
 */

import java.util.LinkedList;

public class NaturalNumber  {

 /*
  *
  *  If the list has N coefficients,  then then the number is represented is a polynomial:
  *  coefficients[N-1] base^{N-1} + ...  coefficients[1] base^{1} +  coefficients[0]
  *  where base has a particular value and the coefficients are in {0, 1, ...  base - 1}
  *
  *  For any base and any positive integer, the representation of that positive
  *  integer as a sum of powers of that base is unique.
  *
  *  We require that the coefficient of the largest power is non-zero.
  *  For example,  '354' is a valid representation (which we call "three hundred fifty four")
  *  but '0354' is not.
  *
  */

  private int base;

  private LinkedList<Integer>  coefficients;

  //  Constructors

  NaturalNumber(int base){

    //  If no string argument is given, then it constructs an empty list of coefficients.

    this.base = base;
    coefficients = new LinkedList<Integer>();
  }

  /*
   *   The constructor builds a LinkedList of Integers where the integers need to be in {0,1,2,3,4...,base-1}.
   *   The string only represents a base 10 number when the base is given to be 10.
   */
  NaturalNumber(String sBase,  int base) throws Exception{
    int i;
    this.base = base;
    coefficients = new LinkedList<Integer>();
    if ((base <2) || (base > 10)){
      System.out.println("constructor error:  base must be between 2 and 10");
      throw new Exception();
    }

  /*
   *    The large integer inputs will be read in as strings with character digits.
   *    These characters will need to be converted to integers.   The characters are represented
   *    in ASCII.   See the decimal (dec) and character (char) values in
   *    http://www.asciitable.com/  ).   The ASCII value of symbol '0' is 48,  and the ASCII value
   *    of symbol '1' is 49, etc.  So for example to get the numerical value of '2', we subtract
   *    the character value of '0' (48) from the character value of '2' (50).
   */

    int l = sBase.length();
    for (int indx = 0; indx < l; indx++){
      i = sBase.charAt(indx);
      if ( (i >= 48) && (i - 48 < base))
        coefficients.addFirst( new Integer(i-48) );
      else{
        System.out.println("constructor error:  all coefficients should be non-negative and less than base");
        throw new Exception();
      }
    }
  }

 /*
  *   Construct a NaturalNumber object for a number that has just one digit in [0, base).
  *
  *   This constructor acts as a helper.  It is not called from the Tester class.
  */

  NaturalNumber(int i,  int base) throws Exception{
    this.base = base;
    coefficients = new LinkedList<Integer>();

    if ((i >= 0) && (i < base))
      coefficients.addFirst( new Integer(i) );
    else {
      System.out.println("constructor error: all coefficients should be non-negative and less than base");
      throw new Exception();
    }
  }

 /*
  *   The plus method computes this.plus(b), that is, a+b where 'this' is a.
  *
  *   If you do not know what the Java keyword 'this' is,  then see
  *   https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
  *
  */

 /*
  * Getter for both the private variables- Added by Navin/Ramchalam for testGrader
  */

  public int getBase()
  {
    return base;
  }
  public LinkedList<Integer>  getCoefficients()
  {
    return coefficients;
  }



  //To perform a+b, call a.plus(b). The parameter second refers to the second operand in a+b, that is, b

  public NaturalNumber plus( NaturalNumber  second) throws Exception{

    //  initialize the sum as an empty list of coefficients

    NaturalNumber sum = new NaturalNumber( this.base );

    if (this.base != second.base){
      System.out.println("ERROR: bases must be the same in an addition");
      throw new Exception();
    }

  /*
   * The plus method must not affect the numbers themselves.
   * So let's just work  with a copy (a clone) of the numbers.
   */

    NaturalNumber  firstClone  = this.clone();
    NaturalNumber  secondClone = second.clone();

  /*
   *   If the two numbers have a different polynomial order
   *   then pad the smaller one with zero coefficients.
   */

    int   diff = firstClone.coefficients.size() - second.coefficients.size();
    while (diff < 0){  // second is bigger

      firstClone.coefficients.addLast(0);
      diff++;
    }
    while (diff > 0){  //  this is bigger
      secondClone.coefficients.addLast(0);
      diff--;
    }

    //   ADD YOUR CODE HERE

    //  ---------  BEGIN SOLUTION (plus)  ----------
    //
    //   Note 'firstClone' and 'secondClone' have the same size.  We add the coefficients
    //   term by term.    If the last coefficient yields a carry, then we add
    //   one more term with the carry.
    int carry = 0;
    for(int i = 0; i < firstClone.coefficients.size(); i++) {
      int digitNum = (firstClone.coefficients.get(i) + secondClone.coefficients.get(i) + carry) % base;
      sum.coefficients.addLast(digitNum);
      carry = (firstClone.coefficients.get(i) + secondClone.coefficients.get(i) + carry) / base;
    }
    if (carry == 1){
      sum.coefficients.addLast(carry);
    }
    //  ---------  END SOLUTION (plus)  ----------

    return sum;
  }


 /*
  *    Slow multiplication algorithm, mentioned in lecture 1.
  *    You need to implement the plus algorithm in order for this to work.
  *
  *    'this' is the multiplicand i.e. a*b = a+a+a+...+a (b times) where a is multiplicand and b is multiplier
  */

  public NaturalNumber slowTimes( NaturalNumber  multiplier) throws Exception{

    NaturalNumber prod  = new NaturalNumber(0, this.base);
    NaturalNumber one   = new NaturalNumber(1, this.base);
    for (NaturalNumber counter = new NaturalNumber(0, this.base);  counter.compareTo(multiplier) < 0;  counter = counter.plus(one) ){
      prod = prod.plus(this);
    }
    return prod;
  }

 /*
  *    The multiply method must NOT be the same as what you learned in grade school since
  *    that method uses a temporary 2D table with space proportional to the square of
  *    the number of coefficients in the operands i.e. O(N^2).   Instead, you must write a method
  *    that uses space that is proportional to the number of coefficients i.e. O(N).
  *    Your algorithm will still take time O(N^2) however.
  */

 /*   The multiply method computes this.multiply(b) where 'this' is a.
  */

  public NaturalNumber times( NaturalNumber multiplicand) throws Exception{

    //  initialize product as an empty list of coefficients

    NaturalNumber product = new NaturalNumber( this.base );

    if (this.base != multiplicand.base){
      System.out.println("ERROR: bases must be the same in a multiplication");
      throw new Exception();
    }

    //    ADD YOUR CODE HERE

    // --------------  BEGIN SOLUTION (multiply)  ------------------

  /*
   *           multiplicand
   *          x  multiplier  (this)
   *        ---------------
   *
   *   Note we use a helper method.  See below.
   */

    NaturalNumber multiplierClone = this.clone();
    for (int i = 0; i < multiplierClone.coefficients.size(); i++){
      NaturalNumber numToPlus = multiplicand.timesSingleDigit(multiplierClone.coefficients.get(i)).timesBaseToThePower(i);
      product = product.plus(numToPlus);
    }

    //  ---------------  END SOLUTION  (multiply) -------------------

    return product;
  }


  // -------- BEGIN SOLUTION     *helper method* for multiply  -----
  /*
   *    'this' (the caller) will be the multiplicand.
   */
  private NaturalNumber timesSingleDigit(int singleDigit){
    NaturalNumber timesSingleDigit = new NaturalNumber(this.base);
    NaturalNumber multiplicandClone = this.clone();
    int carry = 0;
    for(int i = 0; i < multiplicandClone.coefficients.size(); i++){
      int digitNum = (multiplicandClone.coefficients.get(i) * singleDigit + carry) % base;
      timesSingleDigit.coefficients.addLast(digitNum);
      carry = (multiplicandClone.coefficients.get(i) * singleDigit + carry) / base;
    }
    if (carry != 0){
      timesSingleDigit.coefficients.addLast(carry);
    }
    return timesSingleDigit;
  }

  //   END SOLUTION ----------  *helper method* for multiply ---------


 /*
  *   The minus method computes this.minus(b) where 'this' is a, and a > b.
  *   If a < b, then it throws an exception.
  *
  */

  public NaturalNumber  minus(NaturalNumber second) throws Exception{

    //  initialize the result (difference) as an empty list of coefficients

    NaturalNumber  difference = new NaturalNumber(this.base);

    if (this.base != second.base){
      System.out.println("ERROR: bases must be the same in a subtraction");
      throw new Exception();
    }
  /*
   *    The minus method is not supposed to change the numbers.
   *    But the grade school algorithm sometimes requires us to "borrow"
   *    from a higher coefficient to a lower one.   So we work
   *    with a copy (a clone) instead.
   */

    NaturalNumber  first = this.clone();

    //   You may assume 'this' > second.

    if (this.compareTo(second) < 0){
      System.out.println("Error: the subtraction a-b requires that a > b");
      throw new Exception();
    }

    //   ADD YOUR CODE HERE

    //  ---------  BEGIN SOLUTION (minus)  ----------
    NaturalNumber  firstClone  = this.clone();
    NaturalNumber  secondClone = second.clone();

    //just make two lists the same size like in plus method
    int   diff = firstClone.coefficients.size() - second.coefficients.size();
    while (diff > 0){  //  this is bigger
      secondClone.coefficients.addLast(0);
      diff--;
    }
    for(int i = 0; i < firstClone.coefficients.size(); i++) {
      int borrow = 0;
      if (firstClone.coefficients.get(i) < secondClone.coefficients.get(i)){
        borrow = base;
        firstClone.coefficients.set(i+1, firstClone.coefficients.get(i+1)-1); //borrowing process
      }
      int digitNum = firstClone.coefficients.get(i) + borrow - secondClone.coefficients.get(i);
      difference.coefficients.addLast(digitNum);
    }

    //  ---------  END SOLUTION (minus)  ----------

  /*
   *  In the case of say  100-98, we will end up with 002.
   *  Remove all the leading 0's of the result.
   *
   *  We are giving you this code because you could easily neglect
   *  to do this check, which would mess up grading since correct
   *  answers would appear incorrect.
   */

    while ((difference.coefficients.size() > 1) &
        (difference.coefficients.getLast().intValue() == 0)){
      difference.coefficients.removeLast();
    }
    return difference;
  }


 /*
  *    Slow division algorithm, mentioned in lecture 1.
  */


  public NaturalNumber slowDivide( NaturalNumber  divisor) throws Exception{

    NaturalNumber quotient = new NaturalNumber(0,base);
    NaturalNumber one = new NaturalNumber(1,base);
    NaturalNumber remainder = this.clone();
    while ( remainder.compareTo(divisor) >= 0 ){
      remainder = remainder.minus(divisor);
      quotient = quotient.plus(one);
    }
    return quotient;
  }



 /*
  *  The divide method divides 'this' by 'divisor' i.e. this.divide(divisor)
  *   When this method terminates, there is a remainder but it is ignored (not returned).
  *
  */

  public NaturalNumber divide( NaturalNumber  divisor ) throws Exception{

    //  initialize quotient as an empty list of coefficients

    NaturalNumber  quotient = new NaturalNumber(this.base);

    if (this.base != divisor.base){
      System.out.println("ERROR: bases must be the same in an division");
      throw new Exception();
    }

    if(divisor.compareTo(new NaturalNumber(0, this.base))==0){
      System.out.println("ERROR: division by zero not possible");
      throw new Exception();
    }

    NaturalNumber  remainder = this.clone();

    //   ADD YOUR CODE HERE.

    //  --------------- BEGIN SOLUTION (divide) --------------------------
    //make quotient the same size as the dividend
    int   diff = this.coefficients.size() - quotient.coefficients.size();
    while (diff > 0){  //  dividend is bigger
      quotient.coefficients.addLast(0);
      diff--;
    }
    NaturalNumber numToDiv = new NaturalNumber(this.base);
    for (int i = this.coefficients.size()-1; i >= 0; i--){
      numToDiv.coefficients.addFirst(this.coefficients.get(i));
      for (int j = 0; j < this.base; j++){ //try from 0 to the maximum possible digit
        NaturalNumber productToCompare = divisor.timesSingleDigit(j);
        if (productToCompare.compareTo(numToDiv) != 1) {
          quotient.coefficients.set(i,j); //first digit's position
          if (j == this.base-1) {
            numToDiv = numToDiv.minus(divisor.timesSingleDigit(j));
          }
        } else {
          if(j != 0) {
            numToDiv = numToDiv.minus(divisor.timesSingleDigit(j - 1));
          }
          j = this.base; //jump out of the loop
        }
      }
      if (i == 0) {
        remainder = numToDiv;
      }
    }
    //delete the leading 0s from the front
    while ((quotient.coefficients.size() > 1) &
        (quotient.coefficients.getLast().intValue() == 0)){
      quotient.coefficients.removeLast();
    }
    System.out.println("My mode: " + remainder);
    // -------------  END SOLUTION  (divide)  ---------------------

    return quotient;
  }

  //   Helper methods

 /*
  * The methods you write to add, subtract, multiply, divide
  * should not alter the two numbers.  If a method require
  * that one of the numbers be altered (e.g. borrowing in subtraction)
  * then you need to clone the number and work with the cloned number
  * instead of the original.
  */

  @Override
  public NaturalNumber  clone(){

    //  For technical reasons that don't interest us now (and perhaps ever), this method
    //  has to be declared public (not private).

    NaturalNumber copy = new NaturalNumber(this.base);
    for (int i=0; i < this.coefficients.size(); i++){
      copy.coefficients.addLast( new Integer( this.coefficients.get(i) ) );
    }
    return copy;
  }

 /*
  *  The subtraction method (minus) computes a-b and requires that a>b.
  *  The a.compareTo(b) method is useful for checking this condition.
  *  It returns -1 if a < b,  it returns 0 if a == b,
  *  and it returns 1 if a > b.
  *
  *  The compareTo() method assumes that the two numbers have the same base.
  *  One could add code to check this but I didn't.
  */

  private int  compareTo(NaturalNumber second){

    //   if  this < other,  return -1
    //   if  this > other,  return  1
    //   otherwise they are equal and return 0

    //   Assume maximum degree coefficient is non-zero.   Then,  if two numbers
    //   have different maximum degree, it is easy to decide which is larger.

    int diff = this.coefficients.size() - second.coefficients.size();
    if (diff < 0)
      return -1;
    else if (diff > 0)
      return 1;
    else {

      //   If two numbers have the same maximum degree,  then it is a bit trickier
      //   to decide which number is larger.   You need to compare the coefficients,
      //   starting from the largest and working toward the smallest until you find
      //   coefficients that are not equal.

      boolean done = false;
      int i = this.coefficients.size() - 1;
      while (i >=0 && !done){
        diff = this.coefficients.get(i) - second.coefficients.get(i);
        if (diff < 0){
          return -1;
        }
        else if (diff > 0)
          return 1;
        else{
          i--;
        }
      }
      return 0;    //   if all coefficients are the same,  so numbers are equal.
    }
  }

 /*  computes  'this' * base^n
  */

  private NaturalNumber timesBaseToThePower(int n){
    for (int i=0; i< n; i++){
      this.coefficients.addFirst(new Integer(0));
    }
    return this;
  }

 /*
 The following method is invoked by System.out.print.
 It returns the string with coefficients in the reverse order
 which is the natural format for people to reading numbers,
 i.e. people want to read  a[N-1], ... a[2] a[1] a[0].
 It does so simply by make a copy of the list with elements in
 reversed order, and then printing the list using the LinkedList's
 toString() method.
 */

  @Override
  public String toString(){
    String s = new String();
    for (Integer coef : coefficients)     //  Java enhanced for loop
      s = coef.toString() + s ;        //   Append each successive coefficient.
    return "(" + s + ")_" + base;
  }

}