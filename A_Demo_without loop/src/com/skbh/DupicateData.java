package com.skbh;

import java.util.TreeSet;

public class DupicateData {
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public void test(){
		System.out.println("test");
	}
	public static TreeSet<Integer> getData(int [] a,int [] a2){
		TreeSet<Integer> set=new TreeSet<Integer>();
		for(int local : a){
		set.add(local);
		}
		for(int local : a2){
			set.add(local);
			}
		
		return set;
	}

	public static void main(String[] args) {
		int[] a1={1,2,3,5,6,8,9};
		int [] a2={1,2,9,7,5};
		TreeSet<Integer> ts=DupicateData.getData(a1, a2);
		DupicateData d1=new DupicateData();
		d1.test();try {
			d1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Unique Data :");
		System.out.println(ts);
	
		System.out.print("Duplicate Data :");
		for(int local : a1){
			for(int local1 : a2){
				if(local==local1){
					System.out.print(local + " ");
					}
			}
			
		}
		
	}

}
