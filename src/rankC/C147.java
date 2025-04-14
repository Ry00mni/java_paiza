package rankC;

import java.util.Arrays;
import java.util.Scanner;

public class C147 {
//	C147:合言葉
//	s
//	t
//	・1行目に、合言葉を表す文字列 s が与えられます。
//	・2 行目に、システムに入力される文字列 t が与えられます。
//	・入力は 2 行となり、2 行目の末尾に改行が 1 つ入ります。
//	YESかNOを出力
//	・s, t はそれぞれ英小文字で構成される文字列
//	・1 ≦ (s の長さ), (t の長さ) ≦ 10
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String authStr = isValidString(sc, 1, 10, "合言葉");
			String inputStr = isValidString(sc, 1, 10, "入力文字列");
			
			// 完全一致の場合はロックを文字列の段階で実施
			if (authStr.equals(inputStr)) {
				System.out.println("NO");
				return;
			}
			//それぞれchar型の配列に格納し、ソートする 
			char[] authChar = authStr.toCharArray();
			char[] inputChar = inputStr.toCharArray();
			Arrays.sort(authChar);
			Arrays.sort(inputChar);
			
			if (Arrays.equals(authChar, inputChar)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	private static String isValidString(Scanner sc, int min, int max, String label) {
		String str = sc.nextLine();
		if (str.length() < min || str.length() > max) {
	        System.out.printf("%sは%d以上、%d以下でなければなりません。\n", label, min, max);
	        System.exit(1); //プログラム自体の終了 メソッドを終了させたければreturnにする
		}
		return str;
	}
}
