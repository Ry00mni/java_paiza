package rankC;

import java.util.Scanner;
import java.util.Set;

public class C086 {
	//C086:ハンドルネームの生成
	//・5 ≦ S の長さ ≦ 20
//	・S は英字大文字および小文字で構成される文字列
//	・S には必ず子音が含まれる
//	小文字( "a", "e", "i", "o", "u" )、大文字( "A", "E", "I", "O", "U" )を取り除く
	public static void main(String[] args) {
		//点数低かったので修正 
		try(Scanner sc = new Scanner(System.in)) { 
			String name = sc.nextLine();
			if (name.length() < 5 || name.length() > 20 ) {
				System.out.println("名前は5文字以上、20文字以内");
				return;
			}
			
			// 要素がユニークであるためSetを使用
			Set<Character> vowel = Set.of('a', 'i', 'u', 'e', 'o');
			
			// 文字列を操作するため、Stringよりもメモリ効率重視のStringBuilder
			StringBuilder result = new StringBuilder();
			
			// 文字列1文字ずつ取り出し、小文字化して母音含まれていなければStringBuilderに追加
			for (char c : name.toCharArray()) {
				if (!vowel.contains(Character.toLowerCase(c))) {
					result.append(c);
				}
			}
			System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
//			}
			
//		バイト数： 826 Byte スコア： 68点 時間かかりすぎた
//		Scanner sc = new Scanner(System.in);
//		try {
//			String name = sc.nextLine();
//			if (name.length() < 5 || name.length() > 20 ) {
//				System.out.println("名前は5文字以上、20文字以内");
//				return;
//			}
//			
//			List<String> nameArray = new ArrayList<String>();
//			// 1文字ずつ分割した文字列に変換
//			for (char s : name.toCharArray()) {
//				nameArray.add(String.valueOf(s));
//			}
//			List<String> lowerVowel = Arrays.asList("a", "i", "u", "e","o");
//			List<String> upperVowel = Arrays.asList("A", "I", "U", "E","O");
//			
//			nameArray.removeIf(lowerVowel::contains);
//			nameArray.removeIf(upperVowel::contains);
//			
//			for (String string : nameArray) {
//				System.out.print(string);
//			}
//			
//			
//			
//		} catch (Exception e) {
//			return;
//		} finally {
//			sc.close();
//		}
//	}

}
