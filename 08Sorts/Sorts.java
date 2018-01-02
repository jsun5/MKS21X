import java.util.Arrays;
                                                            
public class Sorts{                                                                 
                                                                                    
    public static String name(){                                                    
        return "09.Sun.Jerry";                                                  
    }                                                                               
                                                                                    
    public static boolean isSorted(int[]ary){                                       
        for(int i = 0; i < ary.length - 1 ; i++){                                   
            if(ary[i] > ary[i+1]){                                                  
                return false;                                                       
            }                                                                       
        }                                                                           
        return true;                                                                
    }

    private static void swap(int[]ary,int a, int b){                                
        int c = ary[a];                                                              
        ary[a] = ary[b];                                                            
        ary[b] = c;                                                                 
    }
    
    public static void selectionSort(int[] data){
        for (int i = 0; i < data.length - 1; i ++){
            int smallestIndex = i;
            for (int ind = i + 1; ind < data.length; ind++){
                if (data[ind] < data[smallestIndex]){
                   smallestIndex = ind;
                }
            }
            swap(data, i, smallestIndex);
        }
    }
    
    public static void insertionSort(int[] data){
        for (int i = 0; i < data.length - 1; i ++) {
            for (int ind = i + 1; ind > 0; ind --) {
                if (data[ind ] < data[ind - 1]) {
                    swap(data, ind, ind- 1);
                }
            }
        }
    }

    public static void bubbleSort(int[] data){
	int limit = data.length - 1;
	while (limit > 1 && !isSorted(data)){
	    int swaps = 0;
	    for (int i = 0; i < limit; i ++){
		if (data[i] > data[i + 1]){
		    swap (data, i, i + 1);
		    swaps ++;
		}
	    }
	    if (swaps == 0){
		return;
	    }
	    limit --;
	}
    }
        
        
        

    public static void main(String[]args){                                         
        int[] randish = new int[25];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }
	int[] copy = randish;
        System.out.println(name());
	        System.out.println(Arrays.toString(randish));                               
        bubbleSort(randish);                                                  
	    System.out.println(Arrays.toString(randish));
		Arrays.sort(copy);
	System.out.println(copy.equals(randish));
    }                                     
}
