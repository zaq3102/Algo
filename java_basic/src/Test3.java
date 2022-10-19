import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Test3 {
	public static void main(String[] args) {
		List<String> al = new LinkedList<String>();
		
		al.add("abc");
		Integer[] ii = new Integer[] {new Integer(1),2,3,4};
		List<Integer> list = Arrays.asList(ii);
		
		System.out.println(Arrays.toString(ii));
		System.out.println(list);
		list.set(2, 9999);
		System.out.println(Arrays.toString(ii));
		System.out.println(list);
		
		List<Integer> ll = new ArrayList<Integer>(list);
		System.out.println(ll);
		ll.add(8888);
		System.out.println(ll);
		
		
		/////////////////////////////////////////////////////////
		Set<Integer> set = new HashSet<Integer>();
		set.add(2);
		set.add(30);
		set.add(10);
		set.add(4);
		System.out.println(set);
		
		for (Integer i : ll) {
			System.out.print(i + " ");
		}
		
		Iterator<Integer> iter = ll.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		ListIterator<Integer> listiter = ll.listIterator();
		
//		while(listiter.hasNext()) {
//			System.out.println(listiter.next());
//		}
		
		System.out.println(listiter.next());
		System.out.println(listiter.next());
		System.out.println(listiter.previous());
		System.out.println(listiter.previous());
			
		
		
		
		
		
		
	}
}
