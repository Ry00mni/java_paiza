package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C165 {
//	C165:カレーライス工場
//	N
//	A_1 A_2 ... A_N
//	・1 行目に、1 日に生産されるカレーとライスの合計を表す整数 N が与えられます。
//	・2 行目に、i (1 ≦ i ≦ N) 番目に生産されるものがカレーかライスかを表した文字 A_i (1 ≦ i ≦ N) が半角スペース区切りで与えられます。
//	　・A_i が 'C' の時は、カレーを意味します。
//	　・A_i が 'R' の時は、ライスを意味します。
//	・入力は合計で 2 行となり、末尾に改行が 1 つ入ります。
//	1 行目に、完成したカレーライスの数を整数で出力してください。
//	K 個のカレーライスができたとき、続く K 行について、 i (1 ≦ i ≦ K) 行目に i 番目のカレーライスを構成するカレーとライスの番号を、半角スペース区切りで出力してください。
//	・1 ≦ N ≦ 100
//	・A_i は 'C' か 'R' (1 ≦ i ≦ N)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int productCount = isValidRange(sc, 1, 100, "カレーライスの生産個数");
			sc.nextLine();
			
			// 生産されたアイテムをIndexとともに取得
			List<Character> ingList = new ArrayList<>();
			for (int i = 0; i < productCount; i++) {
				String parts = sc.next();
				if (!parts.equals("C") && !parts.equals("R")) {
					System.out.println("意図しない文字列");
					return;
				}
				ingList.add(parts.charAt(0));
			}
			
			List<Integer> curryNum = new ArrayList<Integer>();
			List<Integer> riceNum = new ArrayList<Integer>();
			int curryRiceCount = 0;
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < productCount; i++) {
				char ingredients =  ingList.get(i);
				// カレー、ライスの作られた順番を管理するListに格納
				if (ingredients == 'C') {
					curryNum.add(i + 1);
				} else {
					riceNum.add(i + 1);
				}
				
				// カレーライスが完成時処理
				// インデックス番号 + 1番目の情報を保持する配列から、もっとも若い番号を削除
//				if (curryNum.size() >= 1 && riceNum.size() >= 1) 
				if (!curryNum.isEmpty() && !riceNum.isEmpty()){ 
					curryRiceCount ++;
					// 各具材の最も若いインデックス番号の情報をString Builderに追加
					sb.append(curryNum.get(0) + " " + riceNum.get(0) + "\n");
					// それぞれのインデックス番号を配列から取り除く
					curryNum.remove(0);
					riceNum.remove(0);
				}
			}
			System.out.println(curryRiceCount);
			System.out.println(sb.toString());
			
			
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
