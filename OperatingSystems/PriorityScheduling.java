import java.io.*;
import java.util.*;
class priority1
{
public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	int prior[]=new int [10];
	int burst[]=new int [10];
	System.out.println("Enter the no. of processes:");
	int n=sc.nextInt();
	System.out.println("Enter the burst time of processes");
	for( int i=0;i<n;i++)
	  {
	   burst[i]=sc.nextInt();
	   } 
	System.out.println(" Enter priority of the processes:");
	for( int i=0;i<n;i++)
	  {
	   prior[i]=sc.nextInt();
	   }
	int temp,  temp1;
	for(int i=n-1;i>0;i--)
	{ for(int j=0;j<i;j++)
		{ if(prior[j]>prior[j+1])
			{temp=prior[j];
			prior[j]=prior[j+1];
			prior[j+1]=temp;
			
			temp1=burst[j];
			burst[j]=burst[j+1];
			burst[j+1]=temp1;
				
		}
		}
	}
	
	System.out.println("The processes scheduling is as foll:");
	for(int i=0;i<n;i++)
		{System.out.println("P"+(i+1)+	"  "+prior[i] + "   " + burst[i]);
		}
	
	double sum=0,sum1=0;
	double time=0;
	System.out.println("Avg waiting time:");
	for(int i=1;i<n;i++)
	{sum1=sum1+burst[i-1];
	sum=sum+sum1;
	  
	}
	time=sum/n;
	System.out.print(time);

}
}

/* OUTPUT:

D:\d12a34,47>java priority1
Enter the no. of processes:
5
Enter the burst time of processes
10 1 2 1 5
 Enter priority of the processes:
3 1 4 5 2
The processes scheduling is as foll:
P1  1   1
P2  2   5
P3  3   10
P4  4   2
P5  5   1
Avg waiting time:
8.2


*/