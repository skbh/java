package com.skbh;

public class StringSearch {
	
	public static int check(char[] array,char s){
		int count=0;
		for(int i=0;i<array.length;i++)
			if(array[i]==s)	count++;
						
		if(count>1)		return 1;		else			return 0;
	}

	public static void search(String arg){
		char[] array=arg.toCharArray();
		System.out.println(arg);
		
		for(int i=0;i<array.length;i++){
			if(check(array,array[i])==0){
				System.out.print(array[i]);
			}
		}

		
	}			
	
	
	public static void main(String[] args) {
		StringSearch.search("ABCD ABCD XYZ ABCPpP");
		
	}	

	
}

/*
 LinkedHashSet<Character> hashset=new LinkedHashSet<Character>();
		char[] array=arg.toCharArray();
		
	for(int i=0;i<array.length;i++){
		hashset.add(array[i]);
	}
	System.out.println(hashset);
 */
