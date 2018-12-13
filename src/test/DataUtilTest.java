package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		String date7 = "1일전";
		String date8 = "5시간전";
		
		LocalDate ld = LocalDate.parse("2018-12-12",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate rd = LocalDate.parse("2018-12-11",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		LocalDate rd 
		

		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd")));
		
		
		
//		System.out.println(ld.compareTo(rd));
//		
//		boolean flag = false;
//		
//		if(date1.length() < 10 && date1.matches(".*[��-����-�Ӱ�-�R]+.*")){
//			System.out.println("type = 1일전 ");
//		}else if(date1.length() < 10 && date1.matches(".*:.*")){
//			System.out.println("type = 00:02:05");
//		}else{
//			// ��¥�� �Լ� ����
//
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd",Locale.KOREA);
//			Pattern dp = Pattern.compile(pattern);
//			Matcher dm = dp.matcher(date1);
//		
//			while(dm.find()){sb.append(dm.group(0).replaceAll("(\\.|\\/|\\-)", "-"));}
//				if(sb.toString().indexOf('-')+1 == 3 && sb.length() >= 8){
//					sb.insert(0, "20");
//				}else if(sb.length() < 6){
//					// mm-dd Ÿ�� 
//					sb.insert(0, "2018-");
//				}
////				LocalDate ld = LocalDate.parse(sb.toString());
//				System.out.println(ld);
//		}
//		sb.setLength(0);
		
		
		
		
	
	}
}
