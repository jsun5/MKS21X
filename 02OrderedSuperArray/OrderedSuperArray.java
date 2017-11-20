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
    }
    
    public String get(int index, String element){
	throw new UnsupportedOperationException();
    }

    /*call the proper add.*/
//    public void add(int index, String value){
  //      add(value);
//    } 

    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String value){
        super.add(findIndexBinary(value), value);
        return true;
    }

    private int findIndex(String value) {
        for (int index = 0; index < size(); index ++) {
            if (get(index).compareTo(value) > 0) {
                return index ;
            }
        }
        return size();
    }
    
    private int findIndexBinary(String value){
        /*	for(int index = 0; (value.compareTo(data[index]) == -1; xzv)) {}
       
        int start = 0; //min
        int end = 0; //max
        int average = 0;
        if (value.compareTo(data[index]) < 0;) {} 
        // ["abb", "bob"," cat", "dog" ] bu 
        */

        int start = 0;
        int end = size() - 1;
        int average = 0;
        System.out.println("" + start + end + average);
        //	for (int index = 0; 
        while (start <= end) {
            average = (start + end) / 2;
            System.out.println("" + start + end + average);
            if (value.compareTo(get(average)) < 0) {
                end = average - 1;
            }
            if (value.compareTo(get(average)) > 0) {
                start = average + 1;
            }
            else {
                return average;
            }
	}
        return -1;
    }


    public static void main(String[] args) {
	OrderedSuperArray a = new OrderedSuperArray();
	a.add(0, "a");
	a.add(1, "1");
        System.out.println(a);
    	System.out.println("index of a: " + a.findIndex("a"));
        System.out.println("index of 8: " + a.findIndex("8"));
        System.out.println("index of 5: " + a.findIndex("6"));
    	System.out.println("index of a: " + a.findIndexBinary("a"));
        System.out.println("index of 8: " + a.findIndexBinary("8"));
        System.out.println("index of 6: " + a.findIndexBinary("6"));
    }

}
