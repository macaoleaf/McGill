import java.util.Arrays;

public class ExamGrading{
  public static void main(String[] args){
    int minSimilar = Integer.parseInt(args[0]);
    char[][] responses = {{'C', 'A', 'B', 'B', 'C', 'A'},
                          {'A', 'A', 'B', 'B', 'B', 'B'},
                          {'C', 'B', 'A', 'B', 'C', 'A'},
                          {'A', 'B', 'A', 'B', 'B', 'B'}};
    char[] solutions = {'C', 'A', 'B', 'B', 'C', 'C'};
    System.out.println(Arrays.deepToString
                       (findSimilarAnswers(minSimilar, responses, solutions)));
  }
  public static int[][] findSimilarAnswers(int minSimilar, char[][] responses,
                                            char[] solutions){
    int[][] similarAnswers = new int[responses.length][];
    for(int n = 0; n < responses.length; n++){
      int studentNum = numMatches(responses, solutions, n, minSimilar);
      int[] subArray = new int[studentNum];
      int subArrayPosition = 0;
      for(int x = 0; x < responses.length; x++){
        boolean similar = (n != x && numWrongSimilar
                          (responses[x], responses[n], solutions) >= minSimilar); 
        if(similar){
          subArray[subArrayPosition] = x;
          System.out.println(subArrayPosition);
          subArrayPosition++;
        }
      }
      similarAnswers[n] = subArray;
    }
    return similarAnswers;
  }
  public static int numWrongSimilar(char[] ansOne, char[] ansTwo,
                                    char[] solutions){
    int coWrong = 0;
    if(ansOne.length != ansTwo.length){
      throw new IllegalArgumentException("Answers with different lengths!");
    }else{
      for(int n = 0; n < ansOne.length; n++){
        if(ansOne[n] == ansTwo[n] && ansOne[n] != solutions[n]){
          coWrong++;
        }
      }
    }
    return coWrong;
  }
  public static int numMatches(char[][] responses, char[] solutions,
                               int index, int similarityThreshold){
    int numMatches = 0;
    for(int n = 0; n < responses.length; n++){
      if(n != index && numWrongSimilar(
         responses[index], responses[n], solutions) >= similarityThreshold){
      numMatches++;
      }
    }
    return numMatches;
  }
  //this method is for the 1st question and has nothing to do in the 2nd one
  public static double[] gradeAllStudents(char[][] responses, 
                                          char[] solutions){
    double grades[] = new double[responses.length];
    for(int n = 0; n < responses.length; n++){
      double correct = 0;
      for(int x = 0; x < responses[n].length; x++){
        if(responses[n][x] == solutions[x]){
          correct++;
        }
      }
      grades[n] = 100 * (correct / responses[n].length);
    }
    return grades;
  }
}