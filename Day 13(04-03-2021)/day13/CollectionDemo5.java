package day13;

import java.util.Map;
import java.util.WeakHashMap;

public class CollectionDemo5 {
	public static void main(String[] args) {
		Map<MyKey, String> map = new WeakHashMap<MyKey, String>();

		MyKey mykey1 = new MyKey("a1");
		MyKey mykey2 = new MyKey("a2");
		MyKey mykey3 = new MyKey("a3");

		map.put(mykey1, "Raj");
		map.put(mykey2, "somu");
		map.put(mykey3, "Akshay");

		System.out.println(map);

		mykey1 = null;
		System.out.println("Before");
		System.out.println(map);
		System.gc();
		System.out.println("After");
		System.out.println(map);
	}
}