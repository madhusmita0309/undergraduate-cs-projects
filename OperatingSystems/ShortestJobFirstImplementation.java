import java.io.*;
import java.util.*;
class sjf1
{
public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	int a[]=new int [10];
	System.out.println("Enter the no. of processes:");
	int n=sc.nextInt();
	System.out.println(" Enter burst time :");
	for( int i=0;i<n;i++)
	  {
	   a[i]=sc.nextInt();
	   }
	int temp;
	for(int i=n-1;i>0;i--)
	{ for(int j=0;j<i;j++)
		{ if(a[j]>a[j+1])
			{temp=a[j];
			a[j]=a[j+1];
			a[j+1]=temp;
			}
		}
	}
	
	System.out.println("The processes scheduling is as foll:");
	for(int i=0;i<n;i++)
		{System.out.println("P"+(i+1)+	"  "+a[i]);
		}
	
	double sum=0,sum1=0;
	double time=0;
	System.out.println("Avg waiting time:");
	for(int i=1;i<n;i++)
	{sum1=sum1+a[i-1];
	sum=sum+sum1;
	  
	}
	time=sum/n;
	System.out.print(time);


}
}
/*Output:
D:\d12a34,47>java sjf1
Enter the no. of processes:
4
 Enter burst time :
9
7
7
3
The processes scheduling is as foll:
P1  3
P2  7
P3  7
P4  9

Avg waiting time:
7.5
*/
