package Done;

public class QuickSort {
    
    public static void sort(int[] array, int begin, int end){
        if(begin < end){
          int pivot = (begin + end)/2;
          swap(array, pivot, end);
          pivot = end;
          int a = begin;
          for(int i = begin; i <= end; i++){
              if(array[i] <= array[pivot]){
                  swap(array, a, i);
                  if(i == end){
                      pivot = a;
                  }
                  a++;
              }
          }
        sort(array, begin, pivot -1);
        sort(array, pivot + 1, end);
       }
    }
    
    private static void swap(int[] array, int index, int target){
        int temp = array[index];
        array[index] = array[target];
        array[target] = temp;
    }
    
}
