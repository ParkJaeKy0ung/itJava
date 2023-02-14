package edu.kh.array.ex;

public class ArrayEx2 {
	
	// 2차원 배열 사용법 1
	public void ex1() {
		
		// 2차원 배열 선언 및 할당
		int[][] arr = new int[2][3];  // 2행 3열
		
		System.out.println("행의 길이 : " + arr.length); // 2
		System.out.println("열의 길이 : " + arr[0].length); // 3
		
		// 2차원 배열 초기화
		
		// 1) 인덱스를 이용한 초기화
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;
		
		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;
		
		System.out.println("---------인덱스를 이용한 초기화-------");
		
		
		// 2) 2중 for문을 이용한 초기화 방법
		
		int number = 0;
		
		for(int row=0; row<arr.length; row++) {  // 행 반복
			for(int col=0; col<arr[0].length; col++) {  // 열 반복
				
				arr[row][col] = number * 5; // [0][0]=0*5=0   [0][1]=1*5=5   [0][2]=2*5=10
											// [1][0]=3*5=15  [1][1]=4*5=20  [1][2]=5*5=25
				number++;
			}
		}
		
		System.out.println("-------2중 for문을 이용한 초기화 방법---------");
		
		
		// 3) 선언 및 초기화
		
		int[][] arr2 = { 
						 {1,2,3,4,5},
				         {60,70,80,90,100},
				         {11,22,33,44,55} 
				       };
		
		System.out.println(arr2[1][3]); // 90
		
		System.out.println("--------선언 및 초기화----------");
		
		
		// 0행 : 1 2 3 4 5 
		// 1행 : 60 70 80 90 100
		// 2행 : 11 22 33 44 55
		
		
		for(int row=0; row<arr2.length; row++) {
			System.out.print(row + "행 : ");
			
			// 한 행에 있는 모든 열의 값 출력
			for(int col=0; col<arr2[row].length; col++) {
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println(); // 개행
		}       
	}
	
	
	// 2차원 배열 응용 1
	public void ex2() {    // -> 응용하면 표로 만든 프로그램 만들 수 있음.
		
		// 3행 3열 짜리 int 2차원 배열에 난수(0~9)를 대입한 후
		// 각 행의 합과 전체 합을 출력
		
		// 3  2  5
		// 9  7  2
		// 1  2  3
		
		// 0행의 합 : 10
		// 1행의 합 : 18
		// 2행의 합 : 6
		// 전체 합 : 34
		
		
		// 3행 3열 배열 생성
		int[][] arr = new int[3][3];
		
		
		// 난수 대입 및 출력
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				
				// 배열 요소에 난수 대입
				arr[row][col] = (int)(Math.random() * 10);  // 0~9
				
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
		
		
		// 합계 계산 및 출력
		
		int sum = 0; // 전체 합(모든 요소 합)
		
		for(int row=0; row<arr.length; row++) {
			
			int rowSum = 0; // 행의 합
			for(int col=0; col<arr[row].length; col++) {
				rowSum += arr[row][col]; 
			}
			System.out.println(row + "행의 합 : " + rowSum);
			
			sum += rowSum; // 각 행의 합을 sum에 누적
		}
		System.out.println("전체 합 : " + sum);
	}
	
	
	
	// 가변 배열
	public void ex3() {
		
		// 가변 매열
		// - 2차원 배열 할당 시
		//   마지막 차수(열)의 크기를 지정하지 않고
		//   추후에 각행에 새로운 1차원 배열의 주소를 대입하는 배열
		
		char[][] arr = new char[4][];
		
		// 각 행마다 각자 다른 열의 개수 입력
		arr[0] = new char[3];  // 이 숫자만 바꾸면 출력값 바로 변경 가능함
		arr[1] = new char[6];
		arr[2] = new char[2];
		arr[3] = new char[9];
		
		// 배열의 모든 요소에 a부터 시작하여 하나씩 증가하는 알파벳 대입
		
		char ch = 'a';
		
		for(int row=0; row<arr.length; row++) {
			
			// 각 행의 열의 길이가 다르기 때문에
			// 조건식의 값이 행별로 변할 수 있도록
			// arr[row].length 사용
			for(int col=0; col<arr[row].length; col++) {
				
				arr[row][col] = ch;
				ch++;  // 소문자에 해당되는 숫자가 1씩 증가하면서 다음 문자로 증가
				
				System.out.print(arr[row][col] + " "); // 저장된 알파벳 출력
			}
			System.out.println();
		}
	}
	
	
	
	public void ex4() {
		
	}
	
	
	
	public void ex5() {
		
	}
	
	

}
