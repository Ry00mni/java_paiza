package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C023 {
//	C023:クジの当選番号
//	a_0 b_0 c_0 d_0 e_0 f_0　　　1 行目はくじの当選番号 6 つ、2 行目の N はあなたの購入したくじの枚数
//	N
//	a_1 b_1 c_1 d_1 e_1 f_1
//	a_2 b_2 c_2 d_2 e_2 f_2
//	...
//	a_N b_N c_N d_N e_N f_N
//	
//	それぞれのくじについて、当選番号と一致する数字の数出力
//	・1 ≦ N ≦ 100
//	・1 ≦ a_i, b_i, c_i, d_i, e_i, f_i ≦ 100
//	a_i, b_i, c_i, d_i, e_i, f_i (0 ≦ i ≦ n) は全て異なる整数
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String[] line1 = sc.nextLine().trim().split("\\s+");
			List<Integer> winnigNumbers = new ArrayList<Integer>();
			
			for (int i = 0; i < line1.length; i++) {
				winnigNumbers.add(Integer.parseInt(line1[i]));
			}
			if (!isValidNumber(winnigNumbers)) return; 
			
			int lotteryCounts = Integer.parseInt(sc.nextLine());
			if (lotteryCounts < 1 || lotteryCounts > 100) {
				System.out.println("くじの抽選回数は1~100");
				return;
			}
			
			for (int i = 0; i < lotteryCounts; i++) {
				// 自身が購入した数字の組み合わせを配列で取得
				String[] line3 = sc.nextLine().trim().split("\\s+");
				List<Integer> myNumber = new ArrayList<Integer>();
				
				for (int j = 0; j < line3.length; j++) {
					myNumber.add(Integer.parseInt(line3[j]));
				}
				if(!isValidNumber(myNumber)) break;
				
				int matchCounts = 0; //番号が一致した回数をカウント
				for (int num : myNumber) {
					if (winnigNumbers.contains(num)) {
						matchCounts ++;
					}
				}
				System.out.println(matchCounts);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	private static boolean isValidNumber(List<Integer> winNum) {
		for (int num : winNum) {
			if (num < 1 || num > 100) {
				System.out.println("抽選番号は1~100");
				return false;
			}
		}
		return true;
	}

}
