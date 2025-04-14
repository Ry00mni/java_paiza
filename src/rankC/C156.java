package rankC;

import java.util.Scanner;

public class C156 {
//	C156:勤怠管理
//	N			通った日数
//	e_1 l_1		
//	e_2 l_2
//	...
//	e_N l_N 	入室 退室時刻
//	時間は 24 時間表記で、hh, mm それぞれ 1 桁の場合はゼロ埋めされて 2 桁
//	・1 ≦ N ≦ 30
//	・退室時刻は必ず入室時刻の後である。
//	・入室した日と同じ日に退室が行われる。
//	・与えられる時刻 hh:mm は 24 時間表記であり、不正な時刻は与えられない。すなわちhh, mm それぞれを数値として解釈したとき、
//	　・00 ≦ hh ≦ 23
//	　・00 ≦ mm ≦ 59
//	07:11 17:09
//	11:10 23:00
//	13:11 13:20
//	00:59 08:08
//	08:23 17:33
//	55分20秒 バイト数： 1723 Byte スコア： 100点
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 規定日数の取得
			int totalDays = Integer.parseInt(sc.nextLine());  
			if (totalDays < 1 || totalDays > 30) {
				System.out.println("1以上30以下で入力");
				return;
			}
			
			int totalMinutes = 0;
			for (int i = 0; i < totalDays; i++) {
				if (!sc.hasNext()) {
					System.out.println("日数に対して勤怠データが不足しています。");
					break;
				}
				// 「入室時刻 退室時刻」をスペース区切りで分割して配列取得
				String[] attendanceData = sc.nextLine().trim().split("\\s+");
				
				// Index 0に入室、1に退室時間が入っているので、hh,mmに分割して取得
				String[] entryData = attendanceData[0].split(":");
				String[] exitData = attendanceData[1].split(":");
				
				// 0埋め文字列でもintに変換する際に取り除かれるのでOK
				//入室時刻取得
				int entryHour = getHour(entryData[0]);
				int entryMinutes = getMinute(entryData[1]);
				// 退室時刻取得
				int exitHour = getHour(exitData[0]);
				int exitMinutes = getMinute(exitData[1]);
				
				// すべて分に置き換えて計算
				int entryTime = entryHour * 60 + entryMinutes;
				int exitTime = exitHour * 60 + exitMinutes;
				
				if (exitTime < entryTime) {
					System.out.println("時刻の入力に異常値があります。");
					break;
				}
				totalMinutes = totalMinutes + (exitTime - entryTime);
			}
			
			int hours = totalMinutes / 60;
			int minutes = totalMinutes % 60;
			System.out.println(hours + " " + minutes);
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
	}
	private static int getHour(String str) {
		int hour = Integer.parseInt(str);
		if (hour < 0 || hour > 23) {
			System.out.println("無効な時間(hh)が入力されています。");
			System.exit(1);
		}
		return hour;
	}
	
	private static int getMinute(String str) {
		int minute = Integer.parseInt(str);
		if (minute < 0 || minute > 59) {
			System.out.println("無効な時間(mm)が入力されています。");
			System.exit(1);
		}
		return minute;
	}
	
	// 2行目移行の入力値の処理に関して、こんなメソッド切り出しても良かったかも
	// ロジック追加や、保守のことを考えるとこの処理は切り出しておくべき
	private static int getStayMinutes(String line) {
	    try {
	        String[] attendanceData = line.trim().split("\\s+");
	        int entryHour = getHour(attendanceData[0].split(":")[0]);
	        int entryMin = getMinute(attendanceData[0].split(":")[1]);
	        int exitHour = getHour(attendanceData[1].split(":")[0]);
	        int exitMin = getMinute(attendanceData[1].split(":")[1]);

	        int entryTime = entryHour * 60 + entryMin;
	        int exitTime = exitHour * 60 + exitMin;
	        
	        if (exitTime < entryTime) {
	            throw new IllegalArgumentException("退室時刻が入室より早いです。");
	        }
	        
	        return exitTime - entryTime;

	    } catch (IllegalArgumentException e) {
	        System.out.println("不正な入力です: " + e.getMessage());
	        return -1; // エラーを示す値
	    }
	}
}	
