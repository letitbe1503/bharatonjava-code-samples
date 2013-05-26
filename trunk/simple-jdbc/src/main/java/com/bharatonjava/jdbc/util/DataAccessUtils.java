package com.bharatonjava.jdbc.util;

import java.util.Collection;

import com.bharatonjava.jdbc.exceptions.EmptyResultsetException;
import com.bharatonjava.jdbc.exceptions.IncorrectResultsetSizeException;

public class DataAccessUtils {

	public static <T> T getSingleResult(Collection<T> results)
			throws EmptyResultsetException {

		int size = (results != null ? results.size() : 0);

		if (size == 0) {
			throw new EmptyResultsetException("Resultset was empty.");
		}

		if (size > 0) {
			throw new IncorrectResultsetSizeException(
					"Resultset returned more than expected records. Expected=1.");
		}

		return results.iterator().next();
	}
}
