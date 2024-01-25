import java.util.*;
import java.util.Collections; 

class CLOOK {
public static void main(String args[])
{
int i;
int[] arr = new int[]{98,26,37,18,14,65,67};
Vector temp1 = new Vector();
Vector temp2 = new Vector();
for(i=0;i<arr.length;i++)
{
if(arr[i]>53)
{
temp1.add(arr[i]);
}
if(arr[i]<53)
{
temp2.add(arr[i]);
}
}
Collections.sort(temp1);
Collections.sort(temp2);
int x=temp2.size();
Arrays.sort(arr);
if(temp1.size()>temp2.size())
{

System.out.println("53->"+temp1.get(0));
for(i=0;i<temp1.size();i++)
{
if(i==(temp1.size()-1))
break;
else
System.out.println(temp1.get(i)+"->"+ temp1.get(i+1));
}
System.out.println(Collections.max(temp1)+"->"+temp2.get(0));
for(int j=0;j<temp2.size();j++)
{
if(j==(temp2.size()-1))
break;
else
System.out.println(temp2.get(j)+"->"+temp2.get(j+1));
}

}
else
{

System.out.println("53->"+temp2.get(x-1));
for(i=temp2.size()-1;i>0;i--)
{
if(i==1)
break;
else
System.out.println(temp2.get(i)+"->"+ temp2.get(i-1));
}
System.out.println(temp2.get(0)+"->"+temp1.get(0));
for(int j=0;j<temp1.size();j++)
{
if(j==(temp1.size()-1))
break;
else
System.out.println(temp1.get(j)+"->"+temp1.get(j+1));
}

}

}}