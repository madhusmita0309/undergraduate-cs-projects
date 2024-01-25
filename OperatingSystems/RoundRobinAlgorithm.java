import java.io.*;
import java.util.*;
class rr
{
public static void main(String args[]) 
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the no.of processes:");
	int n=sc.nextInt();
	int burst[]=new int[10];
	int e[]=new int[10];
	int w[]=new int[10];
	int s[]=new int[10];
	for(int m=0;m<10;m++)
		{e[m]=0;
		s[m]=0;
		w[m]=0;
		}
	System.out.println("Enter the burst time for the processes");
	for(int i=0;i<n;i++)
	burst[i]=sc.nextInt();	
	System.out.println("Enter the quantum time:");
	int q=sc.nextInt();
	int sum=0;
	for(int i=0;i<n;i++)
	sum=sum+burst[i];
	int i=0;
	int j=0;
	while(i<sum)
		{j=0;
			while(j<n)
			{
			if(burst[j]!=0)
			{
			if(burst[j]>q)
				{burst[j]=burst[j]-q;
				System.out.println("process=  "+j+"    time="+i+" to "+(i+q));
				s[j]=i;	//starting time
				i=i+q;
				w[j]=w[j]+s[j]-e[j];; 
				e[j]=i;	//ending time
				j++;
				
				}
			else if(burst[j]<=q)
				{
				System.out.println("process = "+j+"   time= "+i+"  to  "+(i+burst[j]));
				s[j]=i;
				w[j]=w[j]+s[j]-e[j];
				i=i+burst[j];
				e[j]=i;
				burst[j]=0;
				j++;
				 }
			}
			else
			j++;
			}
		}
		double time=0;
		for(int k=0;k<n;k++)
		time=time+w[k];
		System.out.println("Avg Waiting Time=  "+(time/n));
		
	}
}


/* OUTPUT:

C:\Users\colg\SEM 5 PRACS\OS>java rr
Enter the no.of processes:
3
Enter the burst time for the processes
24
3
3
Enter the quantum time:
4
process=  0    time=0 to 4
process = 1   time= 4  to  7
process = 2   time= 7  to  10
process=  0    time=10 to 14
process=  0    time=14 to 18
process=  0    time=18 to 22
process=  0    time=22 to 26
process = 0   time= 26  to  30
Avg Waiting Time=  5.666666666666667

*/