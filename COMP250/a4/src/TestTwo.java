package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class TestTwo extends Test{
    private ArrayList<Song> songs;
	private static String dataFile = "/Users/zisheng/GitHub/McGill_COMP250/a4/src/songs.txt";   //  NEED TO ADD DIRECTORY
    TestTwo(Integer timeOut){
	super(timeOut);
	SongList testCases = new SongList();
	this.songs = testCases.allSongsEver(90000,dataFile);
    }
    TestTwo(Integer timeOut, PrintStream out){
	super(timeOut,out);
	SongList testCases = new SongList();
	this.songs = testCases.allSongsEver(90000,dataFile);	    
    }
    TestTwo(Integer timeOut, PrintStream out, Integer songCount){
	super(timeOut,out);
	SongList testCases = new SongList();
	this.songs = testCases.allSongsEver(songCount,dataFile);	    
    }

    public Integer tester(){
	int numBuckets = 7;
	int scorea =10, scoreb= 5 , scorec = 5;
    	MyHashTable<String,Song> mySongTable = new MyHashTable<String,Song>(numBuckets);
	HashMap<String,Song> javaSongTable = new HashMap<String,Song>(numBuckets);

		
	int mySize = 0;
	int trueSize = 0;
	int flag=0;
	try{
	    for (Song song: songs)
		{
		    mySongTable.put(song.getTitle(),song);
		    javaSongTable.put(song.getTitle(),song);
		}
	}catch(Exception e){
	    stackTrace(e);
	    //return 0;//can't really do much after put stuff in fails...
	}
	this.out.println("---------------Testing iterator-------------------");  

	try{
	    HashSet<String> javaIterKeys = new HashSet<String>();
	    HashSet<String> myIterKeys = new HashSet<String>();
	    HashSet<Song> javaIterValues = new HashSet<Song>();
	    HashSet<Song> myIterValues = new HashSet<Song>();
	    
	    for (HashMap.Entry<String, Song> entry : javaSongTable.entrySet()) {
		String key = entry.getKey();
		Song value = entry.getValue();
		javaIterKeys.add(key);
		javaIterValues.add(value);
		trueSize++;
	    }
	    
	    // First run of iterator to make sure the iterator doesn't
	    // change the hash table
	    MyHashTable<String, Song>.HashIterator myIter = mySongTable.iterator();
	    while(myIter.hasNext()){
		myIter.next();
	    }
    	
	    //Second run of iterator for actual testing
	    MyHashTable<String, Song>.HashIterator myIter2 = mySongTable.iterator();
	    HashNode<String,Song> current;
	    while(myIter2.hasNext()){
		current = myIter2.next();
		Song song = current.getValue();
		String key = current.getKey();
		myIterKeys.add(key);
		myIterValues.add(song);
		mySize++;
	    }

	    if(mySize != trueSize){
    		scorea -= 3;
		this.out.println("Size incorrect");
    		if(verbose){
		    this.out.println("Expected size : " + trueSize);
		    this.out.println("Output size : " + mySize);
		}
	    }

	    //compare iterator output as a set
	    if(javaIterKeys.equals(myIterKeys)){
		if(verbose)
		    this.out.println("Iterator listed all Keys");
	    }else{
		this.out.println("Iterator failed to list all Keys");
		if(verbose){
		    HashSet<String> javaKeys = new HashSet<String>(javaIterKeys);
		    javaIterKeys.removeAll(myIterKeys);
		    for(String key: javaIterKeys){
			this.out.println("Missed Key: " + key);
		    }
		    myIterKeys.removeAll(javaKeys);
		    for(String key: myIterKeys){
			this.out.println("Additional Key: " + key);
		    }
		}
		scorea -= 3;
	    }
	    
	    if(javaIterValues.equals(myIterValues)){
		if(verbose)
		    this.out.println("Iterator listed all Values");
	    }else{
                this.out.println("Iterator failed to return all Values");
                if(verbose){
		    HashSet<Song> javaValues = new HashSet<Song>(javaIterValues);
		    javaIterValues.removeAll(myIterValues);
		    for(Song s: javaIterValues){
			this.out.println("Missed Song: " + s);
		    }
		    myIterValues.removeAll(javaValues);
		    for(Song s: myIterValues){
			this.out.println("Additional Song: " + s);
		    }
		}
		scorea -= 2;
	    }

    	}
    	catch(Exception e)
    	{
    		scorea = 0; 
    		stackTrace(e);
    	}
	this.out.println("----------Testing Keys---------");
    	try{
	    HashSet<String> myKeys = new HashSet<String>(mySongTable.keys());
	    HashSet<String> javaKeys = new HashSet<String>(javaSongTable.keySet());
	    if(javaKeys.equals(myKeys)){
		if(verbose)
		    this.out.println("keys() returned all Keys");
	    }else{
                this.out.println("keys() failed to return all Keys");
		if(verbose){
		    HashSet<String> allKeys = new HashSet<String>(javaKeys);
		    javaKeys.removeAll(myKeys);
		    for(String key: javaKeys){
			this.out.println("Missed Key: " + key);
		    }
		    myKeys.removeAll(allKeys);
		    for(String key: myKeys){
			this.out.println("Additional Key: " + key);
		    }
		}
		scoreb -= 5;
	    }
	}catch(Exception e){
	    scoreb = 0;
	    stackTrace(e);
	}
	this.out.println("----------Testing Values---------");
	try{
	    HashSet<Song> myValues = new HashSet<Song>(mySongTable.values());
	    HashSet<Song> javaValues = new HashSet<Song>(javaSongTable.values());
	    if(javaValues.equals(myValues)){
		if(verbose)
		    this.out.println("values() returned all Values");
	    }else{
		this.out.println("values() failed to return all Values");
		if(verbose){
		    HashSet<Song> allValues = new HashSet<Song>(javaValues);
		    javaValues.removeAll(myValues);
		    for(Song value: javaValues){
			this.out.println("Missed Value: " + value);
		    }
		    myValues.removeAll(allValues);
		    for(Song value: myValues){
			this.out.println("Additional Value: " + value);
		    }
		}
		scorec -= 5;
	    }

	    
	}catch(Exception e){
	    scorec = 0;
    	    stackTrace(e);
	}
	if(verbose){
	    this.out.println("Score Sub-section a :" + scorea );
	    this.out.println("Score Sub-section b :" + scoreb );
	    this.out.println("Score Sub-section c :" + scorec );
	}

	return (scorea + scoreb + scorec);

    }
}
