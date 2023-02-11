package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // Scanner 생성
		
		System.out.println("[홀짝 검사기]");
		
		System.out.print("정수 하나를 입력해주세요 : ");
		
		int input = sc.nextInt(); // 정수 입력 받기
		
		// 삼항 연산자
		// 조건식 ? true인 경우 : false인 경우
		String result = Math.abs(input) % 2 == 1 ? "홀수 입니다." 
						: input == 0 ? "0입니다." : "짝수입니다."; // 0부터 판별하고 홀짝 판별하면 더 쉬울 듯
		
		System.out.println(result);
		// Math.abs(숫자) ->  절대값
	}
}