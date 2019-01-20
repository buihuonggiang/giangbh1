package Testmater;

import java.util.Random;

class Xulychuoi {
	public void ktten(String hoten) {
	String ho,dem,ten,kt;
	ho = hoten.substring(0, hoten.indexOf(" "));
	System.out.println("ho:"+ho);
	
	dem = hoten.substring(hoten.indexOf(" ",1), hoten.lastIndexOf(" "));
	System.out.println("dem:"+dem);
	
	String[] app = hoten.split(" ");
	ten = app[app.length - 1];
	//ten = hoten.substring(hoten.lastIndexOf(" ")+1, hoten.length());
	System.out.println("Ten:"+ten);
	//cat chuoi bat ky
	Random rad = new Random();
	String p1 = hoten.substring(rad.nextInt(hoten.length()));
	System.out.println(p1);
	}

}
