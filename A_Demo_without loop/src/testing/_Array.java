package testing;

import java.math.BigDecimal;
import java.util.Arrays;

class Robots {
	private Integer systemId;
	private String bootSystem;
	private String systemRole;

	public Robots(Integer systemId, String bootSystem, String systemRole) {
		super();
		this.systemId = systemId;
		this.bootSystem = bootSystem;
		this.systemRole = systemRole;
	}

	public Robots() {

	}

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public String getBootSystem() {
		return bootSystem;
	}

	public void setBootSystem(String bootSystem) {
		this.bootSystem = bootSystem;
	}

	public String getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}

	@Override
	public String toString() {
		return "Robots [systemId=" + systemId + ", bootSystem=" + bootSystem + ", systemRole=" + systemRole + "]";
	}

}

public class _Array {

	public static void main(String[] args) {
		int[][][] _a = { { { 10, 20, 30, 52 }, { 1, 2, 9, 10 }, { 14, 58, 69, 6, 3 } },
				{ { 10, 20, 30, 52 }, { 1, 2, 9, 10 }, { 14, 58, 69, 6, 3 } } };
		System.out.println(Arrays.deepToString(_a));

		for (int i = 0; i < _a.length; i++) {
			for (int j = 0; j < _a[i].length; j++) {
				System.out.print("[");
				for (int k = 0; k < _a[i][j].length; k++) {
					System.out.print(_a[i][j][k] + ", ");
				}
				System.out.print("]");
			}
		}
		System.out.println();
		Robots robots = new Robots(12, "sysg", "sds");
		System.out.println(robots);
		Robots robots2 = new Robots();
		robots2.setBootSystem("sys42");
		robots2.setSystemId(434);
		robots2.setSystemRole("admin");
		System.out.println(robots2);
		Integer i = new Integer(5896);
		int inti = i.intValue();
		System.out.println(inti);
		String s = "45488.33";
		Float fi = Float.valueOf(s);
		System.out.println(1.0);
		BigDecimal fif = new BigDecimal("435345");
		System.out.println(Float.valueOf("54.36"));

	}

}
