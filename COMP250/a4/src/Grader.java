package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintStream;
import java.io.OutputStream;


public class Grader {

    public static void main(String[] args){
	PrintStream out = System.out;
	//Uncomment this to silence student outputs.
	/*
	System.setOut(new PrintStream(new OutputStream() {
                public void write(int b) { }
	    }));
	*/
	Grader grader = new Grader();
	Integer totalScore = 0;
	ArrayList<Test> tests = new ArrayList<Test>();
	tests.add(new TestZero(1,out));
	tests.add(new TestOne(10,out));
	tests.add(new TestTwo(30,out));
	for(Test t: tests){
	    totalScore += t.run();
	}
	out.println("Total Score : " + totalScore);
	System.exit(totalScore);
    }
}
