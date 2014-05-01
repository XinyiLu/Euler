
public class Diagonal {
	long getSumOfNumbersOnDiagonalHelper(int n,int[] mat,int[] count){
		if(n==1){
			for(int i=0;i<4;i++){
				mat[i]=1;
			}
			count[0]=1;
			return 1;
		}
		
		
		long sum=getSumOfNumbersOnDiagonalHelper(n-1,mat,count);
		for(int i=0;i<4;i++){
			int temp=mat[i]+2*count[0];
			mat[i]=temp;
			sum+=temp;
			count[0]++;
		}
		
		return sum;
	}
	
	long getSumOfNumbersOnDianogal(int n){
		int[] mat=new int[4];
		int[] count={0};
		return getSumOfNumbersOnDiagonalHelper(n/2+1,mat,count);
	}
	
	public static void main(String[] args){
		Diagonal oper=new Diagonal();
		System.out.println(oper.getSumOfNumbersOnDianogal(1001));
	}
}
