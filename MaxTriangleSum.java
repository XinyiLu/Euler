import java.util.ArrayList;
import java.util.Scanner;


public class MaxTriangleSum {
	int getMaxTriangleSum(ArrayList<ArrayList<Integer>> triangle){
		if(triangle.size()==0)
			return 0;
		
		ArrayList<Integer> prevList=triangle.get(0);
		for(int i=1;i<triangle.size();i++){
			ArrayList<Integer> curList=triangle.get(i);
			for(int j=1;j<prevList.size();j++){
				curList.set(j,Math.max(prevList.get(j),prevList.get(j-1))+curList.get(j));
			}
			curList.set(0,prevList.get(0)+curList.get(0));
			curList.set(curList.size()-1,prevList.get(prevList.size()-1)+curList.get(curList.size()-1));
			prevList=curList;
		}
		int max=prevList.get(0);
		for(int k=1;k<prevList.size();k++){
			if(prevList.get(k)>max){
				max=prevList.get(k);
			}
		}
		return max;
	}
	
	ArrayList<ArrayList<Integer>> parseToTriangle(ArrayList<String> list){
		ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>>();
		for(String str:list){
			ArrayList<Integer> row=new ArrayList<Integer>();
			String segs[]=str.split(" ");
			for(String seg:segs){
				row.add(Integer.parseInt(seg));
			}
			triangle.add(row);
		}
		
		return triangle;
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		ArrayList<String> list=new ArrayList<String>();
		while(scan.hasNextLine()){
			String line=scan.nextLine();
			if(line.isEmpty())
				break;
			list.add(line);
			System.out.println(line);
			
		}
		MaxTriangleSum sol=new MaxTriangleSum();
		ArrayList<ArrayList<Integer>> triangle=sol.parseToTriangle(list);
		System.out.println(sol.getMaxTriangleSum(triangle));
	}
}
