package rankC;

import java.util.Scanner;

public class C154 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		・1 ≦ N ≦ 100 Nは個数
//		・2 ≦ u_i ≦ 2,000 (1 ≦ i ≦ N) 価格は偶数かつ2000円以内
//		・2 ≦ L ≦ 2,000 割引を適用できる最低価格

//		N L
//		u_1 u_2 ... u_i で指定
		try {
			String[] line1 = sc.nextLine().trim().split("\\s+");
			
			if (line1.length != 2) {
				System.out.println("商品個数、割引適用最低金額の2つの数値を入力してください。");
			}
			int N = Integer.parseInt(line1[0]);
			int L = Integer.parseInt(line1[1]);
//			・1 ≦ N ≦ 100 Nは個数
			if( 1 > N || N > 1000 ) {
				System.out.println("個数Nは1以上、1000以下で指定してください");
				return;
			}
//			・2 ≦ L ≦ 2,000 割引を適用できる最低価格
			if (L < 2 || L > 2000) {
				System.out.println("割引可能下限値は2円以上、2000円以下の近画角を指定してください");
				return;
			}
			
			String[] line2 = sc.nextLine().trim().split("\\s+");
//			・2 ≦ u_i ≦ 2,000 (1 ≦ i ≦ N) 価格は偶数かつ2000円以内
			if (line2.length != N) {
				System.out.println("指定した商品個数上限を超えているか、金額が入力されていません。");
				return;
			}
			
			int numbers[] = new int[line2.length];
			int max = 0;
			int sum = 0;
			
			for(int n = 0; n < line2.length; n++) {
//				・u_i は偶数 商品価格
				numbers[n] = Integer.parseInt(line2[n]);
				System.out.println(numbers[n]);
				if (numbers[n] % 2 != 0) {
					System.out.println("金額は偶数で指定してください。");
					return;
				}
				//最大値算出
				if (max < numbers[n]) {
					max = numbers[n];
				}
				sum += numbers[n];
				
			}
				
			System.out.println("最大値は" + max);
			if (max > L) {
				sum = sum - max / 2;				
			}
				
			System.out.println(sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

}
