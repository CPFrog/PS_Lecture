package part1.week01.A_Monday.live;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("기수 입력: ");
		int no=sc.nextInt();
		System.out.println("--> SSAFY "+no+"기");
		
		System.out.print(no+"기의 슬로건?");
		String msg;
//		msg=sc.nextLine(); --> 개행문자 처리에 대한 문제때문에 혼용 사용 금지
		msg=sc.next();
		System.out.println("--> 슬로건: "+msg);
		sc.close();
	}

}
