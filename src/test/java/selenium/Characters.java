
package selenium;

public class Characters {

	public static void main(String[] args) {
		String input="HeX1aWa1Re3";
		StringBuilder result1=new StringBuilder();
		StringBuilder result2=new StringBuilder();
		for(Character ch : input.toCharArray()) {
			if(Character.isUpperCase(ch)) {
				
				result1.append(Character.toLowerCase(ch));
				
			}else if(Character.isLowerCase(ch)) {
				
				result1.append(Character.toUpperCase(ch));
				
			}else if (Character.isDigit(ch)) {
				result2.append(ch);
			}
		}
		System.out.println(result1+"       "+result2);
			
	}

}
