public class Vector{
  private double x;
  private double y;
  private double z;
  //this main method is only for test
  public static void main(String[] args){
    Vector a = new Vector(1, 1, 1);
    System.out.println(a.calculateMagnitude());
  }
  public Vector(double x, double y, double z){
    this.x = x;
    this.y = y;
    this.z = z;
  }
  public void setX(double x){
    this.x = x;
  }
  public void setY(double y){
    this.y = y;
  }
  public void setZ(double z){
    this.z = z;
  }
  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }
  public double getZ(){
    return z;
  } //methods should be non-static
  public double calculateMagnitude(){
    return (Math.sqrt(x * x + y * y + z * z));
  } //this method should be non-static as well
}