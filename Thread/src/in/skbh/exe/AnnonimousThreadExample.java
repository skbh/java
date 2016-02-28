package in.skbh.exe;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AnnonimousThreadExample {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Document doc = Jsoup.connect("https://www.google.co.in/").get();
					System.out.println("getting response #" + new Date());
					String title = doc.title();
					System.out.println(title);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Document doc = Jsoup.connect("http://skbh.in/").get();
					System.out.println("getting response #" + new Date());
					String title = doc.title();
					System.out.println(title);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
		t2.start();
		t1.start();
	}

}
