import java.util.Scanner;
import java.util.Random;
public class WoolFactory{
  //The provided code generates random ages for sheep, 
  //and picks random names from the below array
  private static String[] namesForSheep = {"Cerdic","Cynric","Ceawlin","Ceol","Ceolwulf",
    "Cynegils","Cenwalh","Seaxburh","Aescwine","Centwine","Ceadwalla","Ine",
    "Aethelheard","Cuthred","Cynewulf","Berhtric","Egbert","Aethelwulf","Aethelbald",
    "Aethelberht","Aethelred","Hengest","Aesc","Octa","Eormenric","Aethelbert I",
    "Eadbald","Earconbert","Egbert I","Hlothere","Oswine","Wihtred","Aethelbert II",
    "Sigered","Egbert II","Eadberht II","Cuthred","Baldred","Aethelfrith","Edwin",
    "St. Oswald","Oswiu","Ecgfrith","Aldfrith","Osred I","Cenred","Osric","Ceolwulf",
    "Eadberht","Aethelwald","Alhred","Aethelred I","Aelfwald I","Eardwulf","Eanred",
    "George V","Edward VIII","George VI","Elizabeth II"};
  private static Random r = new Random(123); 
  //returns a random String from the above array. 
  private static String getRandomName(){
    int index = r.nextInt(namesForSheep.length);
    return namesForSheep[index];
  }
  //returns a random age for a sheep from 1 to 10
  private static int getRandomAge(){
    return r.nextInt(10)+1;
  }
  //End of provided name/age generation code. 
  public static void main(String[] args){
    //use a scanner to input
    Scanner scan = new Scanner(System.in);
    System.out.println("What is the name of your farm?");
    String farmName = scan.nextLine();
    System.out.println("What is the name of your dog?");
    String dogName = scan.nextLine();
    System.out.println("What kind of dog is " + dogName + "?");
    String dogBreed = scan.nextLine();
    System.out.println("And how many sheep do you have?");
    int numOfSheep = scan.nextInt();
    //get ready to create a farm
    Dog herding = new Dog(dogName, dogBreed);
    Sheep[] sheep = new Sheep[numOfSheep];
    for(int n = 0; n < numOfSheep; n++){
      sheep[n] = new Sheep(getRandomName(), getRandomAge());
    }
    //ready to print out
    Farm work = new Farm(farmName, herding, sheep);
    System.out.println("The farm has " + work.getNumSheep() + " sheep.");
    work.printFarm();
    double total = work.getWool();
    double earn = 1.45 * total;
    System.out.println("We just sheared " + total +"lbs of wool for a value of $" + earn);
  }
}