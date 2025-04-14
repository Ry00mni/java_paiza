package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C159 {
//	C159:当選通知
//	N K　当選番号の数を表す整数 N と 投票の数を表す整数 K 
//	w_1 w_2 ... w_N　i (1 ≦ i ≦ N) 個目の当選番号が合計で N 個
//	v_1 v_2 ... v_K　k (1 ≦ k ≦ K) 個目に投票番号が合計で K 個
//	・1 ≦ N ≦ 10
//	・1 ≦ K ≦ 10,000
//	・0 ≦ w_i, v_k ≦ 9,999 (1 ≦ i ≦ N, 1 ≦ k ≦ K)
	
//	当選した投票の ID を小さい番号から順に改行区切りですべて出力
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int winningNumCount = isValidRange(sc, 1, 10, "当選番号の数");
			int voteCounts = isValidRange(sc, 1, 10000, "投票回数");
			
			List<Integer> winningNum = new ArrayList<Integer>();
			List<Integer> voteNum = new ArrayList<Integer>();
			
			for (int i = 0; i < winningNumCount; i++) {
				int line1 = isValidRange(sc, 0, 9999, "当選番号");
				winningNum.add(line1);
			}
			sc.nextLine();
			
			for (int i = 0; i < voteCounts; i++) {
				int line2 = isValidRange(sc, 0, 9999, "投票番号");
				voteNum.add(line2);
			}
			
			boolean isWin = false; 
			for (int i = 0; i < voteCounts; i++) {
				if (winningNum.contains(voteNum.get(i))) {
					isWin = true;
					System.out.println(i + 1);
				}
			}
			
			if (!isWin) System.out.println("-1");
				
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
