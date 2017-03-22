package com.fd.admin.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Muguruza info:
 *         https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 *         info:
 *         https://docs.oracle.com/javase/tutorial/datetime/iso/format.html
 * 
 */
public class ContactForm implements Serializable {

    private static final long serialVersionUID = 6264467729654829602L;
    private String fullName;
    private String email;
    private String comment;
    private String zoneId;
    private Map<String, String> zoneIdsList;

    public ContactForm() {
        this.zoneIdsList = new LinkedHashMap<String, String>();
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList<String>(allZones);
        Collections.sort(zoneList);

        for (String s : zoneList) {
            ZoneId zone = ZoneId.of(s);
            LocalDateTime dt = LocalDateTime.now(zone);
            ZonedDateTime zdt = dt.atZone(zone);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
            String out = zdt.format(format);
            zoneIdsList.put(zone.getId(), String.format("%s (%s)%n", out, zone));
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public Map<String, String> getZoneIdsList() {
        return zoneIdsList;
    }

    public void setZoneIdsList(Map<String, String> zoneIdsList) {
        this.zoneIdsList = zoneIdsList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ContactForm [fullName=");
        builder.append(fullName);
        builder.append(", email=");
        builder.append(email);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", zoneId=");
        builder.append(zoneId);
        builder.append(", zoneIdsList=");
        builder.append(zoneIdsList);
        builder.append("]");
        return builder.toString();
    }

}