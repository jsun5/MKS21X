import java.util.*; //for testing w ArrayList

public class OrderedSuperArray extends SuperArray{

    //private String[] data;
    //private int size;
    
    /*constructor initializes an empty List*/
    public OrderedSuperArray(){
        super();
    }

    public OrderedSuperArray(int capacity) {
        super(capacity);
    }
    
    public OrderedSuperArray(String [] ary) { //-> call super and add all the elements
        super();
        for (int index = 0; index < ary.length; index ++) {
            add(ary[index]);
        }
    }
    
    /*call the proper add.*/
    public void add(int index, String value){
        add(value);
    } 

    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String value){
        super.add(findIndex(value), value);
        return true;
    }

    private int findIndex(String value) {
        for (int index = 0; index < size(); index ++) {
            if (get(index).compareTo(value) >= 0) {
                return index ;
            }
        }
        return size();
    }
    
    private int findIndexBinary(String value){
        if (size() == 0) {
            return 0;
        }
        int start = 0;
        int end = size() - 1;
        int average = 0;
        //System.out.println("" + start + end + average);
        while (start <= end) {
            average = (start + end) / 2;
            //System.out.println("" + start + end + average);
            if (value.compareTo(get(average)) < 0) {
                end = average - 1;
            }
            else if (value.compareTo(get(average)) > 0) {
                start = average + 1;
            }
            else {
                return average;
            }
        }
        return -1;
    }
    
    public int indexOfBinary (String value) {
        int start = 0;
        int end = size() - 1;
        int average = 0;
        while (start <= end) {
            average = (start + end) / 2;
            if (value.compareTo(get(average)) < 0) {
                end = average - 1;
            }
            else if (value.compareTo(get(average)) > 0) {
                start = average + 1;
            }
            else {
                while (get(average) == get(average - 1)) {
                    if (average - 1 == 0) {
                        return 0;
                    }
                    average --;
                }
                return average;
            }
        }
        return -1;
    }

   public int lastIndexOfBinary (String value) {
        int start = 0;
        int end = size() - 1;
        int average = 0;
        while (start <= end) {
            average = (start + end) / 2;
            if (value.compareTo(get(average)) > 0) {
                start = average + 1;
            }
            else if (value.compareTo(get(average)) < 0) {
                end = average - 1;
            }
            else {
                while (get(average) == get(average + 1) ) {
                    if (average + 1 == size() - 1) {
                        return size() - 1;
                    }
                    average ++;
                }
                return average;
            }
        }
        return -1;
    }
    
    ////////////////////////////////////////////////////////////////

/*public static void runTest02(int testID){
  
  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }
  
  OrderedSuperArray s1 = new OrderedSuperArray();
  ArrayList<String> s2 = new ArrayList<>();
  
  try{
    if(testID == 0 ){
    }
    
    if(testID == 1 ){
      s1.add("4");
      s2.add("4");
      s1.add("1");
      s2.add("1");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 2 ){
      s1.add("3");
      s2.add("3");
      s1.add("1");
      s2.add("1");
      s1.add("5");
      s2.add("5");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 3 ){
      s1.add("1");
      s2.add("1");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    if(testID == 4 ){
      s1.add("1");
      s2.add("1");
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 5 ){
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 6 ){
      String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
      s1 = new OrderedSuperArray(x);
      s2.addAll(Arrays.asList(x));
    }
    if(testID == 7 ){
      s1.add("1");
      s2.add("1");
      
      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        s1.add(v);
        s2.add(v);
      }
    }
    
    
  }catch(Exception f){
    s2.add("0");
    //f.printStackTrace();
  }
  
  Collections.sort(s2);
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
  }
}


//oops!
public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(!s.get(i).equals( a.get(i))){
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static void main(String[]Args){
    runTest02(0);
    runTest02(1);
    runTest02(2);
    runTest02(3);
    runTest02(4);
    runTest02(5);
    runTest02(6);
    runTest02(7);
} 
*/

}

