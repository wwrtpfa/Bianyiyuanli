package aaaa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
public class Main {

		// TODO Auto-generated method stub
		static boolean flag;
		static String s;
		static Map<Character, Integer>vn=new HashMap<>();
		static Map<Character, Integer>vt=new HashMap<>();
		static Stack<Character>stack=new Stack<Character>();
		static Stack<Character>string=new Stack<Character>();
		static String  fir[][]= {
				{"","","AT","","AT",""},
				{"","","BU","","BU",""},
				{"+AT","","","$","","$"},
				{"$","*BU","","$","","$"},
				{"","","(S)","","m",""}
				};
		public static void inital() {
			vn.put('S', 1);
			vn.put('A', 2);
			vn.put('T', 3);
			vn.put('U', 4);
			vn.put('B', 5);
			vt.put('+', 1);
			vt.put('*', 2);
			vt.put('(', 3);
			vt.put(')', 4);
			vt.put('m', 5);
			vt.put('#', 6);
			flag=true;
		}
		public static void start() {
			while(! stack.isEmpty())
				stack.pop();
			while(! string.isEmpty())
				string.pop();
			System.out.print("输入：");
			Scanner sc=new Scanner(System.in);
			s=sc.nextLine();
			System.out.print("step\tstack\t\tstring\t\trule\n");
			ann();
			System.out.print("\n\nthe annli is finish! \n\n");
			sc.close();
		}
		public static void ann(){
			int len=0,count=0;
			char stack_top,string_top;
			stack.push('#');
			stack.push('S');
			for(len=s.length()-1;len>=0;len--)
				string.push(s.charAt(len));
			while((++count)!=0) {
				System.out.print(count+"\t");
				output_stackt();
				if(stack.empty()) {
					System.out.print("报错\nerror---the stack is empty\n");
					flag=false;
					break;
				}
				if(string.empty()) {
					System.out.print("报错\nerror---the string is empty\n");
					flag=false;
					break;
				}
				stack_top=(char)stack.peek();
				stack.pop();
				string_top=(char)string.peek();
				if(vt.containsKey(stack_top)&&stack_top!='#') {
					if(stack_top==string_top) {
						System.out.println("'"+stack_top+"'匹配");
						string.pop();
						continue;
					}else {
						System.out.print("报错\nerror---stack_top!=string_top\n");
						flag=false;
						break;
				}
			}
			if(stack_top=='#') {
				if(stack_top==string_top) {
					System.out.print("接受");
					break;
				}else {
					System.out.print("报错\nerror---stack_top=='#',but stack_top!=string_top\n");
					flag=false;
					break;
				}
			}else {
				if(vn.containsKey(stack_top)&&vt.containsKey(string_top)) {
					s=fir[vn.get(stack_top)-1][vt.get(string_top)-1];
					if(s!="") {
						if(s!="$") 
							for(len=s.length()-1;len>=0;len--)
								stack.push(s.charAt(len));
							System.out.println(stack_top+"->"+s);
						}else {
							System.out.print("报错\nerror---fir[vn[stack_top]-1][vt[string_top]-1]is null! \n");
							flag=false;
							break;
						}
					}else {
						System.out.print("报错\nerror---vn[stack_top]==0 || vt[string_top]==0\n");
						flag=false;
						break;
					}
				}
			}
		}
		public static void output_stackt() {
			int n;
			s="";
			while(!stack.empty()) {
				s+=stack.peek();
				stack.pop();
			}
			n=0;
			for(n=s.length()-1;n>=0;n--) {
				stack.push(s.charAt(n));
				System.out.print(s.charAt(n));
			}
			System.out.print("\t\t");
			s="";
			while(!string.empty()) {
				s+=string.peek();
				string.pop();
			}
			System.out.print(s+"\t\t");
			n=0;
			for(n=s.length()-1;n>=0;n--)
				string.push(s.charAt(n));
		}
		public static void main(String [] args) {
			inital();
			start();
			if(flag==true)
				System.out.println("合法。");
			else
				System.out.println("不合法。");
		}
}
