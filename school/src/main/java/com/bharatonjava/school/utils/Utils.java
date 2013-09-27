package com.bharatonjava.school.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Utils {

	private static final Log log = LogFactory.getLog(Utils.class);

	public static Date convertStringToDate(String date) {
		log.info("Converting string " + date + " to Date");
		DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
		Date d = null;

		try {
			d = df.parse(date);
		} catch (ParseException pe) {
			log.error("Error while parsing date string " + date
					+ " to date format " + Constants.DATE_FORMAT);
		}

		return d;
	}

	public static String convertDateToString(Date date) {
		log.info("Converting date " + date + " to string");
		DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
		String dateString = df.format(date);
		return dateString;
	}
}
