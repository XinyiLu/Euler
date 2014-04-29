import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


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
	
	public int smallestMultiple(int limit){
		int sum=1;
		ArrayList<Integer> divisors=new ArrayList<Integer>();
		for(int i=2;i<=limit;i++){
			for(int j=0;j<divisors.size();j++){
				int div=divisors.get(j);
				if(i%div==0){
					divisors.remove((Object)div);
				}
			}
			divisors.add(i);
		}
		
		for(int i=2;i<limit;i++){
			boolean hasInt=false;
			for(int j=0;j<divisors.size();j++){
				if(divisors.get(j)%i==0){
					hasInt=true;
					divisors.set(j,divisors.get(j)/i);
				}
			}
			
			if(hasInt){
				sum*=i;
				i--;
			}
		}
		
		return sum;
	}
	
	long sumOfSquares(int limit){
		long sum=0;
		for(int i=1;i<=limit;i++){
			sum+=i*i;
		}
		return sum;
	}
	
	long sumOfNumbers(int limit){
		long sum=0;
		for(int i=1;i<=limit;i++){
			sum+=i;
		}
		return sum;
	}
	
	long diffOfSquares(int limit){
		long sum=sumOfNumbers(limit);
		return sum*sum-sumOfSquares(limit);
	}
	
	long findKthPrime(int k){
		int count=0;
		int number=2;
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(count<k){
			boolean isPrime=false;
			while(!isPrime){
				int i=0;
				for(;i<list.size();i++){
					int div=list.get(i);
					if(number%div==0){
						break;
					}
				}
				if(i==list.size()){
					isPrime=true;
				}else{
					number++;
				}
			}
			list.add(number);
			count++;
			number++;
		}
		
		return number-1;
	}
	
	int greatestProductOfConsecutiveDigits(int[][] mat,int k){
		int row=mat.length,col=mat[0].length;
		int product=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<=col-k;j++){
				int temp=1;
				for(int num=0;num<k;num++){
					temp*=mat[i][j+num];
					product=Math.max(product,temp);
				}
			}
		}
		
		for(int j=0;j<col;j++){
			for(int i=0;i<=row-k;i++){
				int temp=1;
				for(int num=0;num<k;num++){
					temp*=mat[i+num][j];
					product=Math.max(product,temp);
				}
			}
		}
		
		return product;
	}
	
	
	int[][] convertToIntMatrix(String[] segments){
		int[][] mat=new int[segments.length][segments[0].length()];
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				mat[i][j]=segments[i].charAt(j)-'0';
			}
		}
		return mat;
	}
	
	int productOfTriplet(int sum){
		int a,b,c;
		for(b=290;b<500;b++){
			long dividend=500000-1000*b;
			long divisor=1000-b;
			if(dividend%divisor!=0)
				continue;
			a=(int)(dividend/divisor);
			c=1000-a-b;
			if(a<b&&b<c){
				return a*b*c;
			}
		}
		return 0;
	}
	
	long sumOfPrimes(long limit){
		long sum=0;
		long number=2;
		ArrayList<Long> list=new ArrayList<Long>();
		while(number<limit){
			boolean isPrime=true;
			for(Long div:list){
				if(number%div==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				sum+=number;
				list.add(number);
			}
			number++;
		}
		
		return sum;
	}
	
	int largestProductInGrid(int[][] mat,int k){
		int row=mat.length,col=mat[0].length;
		int product=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<=col-k;j++){
				int temp=1;
				for(int num=0;num<k;num++){
					temp*=mat[i][j+num];
					if(product<temp){
						product=temp;
					}
				}
			}
		}
		
		for(int j=0;j<col;j++){
			for(int i=0;i<=row-k;i++){
				int temp=1;
				for(int num=0;num<k;num++){
					temp*=mat[i+num][j];
					if(product<temp){
						product=temp;
					}
				}
			}
		}
		
		for(int i=0;i<=row-1;i++){
			for(int j=0;j<=col-i-k;j++){
				int temp=1;
				for(int num=0;num<k;num++){
					temp*=mat[i+j+num][j+num];
				}
				if(product<temp)
					product=temp;
			}
		}
		
		for(int i=0;i<=row-1;i++){
			for(int j=col-1;j>=i+k-1;j--){
				int temp=1;
				for(int num=0;num<k;num++){
					temp*=mat[i+col-1-j+num][j-num];
				}
				if(product<temp)
					product=temp;
			}
		}
		
		for(int j=1;j<=col-1;j++){
			for(int i=0;i<=row-j-k;i++){
				int temp=1;
				for(int num=0;num<k;num++){
					temp*=mat[i+num][i+j+num];
				}
				if(product<temp)
					product=temp;
			}
		}
		
		for(int j=col-2;j>=0;j--){
			for(int i=0;i<=j-k+1;i++){
				int temp=1;
				for(int num=0;num<k;num++){
					temp*=mat[i+num][j-i-num];
					
				}
				if(product<temp)
					product=temp;
			}
		}
		
		return product;
	}

	int[][] covertToGrid(String[] strs){
		int col=strs[0].split(" ").length,row=strs.length;
		int[][] mat=new int[row][col];
		for(int i=0;i<row;i++){
			String[] segs=strs[i].split(" ");
			for(int j=0;j<col;j++){
				mat[i][j]=Integer.parseInt(segs[j]);
			}
		}
		return mat;
	}
	
	
	long firstTriangleNumber(int numOfdivs){
		long number=1;
		long index=2;
		HashMap<Long,HashSet<Long>> map=new HashMap<Long,HashSet<Long>>();
		while(numberOfDivisors(map,number)<=numOfdivs){
			number+=index;
			index++;
		}
		
		return number;
	}
	
	
	int numberOfDivisors(HashMap<Long,HashSet<Long>> map,long number){
		HashSet<Long> newSet=new HashSet<Long>();
		
		for(long i=2;i<=number/2;i++){
			if(number%i==0){
				if(!map.containsKey(i)){
					numberOfDivisors(map,i);
				}
				if(!map.containsKey(number/i)){
					numberOfDivisors(map,number/i);
				}
				HashSet<Long> set1=map.get(i);
				HashSet<Long> set2=map.get(number/i);
				
				for(Long i1:set1){
					for(Long i2:set2){
						newSet.add(i1*i2);
					}
				}
				newSet.addAll(set1);
				newSet.addAll(set2);
				break;
			}
		}
		
		newSet.add((long)1);
		newSet.add((long)number);
		map.put(number,newSet);
		return newSet.size();
	}
	
	
	List<Integer> sumOfDigits(int mat[][],int k){
		ArrayList<Integer> list=new ArrayList<Integer>();
		int row=mat.length,col=mat[0].length;
		int advance=0;
		for(int index=col-1;index>=0;index--){
			int sum=advance;
			for(int i=0;i<row;i++){
				sum+=mat[i][index];
			}
			advance=sum/10;
			list.add(0,sum%10);
		}
		
		while(advance>0){
			list.add(0,advance%10);
			advance/=10;
		}
		return list.subList(0, k);
	}
	
	
	
	long getStartOfLongestCollatz(long limit){
		HashMap<Long,Long> map=new HashMap<Long,Long>();
		long chain=1,result=1;
		map.put((long)1,(long)1);
		for(long number=limit-1;number>=1;number--){
			long temp=getStartOfLongestCollatzHelper(map,number);
			if(temp>chain){
				chain=temp;
				result=number;
			}
		}
		
		return result;
	}
	
	
	
	long getStartOfLongestCollatzHelper(HashMap<Long,Long> map,long number){
		if(map.containsKey(number)){
			return map.get(number);
		}
		
		long result=1;
		if(number%2==0){
			result+=getStartOfLongestCollatzHelper(map,number/2);
		}else{
			result+=getStartOfLongestCollatzHelper(map,3*number+1);
		}
		map.put(number,result);
		return result;
	}
	
	public long routesInGrid(int m,int n){
		long mat[][]=new long[m+1][n+1];
		for(int i=0;i<=m;i++){
			mat[i][0]=1;
		}
		for(int j=1;j<=n;j++){
			mat[0][j]=1;
		}
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				mat[i][j]=mat[i-1][j]+mat[i][j-1];
			}
			
		}
		return mat[m][n];
	}
	
	String Pow(String base,int exp){
		
		if(exp==0||base.equals("1"))
			return "1";
		
		String str=(exp%2==0)?"1":base;
		
		str=multiply(str,Pow(multiply(base,base),exp/2));
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
	
	public long addAllDigitsInString(String str){
		long sum=0;
		for(int i=0;i<str.length();i++){
			sum+=str.charAt(i)-'0';
		}
		return sum;
	}
	

	
	
	public static void main(String[] args){
		IntegerOperation oper=new IntegerOperation();
		//System.out.println(oper.addAllDigitsInString(oper.Pow("2",1000)));
		
	}
	
	
}

