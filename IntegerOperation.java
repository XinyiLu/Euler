import java.util.ArrayList;


public class IntegerOperation {
	int sumOfThreeAndFive(int limit){
		int sum=0;
		for(int i=1;i<limit;i++){
			if(i%3==0||i%5==0){
				sum+=i;
			}
		}
		return sum;
	}
	
	int sumOfEvenFibNumbers(int limit){
		int sum=0;
		int prev1=1,prev2=2;
		if(limit<3)
			return limit;
		sum+=prev2;
		int cur=prev1+prev2;
		while(cur<limit){
			if(cur%2==0)
				sum+=cur;
			prev1=prev2;
			prev2=cur;
			cur=prev1+prev2;
		}
		return sum;
	}
	
	long largestPrimeFactor(long number){
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=2;i<number;i++){
			boolean isPrime=false;
			for(Integer prime:list){
				if(i%prime==0){
					isPrime=true;
					break;
				}
			}
			if(isPrime)
				continue;
			list.add(i);
			
			if(number%i==0){
				while(number%i==0){
					number=number/i;
				}
				if(number==i)
					return number;
			}
		}
		
		return number;
	}
	
	public int largestPalindrome(int min,int max){
		int largest=min*min;
		for(int i=max;i>=min;i--){
			for(int j=max;j>=min;j--){
				if(isPalindrome(i*j)){
					largest=Math.max(largest,i*j);
				}
			}
		}
		return largest;
	}
	
	public boolean isPalindrome(int number){
		String str=Integer.toString(number);
		int i=0,j=str.length()-1;
		while(i<j){
			if(str.charAt(i)!=str.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args){
		IntegerOperation oper=new IntegerOperation();
		//System.out.println(Long.MAX_VALUE);
		
		System.out.println(oper.largestPalindrome(100, 999));
	}
}

