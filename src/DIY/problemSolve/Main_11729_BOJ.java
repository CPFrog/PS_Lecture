package DIY.problemSolve;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_11729_BOJ {
	static int[][] wall;
	static int n;
	static BufferedWriter bw;

	public static void Hanoi(int start, int tmp, int end, int size) throws Exception {
		if (size == 1) {
			bw.append(start + " " + end + "\n");
		} else {
			Hanoi(start, end, tmp, size - 1);
			bw.append(start + " " + end + "\n");
			Hanoi(tmp, start, end, size - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = sc.nextInt();
		sc.close();
		bw.append(((int) Math.pow(2, n) - 1) + "\n");
		Hanoi(1, 2, 3, n);
		bw.flush();
		bw.close();
	}
}
