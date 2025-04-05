package rankC;

import java.util.Scanner;

public class C148 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		・1 行目に戦闘回数の N と、最初のあなたのレベル L が与えられます。
//		・続く N 行の各行には i 番目 (1 ≦ i ≦ N) の戦闘相手のレベルが x_i であるという情報が与えられます。
//		・入力は合計で N+1 行からなり、入力値最終行の末尾に改行が 1 つ入ります。
//		レベル出力
//		・1 ≦ N ≦ 100,000
//		・1 ≦ L ≦ 10,000
//		・1 ≦ x_i ≦ 10,000 (1 ≦ i ≦ N)
		Scanner sc = new Scanner(System.in);
		
		try {
			// 戦闘回数と初期レベル取得
			String setting[] = sc.nextLine().trim().split("\\s+");
			
			int battleCounts = Integer.parseInt(setting[0]); // 戦闘回数
			int ownLevel = Integer.parseInt(setting[1]); //自身の初期レベル
			
			if ( battleCounts < 1 || battleCounts > 100000) {
				System.out.println("戦闘回数は1以上100000以下で入力");
				return;
			}
			if ( ownLevel < 1 || ownLevel > 10000 ) {
				System.out.println("初期レベルは1以上10000以下で入力");
				return;
			}
			System.out.println("battleCounts :" + battleCounts);
			int[] enemyLevel = new int[battleCounts]; //N回の戦闘 敵のレベルを格納する
			for (int i = 0; i < enemyLevel.length; i++) {
				enemyLevel[i] = sc.nextInt();
			}
			if(enemyLevel.length < 1 || enemyLevel.length > battleCounts) {
				System.out.println("指定した戦闘回数分の数値を入力してください");
				System.out.println(enemyLevel.length);
				return;
			}

			/* 
			 * 各戦闘において自身のレベルが敵のレベルに比べて高いか低いか
			 * 勝ち
			 * 	自身のレベル + Math.floor(敵のレベル / 2)
			 * 負け
			 *  自身のレベル / 2 
			 */
			for (int i = 0; i < battleCounts; i++) {
				int levelChanges = (int) Math.floor(enemyLevel[i] / 2);
				if (ownLevel < enemyLevel[i]) {
					ownLevel = (int) Math.floor(ownLevel / 2);
					System.out.println("敗北" +ownLevel);
				} else if (ownLevel > enemyLevel[i]) {
					ownLevel = ownLevel + levelChanges;
					System.out.println("勝利" +ownLevel);
				} else {
					System.out.println("引き分けの場合レベル変動なし");
				}
			}
			System.out.println(ownLevel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
