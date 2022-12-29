package info.controller;

import java.util.ArrayList;
import java.util.Scanner;

import info.view.StudentView;
import info.vo.SchoolInfo;
import info.vo.StudentDAO;
import info.vo.StudentVO;

public class StudentInfoController {
	public static final int CONTINUE = 1;
	public static final int EXIT = 0;
	
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> stuIds = new ArrayList<Integer>();
		ArrayList<Integer> grades = new ArrayList<Integer>();
		ArrayList<String> majors = new ArrayList<String>();
		ArrayList<String> mobiles = new ArrayList<String>();
		ArrayList<String> addresses = new ArrayList<String>();
		
		Scanner s1 = new Scanner(System.in);  // 문자열 입력용
		Scanner s2 = new Scanner(System.in);  // 정수값 입력용
		
		int flag = CONTINUE;
		System.out.println("========       학생 정보 입력 화면       ========");
		while (true) {
			if(flag == CONTINUE) {
				System.out.print("== 성명: ");
				names.add(s1.nextLine());
				System.out.print("== 학번: ");
				stuIds.add(s2.nextInt());
				System.out.print("== 학년: ");
				grades.add(s2.nextInt());
				System.out.print("== 전공: ");
				majors.add(s1.nextLine());
				System.out.print("== 전화: ");
				mobiles.add(s1.nextLine());
				System.out.print("== 주소: ");
				addresses.add(s1.nextLine());
			}else if(flag == EXIT) {
				break;
			}
			
			System.out.print("계속 입력하시겠습니까?(계속: 1, 종료: 0): ");
			flag = s2.nextInt();
			System.out.println("---------------------------------");
		}
			
		StudentDAO dao = new StudentDAO();
		
		for (int i = 0; i < names.size(); i++) {
			StudentVO svo = new StudentVO(names.get(i), stuIds.get(i), grades.get(i), majors.get(i), mobiles.get(i), addresses.get(i));
			dao.insert(svo);
		}
		

//		화면출력
		StudentView stuView = new StudentView();
		stuView.view(dao.select());
		
		s1.close();
		s2.close();
	}

}
