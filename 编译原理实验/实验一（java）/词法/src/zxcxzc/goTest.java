package zxcxzc;

import java.util.Scanner;

public class goTest extends Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("�����ַ���");
		String s = in.nextLine();
		s = s.trim();      										  //��ȥ�ո�
		boolean result = s.startsWith("const")&&s.endsWith(";");  //��const��ʼ ����β
		while(! result){
			System.out.println("������� �����������ַ���");
			s = in.nextLine();
			s = s.trim();
			result = s.startsWith("const")&&s.endsWith(";");
		}
		cheak.Output(s);
		in.close();
	
	}

}
