package com.fd.mvc.model;


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
public class SerializableGeneralSearchCriteria implements Serializable {

	private static final long serialVersionUID = 7720959752073547228L;
	
	private String search;
	private String browser;
	private transient String version;
	private String user;
	private transient LocalDate dateSearched;
	private transient LocalTime timeSearched;
	private Locale locale;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public transient String getVersion() {
        return version;
    }

    public void setVersion(transient String version) {
        this.version = version;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public transient LocalDate getDateSearched() {
        return dateSearched;
    }

    public void setDateSearched(transient LocalDate dateSearched) {
        this.dateSearched = dateSearched;
    }

    public transient LocalTime getTimeSearched() {
        return timeSearched;
    }

    public void setTimeSearched(transient LocalTime timeSearched) {
        this.timeSearched = timeSearched;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
