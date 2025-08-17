package selenium;
import java.util.HashMap;
import java.util.Map;


public class Mapping {
	
	    public static void main(String[] args) {
	        // 1⃣ Create a Map using HashMap
	        Map<String, Integer> map = new HashMap<>();

	        // 2⃣ Add key-value pairs
	        map.put("Apple", 3);
	        map.put("Banana", 5);
	        map.put("Orange", 2);
	        // Adding same key replaces value
	        map.put("Banana", 6);

	        // 3⃣ Print the entire map
	        System.out.println("Map contents: " + map);

	        // 4⃣ Retrieve a value by key
	        int oranges = map.get("Orange");
	        System.out.println("Number of Oranges: " + oranges);

	        // 5⃣ Check key existence
	        System.out.println("Contains 'Apple'? " + map.containsKey("Apple"));
	        System.out.println("Contains value 10? " + map.containsValue(10));

	        // 6⃣ Iterate through entries
	        System.out.println("Iterating entries:");
	        for (Map.Entry<String, Integer> entry : map.entrySet()) {
	            System.out.printf("  Key = %s, Value = %d%n", entry.getKey(), entry.getValue());
	        	//System.out.println(entry.getKey() + "=>" + entry.getValue());
	        }

	        // 7⃣ Remove an entry
	        map.remove("Orange");
	        System.out.println("After removing Orange: " + map);

	        // 8⃣ Map size
	        System.out.println("Map size: " + map.size());
	      
	    }
	}


