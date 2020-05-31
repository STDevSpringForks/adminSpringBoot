package com.fd.mvc.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

/**
 * <p>This is an example with interface Serializable</p>
 * <p>The class "SerializableGeneralSearchCriteria" it's inserting in DB as byte[]
 * 	for this reason is implementing Serializable interface.
 * </p>
 * <b>Note:</b>
 * <ul>
 *   <li><a href="http://chuwiki.chuidiang.org/index.php?title=Serializaci%C3%B3n_de_objetos_en_java">Serializable</a></li>
 * </ul>
 */
@Data
public class SerializableGeneralSearchCriteria implements Serializable {

	private static final long serialVersionUID = 7720959752073547228L;
	
	private String search;
	private String browser;
	private transient String version;
	private String user;
	private transient LocalDate dateSearched;
	private transient LocalTime timeSearched;
	private Locale locale;

}
