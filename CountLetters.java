
public class CountLetters {
	
	public int letterCounts(int min,int max){
		int sum=0;
		for(int number=min;number<=max;number++){
			String str=letterCountsHelper(number);
			//System.out.println(str);
			sum+=str.length();
		}
		return sum;
	}
	
	public String letterCountsHelper(int number){
		String base[]={"zero","one","two","three","four","five","six","seven","eight",
				"nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		
		String tens[]={"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		String hundreds[]={"hundred","thousand"};
		
		String str="";
		if(number<20){
			str=base[number];
		}else if(number<100){
			str=tens[number/10-2];
			number%=10;
			if(number>0){
				str+=letterCountsHelper(number);
			}
		}else if(number<1000){
			str+=letterCountsHelper(number/100)+hundreds[0];
			number%=100;
			if(number>0){
				str+="and"+letterCountsHelper(number);
			}
		}else{
			str+=letterCountsHelper(number/1000)+hundreds[1];
			number%=1000;
			if(number>0){
				str+=letterCountsHelper(number);
			}
		}	
		return str;
	}
	
	public static void main(String[] args){
		CountLetters sol=new CountLetters();
		System.out.println(sol.letterCounts(1, 1000));
	}
}
