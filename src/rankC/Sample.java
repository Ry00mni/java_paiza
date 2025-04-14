package rankC;

import java.util.Scanner;

public class Sample {
//	N
//	a_1 a_2 ... a_N
//	1 行目に整数 N が与えられます。
//	2 行目に N 個の整数 a_1, a_2, ..., a_N 
//	N 個の整数を小さい順にソートし、改行区切りで出力
    public static void main(String[] args) {
    	try (Scanner sc = new Scanner(System.in)) {
    		int numberCounts = sc.nextInt();
    		if (numberCounts < 1 || numberCounts > 10) {
				return;
			}
    		String[] line2 = sc.nextLine().trim().split("\\s+");
    				
		} catch (Exception e) {
			// TODO: handle exception
		}
    	Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().trim().split("\\s+");
        System.out.println(line.length);
    }
}
