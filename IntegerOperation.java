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
	
	
	
	public static void main(String[] args){
		IntegerOperation oper=new IntegerOperation();
		/*Scanner input = new Scanner(System.in);
		String strs[]=new String[100];
		int i=0;
        while (input.hasNextLine()) {
        	String str=input.nextLine();
        	if(str.length()<50)
        		break;
            strs[i++]=str;
        }
        int[][] mat=oper.convertToIntMatrix(strs);
        List<Integer> list=oper.sumOfDigits(mat, 10);
		for(Integer it:list){
			System.out.print(it);
		}
		System.out.println();*/
		
		System.out.println(oper.getStartOfLongestCollatz((long)1000000));
		HashMap<Long,Long> map=new HashMap<Long,Long>();
		map.put((long)1,(long)1);
		System.out.println(oper.getStartOfLongestCollatzHelper(map, 13));
	}
}

