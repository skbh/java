package skbh.in;

public class RemoveDuplicateItems {
	
	public static void main(String[] args) {

		int[] ar = new int[10];
		ar[0] = 14;
		ar[1] = 10;
		ar[2] = 12;
		ar[3] = 10;
		ar[4] = 11;
		ar[5] = 10;
		ar[6] = 11;
		ar[7] = 15;
		ar[8] = 15;
		ar[9] = 11;
		int len = ar.length;
		System.out.println("size of an Array : " + len);
		System.out.print("ALL items in an Array :");
		for (int i = 0; i < len; i++)
			System.out.print(" i=" + ar[i] + "  ");
		System.out.println();

		for (int i = 0; i <= len; i++) {

			for (int j = i + 1; j < len; j++) {
				if (ar[i] == ar[j]) {
					--len;
					for (int j2 = j; j2 < len; j2++)
						ar[j2] = ar[j2 + 1];

				}// if
				for (int p = 0; p < len; p++)
					System.out.print(" i=" + ar[p] + "  ");
				System.out.println();
				
			}// /inner loop j
		}// outer loop i
		
		System.out.print("Removed duplicate items :");
		for (int i = 0; i < len; i++)
			System.out.print(" i=" + ar[i] + "  ");

	}// end main

}// end class

