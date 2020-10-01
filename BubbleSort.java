public class BubbleSort{
public static void main(String[] args){
long start1=System.nanoTime();
for(int p=0;p<10;p++){
long start=System.nanoTime();
int[] A={23,56,25,98,434,23};
bubbleSort(A,A.length-1);
for (int i=0;i<=A.length-1;i++){
System.out.println(A[i]);
}
long end=System.nanoTime();
long total=end-start;
System.out.println("total  time take"+(total/1000000));
}
long end1=System.nanoTime();
long total1=end1-start1;
System.out.println("total  average time take"+(total1/1000000)/10);
}
public static void bubbleSort(int[] A,int N){
int temp=0;
for(int count=0;count<=N-1;count++){
for (int i=0;i<=N-1-count;i++){
if(A[i]>A[i+1]){
temp=A[i];
A[i]=A[i+1];
A[i+1]=temp;
}}}}
}