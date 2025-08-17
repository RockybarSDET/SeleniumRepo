package selenium;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice1 {

	public static void main(String[] args) {
		String input="I ordered 23  apples 3 bananas 4 oranges and 5 kiwis";
		Pattern pattern = Pattern.compile("(\\d+)\\s+(\\w+)");
		Matcher matcher = pattern.matcher(input);
		
		Map<String,Integer> fruitmap = new HashMap<>();
		
		while(matcher.find()) {
			int quantity= Integer.parseInt(matcher.group(1));
			String fruit= matcher.group(2);
			fruit = fruit.substring(0,1).toUpperCase()+fruit.substring(1).toLowerCase();
			fruitmap.put(fruit, quantity);
		}
		for(Map.Entry<String,Integer> entry : fruitmap.entrySet())
		{
			System.out.println(entry.getKey()+" => "+entry.getValue());
		}
		

	}

}
