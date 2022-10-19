import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueAPITest {
	public static void main(String[] args) {
		
//		Queue<String> queue = new LinkedList<String>();
		Queue<String> queue = new ArrayDeque<String>();
		System.out.println(queue.size() + "//" + queue.isEmpty());
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		System.out.println(queue.size() + "//" + queue.isEmpty());
		
		System.out.println(queue.poll());
		System.out.println(queue.size() + "//" + queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.size() + "//" + queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size() + "//" + queue.isEmpty());
		System.out.println(queue.poll());
		
	}
}
