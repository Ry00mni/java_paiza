package rankC;

import java.util.Scanner;

public class C013 {
//	C013:嫌いな数字
//	n #嫌いな数字
//	m #病室の総数
//	r_1 #1個目の部屋番号
//	r_2 #2個目の部屋番号
//	...
//	r_m #m個目の部屋番号
//	希望する病室をそれぞれ1行に、入力された順番を崩すことなくすべて出力してください。
//
//	もし希望する部屋が1つもなければ"none" と出力してください。
//	0 ≦ n ≦ 9
//	1 ≦ m ≦ 100
//	1 ≦ r_i ≦ 1000
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int cursedNum = isValidRange(sc, 0, 9, "嫌いな数字");
			int roomCount = isValidRange(sc, 1, 100, "病室数");
			
			int[] roomArr = new int[roomCount];
			for (int i = 0; i < roomCount; i++) {
				int roomNum = isValidRange(sc, 1, 1000, "部屋番号");
				roomArr[i] = roomNum;
			}
			
			int noneCount = 0;
			for (int i : roomArr) {
				int temp = i;
				boolean hasCursedNum = false;
				
				while (i > 0) {
					int digit = i % 10;
					if (digit == cursedNum) {
						hasCursedNum = true;
						break;
					}
					i /= 10;
				}
				if (!hasCursedNum) {
					System.out.println(temp);
				} else {
					noneCount ++;
				}
			}
			
			if (noneCount == roomCount) {
				System.out.println("none");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	private static int isValidRange(Scanner sc, int min, int max, String label) {
		int value = sc.nextInt();
		if (value < min || value > max) {
	        System.out.printf("%sは%d以上、%d以下でなければなりません。\n", label, min, max);
	        System.exit(1); //プログラム自体の終了 メソッドを終了させたければreturnにする
		}
		return value;
	}
}
