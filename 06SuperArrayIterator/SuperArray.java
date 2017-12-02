// Jerry Sun Pd 9
import java.util.*;

public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    private class SuperArrayIterator implements Iterator<String> {
	private SuperArray data;
	private int index;

	public SuperArrayIterator (SuperArray caller, int position){
	    data = caller;
	    index = position;
	}

	public String next() {
	    if (hasNext()){
		index ++;
	    }
	    else {
		System.exit(0);
	    }
	    return data.get(index- 1);
	}

	public boolean hasNext(){
	    return index < data.size();
	}
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(this, 0);
    }
	
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
        if (index < 0 || index >= size()) {
            throw new UnsupportedOperationException("No element at index " + index);
        }
        return data[index];
    }

    public String set(int index, String str) { 
        if (index < 0 || index > size()) {
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
    
    ////////////// ITERATOR DRIVER ///////////////
    public static void main(String[] args) {
    SuperArray data = new SuperArray();
    int i = 0;
    while(i < 26){
      data.add(""+(char)('A'+i%26));
      i++;
    }

    System.out.println(data);
    System.out.println("Standard loop:");

    for(int n = 0; n < data.size(); n++){
      System.out.print(data.get(n)+" ");
    }
    System.out.println();
    System.out.println("for-each loop:");
    for(String s : data){
      System.out.print(s+" ");
    }
  }
}
