package rankC;

import java.util.Scanner;
//・E は半角記号 "<", "/", "+" で構成される
//・3 ≦ (E の長さ) ≦ 100
// "/" = 1 ,"//" = 2
// "<" = 10, "<<" = 20
public class C039 {
//	C039:古代の数式
	public static void main(String[] args) {
		try  (Scanner sc = new Scanner(System.in)) {
			// 文字列長さチェック
			String lineCheck = sc.nextLine();
			if (lineCheck.length() < 3 || lineCheck.length() > 100) {
				System.out.println("3文字以上、100文字以内で入力してください");
				return;
			}
			
			// 数字単位で分割して配列格納
			String[] line = lineCheck.trim().split("\\+"); 
			
			int result = 0; //結果格納用
			
			// "+"の数だけループ
			for (int i = 0; i < line.length; i++) {
				String[] numArr = line[i].split(""); // 1文字ずつに分解
				int identifiedNum = identifyNum(numArr); //メソッドで文字列を値に変換
				// 生成された値チェック
				if (identifiedNum == -1) {
					System.out.println("不正な数値が入力されています。");
					return;
				}
				result += identifiedNum;
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	
	// 文字列を数値に変換する
	public static int identifyNum(String[] num) {
		int onesPlaceCounter = 0; 
		int tensPlaceCounter = 0;
		for (int i = 0; i < num.length; i++) {
			if ("<".equals(num[i])) {
				tensPlaceCounter ++;
			}
			if ("/".equals(num[i])) {
				onesPlaceCounter ++;
			}
		}
		int identifiedNum = 10 * tensPlaceCounter + onesPlaceCounter;
		// 生成された値の検査
		if (identifiedNum < 1 || identifiedNum > 99){
		 return -1;
		}
		
		System.out.println("10の位" + 10 * tensPlaceCounter);
		System.out.println("1の位" + onesPlaceCounter);
		System.out.println("数字解析結果 :");
		System.out.println(10 * tensPlaceCounter + onesPlaceCounter);
		return identifiedNum;
	}
}
