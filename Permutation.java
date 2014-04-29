import java.util.ArrayList;


public class Permutation {
	String getPermutation(int n, int k) {
        ArrayList<Integer> result=new ArrayList<Integer>();
		ArrayList<Integer> factor=new ArrayList<Integer>();
		factor.add(0);
		int f=1;
		for(int i=1;i<n;i++){
			f*=i;
			factor.add(f);
			result.add(i-1);
		}
		result.add(n-1);
		int findex=n-1;
		int index=0;
		k--;
		while(k>0){
			int tempIndex=k/factor.get(findex);
			k=k%factor.get(findex);
			int tempValue=result.get(tempIndex+index);
			result.remove((int)(tempIndex+index));
			result.add(index,tempValue);
			index++;
			findex--;
		}
		String str="";
		for(int i=0;i<result.size();i++){
			str+=Integer.toString(result.get(i));
		}
		
		
		return str;
    }
	
	
	public static void main(String[] args){
		Permutation sol=new Permutation();
		System.out.println(sol.getPermutation(10,1000000));
	}
}
