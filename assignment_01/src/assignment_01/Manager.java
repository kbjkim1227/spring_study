package assignment_01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

// 매니저 관리
public class Manager {
	double money; // 총 품목 매출액
	int allMcnt = 0, allHcnt=0, allOcnt=0; // 전체 출고
	int Mcnt = 0, Hcnt = 0, Ocnt = 0; // 출고량 누적 
	int Fcnt; // 남은 재고
	int Fmcnt = 1000, Fhcnt = 2000, Focnt = 3000; // 품목별 재고량
	MakeupProduct[] mpa = new MakeupProduct[Mcnt];	// 화장품 품목
	HomeProduct[] hpa = new HomeProduct[Hcnt];	// 가전제품
	OfficeProduct[] opa = new OfficeProduct[Ocnt];	// 사무용품
	
	// 년, 월(문자열, 숫자), 일(월 기준, 년 기준), 요일(문자열, 숫자), 시, 분, 초 구하기
	LocalDateTime now = LocalDateTime.now(); // 날짜 시간 불러오기
	int year = now.getYear(); // 연도
	String month = now.getMonth().toString(); // 월(문자열)
	int monthValue = now.getMonthValue(); // 월(숫자)
	int dayOfMonth = now.getDayOfMonth(); // 일(월 기준)
	int dayOfYear = now.getDayOfYear(); // 일(년 기준)
	String dayOfWeek = now.getDayOfWeek().toString(); // 요일(문자열)
	int dayOfWeekValue = now.getDayOfWeek().getValue(); // 요일(숫자)
	int hour = now.getHour(); // 시간
	int minute = now.getMinute();	// 분
	int second = now.getSecond();	// 초
	
	Scanner sc = new Scanner(System.in); // 수량 입력

	// 메이크업 관리 메소드
	void makeUpInput(MakeupProduct p) throws Exception {
		//파일 쓰기
		FileWriter fw = new FileWriter("C:\\temp\\Product.txt", true); // false 초기화 쓰기 true 이어쓰기 추후 각각 품목별로 저장되게 함 경로는 C:\Temp
		// 판매 관리
		System.out.print("몇 개 팔았는지 입력 >");
		Mcnt = sc.nextInt(); // 출고량 입력
		mpa = new MakeupProduct[Mcnt]; // 총 판매 개수가 배열 크기
		allMcnt += Mcnt; // 메이크업 누척 출고
		Fcnt = Fmcnt-Mcnt; // 남은 재고량 = 품목별 재고량 - 판매 출고량
		int pmoney = (int)(Mcnt*p.price); // 판매가 = 출고량 * 제품가격
		money += (p.price*Mcnt); // 입력받은 개수만큼 * 가격 = 총 판매 누적금액
		int Pprice = (int)p.price; // 형변환 출력용 변수 설정 
		BufferedWriter bw = new BufferedWriter(fw); // 버퍼 입출력 객체 생성
		
		// 날짜 노출이 필요 없어 빠짐
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("제품명 : %s | 판매가 : $%,d | 매출액 : $%,d | 판매 수량 : %d \n",p,Pprice,pmoney,Mcnt);
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("총재고 : %d | 남은 재고 : %d \n",Fmcnt,Fcnt);
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("화장품 | 총 매출액 : $%,d | 총 판매 수량 : %d\n",(int)money,allMcnt);
		System.out.println("----------------------------------------------------------------------------");		
		
		// 파일로 저장
		bw.write (String.format("%s년 %s월 %s일 %d시간 %d분 %d초",year, monthValue, dayOfMonth, hour, minute,second));
		bw.newLine();
		bw.write (String.format("----------------------------------------------------------------------------"));
		bw.newLine();
		bw.write (String.format("제품명 : %s | 판매가 : $%,d | 매출액 : $%,d | 판매 수량 : %d",p,Pprice,pmoney,Mcnt));
		bw.newLine();
		bw.write (String.format("----------------------------------------------------------------------------"));
		bw.newLine();
		bw.write (String.format("총재고 : %d | 남은 재고 : %d",Fmcnt,Fcnt));
		bw.newLine();
		bw.write (String.format("----------------------------------------------------------------------------"));
		bw.newLine();
		bw.write (String.format("화장품 | 총 매출액 : $%,d | 총 판매 수량 : %d",(int)money,allMcnt));
		bw.newLine();
		bw.write (String.format("----------------------------------------------------------------------------"));
		bw.newLine();
	    bw.flush();
	    bw.close();
	}
	// 가전제품 관리 메소드
	void homeProduct(HomeProduct p) throws Exception {
		//파일 쓰기
		FileWriter fw = new FileWriter("C:\\temp\\Product.txt", true); // false 초기화 쓰기 true 이어쓰기 추후 각각 품목별로 저장되게 함
		// 판매 관리
		System.out.print("몇 개 팔았는지 입력 >");
		Hcnt = sc.nextInt(); //출고량 입력
		hpa = new HomeProduct[Hcnt]; // 총 판매 개수가 배열 크기
		allHcnt += Hcnt; // 총판매수량 = 누적판매수량
		Fcnt = Fhcnt-Hcnt; // 남은재고 = 남은재고 - 출고누적량
		money += (p.price*Hcnt); // 입력받은 개수만큼 * 가격 = 총 판매 누적금액
		int kmoney = (int)(Hcnt*p.price); // 총 매출액 
		int Pprice = (int)p.price;
		BufferedWriter bw = new BufferedWriter(fw); // 

		// 형변환 출력용 변수 설정
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("제품명 : %s | 판매가 : $%,d | 매출액 : $%,d | 판매 수량 : %d \n",p,Pprice,kmoney,Hcnt);
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("총재고 : %d | 남은 재고 : %d \n",Fhcnt,Fcnt);
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("가전제품 | 총 매출액 : $%,d | 총 판매 수량 : %d\n",(int)money,allHcnt);
		System.out.println("----------------------------------------------------------------------------");		
		
		// 포맷 적용
		bw.write (String.format("%s년 %s월 %s일 %d시간 %d분 %d초",year, monthValue, dayOfMonth, hour, minute,second)); // BufferedWriter 메소드 사용
		bw.newLine(); // 줄바꿈
		bw.write (String.format("----------------------------------------------------------------------------")); // BufferedWriter 메소드 사용
		bw.newLine(); // 줄바꿈
		bw.write (String.format("제품명 : %s | 판매가 : $%,d | 매출액 : $%,d | 판매 수량 : %d",p,Pprice,kmoney,Hcnt)); // BufferedWriter 메소드 사용
		bw.newLine(); // 줄바꿈
		bw.write (String.format("----------------------------------------------------------------------------")); // BufferedWriter 메소드 사용
		bw.newLine(); // 줄바꿈
		bw.write (String.format("총재고 : %d | 남은 재고 : %d",Fhcnt,Fcnt));
		bw.newLine(); // 줄바꿈
		bw.write (String.format("----------------------------------------------------------------------------")); // BufferedWriter 메소드 사용
		bw.newLine(); // 줄바꿈
		bw.write (String.format("가전제품 | 총 매출액 : $%,d | 총 판매 수량 : %d",(int)money,allHcnt));
		bw.newLine(); // 줄바꿈
		bw.write (String.format("----------------------------------------------------------------------------")); // BufferedWriter 메소드 사용
		bw.newLine(); // 줄바꿈
	    bw.flush(); // flush 메소드 호출 (버퍼에 잔류데이터 모두 출력 및 제거)
	    bw.close(); // close 메소드 호출 (시스템 자원 방출)
	}
	// 사무용품 관리 메소드
	void officeProduct(OfficeProduct p) throws Exception {
		//파일 쓰기
		FileWriter fw = new FileWriter("C:\\temp\\Product.txt", true); // false 초기화 쓰기 true 이어쓰기 추후 각각 품목별로 저장되게 함
		// 판매 관리
		System.out.print("몇 개 팔았는지 입력 >");
		Ocnt = sc.nextInt();
		opa = new OfficeProduct[Ocnt]; // 총 판매 개수가 배열 크기
		allOcnt += Ocnt;
		Fcnt = Focnt-Ocnt;		
		money += (p.price*Ocnt); // 입력받은 개수만큼 * 가격 = 총 판매 누적금액
		int Mmoney = (int)(p.price*Ocnt);
		int Pprice = (int)p.price; // 형변환 출력용 변수 설정
		BufferedWriter bw = new BufferedWriter(fw);

		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("제품명 : %s | 판매가 : $%,d | 매출액 : $%,d | 판매 수량 : %d \n",p,Pprice,Mmoney,Ocnt);
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("총재고 : %d | 남은 재고 : %d \n",Focnt,Fcnt);
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("사무용품 | 총 매출액 : $%,d | 총 판매 수량 : %d\n",(int)money,allOcnt);
		System.out.println("----------------------------------------------------------------------------");
		
		// 포맷 적용
		bw.write (String.format("%s년 %s월 %s일 %d시간 %d분 %d초",year, monthValue, dayOfMonth, hour, minute,second));
		bw.newLine();
		bw.write (String.format("----------------------------------------------------------------------------"));
		bw.newLine(); 
		bw.write (String.format("제품명 : %s | 판매가 : $%,d | 매출액 : $%,d | 판매 수량 : %d",p,Pprice,Mmoney,Ocnt));
		bw.newLine();
		bw.write (String.format("----------------------------------------------------------------------------"));
		bw.newLine();
		bw.write (String.format("총재고 : %d | 남은 재고 : %d",Focnt,Fcnt));
		bw.newLine();
		bw.write (String.format("----------------------------------------------------------------------------"));
		bw.newLine();
		bw.write (String.format("사무용품 | 총 매출액 : $%,d | 총 판매 수량 : %d",(int)money,allOcnt));
		bw.newLine();
		bw.write (String.format("----------------------------------------------------------------------------"));
		bw.newLine();
	    bw.flush();
	    bw.close();		
	}

}