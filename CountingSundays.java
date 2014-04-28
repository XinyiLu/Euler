
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class CountingSundays {
	
	HashSet<Integer> thirtySet;
	HashSet<Integer> thirtyOneSet;
	
	enum WeekDay{
		Monday(0),
		Tuesday(1),
		Wednesday(2),
		Thursday(3),
		Friday(4),
		Saturday(5),
		Sunday(6);
		private int value;
		WeekDay(int v){
			this.value=v;
		}
	};
	
	public CountingSundays(){
		thirtySet=new HashSet<Integer>();
		thirtyOneSet=new HashSet<Integer>();
		Integer thirties[]=new Integer[]{9,4,6,11};
		thirtySet.addAll((List<Integer>)Arrays.asList(thirties));
		for(int i=1;i<=12;i++){
			if(i!=2&&!thirtySet.contains(i)){
				thirtyOneSet.add(i);
			}
		}
	}
	
	boolean isFebruary29(int year){
		if(year%4==0&&(year%100!=0||year%400==0)){
			return true;
		}
		return false;
	}
	
	//get the weekday of the first day of next month
	WeekDay getFirstDayOfMonth(int year,int month,WeekDay weekday){
		int daysInMonth=28;
		if(thirtySet.contains(month)){
			daysInMonth=30;
		}else if(thirtyOneSet.contains(month)){
			daysInMonth=31;
		}else if(isFebruary29(year)){
			daysInMonth=29;
		}
		return WeekDay.values()[(weekday.value+daysInMonth)%7];
	}
	
	
	WeekDay getFirstDayOfNextYear(int year,WeekDay weekday){
		for(int i=1;i<=12;i++){
			weekday=getFirstDayOfMonth(year,i,weekday);
		}
		return weekday;
	}
	
	int sundaysFirstOfMonth(int startYear,int endYear,WeekDay weekday){
		int sum=0;
		for(int year=startYear;year<=endYear;year++){
			for(int month=1;month<=12;month++){
				if(weekday==WeekDay.Sunday){
					sum++;
				}
				weekday=getFirstDayOfMonth(year,month,weekday);
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		CountingSundays sol=new CountingSundays();
		System.out.println(sol.sundaysFirstOfMonth(1901, 2000, sol.getFirstDayOfNextYear(1900,WeekDay.Monday)));
	}
}



















