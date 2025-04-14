package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C114 {
//	C114:しりとりの判定
//	N　　　単語の数 N
//	s_1　英字小文字および、英字大文字からなる文字列 s_i 
//	s_2
//	...
//	s_N
//	成立したらYes
//	初めてしりとりが成立しなかった 2 つの連続する単語の 1 つ目の単語の末尾の文字を表す英字 x と 2 つ目の単語の先頭の文字を表す英字 y
//	でx yで出力
//	・2 ≦ N ≦ 1,000
//	・1 ≦ (s_iの長さ) ≦ 50 (1 ≦ i ≦ N)
//	・s_i は英字小文字または英字大文字からなる
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int wordCount = isValidRange(sc, 2, 1000, "単語数");
			sc.nextLine();
			
			List<String> words = new ArrayList<String>();
			
			for (int i = 0; i < wordCount; i++) {
				words.add(sc.nextLine());
				int stLength = words.get(i).length();
				if (stLength < 1 || stLength > 50 ) {
					return;
				}
			}
			
			boolean isFormed = true;
			for (int j = 0; j < wordCount - 1; j++) {
				if (isFormed) {
					String[] A = (words.get(j)).split(""); 
					String[] B = (words.get(j + 1)).split(""); 
					
					String lastLetter = A[A.length - 1]; // Aのしりの文字
					String firstLetter = B[0];       // Bの先頭文字
					if (!lastLetter.equals(firstLetter)) {
						System.out.println(lastLetter + " " + firstLetter);
						isFormed = false;
					} 
				}
			}
			if (isFormed) System.out.println("Yes");			
			
			
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
