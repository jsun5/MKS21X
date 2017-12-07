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
            for (int ind = i; ind > -1; ind --) {
                if (data[ind + 1] < data[ind]) {
                    swap(data, ind + 1, ind);
                }
            }
        }
    }
                    
        
        
        

    public static void main(String[]args){                                         
        int[] randish = new int[100];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }                                         
        System.out.println(name());
        System.out.println(Arrays.toString(randish));                               
        insertionSort(randish);                                                  
        System.out.println(Arrays.toString(randish));                                                                                                                 
    }                                                                               
}                       