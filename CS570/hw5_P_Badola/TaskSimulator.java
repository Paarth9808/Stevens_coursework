//Paarth Badola
//20012789

import java.util.Arrays;
import java.util.stream.IntStream;

public class TaskSimulator {

	public static int[] exampleSimulation1() {

		Heap<Integer, Task> tQ = new Heap<Integer, Task>(); // Creating empty priority queue

		int N = 100;
		int[] TAPE = IntStream.range(0, N).toArray(); // The tape holds 100 integers from 0 to 99

		Task t0 = new Task(-1, 3); // Task which multiplies (in place) an entry by -1 provided that index = 0 (mod// 3)
		tQ.insert(0, t0);

		for (int t = 0; t < N; t++) { // This loop processes the tape entry by entry
			Pair<Integer, Task> timeTask = tQ.findMin();
			int tt = timeTask.k;
			Task task = timeTask.v;

			while (task != null && tt == t) {
				// This will look at index t of the TAPE and process the entry there (b/c we've
				// checked that task.time = t)
				task.execute(TAPE, t);
				tQ.removeMin();

				// Reinsert the same task but for the future time.
				// Hence, we will perform the same action in three units of time
				int next_time = tt + task.multiplicity;
				tQ.insert(next_time, task);

				// Go to the next task (if any) for this time
				task = null;
				timeTask = tQ.findMin();
				if (timeTask != null) {
					tt = timeTask.k;
					task = timeTask.v;
				}
			}

		}
		//System.out.println(t0);
		return TAPE;
	}

	public static int[] exampleSimulation2() {

		Heap<Integer, Task> tQ = new Heap<Integer, Task>();

		int N = 10;
		int[] TAPE = IntStream.range(0, N).toArray();

		int tt = -1;
		Task task = null;

		for (int t = 0; t < N; t++) { // This loop processes the tape entry by entry
			if (t < 1)
				continue;

			Pair<Integer, Task> timeTask = tQ.findMin(); // Initially there will be no tasks on the queue
			if (timeTask != null) {
				tt = timeTask.k;
				task = timeTask.v;
			}

			// If there are tasks to be executed at this
			// time, go ahead and do the work
			while (task != null && tt == t) {
				// This will look at the index t of the TAPE and process it (b/c we've checked
				// that tt ==t)
				task.execute(TAPE, t);
				tQ.removeMin();

				task = null;
				timeTask = tQ.findMin();
				if (timeTask != null) {
					tt = timeTask.k;
					task = timeTask.v;
				}
			}

			task = new Task(TAPE[t], 1); // The multiplier is what we see on the tape
			int next_time = t + 1;
			tQ.insert(next_time, task);
		}
		//System.out.println("exec. time = " + tQ.findMin());
		return TAPE;
	}
	
	public static int[] simulation1() {
		// empty priority queue
		Heap<Integer, Task> taskQueue = new Heap<>();
		
		int n = 100;
		// tape to hold integer entry from 0 to 99
		int[] TAPE = IntStream.range(0, n).toArray();
		
		// task given is multiply every entry by -2
		Task newTask = new Task(-2, 1);
		taskQueue.insert(0, newTask);
		
		// processing the tape entry
		for (int i = 0; i < n; i++) {
			// given minimum to timeTask
			Pair<Integer, Task> timeTask = taskQueue.findMin();
			
			int taskTime = timeTask.k;
			Task task = timeTask.v;
			
			while(task != null && taskTime == i) {
				
				// check index and process the task at that index
				newTask.execute(TAPE, i);
				taskQueue.removeMin();
				
				// after removing task from queue we reinsert the task
				int next_time = taskTime + newTask.multiplicity;
				taskQueue.insert(next_time, task);
				
				// going to execute the next task if there is one
				task = null;
				timeTask = taskQueue.findMin();
				if(timeTask != null) {
					taskTime = timeTask.k;
					task = timeTask.v;
				}
				
			}
			
		}
		System.out.println("exec. time = " + taskQueue.findMin());
		return TAPE;
		
	}

	public static int[] simulation2() {
		Heap <Integer , Task> taskQueue = new Heap<>();
		int n = 10;
		int [] TAPE = IntStream.range(0, n).toArray();
		
		int taskTime = 0;
		Task task = null;
		
		for (int i =0; i< n; i++) {
			if (i<1) {
				continue;
			}
			
			
			Pair<Integer, Task> timeTask = taskQueue.findMin();
			if(timeTask != null) {
				taskTime = timeTask.k;
				task = timeTask.v;
			}
			
			while(task != null && taskTime == i) {
				task.execute(TAPE, i);
				taskQueue.removeMin();
				
				task = null;
				timeTask = taskQueue.findMin();
				
				if(timeTask != null) {
					taskTime = timeTask.k;
					task = timeTask.v;
				}
			}
			
			if (i < n-1) {
				task = new Task(TAPE[i+1], 1);
				int next_time = i+1;
				taskQueue.insert(next_time, task);
			}
			else {
			task = new Task(TAPE[i], 1); // The multiplier is what we see on the tape
			int next_time = i + 1;
			taskQueue.insert(next_time, task);}
		}
		
		System.out.println("exec. time = " + taskQueue.findMin());
		return TAPE;
	}

	public static int[] simulation3() {
		
		Heap<Integer, Task> tQ = new Heap<Integer, Task>();

		int N = 10;
		int[] TAPE = IntStream.range(0, N).toArray();

		int tt = -1;
		Task task = null;

		for (int t = 0; t < N; t++) { // This loop processes the tape entry by entry
			if (t < 1)
				continue;

			Pair<Integer, Task> timeTask = tQ.findMin(); // Initially there will be no tasks on the queue
			if (timeTask != null) {
				tt = timeTask.k;
				task = timeTask.v;
			}

			// If there are tasks to be executed at this
			// time, go ahead and do the work
			while (task != null && tt == t) {
				// This will look at the index t of the TAPE and process it (b/c we've checked
				// that tt ==t)
				task.execute(TAPE, t);
				tQ.removeMin();
				//System.out.println(task);
				task = null;
				timeTask = tQ.findMin();
				if (timeTask != null) {
					tt = timeTask.k;
					task = timeTask.v;
				}
			}
			
			if (t >= 1 && t< N-1) {
				task = new Task(TAPE[t+1]*TAPE[t+1] , 1); // The multiplier is what we see on the tape
				int next_time = t + 1;
				tQ.insert(next_time, task);
			}
			else {
				task = new Task(TAPE[t], 1); // The multiplier is what we see on the tape
				int next_time = t + 1;
				tQ.insert(next_time, task);
			}
		}
		System.out.println("exec. time = " + tQ.findMin());
		return TAPE;
	}

	public static Pair<int[], Heap<Integer, Task>> simulation4() {
		// started with an empty taskQueue
		Heap<Integer, Task> taskQueue = new Heap<>();
		
		int N = 100;
		int[] TAPE = IntStream.range(0, N).toArray(); 
		int taskTime = 0;
		Task task = null;
		
		for(int i =0; i<N; i++) {
			// did not process 0 or 1
			if (i <= 1) 
				continue;
			
			// from i == 2 we execute task
			Pair<Integer, Task> timeTask = taskQueue.findMin();
			if(timeTask != null) {
				taskTime = timeTask.k;
				task = timeTask.v;
			}
			
			while(task!= null && taskTime == i) {
				//executing the task
				task.execute(TAPE, i);
				taskQueue.removeMin();// removing the task
				
				// reinserting the task but with new taskTime 
				int next_time = taskTime + task.multiplicity;
				taskQueue.insert(next_time, task);
				
				
				task = null;
				timeTask = taskQueue.findMin();
				if(timeTask!=null) {
					taskTime = timeTask.k;
					task = timeTask.v;
				}
			}
			// if entry at index i not 0
			if(TAPE[i] !=0) {
				Task T = new Task(0, i);
				int next_time = i + T.multiplicity;
				taskQueue.insert(next_time, T);
			}
		}
		int k = 0;
		int len = 0;
		while(k != N) {
			if (TAPE[k] > 1) {
				len+=1;
			}
			k+=1;
		}
		
		int[] retTape = new int[len];
		
		for (int i = 0, j = 0; i<N; i++) {
			if (TAPE[i] > 1) {
		        retTape[j++] = TAPE[i];
		    }
		}
	
		Pair<int[], Heap<Integer, Task>> retPair = new Pair<int[], Heap<Integer, Task>>(retTape, taskQueue);
		return retPair;
	}
			

	public static Pair<int[], Heap<Integer, Task>> simulation5() {
		// creating empty priority queue
		Heap <Integer, Task> taskQueue = new Heap<>();
		
		int N = 100;
		int[] TAPE = IntStream.range(0, N).toArray();
		int taskTime = 0;
		Task task = null;
		
		for (int i =0; i<N ; i++) {
			if (i<=1)
				continue;
			
			//from i == 2
			// new task
			Task T = new Task(-1, i);
			taskQueue.insert(i, T);
			//taskTime = ;
			Pair<Integer, Task>timeTask = taskQueue.findMin();
			if(timeTask != null) {
				taskTime = timeTask.k;
				task = timeTask.v;
			}
			while(task!= null && taskTime == i) {
				//executing the task
				task.execute(TAPE, i);
				taskQueue.removeMin();// removing the task
				
				// reinserting the task but with new taskTime 
				int next_time = taskTime + task.multiplicity;
				taskQueue.insert(next_time, task);
				
				
				task = null;
				
				timeTask = taskQueue.findMin();
				if(timeTask!=null) {
					taskTime = timeTask.k;
					task = timeTask.v;
				}
			}
		}
		int k = 0;
		int len = 0;
		while(k != N) {
			if (TAPE[k] >= 0) {
				len+=1;
			}
			k+=1;
		}
		
		int[] retTape = new int[len];
		
		for (int i = 0, j = 0; i<N; i++) {
			if (TAPE[i] >= 0) {
		        retTape[j++] = TAPE[i];
		    }
		}
		
		Pair<int[], Heap<Integer, Task>> retPair = new Pair<int[], Heap<Integer, Task>>(retTape, taskQueue);
		return retPair;
	}

	public static void main(String[] args) {
		
		//int[] TAPE = exampleSimulation1();
		//int[] TAPE = exampleSimulation2();
		
		//int[] TAPE = simulation1();
		//int[] TAPE = simulation2();
		//int[] TAPE = simulation3();
		//System.out.println(Arrays.toString(TAPE));
		//Pair<int[], Heap<Integer, Task>> retPair = simulation4();
		Pair<int[], Heap<Integer, Task>> retPair = simulation5();
		int[] type1 = retPair.k;
		System.out.println(Arrays.toString(type1));
		int total = retPair.v.getLength();
		for (int i = 0; i<total; i++) {
			System.out.println(i);
			Pair<Integer, Task> iterH = retPair.v.removeMin();
			System.out.println(iterH.k + " " +iterH.v);
		}
	}

}

