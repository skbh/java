package com.skbh;

import java.util.Date;

public class SplitEx {

	public static void main(String[] args) {
		String string="sushil_k$u*ma(r@ho_+tmail.com";
		for(String i:string.split("[_()$*+@.]")){
			System.out.print(i + " ");
			
		}
		
		StringBuffer sb=new StringBuffer("sushil");
		StringBuffer sb1=new StringBuffer("sushil");
		if(sb.toString().equals(sb1.toString()))
			System.out.println("same");
				else
		System.out.println("not same");
		
		Date date=new Date(1000000000000L);
		System.out.println(date.toString());
		

	}

}
