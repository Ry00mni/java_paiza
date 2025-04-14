package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C162 {
//	C162:パーフェクトシャッフル
//	M N カードの枚数 M と、シャッフルを行う回数 N
//	・2 ≦ M ≦ 200
//	・M は偶数
//	・1 ≦ N ≦ 200
//	出力はN回シャッフルしたあとのカードの並び順
//	解答時間： 76分25秒 バイト数： 1944 Byte スコア： 100点
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int cardsCount = readIntInRange(sc,2,200,"カード枚数");
			if (cardsCount % 2 != 0) {
				System.out.println("カードの枚数は偶数のみ有効です。");
				return;
			}
			int shuffleCount = readIntInRange(sc, 1, 200, "シャッフル回数");
			
			// カード枚数の入力値に応じた初期並び順を取得
			List<Integer> cardOrder = new ArrayList<Integer>();
			for (int i = 1; i <= cardsCount; i++) {
				cardOrder.add(i);
			}
			
			// シャッフル
			for (int i = 0; i < shuffleCount; i++) {

				List<Integer> deck1 = new ArrayList<>(); // 山札1
				List<Integer> deck2 = new ArrayList<>(); // 山札2
				
				// 山の半分(M / 2 枚目)までを山札1リストに格納
				for (int j = 0; j < cardsCount / 2; j++) {
					deck1.add(cardOrder.get(j));
//					System.out.println(deck1.get(j));
				}
//				System.out.println("残り半分");
				// 山の残り半分(M / 2 + 1枚目〜 最後)までを山札2リストに格納
				for (int k = cardsCount / 2 ; k < cardsCount; k++) {
					deck2.add(cardOrder.get(k));
				}
//				for (Integer integer : deck2) {
//					System.out.println(integer);
//				}
				//新規の並び順を格納
				List<Integer> newCardOrder = new ArrayList<Integer>();
				// 山札をそれぞれパーフェクトシャッフルし、並び順を更新
				for (int l = 0; l < deck1.size(); l++) {
					newCardOrder.add(deck2.get(l));
					newCardOrder.add(deck1.get(l));
				}
				cardOrder = newCardOrder;
			}
			
//			for (Integer integer : cardOrder) {
//				System.out.print(integer + " ");
//			}
			for (int i = 0; i < cardOrder.size(); i++) {
				System.out.print(cardOrder.get(i));
				if (i != cardOrder.size() - 1) {
					System.out.println();
				} else {
					System.out.println(" ");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	private static int readIntInRange(Scanner sc, int min, int max, String label) {
	    int value = sc.nextInt();
	    if (value < min || value > max) {
	        System.out.printf("%sは%d以上、%d以下でなければなりません。\n", label, min, max);
	        System.exit(1); //プログラム自体の終了 メソッドを終了させたければreturnにする
	    }
	    return value;
	}
}
