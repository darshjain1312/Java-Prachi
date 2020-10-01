public class InsertionSort {  
 public static void insertionSort(int array[]) {  
 int n = array.length;  
for (int j = 1; j < n; j++) {  
  int key = array[j];  
int i = j-1;  
 while ( (i > -1) && ( array [i] > key ) ) {  
array [i+1] = array [i];  
i--;  
}  
array[i+1] = key;  
}}  
public static void main(String a[]){    
long start=System.nanoTime();
for(int p=0;p<10;p++){
long start1=System.nanoTime();
 int[] arr1 = {9,14,3,2,43,11,58,22};       
insertionSort(arr1);
System.out.println("After Insertion Sort");    
 for(int i:arr1){    
System.out.print(i+" ");}
long end1=System.nanoTime();
System.out.println("total time taken " + (end1-start1)/1000000);
}
long end=System.nanoTime();
System.out.println("total average time taken " + ((end-start)/1000000)/10);
}}