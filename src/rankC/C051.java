package rankC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C051 {
//	C051:カード並べ
//	a b c d
//	・a, b, c, d はそれぞれ 4 枚のカードに書かれた数を表し、半角スペース区切りで与えられます。
//	・1 ≦ a, b, c, d ≦ 9
//	左から 2 枚のカード、右から 2 枚のカードをそれぞれ 2 ケタの整数とみなし、和を計算します。
//	あらゆる並べ方を試し、和の最大値（最大スコア）を出力
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Integer> cardNum = new ArrayList<Integer>();
			
			for (int i = 0; i < 4; i++) {
				cardNum.add(isValidRange(sc, 1, 9, "カードの番号"));
			}
			
			int maxSum = 0;
			
			for (int i = 0; i < cardNum.size(); i++) {
				for (int j = i + 1; j < cardNum.size(); j++) {
					// 左の数字確定
					List<Integer> left = Arrays.asList(cardNum.get(i), cardNum.get(j));
					// 右の数字取得用配列
					List<Integer> right = new ArrayList<Integer>();
					
					// 左の数字以外をright格納
					for (int k = 0; k < cardNum.size(); k++) {
						if (k != i && k != j) {
							right.add(cardNum.get(k));
						}
					}
					// 左右の数字取得
					int leftNum = Math.max(left.get(0),left.get(1)) * 10 + Math.min(left.get(0),left.get(1));
					int rightNum = Math.max(right.get(0),right.get(1)) * 10 + Math.min(right.get(0),right.get(1));
					
					int sum = leftNum + rightNum;
					System.out.println(leftNum + " + " + rightNum);
					
					maxSum = Math.max(maxSum, sum); //最大値を保持
				}
				
			}
				
			System.out.println(maxSum);
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
