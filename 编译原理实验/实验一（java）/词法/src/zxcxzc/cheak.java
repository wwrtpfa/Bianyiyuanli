package zxcxzc;

public class cheak extends Main {  						
	public static int cheakName(char []a,int i){		//�ж�Name�Ƿ�Ϸ�
		name = "";
		while(a[i] != '='){
			name += a[i];
			i++;
		}
		name = name.trim();
		String regex = "[a-zA-Z_][a-zA-Z0-9]*";
		boolean result = name.matches(regex);			//�ж�result���ַ����Ƿ�ƥ�������������ʽregex;
		if(result){
			correctName = 1;
		}
		else{
			correctName = 0;
		}
		return i;
	}
public static int cheakType(char []a,int i){		//�ж������Ƿ�Ϸ�
		value = "";
		errorInfo = "";
		errorInfo = "";
		//System.out.println(i);
		int a1;
		if(a[i]=='"'){
			a1=i;
			while(a[i+1]!='"'){
				i++;
			}
			i++;
			//System.out.println("other"+i);
			//System.out.println(a[i]);
			int j;
			for(j=a1;j<=i;j++){
				//System.out.print(" "+a[j]);
			value+=a[j];
			}
			i++;
			//System.out.println(i);
		}
		else {
			while(a[i] != ','&&a[i] != ';'){
			value += a[i];
			i++;
		}
		}
		value = value.trim();
		if(correctName == 1){	
			//���ƺϷ� �����ж���һ��
			if(value.matches("[+|-]?[0-9]*")){
				
			String s1=value;
			if(value.charAt(0)=='='||value.charAt(0)=='-'){
				s1=value.substring(1);
			}
			if(s1.equals("0")||s1.matches("[1-9][0-9]*")){
				
				correctValue=1;
				type="integer";
				int_num++;
				
			}
			else{
				errorInfo="wrong!the integer can't be start with '0' ";
				correctValue=0;
			}
			}
			
			else if(value.matches("[+|-]?[0-9]*[.][0-9]+")||value.matches("[+|-]?[0-9]*[.][0-9]+e[+|-]?[0-9]*")){	
				correctValue=1;
				type="float";
				float_num++;
				
						}
			else if(value.startsWith("'")&&value.endsWith("'")){
				
					//�ж��Ƿ���char��
				if(value.length()==3){
				correctValue=1;
				type="char";
				char_num++;
			}
			else{
				errorInfo+="wrong!there are more thon one ''. ";
				correctValue=0;
			}
			}
			else if(value.startsWith("\"")&&value.endsWith("\"")){			//�ж��Ƿ���String��
				correctValue=1;
				type="string";
				string_num++;
			}
			else {
					errorInfo+="wrong!the format of the string is not correct! ";
					correctValue=0;
				}
		}	
		
		return i;
	
}

	public static void Output(String s){
		char[] str = s.toCharArray();
		int i = 5;
		while(i < str.length-1){
			i = cheakName(str,i);
			i = cheakType(str,i+1)+1;
			//�ж����ͺ�ֵ��������ȷ֮�� �ж�ֵ
			if(correctName == 1){
				if(correctValue==1){
					
				System.out.println(name+"("+type+","+value+")");
			}
			else{
				System.out.println(name+"("+errorInfo+")");
			}
		}
			else{
				System.out.println(name+"("+"wromg!it is not a identifier!"+")");
			}
		}
		System.out.println("int_num = "+int_num+"; char_num = "+char_num+"; string_num = "+string_num+";float_num = "+float_num+".");
	}
	}
	



