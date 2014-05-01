import java.util.HashMap;


public class Fractions {
	int getLengthOfRecurringCycle(int divisor){
		int remain=1;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int index=0;
		while(remain>0){
			if(map.containsKey(remain)){
				break;
			}
			map.put(remain,index);
			while(remain<divisor){
				remain*=10;
				index++;
			}
			remain=remain%divisor;
			
		}
		
		if(remain==0)
			return 0;
		return index-map.get(remain);
	}
	
	
	int findNumeratorWithLongestRecurringCycle(int limit){
		int len=0;
		int number=1;
		for(int i=2;i<limit;i++){
			int temp=getLengthOfRecurringCycle(i);
			if(temp>len){
				len=temp;
				number=i;
			}
		}
		return number;
	}
	
	public static void main(String[] args){
		Fractions oper=new Fractions();
		System.out.println(oper.findNumeratorWithLongestRecurringCycle(1000));
	}
}
