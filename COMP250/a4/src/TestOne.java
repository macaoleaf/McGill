package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.ArrayList;

public class TestOne extends Test{
    private ArrayList<Song> songs;
	private static String dataFile = "/Users/zisheng/GitHub/McGill_COMP250/a4/src/songs.txt";   //  NEED TO ADD DIRECTORY
    TestOne(Integer timeOut){
	super(timeOut);
	SongList testCases = new SongList();
	this.songs = testCases.allSongsEver(90000,dataFile);
    }
    TestOne(Integer timeOut, PrintStream out){
	super(timeOut,out);
	SongList testCases = new SongList();
	this.songs = testCases.allSongsEver(90000,dataFile);	    
    }
    TestOne(Integer timeOut, PrintStream out, Integer songCount){
	super(timeOut,out);
	SongList testCases = new SongList();
	this.songs = testCases.allSongsEver(songCount,dataFile);	    
    }

    public Integer tester(){
    	int numBuckets = 7;
	int scorea = 10,scoreb = 25, scorec = 15;
	int testCount = 120;
	MyHashTable<String,Song> mySongTable=new MyHashTable<String,Song>(numBuckets);
	HashMap<String,Song> javaSongTable = new HashMap<String,Song>(numBuckets);
	this.out.println("----------------Testing Put---------------------");
	try{
	    int count = 0;
	    for (Song song: songs){
		mySongTable.put(song.getTitle(),song);
		javaSongTable.put(song.getTitle(),song);
	    }

	    //Check size is correct
	    if(javaSongTable.size() != mySongTable.size()){
		this.out.println("Incorrect Size of hashTable");
		scorea -= 5;
	    }
	    //Check number of buckets has increased
	    //implicit check for rehashing functionality
	    if(numBuckets == mySongTable.getNumBuckets()){
		this.out.println("Bucket Count not updated");
		scorea -= 3;
	    }
	}catch(Exception e){
	    scorea = 0;
	    stackTrace(e);
	}

	this.out.println("----------------Testing Get---------------------");
	int i=0;
	Song mySong,javaSong;
	try{
	    for(int test = 0; test < testCount; test++){
		i = (7*test + 49)%(songs.size());
		mySong = mySongTable.get(songs.get(i).getTitle());
		javaSong = javaSongTable.get(songs.get(i).getTitle());
		if(!mySong.getArtist().equals(javaSong.getArtist()) ||
		   ! (mySong.getYear() == javaSong.getYear()) ){
		    this.out.println("Expected: " + javaSong);
		    this.out.println("Output: " + mySong);
		    scoreb -= 7;
		    break;
		}else{
		    if(verbose)
			this.out.println("Found: " + mySong);		
		}
	    }
	    	    
	    //  rehashing: should change bucket count
	    //  but not the number of entries.
	    int oldBucketCount = mySongTable.getNumBuckets();
	    int oldSize = mySongTable.size();
	    mySongTable.rehash();
	    if((mySongTable.getNumBuckets() != 2*oldBucketCount) ||
	       (mySongTable.size() != oldSize)){
		scoreb -= 5;
		this.out.println("Expceted size:"+oldSize);
		this.out.println("Returned size:"+mySongTable.size());
		this.out.println("Expceted bucket count:"+oldBucketCount);
		this.out.println("Returned bucket count:"+mySongTable.getNumBuckets());
	
	    }else{
		if(verbose){
		    this.out.println("number of songs: " + mySongTable.size());
		    this.out.println("number of buckets: " + mySongTable.getNumBuckets());
		}
	    }
	    //Try to change band of Scream
	    Song newScream = new Song("Scream", "Yellow Flag", 1984);
	    Song expectedOldSong = javaSongTable.get("Scream");
	    Song oldScream = mySongTable.put("Scream",newScream);
	    Song oldJavaScream = javaSongTable.put("Scream",newScream);
	    Song testSongChange = mySongTable.get("Scream");
	    if (testSongChange == null ||
		!testSongChange.getArtist().equals("Yellow Flag") ||
		testSongChange.getYear() != 1984) {
		this.out.println("Failed to update old value for key in put.");
		scoreb -= 5;
	    }
	    if (oldScream == null ||
		!oldScream.getArtist().equals(expectedOldSong.getArtist()) ||
		oldScream.getYear() != expectedOldSong.getYear()) {
		this.out.println("Didn't return old value after put update");
		scoreb -= 3;
	    }

	}catch (Exception e){
	    scoreb = 0;
	    stackTrace(e);
	}

	this.out.println("---------------Testing remove-------------------");
	try{
	    Song oldSong;
	    for(int test = 0 ; test  <  testCount; test++){
		i = (13*test + 23)%(songs.size());
		oldSong = songs.get(i);
		mySong = mySongTable.remove(oldSong.getTitle());
		javaSong = javaSongTable.remove(oldSong.getTitle());
	    
		if(mySong == null && javaSong == null){
		    continue;
		}else if((mySong == null && javaSong != null) ||
		     (mySong != null && javaSong == null)){
		    this.out.println("Expected: " + javaSong);
		    this.out.println("Output: " + mySong);
		    scorec -=  12;
		    break;
		}
		if(!mySong.getArtist().equals(javaSong.getArtist()) ||
		   ! (mySong.getYear() == javaSong.getYear()) ){
		    this.out.println("Expected: " + javaSong);
		    this.out.println("Output: " + mySong);
		    scorec -= 12;
		    break;
		}else{
		    if(verbose)
			this.out.println("Sucessfully Removed: " + mySong);
		}
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
