package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C072 {
//	C072:モンスターの進化
//	ATK DEF AGI
//	N
//	s_1 MINATK_1 MAXATK_1 MINDEF_1 MAXDEF_1 MINAGI_1 MAXAGI_1
//	s_2 MINATK_2 MAXATK_2 MINDEF_2 MAXDEF_2 MINAGI_2 MAXAGI_2
//	...
//	s_N MINATK_N MAXATK_N MINDEF_N MAXDEF_N MINAGI_N MAXAGI_N
//	・1 行目にはそれぞれ、モンスターの現在の攻撃力、防御力、素早さを表す 3 つの整数 ATK, DEF, AGI がこの順で半角スペース区切りで与えられます。
//	・2 行目には進化先のモンスター数を表す整数 N が与えられます。
//	・続く N 行のうち、i 行目 (1 ≦ i ≦ N) には、i 番目の進化先のモンスターの名前を表す文字列 s_i と進化条件を表す 6 つの整数 MINATK_i, MAXATK_i, MINDEF_i, MAXDEF_i, MINAGI_i, MAXAGI_i がこの順で半角スペース区切りで与えられます。
//	　・s_i はモンスターの名前を表す、小文字の英字からなる文字列です。
//	　・MINATK_i, MAXATK_i は攻撃力の条件を表し、このモンスターに進化するには攻撃力が MINATK_i 以上 MAXATK_i 以下である必要があります。
//	　・MINDEF_i, MAXDEF_i は防御力の条件を表し、このモンスターに進化するには防御力が MINDEF_i 以上 MAXDEF_i 以下である必要があります。
//	　・MINAGI_i, MAXAGI_i は素早さの条件を表し、このモンスターに進化するには素早さが MINAGI_i 以上 MAXAGI_i 以下である必要があります。
//	・入力は合計で N + 2 行からなり、末尾には改行が 1 つ入ります。
//	進化する条件を満たす進化先のモンスター名を出力してください。条件をみたすモンスターが複数ある場合、入力された順番に改行区切りで出力してください。
//	また、進化条件をみたすモンスターがいない場合は "no evolution" と出力してください。
//	・1 ≦ N ≦ 1,000
//	・1 ≦ ATK, DEF, AGI ≦ 1,000
//	・1 ≦ i ≦ N に対して
//	　・1 ≦ MINATK_i ≦ MAXATK_i ≦ 1,000
//	　・1 ≦ MINDEF_i ≦ MAXDEF_i ≦ 1,000
//	　・1 ≦ MINAGI_i ≦ MAXAGI_i ≦ 1,000
//	　・1 ≦ (s_i の長さ) ≦ 30
//	　・文字列 s_i は半角英小文字のみからなる。
//	・i ≠ j ならば s_i ≠ s_j
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int atk = isValidRange(sc, 1, 1000, "攻撃力");
			int def = isValidRange(sc, 1, 1000, "防御力");
			int agi = isValidRange(sc, 1, 1000, "素早さ");
			int monsterCount = isValidRange(sc, 1, 1000, "モンスターの数");
			
			List<String> evolutionList = new ArrayList<String>();
			
			for (int i = 0; i < monsterCount; i++) {
				System.out.println("[" + (i+1) + "/" + monsterCount + "] モンスター読み取り中");
				String monsterName = sc.next();
				
				int len = monsterName.length();
				if (len < 1 || 30 < len ) {
					System.out.println("名前: " + monsterName + "は文字数の条件から外れています。");
					sc.nextLine();
					continue; //不正データがあれば次のループへ
				}
				System.out.println("名前: " + monsterName);
				int atkMin = isValidRange(sc, 1, 1000, "最小攻撃力");
				int atkMax = isValidRange(sc, 1, 1000, "最大攻撃力");
				int defMin = isValidRange(sc, 1, 1000, "最小防御力");
				int defMax = isValidRange(sc, 1, 1000, "最大防御力");
				int agiMin = isValidRange(sc, 1, 1000, "最小素早さ");
				int agiMax = isValidRange(sc, 1, 1000, "最大素早さ");
				
				if (atkMin <= atk && atk <= atkMax &&
					defMin <= def && def <= defMax &&
					agiMin <= agi && agi <= agiMax) {
					evolutionList.add(monsterName);
				}
				
			}
			
			if (evolutionList.isEmpty()) {
				System.out.println("no evolution");
			} else {
				for (String string : evolutionList) {
					System.out.println(string);
				}
			}
			
			
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
