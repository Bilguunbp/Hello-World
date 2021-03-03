package com.lab4.sw;

import java.util.Arrays;
import java.util.Scanner;
import dataStructures.HashChains;

public class MyHash extends HashChains{

	public static MyHash myhash;
	
	public MyHash(int theDivisor) {
		super(theDivisor);
	}

	public static void main(String[] args) {
		myhash = new MyHash(5);
		Scanner in = new Scanner(System.in);
		
		while(true) {
			myhash.commands();
			System.out.println();
			System.out.print("Сонголт: ");
			int sel = in.nextInt();
			myhash.display(sel);
		}
	}
	
	public void commands() {
		System.out.println("1.Хэш хүснэгт үүсгэх");
		System.out.println("2.Элементийг солих");
		System.out.println("3.Түлхүүрийг солих");
		System.out.println("4.Түлхүүр болон элемент шалгах");
		System.out.println("0.Гарах");
	}
	
	public void display(int s) {
		Scanner sc = new Scanner(System.in);
		switch(s) {
			case 1: 
				createHash();
				break;
				
			case 2: 
				System.out.println("Түлхүүр болон элементийг оруулна уу..");
				int upKey = sc.nextInt();
				int upEl = sc.nextInt();
				myhash.updateElement(upKey, upEl);
				myhash.output();
				break;
				
			case 3: 
				System.out.println("Хуучин болон шинэ түлхүүр ");
				int oldKey = sc.nextInt();
				int newKey = sc.nextInt();
				myhash.updateKey(oldKey, newKey);
				System.out.println("Шинэ түлхүүр дээрх элемент: "+myhash.get(newKey));
				myhash.output();
				break;
				
			case 4: 
				System.out.println("Түлхүүрийг оруулна уу ");
				int delKey = sc.nextInt();
				myhash.delete(delKey);
				break;
				
			case 0: 
				System.exit(0);
				break;
		}
	}
	
	public void createHash() {
		myhash.put(13, 13);
		myhash.put(2, 2);
		myhash.put(7, 7);
		myhash.put(46, 46);
		myhash.put(21, 21);
		System.out.println();
		myhash.output();
	}
	
	public Object updateElement(Object nKey, Object nEl) {  
		if(myhash.get(nKey) != null) {
			myhash.put(nKey,nEl);
		}else {
			System.out.println("Түлхүүр олдсонгүй.");
		}
		
		return myhash;       
	}  
	
	public Object updateKey(Object oKey, Object nKey) {
		Object el = myhash.get(oKey);
		myhash.remove(oKey);
		
		myhash.put(nKey, el);
		return myhash;
	}
	
	public void delete(Object dKey) {
		myhash.remove(dKey);
		myhash.output();
	}

}
