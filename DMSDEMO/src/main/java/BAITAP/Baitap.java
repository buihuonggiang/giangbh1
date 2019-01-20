package BAITAP;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.Math;

import org.junit.Assert;
import org.junit.Test; 

public class Baitap {
	public static String giaiptb2(int a ,int b ,int c) {
		;
		// TODO Auto-generated method stub
		int d = b*b - 4*a*c;
		double x1,x2;
		 if (d<0) {
			return "Phương trình vô nghiệm";
		}else if (d==0) {
			x1 = -b/2*a;
			x2 = -b/2*a;
			return "Phương trình có nghiệm kép x1 = x2 = "+ x1;
		}else {
			x1 = (-b + Math.sqrt(b))/2*a;
			x2 = (-b - Math.sqrt(b))/2*a;
			return "Phương trình có nghiệm kép x1 = "+x1 + "x2 = "+ x2;
		}
	}
	//	Bài 01: Tạo method kiểm tra một số truyền vào có phải là số nguyên tố hay không?
	public static boolean ktsonguyento(int n) {
		int d =0;
		boolean kq;
		for (int i = 1; i <= n; i++) {
			if (n%i==0) d++;
		}
		if (d==2) kq = true; 			//la so nguyen to
		else kq = false;				//Khong la so nguyen to
		System.out.println(kq);
		return kq;
	}

	//Bài 02: Sử dụng method được tạo ra từ bài 01 liệt kê tất cả các số nguyên tố từ 01-100.
	public static int tongsonguyento() {
		int t= 0;
		for (int i = 1; i <= 100; i++) {
			if (ktsonguyento(i) == true) t+=i;
		}
		System.out.println(t);
		return t;
	}
	//Bài 03: Đếm xem có bao nhiêu số nguyê tố từ 01 đến 100 là số chẵn, số lẻ
	//cach 1. Tim so nguyen to chan le sau do cong lai
	public static int ktsonguyentochanle(int n) {
		int d = 0;
		int kq;
		for (int i = 1; i <= n; i++) {
			if (n%i==0) d++;
		}
		if (d==2) 
		{if (n%2==0) kq = 1 ;//so chan
		else kq = 2; //so le
		}
		else kq = 3 ; //khong la so nguyen to
		System.out.println(kq);
		return kq;
	}
	public static String demsonguyentochanle() {
	int sc= 0, sl=0;
		for (int i = 1; i <= 100; i++) {
			if (ktsonguyentochanle(i) == 1) sc++;
			if (ktsonguyentochanle(i) == 2) sl++;
		}
		System.out.println("So chan: "+sc+" So le: "+sl);
		return "So chan: "+sc+" So le: "+sl;
	}
	//cach 2: Duyet so chan le sau do kiem tra la so nguyen to
	public static String demsonguyentochanle1() {
	int sc= 0, sl=0;
		//duyet so le
		for (int i = 1; i <= 100; i+=2) {
			if (ktsonguyento(i) == true) sl++;
			if (ktsonguyento(i+1) == true) sc++;
		}
		System.out.println("So chan: "+sc+" So le: "+sl);
		return "So chan: "+sc+" So le: "+sl;
	}
	//@Test
	public static void main(String[] args) {
	}

}
