package rankC;

import java.util.Scanner;

public class C017 {
//	C017:ハイアンドロー・カードゲーム
//	2枚のカードの強弱関係は、次のルールによって決まります。
//	・1つ目の番号が大きいカードのほうが強い
//	・1つ目の番号が同じ場合、2つ目の番号が小さいカードのほうが強い
//	a b　 親カード1, 2
//	n   　勝負回数
//	A_1 B_1 子カード1,2
//	…
//	A_n B_n
//	出力の i 行目では、親カードと子カード i の強弱関係を調べたときに
//	親カードの方が強いならば "High"、そうでなければ "Low" と出力
//	・1 ≦ a, A_i ≦ 10
//	・1 ≦ b, B_i ≦ 4
//	・1 ≦ n < 40
//	5 1
//	2
//	7 2
//	1 4 
//	↓
//	Low
//	High
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int parentFirstNum = sc.nextInt();
			int parentSecondNum = sc.nextInt();
			// 親カード値チェック
			if (!isValidNumber(parentFirstNum, parentSecondNum)) return;
			
			int matchCounts = sc.nextInt();
			sc.nextLine();
			
			if (matchCounts < 1 || matchCounts > 40) {
				System.out.println("試合回数は1以上40まで");
				return;
			}
			for (int i = 0; i < matchCounts; i++) {
				int childFirstNum = sc.nextInt();
				int childSecondNum = sc.nextInt();
				//子カード値チェック
				if (!isValidNumber(childFirstNum,childSecondNum)) return;
				String result = judgement(parentFirstNum, parentSecondNum, childFirstNum, childSecondNum);
				System.out.println(result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	// 勝敗判定ロジック
	public static String judgement(int pf, int ps, int cf, int cs) {
		// 1枚目の勝敗判定
		if (cf < pf) {  //親の数字が大きい
			return "High";
		} else if ( pf < cf ) {
			return "Low"; // この数字が大きい
		} else { // 引き分け cf == pf の時
			if (ps < cs) {
				return "High";
			} else {
				return "Low";
			}
		}
	}
	// 入力値バリデーション
	public static boolean isValidNumber(int fn, int sn) {
		if (fn < 1 || fn > 10) {
			System.out.println("1枚目は1~10まで");
			return false;
		}
		if (sn < 1 || sn > 4) {
			System.out.println("2枚目は1~4まで");
			return false;
		}
		return true;
	}

}
