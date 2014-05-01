import java.util.HashMap;


public class PrimeNumbers {
	
	HashMap<Integer,Boolean> map; 
	
	public PrimeNumbers(){
		map=new HashMap<Integer,Boolean>();
		map.put(1,false);
	}
	
	public boolean isPrime(int number){
		if(number<0)
			return false;
		if(map.containsKey(number))
			return map.get(number);
		
		boolean result=true;
		for(int i=2;i<=number/2;i++){
			if(!map.containsKey(i)){
				isPrime(i);
			}
			if(number%i==0){
				result=false;
				break;
			}
		}
		map.put(number,result);
		return result;
	}
	
	public int getConsecutivePrimeLength(int a,int b){
		int n=0;
		while(isPrime(getQuadratics(a,b,n))){
			n++;
		}
		return n;
	}
	
	public int getQuadratics(int a,int b,int n){
		return n*n+a*n+b;
	}
	
	public int getProductOfParameters(int alimit,int blimit){
		int len=0;
		int product=0;
		for(int b=-blimit;b<blimit;b++){
			for(int a=-alimit;a<alimit;a++){
				int temp=getConsecutivePrimeLength(a,b);
				if(temp>len){
					len=temp;
					product=a*b;
				}
			}
			
		}
		
		return product;
	}
	
	public static void main(String[] args){
		PrimeNumbers sol=new PrimeNumbers();
		System.out.println(sol.getProductOfParameters(1000, 1000));
	}
}















