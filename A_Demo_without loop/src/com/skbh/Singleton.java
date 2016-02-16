package com.skbh;

public final class Singleton {

	private static class SingletonLoader {
		private static Singleton INSTANCE;
	}

	private Singleton() {
		if (SingletonLoader.INSTANCE != null) {
			throw new IllegalStateException("Already instantiated");
		}
	}

	public static Singleton getInstance() {
		if (SingletonLoader.INSTANCE == null) {
			synchronized (Singleton.class) {
				if (SingletonLoader.INSTANCE == null)
					SingletonLoader.INSTANCE = new Singleton();

			}

		}
		return SingletonLoader.INSTANCE;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public void test() {
		System.out.println("test done");
	}

	public static void main(String[] arg) {
		Singleton singleton = Singleton.getInstance();
		singleton.test();
	}
}
