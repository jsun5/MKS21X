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

/* TESTING IGNORE THIS

    public static void main(String[] args) {
	OrderedSuperArray a = new OrderedSuperArray();
    for (int count = 0; count < 10; count ++) {
        a.add(count, "" + count );
    }
     
        System.out.println(a);
    	System.out.println("index of 1: " + a.findIndex("1"));
        System.out.println("index of 8: " + a.findIndex("8"));
        System.out.println("index of 6: " + a.findIndex("6"));
    	System.out.println("index of 1: " + a.findIndexBinary("1"));
        System.out.println("index of 8: " + a.findIndexBinary("8"));
        System.out.println("index of 6: " + a.findIndexBinary("6"));
        
    OrderedSuperArray b = new OrderedSuperArray(20);
    b.add("b");
    b.add("a");
    b.add("a");
//    b.add("hello");
//    b.add("9.5");
//    b.add("Hello");
//    b.add("oof");
//    b.add("boooooi");
    b.add("a");
    b.add("b");
    
    System.out.println(b);
    System.out.println(b.indexOfBinary("a"));
    System.out.println(b.indexOfBinary("b"));
    System.out.println(b.lastIndexOfBinary("a"));
    System.out.println(b.lastIndexOfBinary("b"));
        
        OrderedSuperArray ordered = new OrderedSuperArray();
      System.out.println(ordered.add("Happy"));
      System.out.println(ordered.add("Apple"));
      System.out.println(ordered.add("Bable"));
      System.out.println("happy".compareTo("Happy"));
      System.out.println(ordered);
      System.out.println(ordered.add("bable"));

      System.out.println(ordered.add("happy"));
      System.out.println(ordered.add("zappy"));
      System.out.println(ordered.add("Zappy"));

      System.out.println(ordered);

      String[] nextStrings = new String[26];
      int count = 0;
      for (int i = 0; i < 26; i ++){
        if (i % 2 == 0){
          nextStrings[i] = "" + (char)(i + 65);
          nextStrings[i] = nextStrings[i].toLowerCase();
        }
        else{
          nextStrings[i] = "" + (char)(i + 65);
        }
      }

      OrderedSuperArray next = new OrderedSuperArray(nextStrings);
      next.add("B");
      next.add("B");
      next.add("B");

      next.add("H");
      System.out.println(next);
      System.out.println(next.indexOfBinary("B"));//should be 0
      System.out.println(next.indexOfBinary("H"));//should be 4
      System.out.println(next.indexOfBinary("Z"));//should be 12
      System.out.println(next.indexOfBinary("X"));//should be 11
      System.out.println(next.lastIndexOf("H")); // 7
      System.out.println(next.lastIndexOf("B")); // 3
      for (int i = 0; i < next.size(); i ++){
        System.out.println(next.get(i) + "||" + next.findIndex(next.get(i)) + "||" + next.findIndexBinary(next.get(i)) );
      }

      System.out.println(next.findIndexBinary("1")); // should return size(); */

}

