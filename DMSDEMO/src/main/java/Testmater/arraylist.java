package Testmater;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class arraylist {
	Random rad = new Random();
	
	public void imputarraylist(ArrayList<Integer> arrlistnumber) {
		arrlistnumber = new ArrayList<Integer>();
		for (int i = 0; i < arrlistnumber.size(); i++) {
			arrlistnumber.add(rad.nextInt(10));
			System.out.println(arrlistnumber.get(i));
		}	
		}
	
	public void printarraylist() {
	// prinr arraylist
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
	//arrlistnumber.add(10);
	//arrlistnumber.add(20);
	//arrlistnumber.add(30);
	imputarraylist(arrlist);
/*	for (Integer number:arrlistnumber) {
		System.out.println(number);
	}*/

	for (int i = 0; i < arrlist.size(); i++) {
		System.out.println(arrlist.get(i));
	}

}
}
