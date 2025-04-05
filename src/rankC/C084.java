package rankC;

import java.util.Scanner;

public class C084 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		
		try {
			String st = sc.nextLine();
			
			if (st.length() < 1 || 100 < st.length() ) {
				System.out.println("1文字以上、100文字以内の英字を入力してください");
			}
			for (int i = 0; i < st.length() + 2; i++) {
				System.out.print("+");
			}	
			System.out.println("");
			System.out.println("+" + st + "+");
			
			for (int i = 0; i < st.length() + 2 ; i++) {
				System.out.print("+");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
