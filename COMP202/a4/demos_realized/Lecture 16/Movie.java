public class Movie{
  //non-static class variables
  public String title;
  public String director;
  public String[] actors;
  public void printInfo(){
    System.out.println(title);
    System.out.println(director);
    for(int i = 0; i < actors.length; i++){
      System.out.println(actors[i]);
    }
  }
} 