public class Farm{
  //this part for tests
  public static void main(String[] args){
    Sheep[] sheep = new Sheep[1];
    sheep[0] = new Sheep("mie", 6);
    Dog herding = new Dog("wof", "shephard");
    Farm one = new Farm("bingo", herding, sheep);
    one.printFarm();
    System.out.println(one.getNumSheep());
  }
  private Sheep[] sheep;
  private Dog herding;
  private String name;
  public Farm(String name, Dog herding, Sheep[] sheep){
    this.name = name;
    this.herding = herding;
    if(this.herding.herd() < sheep.length){
      throw new IllegalArgumentException("Maximum number of sheep for this dog is " + 
                                         herding.herd() + ". Received " + 
                                         sheep.length + " sheep.");
    }else{
      this.sheep = new Sheep[sheep.length];
      for(int n = 0; n < sheep.length; n++){
        this.sheep[n] = sheep[n];
      }
    }
  }
  public String getName(){
    return this.name;
  }
  public int getNumSheep(){
    return this.sheep.length;
  }
  public void printFarm(){
    System.out.println("Farm: " +  this.name + " Dog: " + herding.getName());
    for(int n = 0; n < sheep.length; n++){
      System.out.println(sheep[n].getName() + " " + sheep[n].getAge());
    }
  }
  public double getWool(){
    double total = 0;
    for(int n = 0; n < sheep.length; n++){
      total += sheep[n].shear();
    }
    return total;
  }
}