package assignment_01;

//부모 class
public class MakeupProduct {
	double price; //제품가격
	int mcnt = 0; // 개수
	public MakeupProduct(){}
	public MakeupProduct(double price) {
		this.price=((price+(price*0.5)));} // 이윤(1.5 출력
}

class Lipstic extends MakeupProduct{ //립스틱 가격
	public Lipstic() {super(2000);} //super는 제품의 원가
	@Override
	public String toString() {return "립스틱";} // 립스틱 문자열 반환
}
class Soap extends MakeupProduct{ // 비누 가격 
	public Soap() {super(500);} //super는 제품의 원가
	@Override
	public String toString() {return "비누";} // 비누 문자열 반환
}
class Shampoo extends MakeupProduct{ // 샴푸 가격
	public Shampoo() {super(1000);} //super는 제품의 원가
	@Override
	public String toString() {return "샴푸";} // 샴푸 문자열 반환
}