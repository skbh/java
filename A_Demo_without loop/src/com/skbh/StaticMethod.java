/*
 * @Programmer sushil kumar bhaskar JSR 1.0 skbh 
 * @Auther ${Programmer_Name}
 * @Project Name without loop
 * @File Name StaticMethod.java
 * 
 */
package com.skbh;

public class StaticMethod {
	static int x = 90;
	int p = 890;

	@SuppressWarnings("finally")
	public static int test() {

		try {
			System.out.println(x / 2);
		} catch (ArithmeticException e) {
			return 2;

		} finally {
			return 1;
		}

	}

	public static void main(String[] args) {

		StaticMethod st = new StaticMethod();

	}
}
