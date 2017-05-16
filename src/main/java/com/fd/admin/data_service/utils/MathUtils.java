package com.fd.admin.data_service.utils;

/**
 * 
 * @author Muguruza
 *
 */
public interface MathUtils {

	default boolean isPrime(long l) {
		long sqrt = (long) Math.sqrt(l) + 1;

		if (l == 2 || l == 3) {
			return true;
		}
		if (l % 2 == 0) {
			return false;
		}

		for (int i = 3; i < sqrt; i += 2) {
			if (l % i == 0) {
				return false;
			}
		}

		return true;
	}

}
