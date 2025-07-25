package selenium;

public class Test {
	public static void main(String[] args) {
		Student2 s1=new Student2();
		s1.setAge(15);
		s1.setId(1001);
		s1.setName("Rocky");
		Student2 s2=new Student2();
		s2.setAge(16);
		s2.setId(1002);
		s2.setName("Ram");
		Student2 s3=new Student2();
		s3.setAge(17);
		s3.setId(1003);
		s3.setName("Rahim");
		
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		System.out.println(s1.getId());
		System.out.println(s2.getName());
		System.out.println(s2.getAge());
		System.out.println(s2.getId());
		System.out.println(s3.getName());
		System.out.println(s3.getAge());
		System.out.println(s3.getId());
		System.out.println(Student2.count);
		System.out.println(s3.count);
	}

}
