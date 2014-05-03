import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;



public class Pandigital {
	public static void main(String[] args){
		Pandigital oper=new Pandigital();
		System.out.println(oper.sumOfProducts(new int[]{5}));
	}
	
	public long sumOfProducts(int[] values){
		long sum=0;
		HashSet<Integer> result=new HashSet<Integer>();
		for(int value:values){
			for(int numOfx=2*value-9;numOfx<=value/2;numOfx++){  
				int numOfy=value-numOfx;
				HashSet<Integer> subset=sumOfProductsHelper(numOfx,numOfy);
				result.addAll(subset);
			}
		}
		
		for(Integer n:result){
			sum+=n;
		}
		return sum;
	}
	
	public ArrayList<Integer> repeated(ArrayList<Integer> list,int num,int x,int y){
		HashSet<Integer> set=new HashSet<Integer>();
		ArrayList<Integer> result=new ArrayList<Integer>(list);
		for(int i=num-1;i>=0;i--){
			int exp=(int)Math.pow(10,i);
			set.add(x/exp);
			result.remove((Object)(x/exp));
			x%=exp;
		}
		
		for(int i=num-1;i>=0;i--){
			int exp=(int)Math.pow(10,i);
			if(set.contains(y/exp)){
				return null;
			}
			result.remove((Object)(y/exp));
			y%=exp;
		}
		return result;
	}
	
	public HashSet<Integer> sumOfProductsHelper(int numOfx,int numOfy){
		long product=0;
		Integer[] num=new Integer[]{1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(num));
		HashSet<Integer> xvalues=getPossibleValues(list,numOfx);
		HashSet<Integer> result=new HashSet<Integer>();
		if(numOfx==numOfy){
			System.out.println(xvalues.size());
			Integer[] values=(Integer[])xvalues.toArray(new Integer[xvalues.size()]);
			for(int x=0;x<values.length-1;x++){
				for(int y=x+1;y<values.length;y++){
					ArrayList<Integer> zlist=repeated(list,numOfx,values[x],values[y]);
					if(zlist==null)
						continue;
					HashSet<Integer> zvalues=getPossibleValues(zlist,9-numOfx*2);
					int tempProduct=values[x]*values[y];
					if(zvalues.contains(tempProduct)){
						result.add(tempProduct);
						System.out.println("x "+values[x]+" y "+values[y]+" z "+tempProduct);
					}
					
				}
			}
			return result;
		}
		
		for(Integer xvalue:xvalues){
			ArrayList<Integer> ylist=new ArrayList<Integer>(list);
			int temp=xvalue;
			for(int i=numOfx-1;i>=0;i--){
				ylist.remove((Object)(temp/(int)Math.pow(10,i)));
				temp%=(int)Math.pow(10,i);
			}
			
			HashSet<Integer> yvalues=getPossibleValues(ylist,numOfy);
			for(Integer yvalue:yvalues){
				temp=yvalue;
				ArrayList<Integer> zlist=new ArrayList<Integer>(ylist);
				for(int j=numOfy-1;j>=0;j--){
					zlist.remove((Object)(temp/(int)Math.pow(10,j)));
					temp%=(int)Math.pow(10,j);
				}
				
				HashSet<Integer> zvalues=getPossibleValues(zlist,9-numOfx-numOfy);
				int tempProduct=xvalue*yvalue;
				if(zvalues.contains(tempProduct)){
					result.add(tempProduct);
				}
			}
		}
		
		return result;
	}
	
	public HashSet<Integer> getPossibleValues(ArrayList<Integer> list,int num){
		HashSet<Integer> set=new HashSet<Integer>();
		if(num==0){
			set.add(0);
			return set;
		}
		
		for(int i=0;i<=list.size()-1;i++){
			ArrayList<Integer> newList=new ArrayList<Integer>(list);
			int temp=newList.get(i);
			newList.remove(i);
			HashSet<Integer> subset=getPossibleValues(newList,num-1);
			for(Integer subvalue:subset){
				set.add(subvalue+(int)Math.pow(10,num-1)*temp);
			}
		}
		return set;
	}
	
}
