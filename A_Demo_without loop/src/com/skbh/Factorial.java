package com.skbh;


import java.util.ArrayList;

import java.util.Collections;


public class Factorial {
	
	public static long store=1;
	public static long fac(int i){
		if(i>1){
			store=store*i--;
			fac(i);
		}
		return store; 	
	}
	public static void main(String[] args) {
		System.out.println(fac(6));
		int [] array={2,1,5,1,2,3,4,3,5,6,7,8,5,6,7,0};
	    ArrayList<Integer> ar=new ArrayList<Integer>();
		for(int i:array){
			ar.add(i);
		}
		Collections.sort(ar);
		System.out.println(ar);
		
	}

}
