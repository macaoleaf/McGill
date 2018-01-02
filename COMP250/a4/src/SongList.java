package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
/**
 * Class for testing your implementation of the HashTable class.
 */
public class SongList {

	/**
	 * Returns a minimal list of songs to use for testing the hash table.
	 * incase reading the text file fails.
	 * @return A list of songs to use for testing the hash table
	 */

    public ArrayList<Song> initSongList() {
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(new Song("Paranoid Android", "Radiohead", 1997));
		songs.add(new Song("Machine Gun", "Slowdive", 1993));
		songs.add(new Song("A Change Is Gonna Come", "Sam Cooke", 1964));
		songs.add(new Song("15 Step", "Radiohead", 2008));
		songs.add(new Song("Blue Line Swinger", "Yo La Tengo", 1995));
		songs.add(new Song("Reckoner", "Radiohead", 2008));
		songs.add(new Song("Ashes To Ashes", "David Bowie", 1980));
		songs.add(new Song("Speed Law", "Mos Def", 1999));
		songs.add(new Song("93 'Til Infinity", "Souls of Mischief", 1993));
		songs.add(new Song("Season of the Shark", "Yo La Tengo", 2003));
		songs.add(new Song("Cet Air-La", "France Gall", 1966));
		songs.add(new Song("Space Oddity", "David Bowie", 1969));
		songs.add(new Song("Il Nous Faut Regarder", "Jacques Brel", 1955));
		songs.add(new Song("Happy Holidays", "Jim O'Rourke", 1999));
		songs.add(new Song("Le Premier Bonheur du Jour", "Os Mutantes", 1968));
		songs.add(new Song("Stretch Out And Wait", "The Smiths", 1987));
		songs.add(new Song("Scream", "Black Flag", 1984));
		songs.add(new Song("Europe, After the Rain", "Max Richter", 2002));
		songs.add(new Song("Why Are You Looking Grave?", "Mew", 2005));
		songs.add(new Song("Fallen Angel", "King Crimson", 1974));
		songs.add(new Song("Milk and Honey", "Nick Drake", 2007));
		songs.add(new Song("One Less Bell To Answer", "Burt Bacharach", 2003));
		songs.add(new Song("A Letter To The New York Post", "Public Enemy", 1991));
		songs.add(new Song("Murder Mystery", "Edan", 2005));
		songs.add(new Song("Heaven's Blade", "Coil", 2005));
		songs.add(new Song("Daddy's Gonna Tell You No Lie", "Sun Ra", 2005));
		songs.add(new Song("Burning", "Fugazi", 1989));
		songs.add(new Song("La goualante de pauvre jean", "Edith Piaf", 2007));
		songs.add(new Song("Traveling Riverside Blues", "Led Zeppelin", 1982));
		songs.add(new Song("Sequent C'", "Tangerine Dream", 1974));
		songs.add(new Song("Mothers Of The Disappeared", "U2", 1987));
		songs.add(new Song("Down to the Well", "Pixies", 1990));
		songs.add(new Song("Seras-tu là?", "Michel Berger", 1994));
		songs.add(new Song("Another Brick In The Wall (Part I)", "Pink Floyd", 1979));
		songs.add(new Song("She Lives On A Mountain", "Gorky's Zygotic Mynci", 1999));
		songs.add(new Song("Moody Dipper", "My Education", 2006));
		return songs;
	}

    public ArrayList<Song> allSongsEver(Integer songCount, String filename){
	    try{
		ArrayList<Song> allSongs = new ArrayList<Song>();
		BufferedReader songsReader = new BufferedReader( new FileReader(filename));
		int counter = 0;
		String line;
		while((line = songsReader.readLine()) != null){
		    Integer year = Integer.valueOf(line);
		    String artist = songsReader.readLine();
		    String songName = songsReader.readLine();
		    allSongs.add(new Song(songName,artist,year));
		    if(counter > songCount){
			break;
		    }
		    counter++;
		}
		songsReader.close();
		return allSongs;
	    }
	    catch (IOException e){
		System.err.println("Error reading file.. falling back on static array");
		return initSongList();
	    }

	    
    }

}
