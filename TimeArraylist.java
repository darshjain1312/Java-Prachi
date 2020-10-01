import java.lang.Math;
import java.util.ArrayList;
public class TimeArraylist{
public static void main(String [] args){
long start=System.nanoTime();
for(int p=0;p<10;p++){
long start1=System.nanoTime();
ArrayList al=new ArrayList(10000);
ArrayList  al1=new ArrayList();
for(int i=0;i<=10000;i++){
al.add(Math.random());
}
for(int i=0;i<=10000;i++){
al1.add(Math.random());
}
long end1=System.nanoTime();
long total1=end1-start1;
System.out.println("time" + total1/1000000);
}
long end=System.nanoTime();
long total=end-start;
System.out.println("time average taken"+(total/1000000)/10);
}
}