package rankD;

import java.util.Scanner;

public class D185 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		・1100 ≦ N ≦ 5000
//		・1 ≦ M ≦ 200
//		・N, M は整数
		Scanner sc = new Scanner(System.in);
		
		try {
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            if (N < 1100 || 5000 < N) {
            	System.out.println("時給は1,100円以上、5,000円以下で入力してください");
			}
            if (M < 1 || 200 < M ) {
            	System.out.println("労働時間は1時間以上、200時間以下で入力してください");
            }
            int saraly = N * M;
            System.out.println(saraly);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sc.close();
		}

	}

}
