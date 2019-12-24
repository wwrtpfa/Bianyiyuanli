package zxcxzc;

import java.util.Scanner;

public class goTest extends Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("输入字符串");
		String s = in.nextLine();
		s = s.trim();      										  //除去空格
		boolean result = s.startsWith("const")&&s.endsWith(";");  //以const开始 ；结尾
		while(! result){
			System.out.println("输入错误 请重新输入字符串");
			s = in.nextLine();
			s = s.trim();
			result = s.startsWith("const")&&s.endsWith(";");
		}
		cheak.Output(s);
		in.close();
	
	}

}
