package selenium;

import java.util.*;
import java.util.regex.*;

public class FruitOrderParser {
	
public static void main(String[] args) {
	
			    String input = "I ordered 23  apples 3 bananas and 4 oranges and 5 kiwis";

		        // Use regex to find patterns: number followed by word
		        Pattern pattern = Pattern.compile("(\\d+)\\s+(\\w+)");
		        Matcher matcher = pattern.matcher(input);

		        Map<String, Integer> fruitMap = new LinkedHashMap<>();

		        while (matcher.find()) {
		            int quantity = Integer.parseInt(matcher.group(1));
		            String fruit = matcher.group(2);

		            // Capitalize first letter and rest lowercase (Apples instead of apples)
		            fruit = fruit.substring(0, 1).toUpperCase() + fruit.substring(1).toLowerCase();

		            fruitMap.put(fruit, quantity);
		        }

		        // Output
		        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
		            System.out.println(entry.getKey() + "=>" + entry.getValue());
		        }
		    }
		}






