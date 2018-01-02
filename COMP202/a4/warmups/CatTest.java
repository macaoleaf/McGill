public class CatTest{
  //tests passed in question 4
  //this piece of codes is for question 5
  public static void main(String[] args){
    Cat kitty = new Cat("doll");
    Cat lucia = new Cat("UK");
    Cat tom = new Cat("blue");
    Cat jj = new Cat("TW");
    Cat white = new Cat("hair");
    //put each cat into the array
    Cat[] babies = new Cat[5];
    babies[0] = kitty;
    babies[1] = lucia;
    babies[2] = tom;
    babies[3] = jj;
    babies[4] = white;
    //loop to make them meow
    for(int n = 0; n < 5; n++){
      babies[n].setMood("sleepy");
      babies[n].talk();
    }
  }
}