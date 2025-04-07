package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C144 {
	// じゃんけんの結果
//	N
//	A_1 B_1  手は'G', 'C', 'P'形式で与えられる 
//	A_2 B_2
//	...
//	A_N B_N
//	・1 ≦ N ≦ 100
//	・A_i, B_i は 'G', 'C', 'P' のいずれか
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			// 対戦数の取得、検査
			int numeberOfMatches = Integer.parseInt(sc.nextLine());
			if (numeberOfMatches < 1 || numeberOfMatches > 100) {
				System.out.println("試合数は1~100の範囲で入力");
				return;
			}
			
			// 両者の手を取得
			List<Character> aHands = new ArrayList<>();
			List<Character> bHands = new ArrayList<>();
			
			for(int i = 0; i < numeberOfMatches ; i++) {
				if (!sc.hasNextLine()) {
					System.out.println("手の組み合わせは指定したゲーム数と合わせてください");
					break;
				}
				// 手の入力値配列格納、検査
				String[] combination = sc.nextLine().trim().split("\\s+");
				if (combination.length != 2 || combination[0].length() != 1 || combination[1].length() != 1) {
					System.out.println("不正な入力値");
					return;
				}
				
				// char型で各プレイヤーの手を格納
				aHands.add(combination[0].charAt(0));
				bHands.add(combination[1].charAt(0));
			}
			
			int resultWin = 0; //勝ちカウンター
			for (int i = 0; i < numeberOfMatches; i++) {
//				System.out.println("A : " + aHands.get(i) + " B : " + bHands.get(i));
				char a = aHands.get(i);
				char b = bHands.get(i);
				if ((a == 'G' && b == 'C') || (a == 'C' && b == 'P') || (a == 'P' && b == 'G')) {
					resultWin ++;
				}
			}
			// 勝ち数の出力
			System.out.println(resultWin);
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}
