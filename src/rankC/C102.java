package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C102 {
//	C102:行きたいライブのスケジュール
//	M
//	a_1
//	a_2
//	...
//	a_M
//	N
//	b_1
//	b_2
//	...
//	b_N
//	・1 行目に A のライブ日数を表す整数 M が与えられます。
//	・続く M 行のうちの i 行目 (1 ≦ i ≦ M) には、バンド A の i 番目のライブの日を表す整数 a_i (1 ≦ a_i ≦ 31) が与えられます。
//	・続く 1 行には B のライブ日数を表す整数 N が与えられます。
//	・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には、バンド B の i 番目のライブの日を表す整数 b_i (1 ≦ b_i ≦ 31) が与えられます。
//	・入力は合計で M + 1 + N + 1 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//	・期待する出力は 31 行からなります。
//	・ 行目 (1 ≦ i ≦ 31) にはそれぞれ今月の i 日目にバンド A とバンド B のいずれのライブに行くかを表す文字列を出力してください。
//	　・バンド A のライブに行く場合は、大文字アルファベットの "A" を出力してください。
//	　・バンド B のライブに行く場合は、大文字アルファベットの "B" を出力してください。
//	　・ライブがない場合小文字アルファベットの "x" を出力してください。
//	・ 出力最終行の末尾に改行を入れ、余計な文字、空行を含んではいけません。
//	・1 ≦ M, N ≦ 31
//	・1 ≦ a_i < a_j ≦ 31 (1 ≦ i < j ≦ M)
//	・1 ≦ b_i < b_j ≦ 31 (1 ≦ i < j ≦ N)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int A = isValidRange(sc, 1, 31, "バンドAのライブ本数");
			List<Integer> scheA = new ArrayList<Integer>();
			for (int i = 0; i < A; i++) {
				scheA.add(isValidRange(sc, 1, 31, "バンドAのライブ日程"));
			}
			
			int B = isValidRange(sc, 1, 31, "バンドBのライブ本数");
			List<Integer> scheB = new ArrayList<Integer>();
			for (int i = 0; i < B; i++) {
				scheB.add(isValidRange(sc, 1, 31, "バンドBのライブ日程"));
			}
			
//			1~31日までを走査する
			int doubleBookCount = 0;
			for (int i = 1; i <= 31; i++) {
				if (scheA.contains(i) && scheB.contains(i)) {  // ダブルブッキングしている場合
					if (doubleBookCount % 2 == 0) {  			//偶数回目であればA、奇数回目であればBにいく
						doubleBookCount ++;
						System.out.println("A");
					} else {
						doubleBookCount ++;
						System.out.println("B");
					}
				} else if (scheA.contains(i)) {
					System.out.println("A");
				} else if (scheB.contains(i)) {
					System.out.println("B");
				} else {
					System.out.println("X");
				}
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
