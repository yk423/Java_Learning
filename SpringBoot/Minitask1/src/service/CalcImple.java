package service;

public class CalcImple implements Calc{
	@Override
	public int sumOf(int num1, int num2) {
		int summary = 0;
		
		System.out.println("1つ目の数字 to 2つ目の数字になるまで加算します(同じ場合は、通常通り加算します)");
		System.out.println("ex1) 3 5 -> 3 + 4 + 5 を計算");
		System.out.println("ex2) 2 2 -> 2 + 2     を計算");
		
		if(num1 == num2) {
			drawLine();
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
		
		drawLine();
		
		return summary;
	}
	
	void drawLine() {
		System.out.print("----------------------------------------\n結果 : ");
	}
}
