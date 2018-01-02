public class DynamicIntArray{
  //the actual array of elements
  private int[] arr;
  
  //how many elements have been added to that array
  private int numElements;
  
  public DynamicIntArray(){
    arr = new int[2];
    numElements = 0;
  }
  
  public DynamicIntArray(int size){
    if(size < 0){
      throw new IllegalArgumentException("Invalid size");
    }
    
    arr = new int[size];
    numElements = 0;
  }
  
  public String toString(){
    String s = "Array: [";
    for(int i = 0; i < this.numElements; i++){
      s += arr[i];
      if(i != this.numElements - 1){
        s += ", ";
      }
    }
    return s + "]";
  }
  
  public void add(int x){
    //if we've run out of space
    if(numElements >= arr.length){
      //we need to resize the inner array
      resize();
    }
    
    arr[numElements] = x;
    numElements++;
    System.out.println("Debug: Now contains " + numElements + " elements");
  }
  
  //resize method
  //this method will double the reserved space
  //by creating a new array of double the space
  //and copying over all the existing elements
  private void resize(){
    int[] newArr = new int[arr.length * 2];
    for(int i = 0; i < arr.length; i++){
      newArr[i] = arr[i];
    }
    this.arr = newArr;
  }
  
  //returns true if x is inside this DynamicIntArray
  public boolean contains(int x){
    for(int i = 0; i < numElements; i++){
      if(arr[i] == x){
        return true;
      }
    }
    return false;
  }
  
  //returns the element at index
  public int getAtIndex(int index){
    if(index < 0 || index >= this.numElements){
      throw new IllegalArgumentException("Invalid index");
    }
    return arr[index];
  }
  
  public void addAtIndex(int x, int index){
    if(numElements >= arr.length){
      resize();
    }
    this.numElements++;
    this.shiftRight(index);
    arr[index] = x;
  }
  
  //take all elements at position index
  //and shift them right by one
  private void shiftRight(int index){
    
    System.out.println("Before shiftRight: " + this);
    for(int i = arr.length - 1; i > index; i--){
      arr[i] = arr[i - 1];
      System.out.println("During shiftRight: " + this);
    }
    System.out.println("After shiftRight: " + this);
  }
  
  public int getSize(){
    return numElements;
  }
  
  public static void append(DynamicIntArray first, DynamicIntArray second){
    for(int i = 0; i < second.getSize(); i++){
      int x = second.getAtIndex(i);
      first.add(x);
    }
  }
  
  public static void main(String[] args){
    DynamicIntArray dia = new DynamicIntArray();
    System.out.println(dia);
    dia.add(2);
    System.out.println(dia);
    dia.add(4);
    System.out.println(dia);
    dia.add(7);
    System.out.println(dia);
    dia.addAtIndex(99, 1);
    System.out.println(dia);
    
    DynamicIntArray dia2 = new DynamicIntArray();
    for(int i = 0; i < 5; i++){
      dia2.add(i);
    }
    System.out.println(dia2);
    
    DynamicIntArray.append(dia, dia2);
    System.out.println(dia);
  }
}