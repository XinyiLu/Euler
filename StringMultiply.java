
public class StringMultiply {
	
	String Pow(String base,int exp){
		
		if(exp==0||base.equals("1"))
			return "1";
		
		String str=(exp%2==0)?"1":base;
		
		str=multiply(str,Pow(multiply(base,base),exp/2));
		return str;
	}

	String getFactorial(int number){
		String str="1";
		for(int i=1;i<=number;i++){
			str=multiply(str,Integer.toString(i));
		}
		return str;
	}
	
	String multiply(String str1,String str2){
		if(str1.equals("1")||str2.equals("1")){
			return str1.equals("1")?str2:str1;
		}
		
		if(str2.length()>str1.length()){
			String tempStr=str2;
			str2=str1;
			str1=tempStr;
		}
		String str="0";
		for(int k=str2.length()-1;k>=0;k--){
			str=addString(str,multiplyHelper(str1,str2.charAt(k)-'0',str2.length()-1-k));
		}
		return str;
	}
	
	String multiplyHelper(String str1,int digit,int zeros){
		if(digit==1){
			for(int i=0;i<zeros;i++){
				str1+="0";
			}
			return str1;
		}
		if(digit==0||str1.equals("0")){
			return "0";
		}
		String str="";
		int advance=0;
		for(int i=str1.length()-1;i>=0;i--){
			int temp=(str1.charAt(i)-'0')*digit+advance;
			advance=temp/10;
			str=Integer.toString(temp%10)+str;
		}
		
		while(advance>0){
			str=Integer.toString(advance%10)+str;
			advance/=10;
		}
		
		for(int i=0;i<zeros;i++){
			str+="0";
		}
		return str;
	}

	String addString(String str1,String str2){
		if(str1.equals("0")||str2.equals("0")){
			return str1.equals("0")?str2:str1;
		}
		String str="";
		int advance=0;
		int i=str1.length()-1,j=str2.length()-1;
		while(i>=0&&j>=0){
			int temp=str1.charAt(i)+str2.charAt(j)-2*'0'+advance;
			advance=temp/10;
			str=Integer.toString(temp%10)+str;
			i--;
			j--;
		}
		
		if(i>=0||j>=0){
			String str3=(i>=0)?str1.substring(0,i+1):str2.substring(0,j+1);
			for(int k=str3.length()-1;k>=0;k--){
				int temp=str3.charAt(k)-'0'+advance;
				advance=temp/10;
				str=Integer.toString(temp%10)+str;
			}
		}
		
		while(advance>0){
			str=Integer.toString(advance%10)+str;
			advance/=10;
		}
		return str;
	}
	
	public static void main(String[] args){
		StringMultiply oper=new StringMultiply();
		IntegerOperation intOper=new IntegerOperation();
		System.out.println(intOper.addAllDigitsInString(oper.getFactorial(100)));
	}
}
