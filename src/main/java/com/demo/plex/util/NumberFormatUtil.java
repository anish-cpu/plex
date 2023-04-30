package com.demo.plex.util;

import java.text.DecimalFormat;

public class NumberFormatUtil {
	
	private  NumberFormatUtil() {
		
	}
	
	public static Double truncateToTwoDecimalPlaces(Double decimal) {
		return Double.valueOf(new DecimalFormat("#.##").format(decimal));
	}

}
