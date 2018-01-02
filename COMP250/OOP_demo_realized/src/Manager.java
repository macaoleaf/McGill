public class Manager extends Employee{

  private double bonus;

  public Manager(String aName){
    super(aName);
    bonus = 0;
  }

  public void setBonus(double aBonus){
    bonus = aBonus;
  }

  public double getBonus(){
    return bonus;
  }

  public double getSalary(){
    return bonus + super.getSalary();
  }
}
