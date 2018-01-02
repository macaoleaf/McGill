//don't forget to import Arraylist!
import java.util.ArrayList;
public class Student{
  private String name;
  public Student(String name){
    this.name = name;
  }
  public String getName(){
    return this.name;
  }
  //this is way to print out using toString
  /*public String toString(){
    return "Student name: " + this.name;
  }*/
  public static void main(String[] args){
    Student Tam = new Student("Tam");
    Student Tem = new Student("Tem");
    Student Tim = new Student("Tim");
    Student Tom = new Student("Tom");
    Student Tum = new Student("Tum");
    ArrayList<Student> students = new ArrayList<Student>();
    students.add(Tam);
    students.add(Tem);
    students.add(Tim);
    students.add(Tom);
    students.add(Tum);
    //this is way to print out using a for-loop
    for(int n = 0; n < students.size(); n++){
      if(n == 0){
        System.out.print("[Student name: " + students.get(n).getName() + ", ");
      }else if(n == (students.size() - 1)){
        System.out.println("Student name: " + students.get(n).getName() + "]");
      }else{
        System.out.print("Student name: " + students.get(n).getName() + ", ");
      }
    }
    //System.out.println(students); //way to print out using toString
  }
}