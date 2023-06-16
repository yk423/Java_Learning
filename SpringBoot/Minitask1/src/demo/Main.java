package demo;

import service.CalcImple;

public class Main {

	public static void main(String[] args) {
		CalcImple service = new CalcImple();
		System.out.println(service.sumOf(1, 5));
	}
}
