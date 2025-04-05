package rankC;

import java.util.Scanner;

public class C104 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			
			String line[] = sc.nextLine().trim().split("\\s+");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			
			if (a < 1 || a > 9) {
				System.out.println("1つ目の数字は1~9の値を入力してください");
			}
			if (b < 0 || b > 9 ) {
				System.out.println("2つ目の数字は0~9の値を入力してください");
			}
			
			// (10x + y) * y = (a * 100) + (x * 10) + b が成立するならx,yの組み合わせを出力
			// なければNoを出力
			
			int x = 0;
			int y = 0;
			boolean isMatch = false;
			// x,yは1~9の範囲で検証
			for (x = 1; x <= 9 ; x++) {
				for (y = 0; y <= 9 ; y++) {
					if ((x * 10 + y) * y == (a * 100) + (x * 10) + b) {
						System.out.println(x + " " + y);
						isMatch = true;
					}
				}
			}
			if (!isMatch) {
				System.out.println("No");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}


}
