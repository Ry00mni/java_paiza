package rankC;

import java.util.Scanner;

public class C163 {
//	C163:ころころどんぐり
//	N
//	h_1 h_2 ... h_N
//	・1 行目に坂道の数を表す整数 N が与えられます。
//	・2 行目に i (1 ≦ i ≦ N) 個目の坂道の高さを表す整数 h_i (1 ≦ i ≦ N) が半角スペース区切りで与えられます。
//	池に落ちるなら YES を落ちないなら NO を一行に出力してください。
//	・1 ≦ N ≦ 100
//	・-100 ≦ h_i ≦ 100 (1 ≦ i ≦ N)
//	・h_i ≦ 0 (1 ≦ i ≦ N) のとき下り坂、h_i > 0 (1 ≦ i ≦ N) のとき上り坂
//	・i (1 ≦ i ≦ N) が奇数のとき h_i ≦ 0 、偶数のとき h_i (1 ≦ i ≦ N) > 0 
//	→下りと上りを繰り返す
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int sloopCounts = isValidRange(sc, 1, 100, "坂の数");
			
			// 坂を登る余力
			int stock = 0;
			for (int i = 1; i <= sloopCounts; i++) {
				// 奇数番目は下り坂処理
				if (i % 2 != 0) {
					int down = Math.abs(isValidRange(sc, -100, 0, "下り坂"));
					stock += down;
				} else {
					int up = sc.nextInt();
					if (up < 0) {
						return;
					}
					stock -= up;
				}
				
				if (stock < 0) {
					System.out.println("NO");
					return;
				}
			}
			if (stock > 0) {
				System.out.println("YES");
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
