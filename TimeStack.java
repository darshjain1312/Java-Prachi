
import java.lang.Math;
import java.util.Collections;
import java.util.Stack;
public class TimeStack{
public static void main(String [] args){
long start=System.nanoTime();
for(int p=0;p<10;p++){
long start1=System.nanoTime();
Stack s=new Stack();
Stack s1=new Stack();
for(int i=0;i<=10000;i++){
s.push(Math.random());
}
for(int i=0;i<=10000;i++){
s1.push(Math.random());
}
Collections.copy(s1,s);
for(int j=0;j<=10000;j++)
s1.pop();
long end1=System.nanoTime();
//System.out.println("total time taken "+(end1-start1)/1000000);
}
long end=System.nanoTime();
long total=end-start;
System.out.println("total average time taken"+(total/1000000)/10);
}
}