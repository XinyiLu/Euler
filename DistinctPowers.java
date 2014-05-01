import java.util.HashSet;


public class DistinctPowers {

	public int getNumberofDistinctTerms(int uppera,int lowera,int upperb,int lowerb){
		HashSet<Integer> visited=new HashSet<Integer>();
		int sum=0;
		for(int a=lowera;a<=uppera;a++){
			if(visited.contains(a)){
				continue;
			}
			int exp=1;
			int number=(int) Math.pow(a,exp);
			HashSet<Integer> subset=new HashSet<Integer>();
			for(;number<=uppera;exp++){
				visited.add(number);
				for(int b=lowerb;b<=upperb;b++){
					subset.add(b*exp);
				}
				number=(int) Math.pow(a,exp+1);
			}
			
			sum+=subset.size();
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		DistinctPowers oper=new DistinctPowers();
		System.out.println(oper.getNumberofDistinctTerms(100, 2, 100, 2));
	}
}
