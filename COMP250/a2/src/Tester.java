package Users.zisheng.GitHub.McGill_COMP250.a2.out.production.a2;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Tester{
	public static void main(String[] args) throws IOException {

		//  You need to change your root directory.

		String root = "/Users/zisheng/GitHub/McGill_COMP250/a2/tests/";

		String[] input = {"sample_in.txt"};
		String[] output = {"sample_value.txt"};
		String[] parsedExp = {"sample_exp.txt"};
		/**
		 * Test each input file in the array of strings 'input'
		 * and compare with expected output in corresponding file
		 * in output files listed in array of strings 'output'
		 **/
		for(int i = 0 ; i < input.length; i++){
			String inputFileName = root + input[i];
			String outputFileName = root + output[i];
			String expFileName = root + parsedExp[i];

			FileReader fin = new FileReader(inputFileName);
			FileReader fout = new FileReader(outputFileName);
			FileReader fexp = new FileReader(expFileName);

			BufferedReader inputReader = new BufferedReader(fin);
			BufferedReader outputReader = new BufferedReader(fout);
			BufferedReader expReader = new BufferedReader(fexp);


			Integer passed = 0,expectedValue=0, computedValue = 0;
			String expString;
			String computedParsedExpression, expectedParsedExpression;
			Expression exp;
			/**
			 Test for each input test case in the input file
			 **/
			while((expString = inputReader.readLine()) != null){
				//Read expected output from the output file
				expectedValue = Integer.valueOf(outputReader.readLine());
				expectedParsedExpression = expReader.readLine();

				//Construct Expression from expression string read from
				exp = new Expression(expString);

				computedParsedExpression = exp.toString();
				//compare the parsed expressions
				if (computedParsedExpression.equals(expectedParsedExpression)) {
					passed++;
				}
				else{
					System.out.println("Passed " + passed + " tests");
					System.out.println("Failed for input: " + expString);
					System.out.println("Expected : " + expectedParsedExpression);
					System.out.println("Result:   " + computedParsedExpression);
					System.exit(-1);
				}


				//compute the value of expression using the eval() method
				computedValue = exp.eval();

				//compare the values
				if (computedValue.equals(expectedValue)) {
					passed++;
					System.out.println(exp);
					System.out.println(exp + " = " + computedValue);
				}
				else{
					System.out.println("Passed " + passed + " tests");
					System.out.println("Failed for input: " + expString);
					System.out.println("Expected : " + expectedValue);
					System.out.println("Result:   " + computedValue);
					System.exit(-1);
				}
			}
			System.out.println("Passed all " + passed + " tests.");
		}
	}
}
