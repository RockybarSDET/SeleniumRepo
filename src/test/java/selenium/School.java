package selenium;

public class School {
	
	private static School school=new School();
	private School() {
		
	}
	public static School getinstance() {
		return school;
	}

}
