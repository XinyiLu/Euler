import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		IntegerOperation oper=new IntegerOperation();

		String[] segments={
				"08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08",
				"49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00",
				"81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65",
				"52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91",
				"22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80",
				"24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50",
				"32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70",
				"67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21",
				"24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72",
				"21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95",
				"78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92",
				"16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57",
				"86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58",
				"19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40",
				"04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66",
				"88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69",
				"04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36",
				"20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16",
				"20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54",
				"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"			
		};
			
		int[][] mat=oper.covertToGrid(segments);
		System.out.println(oper.firstTriangleNumber(500));
	}
}

