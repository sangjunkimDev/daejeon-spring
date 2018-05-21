package kr.or.ddit.spring.bean.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//S : 원본 타입 (String)
//T : 변경 타입 (java.util.Date)
public class CustomDateEditor implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		//source : 2018-05-21 --> Date date
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
