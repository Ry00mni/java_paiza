package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C115 {
//	C115:渋滞の距離
	public static void main(String[] args) {
//		N M
//		A_1
//		A_2
//		...
//		A_{N-1} 車間距離だから台数 - 1
//		M以下の合計値を求める
//		・1 ≦ N ≦ 1,000
//		・1 ≦ M ≦ 100
//		・1 ≦ A_i ≦ 200 (1 ≦ i ≦ N - 1)
		try (Scanner sc = new Scanner(System.in)) {
			String[] firstLine = sc.nextLine().trim().split("\\s+");
			// 台数と車間距離取得、検査
			int vehicleCount = Integer.parseInt(firstLine[0]);
			if (vehicleCount < 1 || vehicleCount > 1000) {
				System.out.println("車の台数は1~1000台で入力");
				return;
			}
			
			int distanceSetting =  Integer.parseInt(firstLine[1]);
			if (distanceSetting < 1 || distanceSetting > 100) {
				System.out.println("渋滞ラインの車間距離設定は1~100で入力");
				return;
			}
			
			List<Integer> distance = new ArrayList<Integer>();
			int sumDistance = 0;
			
			for (int i = 0; i < vehicleCount - 1 ; i++) {
				if (!sc.hasNextLine()) {
					break;
				}
				String[] line = sc.nextLine().trim().split("\\s+");
				int n = Integer.parseInt(line[0]);
				if (n < 1 || n > 200) {
					System.out.println("車間距離は1~200で入力");
					break;
				}
				distance.add(n);
				
				if (distance.get(i) <= distanceSetting) {
					sumDistance += distance.get(i);
				}
			}

			System.out.println(sumDistance);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	

	}

}
