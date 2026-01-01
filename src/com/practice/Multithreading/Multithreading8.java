//INTER-THREAD COMMUNICATION
//THE PROBLEM IN THE BELOW CODE IS, THERE ARE TWO THREADS MAIN AND THREAD-0, WHEN I TRY TO 
//PRINT THE VALUE OF COLLECTION IT GIVES US 0 BECAUSE WE HAVE THE SOP STATEMENT IN THE 
//MAIN THREAD AND THREAD-0 HAS NOT FINISHED THE PROCESSING, TO SOLVE THIS ISSUE WE
//CAN USE WAIT AND NOTIFY
package com.practice.Multithreading;

//class TicketCalculator extends Thread {
//	int collection = 0;
//
//	public void run() {
//		for (int i = 1; i <= 10; i++) {
//			collection += 100;
//		}
//	}
//}
//
//public class Multithreading8 {
//	public static void main(String[] args) {
//		TicketCalculator thread1 = new TicketCalculator();
//		thread1.start();
//		System.out.println("The total collection is " + thread1.collection);
//	}
//}

//IN THE BELOW CODE THE MAIN THREAD WILL WAIT FOR THE THREAD-0 TO COMPLETE ITS JOB
//NOTE: WHEN WORKING WITH WAIT AND NOTIFY OUR CODE SHOULD BE SYNCHRONIZED
Main Thread: | Acquire lock on thread1 | wait() → releases lock & waits
Worker Thread (thread1): | Acquire lock | calculate | notify | releases lock
Main Thread:| reacquire lock | print collection
class TicketCalculator extends Thread {
	int collection = 0;

	public void run() {
		synchronized (this) {
			for (int i = 1; i <= 10; i++) {
				collection += 100;
			}
			notify();
		}
	}
}

public class Multithreading8 {
	public static void main(String[] args) throws InterruptedException {
		TicketCalculator thread1 = new TicketCalculator();
		thread1.start();
		synchronized (thread1) {
			thread1.wait();
		}
		System.out.println("The total collection is " + thread1.collection);
	}
}
