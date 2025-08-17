package selenium;

public class Characters {

	public static void main(String[] args) {
		String input="HeXaWaRe";
		StringBuilder result=new StringBuilder();
		
		for(Character ch : input.toCharArray()) {
			if(Character.isUpperCase(ch)) {
				
				result.append(Character.toLowerCase(ch));
				
			}else if(Character.isLowerCase(ch)) {
				
				result.append(Character.toUpperCase(ch));
				
			}else {
				result.append(ch);
			}
		}
		System.out.println(result);
			
	}

}
