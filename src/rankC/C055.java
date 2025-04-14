package rankC;

import java.util.Scanner;

public class C055 {
//	N　文字列の数 N 
//	G　抽出する対象の重要な文字列 G
//	S_1
//	...
//	S_N
//	与えられたログに対して、上から順に重要な文字列が含まれているログを出力してください。
//	重要な文字列が含まれていない場合は "None" と出力してください。
//	・1 ≦ N ≦ 100
//	・1 ≦ (G の長さ) ≦ 100
//	・G は半角英小文字のみで構成されている。
//	・各 i (1 ≦ i ≦ N) に対し
//	　・1 ≦ (S_i の長さ) ≦ 100
//	　・S_i は半角英小文字のみで構成されている。
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int stringLines = isValidRange(sc, 1, 100, "文字列の数");
			sc.nextLine();
			
			String targetWord = sc.nextLine();
			if (targetWord.length() < 1 || targetWord.length() > 100) {
				return;
			}
			
			boolean foundFlag = false;
			
			for (int i = 0; i < stringLines; i++) {
				String log = sc.nextLine();
				if (log.contains(targetWord)) {
					foundFlag = true;
					System.out.println(log);
				}
			}
			
			if (!foundFlag) System.out.println("None");		
		
			
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
