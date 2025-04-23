package rankC;

import java.util.Scanner;

public class C094 {
//	C094:国民の税金
//	N
//	x_1
//	x_2
//	...
//	x_N
//	・ 行目に PAIZA 国民の人数を表す整数 N が与えられます。
//	・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には、i 番目の人の所得を表す整数 x_i が与えられます。
//	税金の合計を整数で出力してください。
//	・1 ≦ N ≦ 10
//	・0 ≦ x_i ≦ 2,000,000 (1 ≦ i ≦ N)
//	0 ~ 100000  0%
//	100001 ~ 750000 10%
//	750001 ~ 1500000 20%
//	1500001 ~ 40%
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			final int LOW = 100000; // 0%ライン
			final int MID = 750000; // 10%ライン
			final int HIGH = 1500000; // 20%ライン
			
			int population = isValidRange(sc, 1, 10, "人口");
			
			int total = 0; // 税収合計値
			for (int i = 0; i < population; i++) {
				int income = isValidRange(sc, 0, 2000000, "所得");
				int LOWIncome = Math.min(MID - LOW, income - LOW) ;
				int MIDIncome = Math.min(HIGH - MID, income - MID) ;
				int HIGHIncome = income - HIGH;
				int higTax = 0;
				int midTax = 0;
				int lowTax = 0;
				
				if (HIGHIncome > 0) higTax = (int)(HIGHIncome * 0.4); 
				if (MIDIncome > 0)  midTax = (int)(MIDIncome * 0.2); 
				if (LOWIncome > 0)  lowTax = (int)(LOWIncome * 0.1);
					
				total += higTax + midTax + lowTax;
			}
			System.out.println(total);
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	private static int isValidRange(Scanner sc, int min, int max, String label) {
		int value = sc.nextInt();
		if (value < min || value > max) {
	        System.out.printf("%sは%d以上、%d以下でなければなりません。\n", label, min, max);
	        System.exit(1); //プログラム自体の終了 メソッドを終了させたければreturnにする
		}
		return value;
	}

}
