package rankC;

import java.util.Scanner;

public class C097 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        try {
            String input = sc.nextLine();
            String[] parts = input.trim().split("\\s+");
            
            if (parts.length != 3){
                System.out.println("3つの数字を入力してください");
                return;
            }
            
            int N = Integer.parseInt(parts[0]);
            int X = Integer.parseInt(parts[1]);
            int Y = Integer.parseInt(parts[2]);
            
            if ( N >= 1 && N <= 1000 && X >= 1 && Y <= N) {
                for (int i = 1 ; i < N; i++ ){
                    if(i % X == 0 && i % Y == 0){
                        System.out.println("AB");
                    } else if( i % X == 0) {
                        System.out.println("A");
                    } else if( i % Y == 0) {
                        System.out.println("B");
                    } else {
                        System.out.println("N");
                    }
                } 
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
