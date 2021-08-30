package Done;

public class MergeSort {
    
    public static void MergeSort(int[] array, int head, int tail){
        if(head < tail){
            int mitte = (head + tail)/2;
            MergeSort(array, head, mitte);
            MergeSort(array, mitte + 1, tail);
            Sort(array, head, mitte, tail);
        }
    }
    
    private static void Sort(int[] array, int head, int mitte, int tail){
        int[] arrayBackup = new int[tail - head + 1];
        int a = 0;
        for(int i = head; i <= mitte; i++){
            arrayBackup[a] = array[i];
            a++;
        }
        a = 0;
        int j = arrayBackup.length - 1;
        for(int k = mitte + 1; k <= tail; k++){
            arrayBackup[j] = array[k];
            j--;
        }
        j = arrayBackup.length - 1;
        for(int b = head; b <= tail; b++){
            if(arrayBackup[a] <= arrayBackup[j]){
                array[b] = arrayBackup[a];
                a++;
            }
            else{
                array[b] = arrayBackup[j];
                j--;
            }
        }
    }
}
