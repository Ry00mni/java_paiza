package rankD;

import java.util.Scanner;

public class D156 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
        try {
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            if (N < 1 || N > 100 || M < 1 || M > 100){
                System.out.println("1以上、100以下で入力してください");
            } else {
                int result = N * M;
                System.out.println(result);
            }
            
        } catch(Exception e) {
        } finally {
        sc.close();
    }
	}

}
