package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C125 {
// １件のみの入力値でエラー
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		・2 ≦ N ≦ 10 　				→カードの枚数
//		・-5 ≦ c_i ≦ 5 (1 ≦ i ≦ N) 	→カードの値
//		・1枚は-1,１枚は+1したあと、すべてのカードの値をかけ合わせた値の最大値
//		N
//		c_1 c_2 ... c_N

		try {
			// カード枚数取得
			String line1 = sc.nextLine();
			int numberOfCards = Integer.parseInt(line1);
			if (numberOfCards < 2 || numberOfCards > 10) {
				System.out.println("カードの枚数は2枚以上、10枚以下です。");
			}
			// 2行目の入力値検査
			String[] line2 = sc.nextLine().trim().split("\\s+");
			if (line2.length < 1 || line2.length != numberOfCards) {
				System.out.println("カードの値の指定枚数に過不足があります。");
				return;
			}
			
			// カードの値取得
			List<Integer> cardValue = new ArrayList<Integer>();
			
			for (int i = 0; i < numberOfCards; i++) {
				int number = Integer.parseInt(line2[i]);
				if (number < -5 || number > 5) {
					System.out.println("カードの値は-5 ~ 5 で指定してください");
					return;
				}
				cardValue.add(number);
			}

			int maxResult = 0; //全体の積
			
			for (int i = 0; i < cardValue.size(); i++) {
				int currentPlus = cardValue.get(i) + 1;
//				System.out.println(cardValue.get(i) + " + 1 = " + currentPlus);
				for (int j = 0; j < cardValue.size(); j++) {
					if (i == j) continue;
					int currentMinus = cardValue.get(j) - 1;
//					System.out.println(cardValue.get(i) + " - 1 = " + currentMinus);

					// ±した値を再度格納するための配列
					List<Integer> modified = new ArrayList<Integer>(cardValue);
					
					modified.set(i, currentPlus);
					modified.set(j, currentMinus);
					
					int temp = 1; // 積一時格納用変数
					for (int k = 0; k < modified.size(); k++) {
						temp *= modified.get(k);
					}
					if(maxResult < temp) {
						maxResult = temp;
						
					}
				}
				
			}
			System.out.println(maxResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

}
