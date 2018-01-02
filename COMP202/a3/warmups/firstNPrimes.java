import java.util.Arrays; //hint from StackOverflow

public class firstNPrimes{
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    int[] primes = firstNPrimes(n); //print out the elements in the array
    System.out.println(Arrays.toString(primes)); //hint from StackOverflow
  }
  public static int[] firstNPrimes(int n){
    int[] prime = new int[n]; //set the prime array
    int num = 0; //position of each prime in the array
    for(int i = 2; num < prime.length; i++){
      boolean isPrime = isPrime(i);
      if(isPrime){
        prime[num] = i; // put the prime into the array
        num++; //go to the next position
      }
    }
    return prime;
  }
  //determine if a number is a prime
  public static boolean isPrime(int i){
    boolean isPrime = true;
    for(int n = 2; n < i; n++){
      if(i % n == 0){
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }
}