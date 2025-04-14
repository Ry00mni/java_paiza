package rankC;

import java.util.Scanner;

public class C075 {
//	C075:ポイント払い
//	N M はじめにチャージされている金額、バスの乗車回数
//	f_1
//	f_2
//	...
//	f_M   、i 回目の降車時にかかった運賃を表す整数 f_i 
//	i 回目の降車時のカード残高とポイントを表す整数 c_i, p_i を出力
//	・1 ≦ N ≦ 10,000
//	・1 ≦ M ≦ 100
//	・0 ≦ f_i ≦ 10,000 (1 ≦ i ≦ M)
//	・また、 f_i は必ず 10 の倍数になります。
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			int chargeBalance = sc.nextInt();
			int getOnBusTimes = sc.nextInt();
			
			if (chargeBalance < 1 || chargeBalance > 10000) {
				return;
			}
			if (getOnBusTimes < 1 || getOnBusTimes > 100) {
				return;
			}
			int pointSum = 0;
			for (int i = 0; i < getOnBusTimes; i++) {
				// i回目のバスの運賃
				int cost = sc.nextInt();
				if (cost < 1 || cost > 10000) {
					break;
				}
				int getPoints = cost / 10;
				
				if (cost <= pointSum) {
					// ポイント数が運賃を上回っていればポイントで支払い
					// 残高、ポイントに変動はない
					pointSum = pointSum - cost;
				} else {
					chargeBalance = chargeBalance - cost;
					// 残高から支払った場合のみポイント加算
					pointSum = pointSum + getPoints; 
				}
				
				System.out.print(chargeBalance + " ");
				System.out.println(pointSum);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

}
