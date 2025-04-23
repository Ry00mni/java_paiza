package rankB;

import java.util.Scanner;

public class B158 {
//	B158:【電脳少女2088コラボ】石の積まれた部屋
//	N
//	s_{1,1} s_{1,2} ... s_{1,N}
//	s_{2,1} s_{2,1} ... s_{2,N}
//	...
//	s_{N,1} s_{N,2} ... s_{N,N}
//	・1 行目に部屋の一辺の板の数を表す整数 N が半角スペース区切りで与えられます。
//	・2 行目から N+1 行目まで i 行 j 列目 (1 ≦ i, j ≦ N) の板に積まれた石の数を表す整数 s_{i,j} が半角スペース区切りで与えられます。
//	・入力は合計で N+1 行となり、末尾に改行が 1 つ入ります。
//	1 番外側の円の板の上には 1 個、その 1 つ内側には 2 個、そして中心には (N+1)/2 個とピラミッド状に石を積むようにしたとき、いくつの石を運び出す必要があるか出力
//	・5 ≦ N ≦ 49
//	・N は奇数
//	・1 ≦ s_{i,j} ≦ 100 (1 ≦ i, j ≦ N)
//	・i 行 j 列目 (1 ≦ i, j ≦ N) の板に積まれた石はその板に置くべき石の数以上
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 正方形の辺の長さ取得
			int sideLength = isValidRange(sc, 5, 49, "辺の長さ");
            if (sideLength < 5 || sideLength > 49 || sideLength % 2 == 0) {
                System.out.println("辺の長さは5以上49以下の奇数でなければなりません。");
                return;
            }
			// 石の数を二重配列で取得
			int[][] blockCounts = new int[sideLength][sideLength];
			for (int i = 0; i < sideLength; i++) {
				for (int j = 0; j < sideLength; j++) {
					blockCounts[i][j] = isValidRange(sc, 1, 100, "石の数");
				}
			}
			
			// 中心座標を決める
			// 一変の長さは奇数で提供されるが、int型であるため、小数点切り捨てとなる
            int center = sideLength / 2;

            int removeCounter = 0;
            for (int i = 0; i < sideLength; i++) {
                for (int j = 0; j < sideLength; j++) {
                    // i,j から中心までの最大距離を求める
                	// 各座標から中心の座標の値を引いた絶対値の大きい方を「距離」とする(
                	// チェビシェフ距離: max(|x1 - x2|, |y1 - y2|))
                    int distance = Math.max(Math.abs(i - center), Math.abs(j - center));
                    // centerの石の数は (center + 1)個
                    // centerを囲うdistance層目の石の数は (center - distance + 1)個
                    int expectedStone = center - distance + 1; 
                    // 過剰な石がある場合、取り除く(カウンターに足し込み)
                    if (blockCounts[i][j] > expectedStone) {
                        removeCounter += blockCounts[i][j] - expectedStone;
                    }
                    // デバッグ
                    System.out.printf("(%d,%d) 元の石=%d, 必要石=%d, 取り除く=%d\n",
                            i, j, blockCounts[i][j], expectedStone,
                            Math.max(0, blockCounts[i][j] - expectedStone));
                }
            }
			System.out.println(removeCounter);
			
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
