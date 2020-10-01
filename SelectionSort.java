public class SelectionSort{
public static void main(String[] args){
long s1=System.nanoTime();
for(int p=0;p<10;p++){
long s2=System.nanoTime();
int[] A={33,4,5,7,89,23,45,12,46,233};
int add,k,temp=0;
for(k=0;k<A.length-1;k++){
add=selectionSort(A,k,A.length);
temp=A[k];
A[k]=A[add];
A[add]=temp;
}
for(int i=0;i<=A.length-1;i++){
System.out.println(A[i]);
}
long e2=System.nanoTime();
long total=e2-s2;
System.out.println("Total time for execution"+total/1000000);
}
long e1=System.nanoTime();
long total1=e1-s1;
System.out.println("Average time for execution"+(total1/1000000)/10);
}

public static int selectionSort(int[] A,int k, int N){
int add,min;
min=A[k];
add=k;
for (int j=k+1;j<=A.length-1;j++){
if(min>A[j]){
min=A[j];
add=j;
}}
return add;
}
}