package in.skbh.exe;

public class Reflection {

	public static void main(String[] args) {
		try {
			Class className = Class.forName("in.skbh.exe.SingletonConnection");
			SingletonConnection interfaceType = (SingletonConnection) className.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
