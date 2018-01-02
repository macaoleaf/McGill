import java.util.HashMap;
public class CountingNames{
  public static void main(String[] args){
    String[] arr = {"Bentley", "Bentley", "Bentley", "Melanie", "Bentley", "Giulia",
                    "Bentley", "Melanie", "Bentley", "Giulia", "Bentley"};
    //question: how many times does each name appear?
    
    //solution: have a mapping from a string to the number of times
    //that String appears in a list
    HashMap<String, Integer> nameCount = getCount(arr);
    for(String key : nameCount.keySet()){
      Integer value = nameCount.get(key);
      System.out.println(key + " - " + value);
    }
  }
  public static HashMap<String, Integer> getCount(String[] arr){
    HashMap<String, Integer> result = new HashMap<String, Integer>();
    for(int i = 0; i < arr.length; i++){
      String s = arr[i];
      if(!result.containsKey(s)){
        //if the name is not in the hashmap,
        //place it in, and say that the name was seen once
        result.put(s, new Integer(1));
      }else{
        //in the else case, the name was already seen
        //so update the value in te hashmap
        Integer count = result.get(s);
        Integer newCount = count + 1;
        //be careful - the line above cannot write count + 1 as count++;
        //not the same thing
        result.put(s, newCount);
      }
    }
    return result;
  }
}