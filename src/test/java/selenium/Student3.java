package selenium;

import java.util.ArrayList;
import java.util.Arrays;

public class Student3 {

	public static void main(String[] args) {
			      
		      String s1="Rahul is the AcTuAl person responsible".trim();
		      String[] arr1=s1.split(" ");
		      ArrayList<String> list1=new ArrayList<>(Arrays.asList(arr1));
		      ArrayList<String> list2=new ArrayList<>();
		      list2=list1;
		      System.out.println(list1);
		      System.out.println(list2);
		      int count=0;
		      //Collections.reverse(list1);
		      for(String str:list1){
		        if (count%2==0) {
		        	StringBuffer sb=new StringBuffer(str);
			        String s2=sb.reverse().toString();
			        list1.set(count,s2);
		        }
		        
		        count++;
		        
		      }
		      
		      System.out.println(list1);
		      String s3=String.join(" ",list1);
		      System.out.println(s3);
		      
		      
//		      String s1="You Shall not pass";
//		      String s2[]=s1.split(" ");
//		      String result="";
//		      for (int i=s2.length-1;i>=0;i--)
//		      {
//		    	  result+=s2[i]+" ";
//		      }
//		      System.out.println(result);
		      }
		  }


	


