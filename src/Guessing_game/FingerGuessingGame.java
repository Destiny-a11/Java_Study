import java.util.Scanner;
import java.util.Random;   


public class FingerGuessingGame {

	public static void main(String[] args) {
		Tom t1 = new Tom();
		Scanner myScanner = new Scanner(System.in);
		String[][] result = new String[3][2];  //�洢�����ڵ��Ժ�tom��ȭ���� ��һ��Ϊtom��ȭ�� �ڶ���Ϊ���Գ�ȭ 
		String[] isWin = new String[3];
		for (int num = 1; num <= 3; num++) {
			System.out.println("\n===========��" + num + "����Ϸ��ʼ��==============");
			System.out.print("\n��������Ҫ����ȭ(������ʯͷ����)��");
			String tomResult = myScanner.next();
			t1.getComputerResult();
			System.out.println("\n���Գ���" + t1.computerPunch);
			t1.tomPunch = tomResult;
			isWin[num - 1] = t1.game();
			System.out.println("\n���Ϊ��" + isWin[num - 1]);
			result[num - 1][0] = tomResult;
			result[num - 1][1] = t1.computerPunch;
		}
		System.out.println("\n=====================������Ӯ�嵥======================="); 
		System.out.println("\n����\tTom�ĳ�ȭ\t���Եĳ�ȭ\t\t��Ӯ���\n"); 
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
			this.computerPunch = "ʯͷ";
		} else if (res == 1) {
			this.computerPunch = "����";
		} else {
			this.computerPunch = "��";
		}   

	}


	public String game() {

		//�г��Լ�Ӯ��ƽ�ֵ���������඼����
		if (this.tomPunch == "ʯͷ" && this.computerPunch == "����") {
			return "TomӮ��";
		} else if (this.tomPunch == "����" && this.computerPunch == "��") {
			return "TomӮ��";
		} else if (this.tomPunch == "��" && this.computerPunch == "ʯͷ") {
			return "TomӮ��";
		} else if (this.tomPunch.equals(this.computerPunch)) {
			return "ƽ��";
	    } else {
	    	return "����Ӯ��";
	    }
	}

}