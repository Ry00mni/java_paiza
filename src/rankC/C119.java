package rankC;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class C119 {
	
//	N M K 軒数、お化けの数、連続でお化け遭遇でアウトの数値
//	b_1   何軒目にお化けがいるか
//	...
//	b_M
	
//	・1 ≦ N ≦ 100
//	・0 ≦ M ≦ N
//	・1 ≦ K ≦ N
//	・1 ≦ b_i ≦ N (1 ≦ i ≦ M)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        try {
            String[] line1 = sc.nextLine().trim().split("\\s+");
            // 軒数取得
            int houseCounts = Integer.parseInt(line1[0]);
            if (houseCounts < 1 || houseCounts > 100) {
            	System.out.println("軒数は0~100の値");
            	return;
			}
            // おばけの数取得
            int ghostCounts = Integer.parseInt(line1[1]);
            if (ghostCounts < 0 || ghostCounts > houseCounts) {
				System.out.println("おばけの数は1以上、軒数以下の値");
				return;
			}
            // 連続アウトの設定値取得
            int deadLine = Integer.parseInt(line1[2]);
            if (deadLine < 1 || deadLine > houseCounts) {
            	System.out.println("閾値は1以上、軒数以下の値");
				return;
			}
            
            // お化けがどこに潜んでいるかの値を格納する配列
            List<Integer> ghostHouses = new ArrayList<Integer>();
            while (sc.hasNextInt() && ghostHouses.size() < ghostCounts) {
                int b = sc.nextInt();
                ghostHouses.add(b);
            }
           if (ghostHouses.size() < 1 || ghostHouses.size() != ghostCounts || ghostHouses.size() > houseCounts ) {
        	   System.out.println("おばけの数は1以上かつ、指定したおばけの数と同値にしてください");
        	   return;
           }
           
           int trickCounts = 0; //お化け遭遇回数カウンター
           int treatCounts = 0; //お菓子もらったカウンター
           
           for (int i = 1; i <= houseCounts ; i++) {
        	   if (ghostHouses.contains(i)) {
        		   trickCounts ++;
				} else {
					treatCounts ++;
					trickCounts = 0;
				}
    		   if (trickCounts >= deadLine) {
    			   break;
        	   }
           }	
            
           System.out.println(treatCounts);
        } catch(InputMismatchException ime) {
            ime.printStackTrace();  
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
