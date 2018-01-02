package Users.zisheng.GitHub.McGill_COMP250.a2.out.production.a2;

/*
  Name: Zisheng Ye
  McGill ID: 260714548
 */

import java.util.Stack;
import java.util.ArrayList;

public class Expression  {
  private ArrayList<String> tokenList;

  //  Constructor
  /**
   * The constructor takes in an expression as a string
   * and tokenizes it (breaks it up into meaningful units)
   * These tokens are then stored in an array list 'tokenList'.
   */

  Expression(String expressionString) throws IllegalArgumentException{
    tokenList = new ArrayList<String>();
    StringBuilder token = new StringBuilder();

    //ADD YOUR CODE BELOW HERE
    //..
    for(int i = 0; i < expressionString.length(); i++){
      char one = expressionString.charAt(i);
      String oneDigit = String.valueOf(one);
      //normally, translation is straightforward
      if(oneDigit.equals("(") || oneDigit.equals(")") || oneDigit.equals("*") || oneDigit.equals("/")
          || oneDigit.equals("[") || oneDigit.equals("]")){
        tokenList.add(oneDigit);
      }else if (oneDigit.equals("+")  || oneDigit.equals("-") ){ //find out special case for ++ and --
        if (String.valueOf(expressionString.charAt(i+1)).equals(oneDigit)){ //if there exist double signs,
          token.append(oneDigit); token.append(oneDigit);
          tokenList.add(token.toString());
          token.delete(0,2);
          i++;
        }else{ //if not,
          tokenList.add(oneDigit);
        }
      }else if (!oneDigit.equals(" ")){ //if it is an int,
        token.append(oneDigit); //prepare for the merge
        int n = 1; //to show the length of the number, add n-1 to i finally
        for (int k = i+1; k < expressionString.length(); k++){
          if(!isInteger(String.valueOf(expressionString.charAt(k))) &&
              expressionString.charAt(k) != ' '){
            //if not an int anymore, end the loop and add the number string
            k = expressionString.length();
            tokenList.add(token.toString());
            token.delete(0,n);
            i = i + n - 1;
          } else if(expressionString.charAt(k) != ' '){
            token.append(String.valueOf(expressionString.charAt(k)));
            n++;
          }
        }
      }
    }
    //..
    //ADD YOUR CODE ABOVE HERE
  }

  /**
   * This method evaluates the expression and returns the value of the expression
   * Evaluation is done using 2 stack ADTs, operatorStack to store operators
   * and valueStack to store values and intermediate results.
   * - You must fill in code to evaluate an expression using 2 stacks
   */
  public Integer eval(){
    Stack<String> operatorStack = new Stack<String>();
    Stack<Integer> valueStack = new Stack<Integer>();

    //ADD YOUR CODE BELOW HERE
    //..
    for(int i = 0; i < tokenList.size(); i++) { //scan through every element of the ArrayList
      if (!isInteger(tokenList.get(i)) && !tokenList.get(i).equals("(")) { //if an operator
        if (!tokenList.get(i).equals("(") && !tokenList.get(i).equals("[")) {//if not a left bracket
          operatorStack.push(tokenList.get(i));
        }
        //since it is hard to determine the calculation sequence,
        //it should be from back to front. Take ")" as the indication.
        if (tokenList.get(i).equals(")")) {
          operatorStack.pop();
          String prevOp = operatorStack.peek();
          if (prevOp.equals("+")) {
            int secondNum = valueStack.pop();
            int firstNum = valueStack.pop();
            int sum = firstNum + secondNum;
            valueStack.push(sum);
          } else if (prevOp.equals("-")) {
            int secondNum = valueStack.pop();
            int firstNum = valueStack.pop();
            int diff = firstNum - secondNum;
            valueStack.push(diff);
          } else if (prevOp.equals("*")) {
            int secondNum = valueStack.pop();
            int firstNum = valueStack.pop();
            int times = firstNum * secondNum;
            valueStack.push(times);
          } else if (prevOp.equals("/")) {
            int secondNum = valueStack.pop();
            int firstNum = valueStack.pop();
            int divide = firstNum / secondNum;
            valueStack.push(divide);
          } else if (prevOp.equals("++")) {
            int Num = valueStack.pop();
            int addOne = Num + 1;
            valueStack.push(addOne);
          } else if (prevOp.equals("--")) {
            int Num = valueStack.pop();
            int minusOne = Num - 1;
            valueStack.push(minusOne);
          }
          operatorStack.pop();
          //to avoid bugs when there are several ()s
          //should follow the normal sequence otherwise there would be an empty stack
        }else if (tokenList.get(i).equals("]")) {
          int Num = valueStack.pop();
          int abs = Math.abs(Num);
          valueStack.push(abs);
        }
      }else if (isInteger(tokenList.get(i))){//if is an int, push to valueStack
        valueStack.push(Integer.valueOf(tokenList.get(i)));
      }
    }
    int result = valueStack.peek(); //the final result should be at the top of the stack
    return result;
    //..
    //ADD YOUR CODE ABOVE HERE

  }

  //Helper methods
  /**
   * Helper method to test if a string is an integer
   * Returns true for strings of integers like "456"
   * and false for string of non-integers like "+"
   * - DO NOT EDIT THIS METHOD
   */
  private boolean isInteger(String element){
    try{
      Integer.valueOf(element);
    }catch(NumberFormatException e){
      return false;
    }
    return true;
  }

  /**
   * Method to help print out the expression stored as a list in tokenList.
   * - DO NOT EDIT THIS METHOD
   */

  @Override
  public String toString(){
    String s = new String();
    for (String t : tokenList )
      s = s + "~"+  t;
    return s;
  }

}
