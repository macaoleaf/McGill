package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

import java.io.PrintStream;


public class TestZero extends Test{
    TestZero(Integer timeOut){
	super(timeOut);
    }
    TestZero(Integer timeOut, PrintStream out){
	super(timeOut,out);
    }
    public Integer tester(){
	int scorea = 10,scoreb = 15,scoreb1=15,scorec = 20;
	int testCount = 120;
	HashLinkedList<Integer,Integer> myLinkedList=new HashLinkedList<Integer,Integer>();
	this.out.println("--------------Testing Linked List add-------------------");
	try{
	    for (Integer i = 0; i < testCount; i++){
		myLinkedList.add(i,i+1);
	    }
	    //Check size is correct
	    if(myLinkedList.size() != testCount){
		this.out.println("Incorrect Size of LinkedList");
		scorea -= 5;
	    }
	}catch(Exception e){
	    scorea = 0;
	    stackTrace(e);
	}

	this.out.println("-------------Testing Linked List remove------------------");
	try{
	    HashNode<Integer,Integer> removedNode;
	    for (Integer  i = 0; i < testCount; i++){
		int r = (i + (testCount/2))%testCount;
		removedNode = myLinkedList.remove(r);
		if(removedNode == null||
		   !removedNode.getKey().equals(r) ||
		   !removedNode.getValue().equals(r+1)){
		    this.out.println("Failed LinkedList remove");
		    scoreb -=5;
		    break;
		}
	    }
	    if(myLinkedList.size() != 0){
		this.out.println("Incorrect Size of LinkedList after remove");
		scoreb -= 3;
	    }
	    //remove from empty list
	    removedNode = myLinkedList.remove(1);
	    if(removedNode != null){
		this.out.println("Failed remove from empty linked list");
		scoreb -= 5;
	    }
	    if(myLinkedList.size() != 0){
		this.out.println("Incorrect Size of LinkedList after remove from empty list");
		scoreb -= 2;
	    }
	}catch(Exception e){
	    scoreb = 0;
	    stackTrace(e);
	}
	this.out.println("-------------Testing Linked List remove first------------------");
	try{
	    HashNode<Integer,Integer> removedNode;
	    for(Integer i = 0 ; i < 4; i++){
		myLinkedList.add(i,i+1);
	    }
	    for(Integer i = 0 ; i < 4; i++){
		removedNode = myLinkedList.removeFirst();
		if(removedNode == null||
		   !removedNode.getKey().equals(4 - i - 1) ||
		   !removedNode.getValue().equals(4 - i)){
		    this.out.println("Failed LinkedList removeFirst");
		    scoreb1 -=5;
		    break;
		}
		
	    }	    	    
	    if(myLinkedList.size() != 0){
		this.out.println("Incorrect Size of LinkedList after removeFirst");
		scoreb1 -= 2;
	    }
	    //removeFirst from empty list
	    removedNode = myLinkedList.removeFirst();
	    if(myLinkedList.size() != 0){
		this.out.println("Incorrect Size of LinkedList after removeFirst on empty size");
		scoreb1 -= 3;
	    }
	    if(removedNode != null){
		this.out.println("Failed removeFirst from empty linked list");
		scoreb1 -= 5;
	    }

	}catch(Exception e){
	    scoreb1 = 0;
	    stackTrace(e);
	}
	
	this.out.println("----------Testing Linked List getListNode---------------");
	try{
	    //get on empty list
	    HashNode<Integer,Integer> returnedNode = myLinkedList.getListNode(75);
	    if(returnedNode != null){
		scorec -= 5;
	    }
	    //get on list of size 1
	    myLinkedList.add(0,1);
	    returnedNode = myLinkedList.getListNode(0);
	    if(returnedNode == null ||
	       !returnedNode.getKey().equals(0) ||
	       !returnedNode.getValue().equals(1)){
		this.out.println("Failed to get node");
		scorec -= 5;
	    }
	    returnedNode = myLinkedList.getListNode(75);
	    if(returnedNode != null){
		scorec -= 5;
	    }
	    //get on list of other size > 1
	    myLinkedList.add(1,2);
	    myLinkedList.add(3,4);
	    returnedNode = myLinkedList.getListNode(0);
	    if(returnedNode == null ||
	       !returnedNode.getKey().equals(0) ||
	       !returnedNode.getValue().equals(1)){
		this.out.println("Failed to get node");
		scorec -= 5;
	    }
	    
	}catch(Exception e){
	    scorec = 0;
	    stackTrace(e);
	}
	if(verbose){
	    this.out.println("Score Sub-section a :" + scorea );
	    this.out.println("Score Sub-section b :" + scoreb );
	    this.out.println("Score Sub-section b1 :" + scoreb1 );
	    this.out.println("Score Sub-section c :" + scorec );
	}

	return (scorea + scoreb1 + scoreb + scorec)/2;

    }
}
