import java.util.HashMap;
import java.util.HashSet;


public class AmicablePair {

	class Unit{
		HashSet<Integer> divisorSet;
		int sum;
		
		public Unit(){
			divisorSet=new HashSet<Integer>();
			divisorSet.add(1);
			sum=1;
		}
		
	}	
	
	HashMap<Integer,Unit> map;
	HashSet<Integer> abundantSet; 
	public AmicablePair(){
		map=new HashMap<Integer,Unit>();
		map.put(1,new Unit());
		abundantSet=new HashSet<Integer>();
	}
	
	public Unit getDivisors(int number){
		if(map.containsKey(number)){
			return map.get(number);
		}
		
		Unit unit=new Unit();
		for(int div=2;div<number;div++){
			if(number%div==0){
				Unit unit1=getDivisors(div);
				Unit unit2=getDivisors(number/div);
				for(Integer div1:unit1.divisorSet){
					for(Integer div2:unit2.divisorSet){
						unit.divisorSet.add(div1*div2);
						unit.divisorSet.add(div*div2);
					}
					unit.divisorSet.add((number/div)*div1);
				}
				break;
			}
		}
		
		unit.sum=0;
		for(Integer div:unit.divisorSet){
			unit.sum+=div;
		}
		if(unit.sum>number){
			abundantSet.add(number);
		}
		map.put(number,unit);
		return unit;
	}
		
	public boolean sumOfTwoAbundantNumbers(int number){
		Unit unit=getDivisors(number);
		for(Integer div:abundantSet){
			if(abundantSet.contains(number-div)){
				return true;
			}
		}
		return false;
	}
	
	public long getSumOfNonAbundantNumbers(int limit){
		long sum=0;
		for(int i=1;i<=limit;i++){
			if(!sumOfTwoAbundantNumbers(i)){
				sum+=i;
			}
		}
		return sum;
	}
	
	public int getAmicableSum(int limit){
		HashSet<Integer> set=new HashSet<Integer>();
		for(int number=1;number<limit;number++){
			if(set.contains(number))
				continue;
			Unit unit1=getDivisors(number);
			if(unit1.sum<limit&&unit1.sum!=number){
				Unit unit2=getDivisors(unit1.sum);
				if(unit2.sum==number){
					set.add(number);
					set.add(unit1.sum);
				}
			}
		}
		
		int sum=0;
		for(Integer num:set){
			sum+=num;
		}
		return sum;
	}

	public static void main(String[] args){
		AmicablePair sol=new AmicablePair();
		System.out.println(sol.getSumOfNonAbundantNumbers(28123));
	}
}
