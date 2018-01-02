package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.Callable;
import java.io.PrintStream;

abstract class Test{
    private Integer timeOut;
    protected PrintStream out;
    protected Boolean verbose;
    //Object data;
    //PrintStream in;
    Test(Integer timeOut){
	this.timeOut = timeOut;
	out = System.out;
	verbose = false;
	//in = System.in;
    }
    Test(Integer timeOut, PrintStream out){
	this.timeOut = timeOut;
	this.out = out;
	verbose = false;
    }

    /* 
     *  Provide implementation of this (tester) method  for each test. 
     */
    abstract Integer tester();

    public void setVerbose(Boolean v){
	verbose = v;
    }
    
    public Integer run(){
	TestCaller test = new TestCaller();
	final ExecutorService service = Executors.newSingleThreadExecutor();
	final Future<Integer> score = service.submit(test);
	Integer result = 0;
	try{
	    result = score.get(timeOut, TimeUnit.SECONDS);
	}catch(Exception e){
	    this.out.println(this.getClass().getSimpleName() + " : " + e.getClass().getSimpleName());
	    this.stackTrace(e);
	}
	return result;
	
    }

    private class TestCaller implements Callable<Integer>{
	public TestCaller(){}
	public Integer call(){
	    try{
		return tester();
	    }catch(Exception e){
		out.println("Exception: " + e);
		return 0;
	    }
	}
    }
    protected void stackTrace(Exception e){
	StackTraceElement[] elements = e.getStackTrace();
	String exception = "";
	for(StackTraceElement s : elements){
	    exception += "Class Name: " + s.getClassName() +
		" Method Name: " +  s.getMethodName() +
		" Line: " + s.getLineNumber() + "\n";
	}
	this.out.println(exception);
    }
    /*
    void setTimeOut(Integer time){
	this.timeOut = time;
    }
    */
}
