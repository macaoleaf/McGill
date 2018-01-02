package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

/**
 * This class represents a single song
 */
public class Song { // implements Comparable<Song> {

	private String title;	// The song's title
	private String artist;	// The song's artist
	private int year;		// The year that the song was released

	/**
	 * Constructor.
	 */
	public Song(String title, String artist, int year) {
		this.title = title;
		this.artist = artist;
		this.year = year;
	}

	/*
	@Override
	public int compareTo(Song song) {
		return title.compareTo(song.getTitle());
	}
	 */

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return "SONG=" + title + ", ARTIST=" + artist + ", YEAR=" + year;
	}

}
