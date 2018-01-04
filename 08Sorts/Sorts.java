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
        boolean swaps = true;
        while (swaps){
            swaps = false;
            for (int i = 0; i < limit; i ++){
                if (data[i] > data[i + 1]){
                    swap (data, i, i + 1);
                    swaps = true;
                }
            }
        }
        limit --;
    }

    
        /////////////////////////////////////////////
        
/*public static void runTest08(int SORT, int SIZE, int MODE){
  //This is super ugly, I repurposed old code
  //Sorry!
  int[]inc = new int[SIZE];
  int[]dec = new int[SIZE];
  int[]rnd = new int[SIZE];
  int[][] arrays = new int [6][];
  
  for(int i = 0; i < inc.length; i ++){
    inc[i] = -10000 + 10 * i + (int)(Math.random()*5);
    dec[SIZE-i-1] = inc[i];
    rnd[i] = (int)(Math.random() * 20000000)-10000000;
  }
  arrays[3]= inc;
  arrays[4]= dec;
  arrays[5]= rnd;
  arrays[0]=Arrays.copyOf(inc,SIZE);
  arrays[1]=Arrays.copyOf(dec,SIZE);
  arrays[2]=Arrays.copyOf(rnd,SIZE);
  Arrays.sort(inc);
  Arrays.sort(dec);
  Arrays.sort(rnd);
  
  sort(arrays[MODE],SORT);
  
  if( ! Arrays.equals(arrays[MODE+3],arrays[MODE]) ) {
    System.out.println("FAIL! "+methodName(SORT)+" Mode:"+MODE+" Size:"+SIZE);
  }else{
    System.out.println("PASS! "+methodName(SORT)+" Mode:"+MODE+" Size:"+SIZE);
  }
}

public static void sort(int[]ary,int method){
  try{
    if(method == 0){
      Sorts.bubbleSort(ary);
    }
    if(method == 1){
      Sorts.selectionSort(ary);
    }
    if(method == 2){
      Sorts.insertionSort(ary);
    }
  }catch ( Exception e){
    e.printStackTrace();
  }
}
public static String methodName(int i){
  String[]names = {"Bubble","Selection","Insertion","Built In"};
  return names[i];
}
        

    public static void main(String[]args){                                         
        runTest08(0, 0, 0);
        runTest08(1, 0, 0);
        runTest08(2, 0, 0);
        runTest08(0, 1, 0);
        runTest08(1, 1, 0);
        runTest08(2, 1, 0);
        runTest08(0, 1000, 0);
        runTest08(1, 1000, 0);
        runTest08(2, 1000, 0);
        runTest08(0, 1000, 1);
        runTest08(1, 1000, 1);
        runTest08(2, 1000, 1);
        runTest08(0, 1000, 2);
        runTest08(1, 1000, 2);
        runTest08(2, 1000, 2);
        
    }*/
        

    }                                     
