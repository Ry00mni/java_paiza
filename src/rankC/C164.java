package rankC;

import java.util.Scanner;

public class C164 {
//	C164:並び替えの検証
//	N
//	A_1 A_2 A_3 ... A_N
//	Q
//	L_1 R_1
//	L_2 R_2
//	...
//	L_Q R_Q
//	・1 行目に配列の長さを表す整数 N が与えられます。
//	・2 行目に配列の各要素を表す整数 A_i (1 ≦ i ≦ N) が半角スペース区切りで与えられます。
//	・3 行目に入れ替えの回数を表す整数 Q が与えられます。
//	・続く Q 行のうち k (1 ≦ k ≦ Q) 行目には、k 回目に入れ替える要素の位置を表す整数 L_k, R_k が半角スペース区切りで与えられます。
//	・入力は Q+3 行からなり、末尾に改行が 1 つ入ります。
//	配列の内容が昇順となっている場合は "Yes" を、そうでない場合は "No" を出力
//	・2 ≦ N ≦ 10)
//	・1 ≦ A_i ≦ 100)
//	・1 ≦ Q ≦ 100)
//	・1 ≦ L_k < R_k ≦ N (1 ≦ k ≦ Q)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int len = isValidRange(sc, 2, 10, "配列の長さ");
			//配列の取得
			int[] numArr = new int[len];
			for (int i = 0; i < numArr.length; i++) {
				numArr[i] = isValidRange(sc, 1, 100, "配列の要素");
			}
			//並べ替え回数取得
			int sortCount = isValidRange(sc, 1, 100, "並べ替え回数");
			
			for (int i = 0; i < sortCount; i++) {
				int L = isValidRange(sc, 1, 100, "動かす左側の番号指定");
				int R = isValidRange(sc, 1, 100, "動かす右側の番号指定");
				if (R <= L) {
					continue;
				}
				
				int numR = R - 1;
				int numL = L - 1;
				
				int temp = numArr[numR];
				numArr[numR] = numArr[numL];
				numArr[numL] = temp;
//				for (int j : numArr) {
//					System.out.print(j + " ");
//				}
			}
			boolean isAscend = true;
			for (int i = 0; i < numArr.length - 1; i++) {
				if (numArr[i] > numArr[i + 1]) {
					isAscend = false;
				}
			}
		
			if (isAscend) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
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
