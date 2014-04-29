import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class NameScores {

	int getStringValue(String word){
		int value=0;
		for(int i=0;i<word.length();i++){
			value+=word.charAt(i)-'A'+1;
		}
		return value;
	}
	
	String[] getWordsFromLine(String line){
		String[] words=line.split(",");
		for(int i=0;i<words.length;i++){
			words[i]=words[i].substring(1, words[i].length()-1);
		}
		return words;
	}
	long getNameScores(String fileName){
		long sum=0;
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"ISO-8859-1"));
			String line=null;
			ArrayList<String> list=new ArrayList<String>();
			//each time we read a line, count its words
			while((line=reader.readLine())!=null){
				String[] words=getWordsFromLine(line);
				list.addAll(Arrays.asList(words));
			}
			String[] words=(String[])list.toArray(new String[list.size()]);
			Arrays.sort(words);
			for(int i=0;i<words.length;i++){
				sum+=getStringValue(words[i])*(i+1);
			}
			//close the buffered reader
			reader.close();

		}catch(IOException e){
			e.printStackTrace();
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		NameScores sol=new NameScores();
		System.out.println(sol.getNameScores("names.txt"));
	}
}
