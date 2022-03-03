import java.util.Scanner;
import java.util.Random;   


public class FingerGuessingGame {

	public static void main(String[] args) {
		Tom t1 = new Tom();
		Scanner myScanner = new Scanner(System.in);
		String[][] result = new String[3][2];  //存储三局内电脑和tom出拳类型 第一列为tom出拳， 第二列为电脑出拳 
		String[] isWin = new String[3];
		for (int num = 1; num <= 3; num++) {
			System.out.println("\n===========第" + num + "局游戏开始！==============");
			System.out.print("\n请输入你要出的拳(剪刀、石头、布)：");
			String tomResult = myScanner.next();
			t1.getComputerResult();
			System.out.println("\n电脑出：" + t1.computerPunch);
			t1.tomPunch = tomResult;
			isWin[num - 1] = t1.game();
			System.out.println("\n结果为：" + isWin[num - 1]);
			result[num - 1][0] = tomResult;
			result[num - 1][1] = t1.computerPunch;
		}
		System.out.println("\n=====================最终输赢清单======================="); 
		System.out.println("\n局数\tTom的出拳\t电脑的出拳\t\t输赢情况\n"); 
		for (int i = 0; i < result.length; i++) {
			System.out.print(i + 1 + "\t");
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + "\t\t");
			}
			System.out.print("\t" + isWin[i]);
			System.out.println();
		}

	}
}

class Tom {
	String computerPunch;
	String tomPunch;

	public void getComputerResult() {

		Random r = new Random();  
		int res = r.nextInt(3);

		if (res == 0) {
			this.computerPunch = "石头";
		} else if (res == 1) {
			this.computerPunch = "剪刀";
		} else {
			this.computerPunch = "布";
		}   

	}


	public String game() {

		//列出自己赢和平手的情况，其余都是输
		if (this.tomPunch == "石头" && this.computerPunch == "剪刀") {
			return "Tom赢了";
		} else if (this.tomPunch == "剪刀" && this.computerPunch == "布") {
			return "Tom赢了";
		} else if (this.tomPunch == "布" && this.computerPunch == "石头") {
			return "Tom赢了";
		} else if (this.tomPunch.equals(this.computerPunch)) {
			return "平手";
	    } else {
	    	return "电脑赢了";
	    }
	}

}