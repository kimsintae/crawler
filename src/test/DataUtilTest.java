package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtilTest {

	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String pattern = "^[0-9]{0,4}(\\-|\\/|\\.){0,1}[0-9]{1,2}(\\-|\\/|\\.)[0-9]{1,2}";

		
		String date1 = "2018-12-10 10:40:25";
		String date2 = "18.12.10 09:31:55";
		String date3 = "2018.03.23";
		String date4 = "18/12/10 02:30";
		String date5 = "12-29";
		String date6 = "00:02:05";
		String date7 = "한시간전";
		String date8 = "5분전";
		
		if(date6.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
			System.out.println("한글");
		}else if(date6.matches(".*:.*")){
			System.out.println("시간");
		}else{
			// 날짜비교 함수 동작
			

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd",Locale.KOREA);
			Pattern dp = Pattern.compile(pattern);
			Matcher dm = dp.matcher(date4);
			
		
			while(dm.find()){sb.append(dm.group(0).replaceAll("(\\.|\\/|\\-)", "."));}
			
				if(sb.toString().indexOf('.')+1 == 3 && sb.length() >= 8){
					sb.insert(0, "20");
				}else if(sb.length() < 6){
					// mm-dd 타입 
					sb.insert(0, "2018.");
				}
		
		}
		
		sb.setLength(0);
		
		
		
		
	
	}
}
