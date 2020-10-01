public class Binarysearch{  
public static void binarySearch(int arr[], int first, int last, int key){  
long start=System.nanoTime();
 int mid = (first + last)/2;  
while( first <= last ){  
if ( arr[mid] < key ){  
first = mid + 1;     
}
else if ( arr[mid] == key ){  
System.out.println("Element is found at index: " + mid);  
break;  
 }
else{  
last = mid - 1;  
}  
mid = (first + last)/2;  
}  
if ( first > last ){  
 System.out.println("Element is not found!");  
   }
long end=System.nanoTime();
System.out.println("time taken by Binary search"+(end-start)/1000000);  
 }  
 public static void main(String args[]){  
        int arr[] = {10,20,30,40,50,67,234,239,300,897};  
        int key = 300;  
        int last=arr.length-1;  
        binarySearch(arr,0,last,key);     
 }  
} 