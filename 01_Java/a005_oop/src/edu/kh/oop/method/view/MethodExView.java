package edu.kh.oop.method.view;

import java.util.Scanner;

import edu.kh.oop.method.service.MethodExService;

// View : 프로그램 실행 시 보여지는 부분
// -> 콘솔에 내용을 출력, 입력 받는 용도의 객체를 만들기 위한 클래스
public class MethodExView {

	// 기본 생성자 자동으로 추가 되어 있음.
	
	// 필드(==멤버변수)
	private Scanner sc = new Scanner(System.in);
	// 클래스 내 어디서든 사용 가능한 Scanner 객체 생성  
	// 코드 길이 감소, 중복 제거 
	
	
	private MethodExService service = new MethodExService();
	// 클래스 내 어디서든 사용 가능한 MethodExService 객체 생성
	// view 클래스에서 service 기능을 가져다 사용하기 위한 객체 생성임.
	// 객체만 생성한 거!
	
	

	// void : 반환 값이 없다
	public void displayMenu() { // 메뉴 표시(출력) 기능
		
		int input = 0; // 입력 받은 정수를 저장할 변수
		
		do {
			System.out.println("-----------------------------------");
			System.out.println("1. 매개 변수 X, 반환 값 X");
			System.out.println("2. 매개 변수 O, 반환 값 X");
			System.out.println("3. 매개 변수 X, 반환 값 O");
			System.out.println("4. 매개 변수 O, 반환 값 O");
			System.out.println("0. 프로그램 종료");
			System.out.println("-----------------------------------");
			
			System.out.print("메뉴 번호 입력 >> ");
			input = sc.nextInt();
			
			System.out.println(); // 개행
			
			switch(input) {
			case 1: menu1(); break;  // 1 입력 시 menu1() 메서드 호출
									 // case 1 실행하고 나면 break; 실행되어 while(input != 0);으로 넘어감.
			case 2: menu2(); break;
			
			case 3: menu3(); break;
			
			case 4: menu4(); break;
			
			case 0: System.out.println("<프로그램 종료>"); break;
			default: System.out.println("잘못 입력 하셨습니다.");
			}
			
		} while(input != 0);  
		// input에 0 입력 -> 0!=0 -> false 되면서 밖으로 나와 프로그램 종료
		
	} // displayMenu() 끝
	
	
	// 1. 매개 변수 X, 반환 값 X
	// [접근제한자] [예약어] 반환형 메서드명([매개변수]) {}
	private void menu1() {
		System.out.println("*** menu1() 실행 ***");
		
		int a = 10;
		int b = 20;
		
		System.out.println("a + b = " + (a+b));
	}
	
	
	// 2. 매개 변수 O, 반환 값 X --> service(기능 제공) 클래스 필요함!!!
	private void menu2() {  // private! public 아님!
		System.out.println("*** menu2() 실행 ***");
		
		System.out.println("[정수 3개를 입력 받아 합계, 평균을 출력]");
		
		System.out.print("입력 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력 3 : ");
		int num3 = sc.nextInt();
		
		// service에서 제공하는 기능
		// threeNumbersSumAndAverage(정수1, 정수2, 정수3); 호출 시 
		// 정수 1,2,3에 각각 num1,2,3(sc로 입력된 값 ex)10, 20, 30) 를 전달함
		service.threeNumbersSumAndAverage(num1, num2, num3);
	}
	
	
	// 3. 매개 변수 X, 반환 값 O
	private void menu3() {
		System.out.println("*** menu2() 실행 ***");
		
		System.out.println("[1부터 10 사이의 난수 5개를 저장한 배열을 반환받아 출력]");
		
		int[] numbers = service.fiveRandomNumbers();  // 3)
		// ex) 0x10  <-  0x10 (주소)  
		// 서로 다른 두개의 변수가 하나의 배열이나 객체를 참조 ==> 얕은 복사
		
		// 1. 호출 -> 2. 로직 처리 완료 -> 3. return 돌아가기
		// 1. 호출 -> 2. service로 이동 -> fiveRandomNumbers()에서 난수 발생 (로직 처리 완료) -> 3. return : 다시 호출한 곳으로 돌아감
		
		// 1) service의 fiveRandomNumbers()를 호출
		// 2) 난수 5개 저장된 int[] 이 반환됨 (돌아옴)
		//    -> 반환된 int[]은 실제 배열이 아닌
		//       int[] 의 '주소값'이다.  == 얕은 복사 !!!!! 개념 적용 (주소만 왔다 갔다 하는 것)
		// 3) service.fiveRandomNumbers()로 반환된 int[] 배열을 numbers 참조 변수에 저장
		
		// 출력
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		
		System.out.println(); // 개행
		
		// 메서드 재사용
		// 메서드 목적 : 한 번 만들어서 여러 군데에서 사용할 수 있게 하는 것
		//			  특정한 객체가 가지고 있는 기능이자 여러 곳에서 다 사용 가능한 것
		service.threeNumbersSumAndAverage(numbers[0], numbers[1], numbers[2]);
				// 2번 메서드				// 난수로 생성된 번호 세개를 보냄.
	}
	
	
	// 4. 매개 변수 O, 반환 값 O
	private void menu4() {
		
		// 정수 2개, 연산자를 입력 받아 계산서비스 호출 후 
		// 연산 결과를 반환 받아서 출력
		
		System.out.println("*** menu4() 실행 ***");
		
		System.out.println("[입력된 정수 2개, 연산자를 이용해서 계산하기]");
		
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		String op = sc.next();
		
		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt();
		
		
		// service의 calculate() 메서드 호출 시 매개변수 3개를 전달
		// -> 계산 결과가 String 형태로 반환
		String result = service.calculate(num1, num2, op);
		System.out.println(result);
		
	}
}
