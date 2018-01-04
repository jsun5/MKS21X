// Jerry Sun Pd 9

//import java.util.*; //for testing w ArrayList

public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray() {
        data = new String[10];
        //size = 0;     NOT NEEDED (IMPLIED)
    }
    
    
    // 11/1/17 
    public SuperArray(int startingCapacity) {
        data = new String[startingCapacity];
    }
    
    
    public void clear() {
        data = new String[data.length];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean add(String element) {
        resize();
        data[size] = element;
        size ++;
        return true;    
    }

    public String toString() {
        String start = "[";
        if (isEmpty()) {
            return "[]";
        }
        for (int index = 0; index < size; index ++) {
            if (data[index] != null) {
                start = start + data[index] + ",";
            }
        }
        return start.substring(0, start.length() - 1) + "]";
    }

    public String get(int index) {
        if (index == 0 && size() == 0){
            return "";
        }
        if (index < 0 || index >= size()) {
            throw new UnsupportedOperationException("No element at index " + index);
        }
        return data[index];
    }

    public String set(int index, String str) { 
        if (index < 0 || index > size() || str.equals("")) {
            throw new UnsupportedOperationException("No element at index " + index);
        }
        String elem = data[index];
        data[index] = str;
        return elem;
    }
    
    private void resize() {
        if (size == data.length) {
            String[] temp = new String[data.length + data.length + 1];
            for (int index = 0; index < data.length; index ++) {
            temp[index] = data[index];
            }
            data = temp;
        }
    }
    
    public boolean contains(String target) {
        for (int index = 0; index < size; index ++) {
            if (data[index].equals(target)) {
                return true;
            }
        }
        return false;
    }
    
    public int indexOf (String element) {
        for (int index = 0; index < size; index ++) {
            if (data[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }
    
    public int lastIndexOf (String element) {
        for (int index = size - 1; index > 0; index--) {
            if (data[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }
    
/* PREVIOUS CODE: DOESNT WORK
    public void add(int index, String element) {
        if (index < 0 || index > size()) {
            System.out.println("error: index out of range");
        }
        else if (index == size) {
            add(element);
        }
        else {
            for (int i = size; size > index; i --) {
                data[i] = data[5];
            }
            data[index] = element;
            size ++;
        }
    } */
                
    public void add(int index, String element){
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        //if (index == size) {          PRODUCED AN ERROR
        //    add(element);
        //}
        else {
            resize();
            for(int i = size; i > index; i--){
                data[i] = data[i-1];
            }
            data[index] = element;
            size++;
        }
    }
    
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        String temp = data[index];

            for (int i = index; i < size; i ++) {
                data[i] = data[i + 1];
            }
            size--;
        
        return temp;
    }
    
    public boolean remove(String element){
        if (indexOf(element) != -1) {
            for (int i = indexOf(element); i < size; i ++) {
                data[i] = data[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////
    
/*    public static void runTest01(int testID){
  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }
  
  SuperArray s1 = new SuperArray();
  ArrayList<String> s2 = new ArrayList<>();
  
  try{
    if(testID == 0 ){
    }
    
    if(testID == 1 ){
      s1.add("0");
      s2.add("0");
      s1.add("1");
      s2.add("1");
    }
    
    if(testID == 2 ){
      
      s1.add("0");
      s2.add("0");
      s1.add("1");
      s2.add("1");
      s1.add(1,"5");
      s2.add(1,"5");
      s1.add(0,"6");
      s2.add(0,"6");
      s1.add(s1.size()-1,"4");
      s2.add(s2.size()-1,"4");
    }
    
    if(testID == 3 ){
      s1.add("0");
      s2.add("0");
      s1.add("1");
      s2.add("1");
      s1.add(1,"5");
      s2.add(1,"5");
      s1.add(0,"6");
      s2.add(0,"6");
      s1.add(s1.size(),"4");
      s2.add(s2.size(),"4");
    }
    
    if(testID == 4 ){
      s1.add(0,"0");
      s2.add(0,"0");
    }
    
    if(testID == 5 ){
      s1.add("1");
      s2.add("1");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    if(testID == 6 ){
      try{
        s1.get(0);
      } catch(IndexOutOfBoundsException e){
        
      }
    }
    
    if(testID == 7 ){
      try{
        s1.set(0,"");
      } catch(IndexOutOfBoundsException e){
        
      }
    }
    
    if(testID == 8 ){
      try{
        s1.add(1,"");
      } catch(IndexOutOfBoundsException e){
        
      }
    }
    if(testID == 9 ){
      s1.add("1");
      s2.add("1");
      
      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    
  }catch(Exception f){
    s2.add("0");
    //f.printStackTrace();
  }
  
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
    System.out.println("Test "+testID+",FAIL");
  }
  
  
  
}

//oops! forgot this
public static boolean equals(SuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(! s.get(i).equals( a.get(i))){
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
public static void main(String[]Args){
    runTest01(0);
    runTest01(1);
    runTest01(2);
    runTest01(3);
    runTest01(4);
    runTest01(5);
    runTest01(6);
    runTest01(7);
    runTest01(8);
    runTest01(9);
} */
}
