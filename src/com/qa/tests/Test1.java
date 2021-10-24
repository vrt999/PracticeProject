package com.qa.tests;

public class Test1 {

	public static void main(String[] args) {

		String s1 = "553355541665522";		
		int j=0;		
		int count =1;
//		while(j<s1.length()-2)	{
		for(j=0;j<s1.length()-2;j++)	{
		while(s1.charAt(j) == s1.charAt(j+1)) {
			count++;
			j++;
		}
		System.out.print(s1.charAt(j) + "-" + count + " ");
		count=1;
		}
		System.out.print(s1.charAt(j) + "-" + count);

	}
	}