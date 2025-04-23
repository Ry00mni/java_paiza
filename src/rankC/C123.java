package rankC;

import java.util.Scanner;

public class C123 {
//	C123:節分ロボット
//	N
//	Y_1
//	Y_2
//	...
//	Y_N
//	M
//	A_1 B_1 C_1
//	A_2 B_2 C_2
//	...
//	A_M B_M C_M
//	・1 行目には、参加者の人数を表す整数 N が与えられます。
//	・続く N 行のうち、 i 行目 (1 ≦ i ≦ N) には、i 番目の参加者の年齢を表す整数 Y_i が与えられます。
//	・その次の行 (N + 2 行目) には、命令の数を表す整数 M が与えられます。
//	・続く M 行のうち、i 行目 (1 ≦ i ≦ M) には、i 番目の命令を表す整数 A_i, B_i, C_i が与えられます。これは、A_i 番目から B_i 番目の参加者に C_i 個の豆を配るということを意味しています。
//	全ての命令が実行された後、それぞれの参加者が持っている豆の数を以下の形式で出力してください。
//	D_1
//	D_2
//	...
//	D_N
//	・1 ≦ N ≦ 1,000
//	・1 ≦ Y_i ≦ 100 (1 ≦ i ≦ N)
//	・1 ≦ M ≦ 100
//	・1 ≦ A_i ≦ B_i ≦ N (1 ≦ i ≦ M)
//	・1 ≦ C_i ≦ 100 (1 ≦ i ≦ M)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 参加人数取得
			int participants = isValidRange(sc, 1, 1000, "参加者");
			
			// 参加者の年齢取得
			int[] ageArr = new int[participants];
			for (int i = 0; i < participants; i++) {
				ageArr[i] = isValidRange(sc, 1, 100, "年齢");
			}
			//命令の数取得
			int orderCounts = isValidRange(sc, 1, 100, "命令の数");
			
			// 豆配り
			int[] howManyBeans = new int[participants];
			for (int i = 0; i < orderCounts; i++) {
				// 配り始めと終わりは参加者の年齢のインデックスに対応しているため、-1
				int start = isValidRange(sc, 1, participants, "配り始め") - 1; 
				int end = isValidRange(sc, 1, participants, "配り終わり") -1;
				int beanCounts = isValidRange(sc, 1, 100, "豆の数");
				for (int j = start; j <= end; j++) {
					howManyBeans[j] += beanCounts;
					// 上限超えていたら年齢と同じ数に調整
					if (ageArr[j] < howManyBeans[j]) {
						howManyBeans[j] = ageArr[j];
					}
				}
			}
			
			for (int i : howManyBeans) {
				System.out.println(i);
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
