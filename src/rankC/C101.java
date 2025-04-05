package rankC;

import java.util.InputMismatchException;
import java.util.Scanner;

// 0~364の値の入力、文字列変換
// 0~364の中で入力した数字を含む個数を出力
public class C101 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			//入力された値検査
			int x = sc.nextInt();
			if (x < 0 || x > 364) {
				return;
			}
			
			//問題なければ文字列として受け取り
			String targetNumber = String.valueOf(x);
			
			int happyDaySum = 0;
			for (int i = 0; i <= 364; i++) {
				if (String.valueOf(i).contains(targetNumber)) {
					happyDaySum += 1;
				}
			}
			System.out.println(happyDaySum);
		} catch (InputMismatchException ime) {
			System.out.println("数値を入力してください");
			ime.printStackTrace();
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}

	}

}
