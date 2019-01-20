package Testmater;

import java.util.Random;

import org.omg.CORBA.PUBLIC_MEMBER;

public class array1 {
Random rad = new Random();
//cach 1
public void printarr() {
	System.out.println("array");
	int arrnumber[] = new int[10];
/*	
	for (int number:arrnumber)
		{
		System.out.println(number);
		};*/
	//bai tap
	int demchan =0;
	int demle =0;
	for (int i = 0; i < arrnumber.length; i++) {
		arrnumber[i] = rad.nextInt(10);
		System.out.println("pt "+i+": "+arrnumber[i]);
		if (arrnumber[i]%2 == 0) demchan ++;
		if (arrnumber[i]%2 > 0) demle ++;
	}
	System.out.println("dem chan "+demchan);
	System.out.println("dem le "+demle);
}

//cach 2
public void imputarr(int[] arr) {

	arr = new int[10];
	for (int i = 0; i < arr.length; i++) {
		arr[i] = rad.nextInt(10);
		System.out.println("pt "+i+": "+arr[i]);
	}
}

public void ktrachanle() {
	int demchan =0;
	int demle =0;
	int[] arr = new int[10];
	imputarr(arr);
	for (int i:arr) {
		if (arr[i]%2 == 0) demchan ++;
		if (arr[i]%2 > 0) demle ++;
	}
	System.out.println("dem chan "+demchan);
	System.out.println("dem le "+demle);
}
}
