package rankD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D334 {
	// 一週間の食費
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> costs = new ArrayList<Integer>();
		try {
			for (int i = 0; i < 7; i++) {
				if(!sc.hasNextInt()) {
					return;
				}
				int costPerDay = sc.nextInt();
				costs.add(costPerDay);
			}
			
			if(costs.size() != 7) {
				System.out.println("7日分の入力に限ります。");
				return;
			}
			int totalCost = 0;
			for (int i = 0; i < costs.size(); i++) {
				totalCost += costs.get(i);
			}
			System.out.println(totalCost);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}

	}

}
