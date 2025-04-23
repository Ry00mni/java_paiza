package rankC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C120 {
//	C120:花のリース
//	N
//	S_1
//	S_2
//	・1 行目には、リースを構成する花の数を表す整数 N が与えられます。
//	・2 行目には、1 つめのリースの状態を表す文字列 S_1 が与えられます。S_1 は英字小文字からなり、それぞれの文字が花の種類に対応します。同じ種類の文字の場合は同じ種類の花であることを表します。
//	・3 行目には、2 つめのリースの状態を表す文字列 S_2 が与えられます。S_1 と同様に、英字小文字からなります。
//	・入力は合計で 3 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//	1 つ目のリースと 2 つ目のリースが同じ種類である場合は "Yes" を、そうでなければ "No" を出力してください。
//	・1 ≦ N ≦ 1,000
//	・(S_1 の長さ) = (S_2 の長さ) = N
//	・S_1, S_2 は英字小文字からなる
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int flowerCount = isValidRange(sc, 1, 1000, "花の数");
			sc.nextLine(); // 文字列行を読み込むため改行
			
			String line1 = sc.nextLine().trim();
			String line2 = sc.nextLine().trim();
			if (line1.length() != flowerCount || line2.length() != flowerCount || line1.length() != line2.length() ) {
				System.out.println("不正入力値");
				return;
			}
			// リースAの並び順を取得
			List<Character> AWreath = new ArrayList<>();
			for (int i = 0; i < line1.length(); i++) {
				AWreath.add(line1.charAt(i));
			}
			// リースBの並び順を取得
			List<Character> BWreath = new ArrayList<>();
			for (int i = 0; i < line2.length(); i++) {
				BWreath.add(line2.charAt(i));
			}
			
			boolean isSame = false;
			for (int i = 0; i <= line2.length(); i++) {
				if (AWreath.equals(BWreath)) {
					isSame = true;
					break;
				}
				Collections.rotate(BWreath, 1);
			}
			if (isSame) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
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
