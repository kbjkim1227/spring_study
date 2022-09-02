package assignment_01;

//부모 클래스
public class OfficeProduct {
	double price; //제품가격
	int ocnt = 0; //총 판매 갯수를 기록할 카운트
	public OfficeProduct() {}
	public OfficeProduct(double price){
		this.price=((price+(price*0.5)));} //가격 * 1.5배로 인상 적용한 가격
}
class AfourPaper extends OfficeProduct{ //OfficeProduct의 자식 클래스
	public AfourPaper(){super(10000);} //용지 가격 10000
	@Override
	public String toString() {return "A4용지";} //AfourPaper이 호출되면 A4용지 출력
}
class Note extends OfficeProduct{ //OfficeProduct의 자식 클래스
	public Note() {super(20000);} //노트가격 20000원
	@Override
	public String toString() {return "노트";} //Note가 호출되면 노트가 출력
}
class Pen extends OfficeProduct{ //OfficeProduct의 자식 클래스
	public Pen() {super(500);} //팬가격 500원
	@Override
	public String toString() {return "펜";}//Pen 이 호출되면 펜이 출력
}