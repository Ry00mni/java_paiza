package rankC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C109 {
//	C109:IDを登録順に並べよう
//	N  ユーザー ID の個数
//	S_1
//	...
//	S_N  ユーザー ID を表す文字列 S_i 
//	・1 ≦ N ≦ 200
//	・ユーザーネームは全て英小文字のみからなり、長さは 1 文字以上 20 文字以下である
//	・通し番号は全て 1 以上 10,000 以下の整数で、先頭に不要な 0 を含まない
//	・入力中に同じ通し番号が 2 回以上現れることはない
//	5
//	paiza1
//	kirishima813
//	pizza99
//	sushi100
//	beef1001
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int uidCounts = Integer.parseInt(sc.nextLine());
			if (uidCounts < 1 || uidCounts > 200) {
				System.out.println("UIDの個数は1~200で指定");
				return;
			}
			
			// UIDをuserName,IDに切り分けて格納するMap
			// key = ID(一意のため)
			// value = userName
			Map<Integer, String> userMap = new HashMap<>();
			
			// 入力された各UIDに対し、分割
			for (int i = 0; i < uidCounts; i++) {
				String userID = sc.nextLine();
				char[] chars = userID.toCharArray();
				
				// char型配列から文字列として結合したものを最後にMapに格納するためのStringbuilder
				StringBuilder userName = new StringBuilder();
				StringBuilder idStr = new StringBuilder();  // ID部分は後でintにする
				
				for (char c : chars) {
					if (Character.isDigit(c)) {
						idStr.append(c);
					} else {
						userName.append(c);
					}
				}
				// 
				int id = Integer.parseInt(idStr.toString());
				userMap.put(id, userName.toString());
								
			}
			
			//Mapの要素を並び替えるため、entrySetをListに格納
			List<Map.Entry<Integer, String>> sortList = new ArrayList<>(userMap.entrySet());
			sortList.sort(Map.Entry.comparingByKey());
			
			// 並べ替えた要素を出力
			for (Map.Entry<Integer, String> entry : sortList) {
				System.out.println(entry.getValue() + entry.getKey());
			}

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

}
