package demo;

import service.MemberServiceImpl;

public class Main {

	public static void main(String[] args) {
		MemberServiceImpl service = new MemberServiceImpl();
		
		/*
		System.out.println(service.getAll());
		System.out.println(service.greet(2));
		
		ArrayList<Member> list = service.getAll();
		
		for(Member mem : list) {
			System.out.println(mem.getId() + "," + mem.getName() + "," + mem.getEmail());
		}
		*/
		
		System.out.println(service.sumOf(5, 1));
	}
}
