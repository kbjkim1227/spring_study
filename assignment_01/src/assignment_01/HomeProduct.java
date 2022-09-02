package assignment_01;

//부모 클래스
public class HomeProduct {
	double price; //price 제품 원가
	int hcnt; // 판매량을 기록할 카운트
	public HomeProduct() {}
	public HomeProduct(double price) {
		this.price=((price+(price*0.5)));} // 원가에서 1.5배하여 판매가 산정 
}

class Shave extends HomeProduct{
	public Shave() {super(1000);} //super는 제품의 원가 
	@Override
	public String toString() {return "면도기";} // Shave 이 호출되면 면도기 출력
}
class Fan extends HomeProduct{
	public Fan() {super(50000);}//super는 제품의 원가
	@Override
	public String toString() {return "선풍기";} // Shave 이 호출되면 펜이 출력
}
class Electronic extends HomeProduct{
	public Electronic () {super(300000);}//super는 제품의 원가 
	@Override
	public String toString() {return "전기담요";} // 전기담요 문자열 반환
}