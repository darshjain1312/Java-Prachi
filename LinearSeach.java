public class LinearSeach{
public static void main(String[] args){
long start=System.nanoTime();
int[] a={3,34,2,45,23,123,6,65};
int ele=23;
for(int i=0;i<a.length;i++){
if(ele==a[i]){
System.out.println("element searched  "+a[i] +" at index = " + i);
}}
long end=System.nanoTime();
System.out.println("time taken to excute the program =" + (end-start)/1000000);
}}