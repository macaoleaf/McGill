public class MovieTest{
  public static void main(String[] args){
    Movie m = new Movie();
    m.title = "Die Hard";
    m.director = "Some Guy";
    String[] movieActors = new String[2];
    movieActors[0] = "Bruce Willis";
    movieActors[1] = "Alan Rickman";
    m.actors = movieActors;
    m.printInfo();
  }
}