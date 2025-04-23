package rankC;

import java.util.Scanner;

public class C016 {
//	C016:Leet文字列
//	s
//	s は Leet に変換する前の文字列を表します。
//	・1 ≦ (s の長さ) ≦ 100
//	・s はアルファベット大文字のみからなる
//	A	4
//	E	3
//	G	6
//	I	1
//	O	0
//	S	5
//	Z	2
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String[] str = sc.nextLine().trim().split("");
			if (str.length < 1 || str.length > 100) {
				return;
			}
			for (int i = 0; i < str.length; i++) {
				switch (str[i]) {
				case "A": 
					str[i] = String.valueOf(4);
					break;
				case "E":
					str[i] = String.valueOf(3);
					break;
				case "G":
					str[i] = String.valueOf(6);
					break;
				case "I":
					str[i] = String.valueOf(1);
					break;
				case "O":
					str[i] = String.valueOf(0);
					break;
				case "S":
					str[i] = String.valueOf(5);
					break;
				case "Z":
					str[i] = String.valueOf(2);
					break;
				default:
				}
			}
			for (String string : str) {
				System.out.print(string);
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

}
