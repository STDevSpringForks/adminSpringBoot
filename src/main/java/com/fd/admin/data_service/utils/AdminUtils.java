package com.fd.admin.data_service.utils;

import java.util.List;

/**
 * 
 * @author Muguruza
 *
 */
interface AdminUtils {
	
	default String getQuestionMarks(List<?> list){
		StringBuilder sb = new StringBuilder();
		int limit = 100000;
		if (list.size() < limit) {
			for (int a = 1; a <= list.size(); a++) {
				if (a == list.size()) {
					sb.append("?");
				} else {
					sb.append("?,");
				}
			}
		}
		return sb.toString();
	}
	
}
