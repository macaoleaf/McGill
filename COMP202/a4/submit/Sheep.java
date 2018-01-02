import java.util.Random;
public class Sheep{
  private String name;
  private int age;
  private boolean hasWool;
  private static Random numberGenerator = new Random(123);
  public String getName(){
    return this.name;
  }
  public int getAge(){
    return this.age;
  }
  public Sheep(String name, int age){
    this.name = name;
    this.age = age;
    this.hasWool = true; 
  }
  public double shear(){
    double wool = 0;
    if(hasWool){
      wool = 6 + (numberGenerator.nextDouble()) * 4;
    }
    return wool;
  }
}