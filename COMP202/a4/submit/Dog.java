public class Dog{
  private String name;
  private String breed;
  public Dog(String name, String breed){
    this.name = name;
    this.breed = breed;
  }
  public String getName(){
    return name;
  }
  public int herd(){
    int sheepNum = 10;
    if(breed.toLowerCase().contains("collie")){
      sheepNum = 20;
    }else if(breed.toLowerCase().contains("shepherd")){
      sheepNum = 25;
    }else if(breed.toLowerCase().contains("kelpy") ||
             breed.toLowerCase().contains("teruven")){
      sheepNum = 30;
    }
    return sheepNum;
  }
}