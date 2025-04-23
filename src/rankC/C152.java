package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C152 {
//	C152:【コドモンコラボ問題】虹が見える日
//	D
//	w_0 w_1 ... w_{D-1}
//	・1 行目に 天気予報が与えられる日数を表す整数 D が与えられます。
//	・続く 2 行目に予報された天気を示す整数 w_i (0 ≦ i ≦ D-1) が D 個半角スペース区切りで与えられます。
//	・入力は合計で 2 行となり、末尾に改行が 1 つ入ります。
//	虹が見られる可能性がある日をすべて、半角スペース区切りで 1 行に出力してください。
//	・2 ≦ D ≦ 100
//	・0 ≦ w_i ≦ 2 (1 ≦ i ≦ D-1)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int days = isValidRange(sc, 2, 100, "日数");
			
			int[] weatherArr = new int[days];
			for (int i = 0; i < days; i++) {
				weatherArr[i] = isValidRange(sc, 0, 2, "天気");
			}
			
			List<Integer> reinbowDays = new ArrayList<Integer>();
			boolean noReinbow = true;
			for (int i = 1; i < weatherArr.length; i++) {
				if (weatherArr[i - 1] == 2 && weatherArr[i] == 0) {
					noReinbow = false;
					reinbowDays.add(i);
				}
			}
			
			if (noReinbow) {
				System.out.println("-1");
			} else {
				System.out.println(
					    reinbowDays.stream()
					               .map(String::valueOf)
					               .collect(Collectors.joining(" "))
					);
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
