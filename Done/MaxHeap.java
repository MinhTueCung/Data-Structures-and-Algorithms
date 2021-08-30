package Done;

public class MaxHeap {
    private final int[] Heap;
    private int Pointer;
    
    public MaxHeap(int i){
        Heap = new int[i];
        Pointer = 0;
    }
    
    public void add(int i){
       try{
           Heap[Pointer] = i;
           Pointer++;
       }
       catch(ArrayIndexOutOfBoundsException exc){
           System.out.println("The maximal capacity of heap has been reached!");
       }
    }
    
    public void showHeap(){
        for(int i = 0; i < Heap.length; ++i){
            System.out.print(Heap[i] + " ");
        }
    }
    
    private void max_Heapify_recur(int AsRoot){
        int largest = AsRoot;
        int left = AsRoot*2 +1;
        int right = AsRoot*2 + 2;
        if(left < Pointer && Heap[left] > Heap[AsRoot]){
            largest = left;
        }
        if(right < Pointer && Heap[right] > Heap[largest]){
            largest = right;
        }
        if(largest != AsRoot){
            int temp = Heap[largest];
            Heap[largest] = Heap[AsRoot];
            Heap[AsRoot] = temp;
            max_Heapify_recur(largest);
        }
    }
    
    public void max_Heapify(){
        for(int i = Pointer/2 - 1; i >=0 ; i--){
            max_Heapify_recur(i);
        }
    }
    
    public void sort(){
       if(Pointer > 1){
        int temp = Heap[0];
        Heap[0] = Heap[Pointer -1];
        Heap[Pointer - 1] = temp;
        Pointer--;
        max_Heapify_recur(0);
        sort();
       }
    }
    
    public int size(){
        return this.Heap.length;
    }
  }
