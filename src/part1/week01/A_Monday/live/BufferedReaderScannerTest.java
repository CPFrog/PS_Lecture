package part1.week01.A_Monday.live;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BufferedReaderScannerTest {

	/*
	 * public static void main(String[] args) throws FileNotFoundException {
	 * System.setIn(new FileInputStream("inputTc.txt")); Scanner sc = new
	 * Scanner(System.in);
	 * 
	 * 
	 * int T = sc.nextInt(); long start = System.nanoTime(); for (int t = 1; t <= T;
	 * t++) { int n = sc.nextInt(); int sum = 0; for (int i = 0; i < n; i++) { for
	 * (int j = 0; j < n; j++) sum += sc.nextInt(); } System.out.println("#" + t +
	 * " " + sum); } long end = System.nanoTime();
	 * System.out.println((end-start)/1_000_000_000.0 + "s");
	 * 
	 * 
	 * }
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("inputTc.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		long start = System.nanoTime();
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(in.readLine());
			int sum = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++)
					sum += Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + t + " " + sum);
		}
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0 + "s");

	}

}
