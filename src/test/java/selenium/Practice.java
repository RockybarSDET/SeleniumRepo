package selenium;

import java.util.HashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		Map<String, Integer> fruits = new HashMap<>();
		fruits.put("Apple", 3);
		fruits.put("Banana", 4);
		fruits.put("Orange", 5);
		fruits.put("Mango", 6);
		
		System.out.println(fruits);
		fruits.remove("Mango");
		System.out.println(fruits);
		for(Map.Entry<String, Integer> entry : fruits.entrySet())
		{
			System.out.println(entry.getKey()+" => "+entry.getValue());
			
		}
		

	}

}
