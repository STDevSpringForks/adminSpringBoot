package com.fd.mvc.admin.data_service_api;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface EmployeeJSON {
	void employeeJSONGenerator() throws FileNotFoundException;
	void employeeJSONParser() throws IOException;
	void employeeJSONReader() throws IOException;
	void employeeJSONWriter() throws FileNotFoundException;
}
