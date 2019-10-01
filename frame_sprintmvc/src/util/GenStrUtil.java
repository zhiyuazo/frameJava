package util;

import java.util.Random;

public class GenStrUtil {
	
	public static String get(int n ) {
		StringBuffer  pool = new StringBuffer();
		
		for(char c= 'a' ; c < 'z' ; c++) {
			pool.append(c);
		}
		for(char c= 'A' ; c < 'Z' ; c++) {
			pool.append(c);
		}
		for(short c= 0 ; c < 10  ; c++) {
			pool.append(c);
		}
		
		Random rd = new Random();
		char[] res = new char[n];
		for(int i=0; i< n ; i++ ) {
			res[i] = pool.toString().charAt(rd.nextInt(pool.toString().length()));
		}
		return new String(res);
	}
}
