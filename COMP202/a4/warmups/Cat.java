public class Cat{
  private String name;
  private String breed;
  private int age;
  private String mood;
  //constructor sets the value to be the breed
  public Cat(String breed){
    this.breed = breed;
  }
  //setter methods
  public void setName(String name){
    this.name = name;
  }
  public void setAge(int age){
    this.age = age;
  }
  public void setMood(String mood){
    if(mood.equals("sleepy") || mood.equals("hungry") ||
       mood.equals("angry") || mood.equals("happy") ||
       mood.equals("crazy")){
      this.mood = mood;
    }else{
      throw new IllegalArgumentException("Mood word not accepted!");
    }
  }
  //getter methods
  public String getName(){
    return name;
  }
  public String getBreed(){
    return breed;
  }
  public int getAge(){
    return age;
  }
  public String getMood(){
    return mood;
  }
  //talking words related to moods
  public void talk(){
    if(this.mood.equals("sleepy")){
      System.out.println("meow");
    }else if(this.mood.equals("hungry")){
      System.out.println("RAWR!");
    }else if(this.mood.equals("angry")){
      System.out.println("hsssss");
    }else if(this.mood.equals("happy")){
      System.out.println("purrrr");
    }else{
      System.out.println("wtfrutkabt");
    }
  }
}