import java.util.*;

public class Schedule
{
	Scanner sh=new Scanner(System.in);
	int process[];
	int burst[];
	int arrival[];
	int priority[];
	int wait[];
	int n;
	int turn;
	
	Schedule(int x)
	{
		n=x;
		process=new int[n];
		burst=new int[n];
		arrival=new int[n];
		priority=new int[n];
		wait=new int[n];
	}
	
	void getData()
	{
		int i;
		for(i=0;i<n;i++)
			process[i]=i+1;
		System.out.println("Enter Burst Time for each process(in ns):");
		for(i=0;i<n;i++)
			burst[i]=sh.nextInt();
		System.out.println("Enter Arrival Time for Each process(in ns):");
		for(i=0;i<n;i++)
			arrival[i]=sh.nextInt();
		System.out.println("Enter Priority of each process:");
		for(i=0;i<n;i++)
			priority[i]=sh.nextInt();
	}
	
	void showData()
	{
		int i;
		System.out.println("\nPROCESS\tBT(in ns)\tAT(in ns)\tPRIORITY");
		System.out.println("------------------------------------------------------------------------");
		for(i=0;i<n;i++)
			System.out.println("P"+process[i]+"\t"+burst[i]+"\t\t"+arrival[i]+"\t\t"+priority[i]);
	}
	
	void calculateTurnaroundTime()
	{
		turn=0;
		for(int i=0;i<n;i++)
			turn=turn+burst[i];		
	}
	
	void copy(int[] source,int[] target)
	{
		for(int i=0;i<n;i++)
			target[i]=source[i];
	}
	
	void resetWait()
	{
		for(int i=0;i<n;i++)
			wait[i]=0;
	}
	
	void FCFS()
	{
		int t1,t2,t3,i,j,time;
		double avg=0;
		resetWait();

		for(i=0;i<n;i++)
			for(j=0;j<n-1;j++)
				if(arrival[j]>arrival[j+1])
				{
					t1=process[j];
					process[j]=process[j+1];
					process[j+1]=t1;
					t2=burst[j];
					burst[j]=burst[j+1];
					burst[j+1]=t2;
					t3=arrival[j];
					arrival[j]=arrival[j+1];
					arrival[j+1]=t3;
				}
		
		for(i=0;i<n;i++)
		{
			for(j=0;j<i;j++)
				wait[i]+=burst[j];
			wait[i]-=arrival[i];
			avg+=wait[i];
		}
		
		System.out.println("\n\nFCFS schedule is as follows:");
		System.out.println("\nProcess\tTime(in ns)\tWaiting Time(in ns)");
		System.out.println("------------------------------------------------------------------------");
		time=0;
		for(i=0;i<n;i++)
		{
			System.out.println("P"+process[i]+"\t"+time+"-"+(time+burst[i])+"\t\t"+wait[i]);
			time+=burst[i];
		}
		avg/=n;
		System.out.println("Average Waiting Time is:"+avg+"ns");
		System.out.println("Turnaround Time:"+turn+"ns");
	}
	
	void SJF()
	{
		int i,j,k,large,temp,in,count=0,t;
		double avg=0;
		int b[]=new int[n];
		resetWait();
		copy(burst,b);
		large=b[0];
		for(i=0;i<n;i++)
			if(b[i]>large)
				large=b[i];
		System.out.println("\n\nSJF schedule is as follows:");
		System.out.println("\nProcess\tTime(in ns)\tWaiting Time(in ns)");
		System.out.println("------------------------------------------------------------------------");
			
		for(i=0;i<n;i++)
		{	
			temp=large;
			in=0;
			t=turn;
			for(j=0;j<n;j++)
				if((b[j]<=temp)&&(b[j]!=0)&&(arrival[j]<=count))
				{
					if((b[j]==temp)&&(arrival[j]>t))
						continue;
					else
					{
						t=arrival[j];
						temp=b[j];
						in=process[j];
					}
				}
			for(k=0;k<n;k++)
			{
				if((process[k]==in)||(b[k]!=0))
					continue;
				else
					wait[(in-1)]+=burst[k];
			}
			wait[(in-1)]-=arrival[(in-1)];
			avg+=wait[(in-1)];
	
			System.out.println("P"+in+"\t"+count+"-"+(count+burst[(in-1)])+"\t\t"+wait[(in-1)]);
			count+=b[(in-1)];
			b[(in-1)]=0;
		}
		avg/=n;
		System.out.println("Average Waiting Time is:"+avg+"ns");
		System.out.println("Turnaround Time:"+turn+"ns");
	}
	
	void SRTF()
	{
		int i,j,k,large,temp,in,t;
		int b[]=new int[n];
		double avg=0;
		resetWait();
		copy(burst,b);
		large=b[0];
		for(i=0;i<n;i++)
			if(b[i]>large)
				large=b[i];
		
		System.out.println("\n\nSRTF schedule is as follows:");
		System.out.println("\nProcess\tTime(in ns)");
		System.out.println("------------------------------------------------------------------------");
		
		for(i=0;i<turn;i++)
		{	
			temp=large;
			in=0;
			t=turn;
			for(j=0;j<n;j++)
				if((b[j]<=temp)&&(b[j]!=0)&&(arrival[j]<=i))
				{
					if((b[j]==temp)&&(arrival[j]>t))
						continue;
					else
					{
						t=arrival[j];
						temp=b[j];
						in=process[j];
					}
				}
			for(k=0;k<n;k++)
				if((process[k]==in)||(b[k]==0))
					continue;
				else
					wait[k]++;
					
			System.out.println("P"+in+"\t"+i+"-"+(i+1));
			b[(--in)]--;
		}
		
		for(i=0;i<n;i++)
		{
			wait[i]-=arrival[i];
			avg+=wait[i];
		}
		avg/=n;
		System.out.println("Process\tWaiting Time(in ns)");
		System.out.println("------------------------------------------------------------------------");
		for(i=0;i<n;i++)
			System.out.println("P"+process[i]+"\t"+wait[i]);
		System.out.println("Average Waiting Time is:"+avg+"ns");
		System.out.println("Turnaround Time:"+turn+"ns");
	}
	
	void roundRobin()
	{	
		int t1,t2,t3,i,j,temp;
		int q=3;
		int count=0;
		int timer=0;
		double avg=0;
		resetWait();

		for(i=0;i<n;i++)
			for(j=0;j<n-1;j++)
				if(arrival[j]>arrival[j+1])
				{
					t1=process[j];
					process[j]=process[j+1];
					process[j+1]=t1;
					t2=burst[j];
					burst[j]=burst[j+1];
					burst[j+1]=t2;
					t3=arrival[j];
					arrival[j]=arrival[j+1];
					arrival[j+1]=t3;
				}
		int[] b=new int[n];
		copy(burst,b);
		System.out.println("\n\nRound Robin schedule with quantum "+q+"ns is as follows:");
		System.out.println("\nProcess\tTime(in ns)");
		System.out.println("------------------------------------------------------------------------");
		i=0;
		while(count<turn)
		{
			if(b[i]>q)
			{
				count+=q;
				temp=q;
			}
			else
			{
				count+=b[i];
				temp=b[i];
			}
			
			for(j=0;j<n;j++)
				if((i==j)||(b[j]==0))
					continue;
				else
					wait[j]+=temp;
			if(b[i]!=0)
			{
				System.out.println("P"+(i+1)+"\t"+timer+"-"+count);
				timer=count;
			}
			
			if(b[i]!=0)
				b[i]-=temp;
			
			if(i==(n-1))
				i=0;
			else
				i++;
		}
		for(i=0;i<n;i++)
		{
			wait[i]-=arrival[i];
			avg+=wait[i];
		}
		avg/=n;
		System.out.println("Process\tWaiting Time(in ns)");
		System.out.println("------------------------------------------------------------------------");
		for(i=0;i<n;i++)
			System.out.println("P"+process[i]+"\t"+wait[i]);
		System.out.println("Average Waiting Time is:"+avg+"ns");
		System.out.println("Turnaround Time:"+turn+"ns");
		
	}
	
	void prioritySchedule()
	{
		int i,j,k,large,temp,in,count=0,t;
		double avg=0;
		int b[]=new int[n];
		resetWait();
		copy(burst,b);
		large=priority[0];
		for(i=0;i<n;i++)
			if(priority[i]>large)
				large=priority[i];
		System.out.println("\n\nPriority schedule is as follows:");
		System.out.println("\nProcess\tTime(in ns)\tPriority\tWaiting Time(in ns)");
		System.out.println("------------------------------------------------------------------------");
		
		for(i=0;i<n;i++)
		{	
			temp=large;
			in=0;
			t=turn;
			for(j=0;j<n;j++)
				if((priority[j]<=temp)&&(b[j]!=0)&&(arrival[j]<=count))
				{
					if((priority[j]==temp)&&(arrival[j]>t))
						continue;
					else
					{
						t=arrival[j];
						temp=priority[j];
						in=process[j];
					}
					
				}
			for(k=0;k<n;k++)
			{
				if((process[k]==in)||(b[k]!=0))
					continue;
				else
					wait[(in-1)]+=burst[k];
			}
			wait[(in-1)]-=arrival[(in-1)];
			avg+=wait[(in-1)];
	
			System.out.println("P"+in+"\t"+count+"-"+(count+burst[(in-1)])+"\t\t"+priority[(in-1)]+"\t\t"+wait[(in-1)]);
			count+=b[(in-1)];
			b[(in-1)]=0;
		}
		avg/=n;
		System.out.println("Average Waiting Time is:"+avg+"ns");
		System.out.println("Turnaround Time:"+turn+"ns");
	}
	
	void priorityPreemptive()
	{
		int i,j,k,large,temp,in,t;
		int b[]=new int[n];
		double avg=0;
		resetWait();
		copy(burst,b);
		large=priority[0];
		for(i=0;i<n;i++)
			if(priority[i]>large)
				large=priority[i];
		
		System.out.println("\n\nPriority schedule (Preemptive Version) is as follows:");
		System.out.println("\nProcess\tTime(in ns)\tPriority");
		System.out.println("------------------------------------------------------------------------");
		
		for(i=0;i<turn;i++)
		{	
			temp=large;
			in=0;
			t=turn;
			for(j=0;j<n;j++)
				if((priority[j]<=temp)&&(b[j]!=0)&&(arrival[j]<=i))
				{
					if((priority[j]==temp)&&(arrival[j]>t))
						continue;
					else
					{
						t=arrival[j];
						temp=priority[j];
						in=process[j];
					}
				}
			for(k=0;k<n;k++)
				if((process[k]==in)||(b[k]==0))
					continue;
				else
					wait[k]++;
					
			System.out.println("P"+in+"\t"+i+"-"+(i+1)+"\t\t"+priority[(in-1)]);
			b[(--in)]--;
		}
		
		for(i=0;i<n;i++)
		{
			wait[i]-=arrival[i];
			avg+=wait[i];
		}
		avg/=n;
		System.out.println("Process\tWaiting Time(in ns)");
		System.out.println("------------------------------------------------------------------------");
		for(i=0;i<n;i++)
			System.out.println("P"+process[i]+"\t"+wait[i]);
		System.out.println("Average Waiting Time is:"+avg+"ns");
		System.out.println("Turnaround Time:"+turn+"ns");
	}
	
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\n\nIMPEMENTATION OF SCHEDULING ALGORITHMS");
		System.out.println("------------------------------------------------------------------------");
		System.out.print("\nEnter number of processes:");
		int x=sc.nextInt();
		Schedule s=new Schedule(x);
		s.getData();
		s.showData();
		s.calculateTurnaroundTime();
		s.FCFS();
		s.SJF();
		s.SRTF();
		s.roundRobin();
		s.prioritySchedule();
		s.priorityPreemptive();
	}
}

/*
OUTPUT:
C:\Users\Anoosha\Sem V\Operating Systems\Practicals\Programs>javac Schedule.java

C:\Users\Anoosha\College\Sem V\Operating Systems\Practicals\Programs>java Schedu
le


IMPEMENTATION OF SCHEDULING ALGORITHMS
------------------------------------------------------------------------

Enter number of processes:4
Enter Burst Time for each process(in ns):
10 4 5 3
Enter Arrival Time for Each process(in ns):
0 1 2 3
Enter Priority of each process:
2 3 1 4

PROCESS BT(in ns)       AT(in ns)       PRIORITY
------------------------------------------------------------------------
P1      10              0               2
P2      4               1               3
P3      5               2               1
P4      3               3               4


FCFS schedule is as follows:

Process Time(in ns)     Waiting Time(in ns)
------------------------------------------------------------------------
P1      0-10            0
P2      10-14           9
P3      14-19           12
P4      19-22           16
Average Waiting Time is:9.25ns
Turnaround Time:22ns


SJF schedule is as follows:

Process Time(in ns)     Waiting Time(in ns)
------------------------------------------------------------------------
P1      0-10            0
P4      10-13           7
P2      13-17           12
P3      17-22           15
Average Waiting Time is:8.5ns
Turnaround Time:22ns


SRTF schedule is as follows:

Process Time(in ns)
------------------------------------------------------------------------
P1      0-1
P2      1-2
P2      2-3
P2      3-4
P2      4-5
P4      5-6
P4      6-7
P4      7-8
P3      8-9
P3      9-10
P3      10-11
P3      11-12
P3      12-13
P1      13-14
P1      14-15
P1      15-16
P1      16-17
P1      17-18
P1      18-19
P1      19-20
P1      20-21
P1      21-22
Process Waiting Time(in ns)
------------------------------------------------------------------------
P1      12
P2      0
P3      6
P4      2
Average Waiting Time is:5.0ns
Turnaround Time:22ns


Round Robin schedule with quantum 3ns is as follows:

Process Time(in ns)
------------------------------------------------------------------------
P1      0-3
P2      3-6
P3      6-9
P4      9-12
P1      12-15
P2      15-16
P3      16-18
P1      18-21
P1      21-22
Process Waiting Time(in ns)
------------------------------------------------------------------------
P1      12
P2      11
P3      11
P4      6
Average Waiting Time is:10.0ns
Turnaround Time:22ns


Priority schedule is as follows:

Process Time(in ns)     Priority        Waiting Time(in ns)
------------------------------------------------------------------------
P1      0-10            2               0
P3      10-15           1               8
P2      15-19           3               14
P4      19-22           4               16
Average Waiting Time is:9.5ns
Turnaround Time:22ns


Priority schedule (Preemptive Version) is as follows:

Process Time(in ns)     Priority
------------------------------------------------------------------------
P1      0-1             2
P1      1-2             2
P3      2-3             1
P3      3-4             1
P3      4-5             1
P3      5-6             1
P3      6-7             1
P1      7-8             2
P1      8-9             2
P1      9-10            2
P1      10-11           2
P1      11-12           2
P1      12-13           2
P1      13-14           2
P1      14-15           2
P2      15-16           3
P2      16-17           3
P2      17-18           3
P2      18-19           3
P4      19-20           4
P4      20-21           4
P4      21-22           4
Process Waiting Time(in ns)
------------------------------------------------------------------------
P1      5
P2      14
P3      0
P4      16
Average Waiting Time is:8.75ns
Turnaround Time:22ns

*/