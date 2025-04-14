package rankC;

import java.util.Scanner;

public class C089 {
//	C089:ストラックアウト
//	H W  高さ、幅を表す整数 H, W
//	s_1
//	s_2
//	...
//	s_H
//	p_{1,1} p_{1,2} ... p_{1,W}
//	p_{2,1} p_{2,2} ... p_{2,W}
//	...
//	p_{H,1} p_{H,2} ... p_{H,W}  "o" および "x" からなる長さ W の文字列 s_i 
//	・1 ≦ H ≦ 100
//	・1 ≦ W ≦ 100
//	・s_{i, j} は半角英字小文字で "o", "x"のいずれか (1 ≦ i ≦ H, 1 ≦ j ≦ W)
//	・1 ≦ p_{i, j} ≦ 100 (1 ≦ i ≦ H, 1 ≦ j ≦ W)
//	4 3
//	oxo
//	oox
//	oxo
//	xxx
//	1 2 3
//	4 5 6
//	7 8 9
//	10 11 12
//	29
	public static void main(String[] args) {
    	try (Scanner sc = new Scanner(System.in)) {
    		int hight = sc.nextInt();
    		int width = sc.nextInt();
    		if (!isValidRange(hight) || !isValidRange(width)) return;
    		sc.nextLine();
    		
    		String[][] state = new String[hight][width];
    		int[][] points = new int[hight][width];
    		
    		for (int i = 0; i < hight; i++) {
    			// 新規結果を読み込む
    			String line = sc.nextLine();
    			for (int j = 0; j < width; j++) {
    				// i行目の結果を1文字ずつ分解してj番目の結果を格納
					state[i][j] = String.valueOf(line.charAt(j));
				}
			}
    		
    		for (int i = 0; i < hight; i++) {
				for (int j = 0; j < width; j++) {
					//　淡々と数値を取得するのみ
					points[i][j] = sc.nextInt();
				}
			}
    		
    		int result = 0; // 合計点カウンター
    		for (int i = 0; i < points.length; i++) {
    			for (int j = 0; j < width; j++) {
					if (state[i][j].equals("o")) {
						result += points[i][j];
					}
				}
			}
    		System.out.println(result);
    		

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	private static boolean isValidRange(int num) {
		if (num < 1 || num > 100) {
			System.out.println("高さ、幅は1~100");
			return false;
		}
		return true;
	}

}
