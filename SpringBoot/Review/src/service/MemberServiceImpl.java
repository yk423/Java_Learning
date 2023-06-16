package service;

import java.util.ArrayList;

import entity.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public String greet(int i) {
		String[] greetings = {"Good morning", "Hello", "Good evening"};
		
		return greetings[i];
	}

	@Override
	public ArrayList<Member> getAll() {
		ArrayList<Member> list = new ArrayList<>();
		
		Member mem1 = new Member(1, "Linda", "linda@example.com");
		Member mem2 = new Member(2, "James", "james@example.com");
		
		list.add(mem1);
		list.add(mem2);
		
		return list;
	}
	
	@Override
	public int sumOf(int num1, int num2) {
		int summary = 0;
		
		System.out.println("1つ目の数字 to 2つ目の数字になるまで加算します(同じ場合は、通常通り加算します)");
		System.out.println("ex1) 3, 5 -> 3 + 4 + 5 を計算");
		System.out.println("ex2) 2, 2 -> 2 + 2 を計算");
		System.out.print("----------------------------------------\n結果:");
		
		if(num1 == num2) {
			summary = num1 + num2;
			return summary;
			
		}else if(num1 > num2) {
			System.out.println("1個目の値:" + num1 + "> 2個目の値:" + num2 + "となりましたので、以下のように計算します");
			System.out.println(num2 + " to " + num1);
			
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		for (int sumCnt = num1; sumCnt <= num2; sumCnt++) {
			summary += sumCnt;
		}
		
		return summary;
	}
}
