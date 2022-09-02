package assignment_01;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Scanner;

public class Main { //부모 Class

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); //프로그램 시작,종료 입력 객체생성
		Manager m1 = new Manager(); //제품선택 객체생성
		int act; // 품목관련 선택 변수
		while(true) {
			try {
			do {
			System.out.println("-------------");  // ------- 줄 출력
			System.out.println("제품관리 프로그램");  //  "제품관리 프로그램" 출력
			System.out.println("-------------"); //  -------- 줄 출력
			System.out.print("1.입력, 2.출력, 3.종료\n >"); // 선택지 출력
			act = sc.nextInt();  // 입력 , 출력 , 종료 중 행동 입력 값 받기위함 
			} while ( act > 3 || act < 1); // 선택지 벗어나면 다시 프로그램 재시작 하도록 함.
			
			switch (act) {
			case 1: 	// 입력 선택 시
				System.out.print("1.화장품 | 2. 가전제품 | 3. 사무용품 \n >");  // 제품관련 선택사항 출력
				act = sc.nextInt();  // 화장품 , 가전제품 , 사무용품 중 원하는사항 입력받음
				if(act == 1 ) {  // 화장품을 선택시
					System.out.print("1. Soap | 2. Shampoo | 3.Lipstick\n>");  // 화장품 관련 제품 선택사항 출력
					act = sc.nextInt(); // 비누 , 샴푸 ,립스틱중 선택사항 입력받음
					if(act == 1 ) { // 비누를 선택했을 시
						m1.makeUpInput(new Soap()); // MakeupProduct에 있는 soap 메소드호출
						break; // 멈춤
					} else if ( act == 2 ) { // 샴푸를 선택했을 시
						m1.makeUpInput(new Shampoo()); // MakeupProduct에 있는 shampoo 메소드 호출
						break; // 멈춤
					} else if ( act == 3 ) { // 립스틱을 선택했을 시 
						m1.makeUpInput(new Lipstic()); // MakeupProduct에 있는 Lipstick 메소드 호출
						break; // 멈춤
					} else {continue;}  // 선택지 벗어나면 다시 입력 , 출력 , 종료 선택창으로
				} else if ( act == 2 ) { //가전제품 관련 선택
					System.out.print("1. Shave | 2. Fan | 3. electronic Blanket\n >"); // 가전제품 관련 선택사항 출력
					act = sc.nextInt(); // 면도기 , 선풍기 , 전기담요중 선택사항 입력받음
					if ( act == 1 ) { // 면도기를 선택했을 시
						m1.homeProduct(new Shave()); // HomeProduct에 있는 Shave 메소드 호출
						break; // 멈춤
					} else if ( act == 2 ) { // 선풍기를 선택했을 시
						m1.homeProduct(new Fan()); // HomeProduct에 있는 Fan 메소드 호출
						break; // 멈춤
					} else if ( act == 3 ) { // 전기담요를 선택했을 시 
						m1.homeProduct(new Electronic()); // HomeProduct에 있는 Electronic 메소드 호출
						break; // 멈춤
					} else {continue;}  // 선택지 벗어나면 다시 입력 , 출력 , 종료 선택창으로
				} else if (act == 3 ) { //사무용품 관련 선택
					System.out.print("1. A4 Paper | 2. Note | 3. Pen \n > "); // 사무용품 관련 선택사항 출력
					act = sc.nextInt(); // A4용지 , 노트 , 볼펜중 선택사항 입력받음
					if( act == 1 ) { // A4용지를 선택했을 시 
						m1.officeProduct(new AfourPaper()); // OfficeProduct에 있는 AfourPaper 메소드 호출
						break; // 멈춤
					} else if ( act == 2 ) { // 노트를 선택했을 시
						m1.officeProduct(new Note()); // OfficeProduct에 있는 Note 메소드 호출
						break; // 멈춤
					} else if ( act == 3 ) { // 볼펜을 선택했을 시 
						m1.officeProduct(new Pen()); // OfficeProduct에 있는 Pen 메소드 호출
						break; // 멈춤
					} else {continue;} // 선택지 벗어나면 다시 입력 , 출력 , 종료 선택창으로
				} else {}
			case 2: // 출력 선택 
				try {
					// 전체 내용을 한 파일로 되어 있음 추후 각각 품목별로 나눔
					// 바이트 단위로 파일읽기
				        String filePath = "C:\\temp\\Product.txt"; // 대상 파일
				        FileInputStream fileStream = null; // 파일 스트림
				        
				        fileStream = new FileInputStream( filePath );// 파일 스트림 생성
				        //버퍼 선언
				        byte[ ] readBuffer = new byte[fileStream.available()];  // 가상메모리에 저장될 내용 담기
				        while (fileStream.read( readBuffer ) != -1){} // 저장된 내용 메모리에 대기
				        System.out.println(new String(readBuffer)); //출력 

				        fileStream.close(); //스트림 닫기
				    } catch (Exception e) {  // 파일이 생성이 안되었을시 예외처리
				    	 System.out.println("생성된 파일이 없습니다! "+e.getMessage()); // 예외처리 시 "생성된 파일이 없습니다" 출력 
				    }
				{continue;}  // 선택지 벗어나면 다시 입력 , 출력 , 종료 선택창으로
			case 3: 
				System.out.println("\n\n\n시스템 종료!\n\n"); 
				sc.close(); System.exit(0); // 시스템 종료
						}
					}catch (Exception e) {
						System.out.println(e.toString());
				}
			}
			
		
	}

}