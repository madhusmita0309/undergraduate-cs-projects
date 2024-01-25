import java.util.concurrent.Semaphore;
import java.util.Random;

public class Diningphilosopher extends Thread
{
    // Shared by each Diningphilosopher
    	private static final Random rand = new Random();
    	private static int event=0;
    	final static int N = 5; 		// five Diningphilosophers, five forks
    	public static Semaphore[] fork = new Semaphore[N];
    	private int oneOnTop = N;
 
    // My local stuff
    	private int id;                  	// Which Diningphilosopher
    	private Semaphore myFork;        // Resource locks
    	private Semaphore myNeighborsFork;
    	private int meals = 1;          	// Maximum meals
 
   	public Diningphilosopher(int i, Semaphore fork1, Semaphore fork2)
    	{
        		id = i;
        		myFork = fork1;
        		myNeighborsFork = fork2;
    	}
 
    	private void postMsg(String str) 		
	{
		System.out.printf("\nChopsitcks left: %d. Diningphilosopher %d %s\n", getTopOne(), id, str);
    	}

    	private void pause()
    	{
        		try
        		{
            			sleep(rand.nextInt(4000));
        		}
		 catch (InterruptedException e){}
    	}
 
    	private void think()
    	{
        		postMsg("is thinking");
        		pause();
    	}
    
    	private synchronized void takeOne()
    	{
        		oneOnTop--;
    	}
    
    	private synchronized void putBack()
    	{
        		oneOnTop++;
    	}
    
    	private synchronized int getTopOne()
    	{
        		return oneOnTop;	
	}
    
    	private void trytoeat()
    	{
        		if (getTopOne() < 2)
		{
           			postMsg("is waiting for enough chopsticks to be on the table");
        		} 
		else 
		{
            			postMsg("is hungry and is trying to pick up two chopsticks");
        		}
        		pause();
       		 try 
		{
            			takeOne();
            			myFork = fork[getTopOne() - 1];
            			myFork.acquire();
            			takeOne();
            			myNeighborsFork = fork[getTopOne() - 1];
            			if (!myNeighborsFork.tryAcquire()) 
			{
                				postMsg(">>>> was not able to get a second chopstick");
                				return;
            			};
            			postMsg("picked up two chopsticks and is eating meal "+ (--meals));
            			pause();
            			postMsg("puts down his chopsticks");
            			putBack();
            			myNeighborsFork.release();
        		} 
		catch (InterruptedException e) 
		{	
			postMsg("was interrupted while waiting for his fork");
        		}
        		finally 
		{ 
            			putBack();
            			myFork.release();
        		}
    	}
    	public void run()
    	{
        		while (meals > 0)
        		{
            			think();
            			trytoeat();
        		}
    	}
    	public static void main(String[] args)
    	{
        		System.out.println("Begin");
        		for (int f = 0; f < N; f++) 
		{
            			fork[f] = new Semaphore(1, true);
        		}
        		Diningphilosopher[] Diningphilosopher = new Diningphilosopher[N];
        		for (int me = 0; me < N; me++) 
		{
            			int myneighbor = me + 1;
            			if (myneighbor == N) 
				myneighbor = 0;
            			Diningphilosopher[me] = new Diningphilosopher(me, fork[me], fork[myneighbor]); 
        		}
        		for (int i = 0; i < N; i++) 
		{
              			Diningphilosopher[i].start();
        		}
        		for (int i = 0; i < N; i++) 
		{
          			try 
			{
            				Diningphilosopher[i].join();
          			} 
			catch(InterruptedException ex) { }
        		}
        		System.out.println("\nDone");
    	}
}

