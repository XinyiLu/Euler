
public class NameScores {

	int getStringValue(String word){
		int value=0;
		for(int i=0;i<word.length();i++){
			value+=word.charAt(i)-'A'+1;
		}
		return value;
	}
	
	long getNameScores(String fileName){
		
	}
}
