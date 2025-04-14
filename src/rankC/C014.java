package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C014 {
//	C014:ボールが入る箱
//	n r　　　#箱の数n, ボールの半径r 表す整数
//	h_1 w_1 d_1　　　#1個目の箱の高さ、幅、奥行きを表す整数
//	h_2 w_2 d_2　　　#2個目の箱の高さ、幅、奥行きを表す整数
//	...
//	h_n w_n d_n　　　#n個目の箱の高さ、幅、奥行きを表す整数
//	・ 1 ≦ n ≦ 100
//	・ 1 ≦ r ≦ 100
//	・ 1 ≦ h_i, w_i, d_i ≦ 200
//	ボールを収納することができる箱の番号を昇順にすべて、改行区切りで出力
	
//	4 2
//	6 6 6
//	4 6 4
//	6 1 1
//	4 4 4
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String[] firstline = sc.nextLine().trim().split("\\s+");
			int boxCounts = Integer.parseInt(firstline[0]);
			int radius = Integer.parseInt(firstline[1]);
			if (boxCounts < 1 || boxCounts > 100) {
				System.out.println("箱の数は1~100で入力");
				return;
			}
			
			if (radius < 1 || radius > 100) {
				System.out.println("半径は1以上100以下で入力");
				return;
			}
//			int boxCounts = readIntInRange(sc,1,100,"箱の数");
//			int radius = readIntInRange(sc,1,100,"半径");
			
			// ボールが格納できる箱の番号を格納
			List<Integer> boxID = new ArrayList<Integer>();
			
			// 1行ごとに箱にボールが入るか長さ確認
			for (int i = 0; i < boxCounts; i++) {
				//長さ情報を読み込み配列へ
				String[] boxLength = sc.nextLine().trim().split("\\s+");
				
				boolean	isStored = true;
				for (String string : boxLength) {
//					System.out.println(string);
					int length = Integer.parseInt(string);
					if (length < 1 || length > 200) {
						System.out.println("各辺の長さは1~200で入力");
						break;
					}
					
					if (length < radius * 2 ) {
						isStored = false;
					} 
				}
				if (isStored) {
					boxID.add(i+1);
				}
			}
			for (Integer integer : boxID) {
				System.out.println(integer);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
}
