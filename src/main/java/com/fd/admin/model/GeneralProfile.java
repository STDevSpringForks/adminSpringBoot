package com.fd.admin.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Muguruza
 *
 */
public class GeneralProfile implements Serializable {

    private static final long serialVersionUID = -6478508103043483094L;
    private String firstName;
    private String lastName;
    private String sexo;
    private LinkedHashMap<String, String> countryOptions;
    private String country;
    private String equipo;
    private String[] checkSO;

    public GeneralProfile() {
        this.countryOptions = new LinkedHashMap<String, String>();
        this.countryOptions.put("MX", "México");
        this.countryOptions.put("BR", "Brazil");
        this.countryOptions.put("US", "Estados Unidos");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Map<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String[] getCheckSO() {
        return checkSO;
    }

    public void setCheckSO(String[] checkSO) {
        this.checkSO = checkSO;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GeneralProfile [firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", sexo=");
        builder.append(sexo);
        builder.append(", countryOptions=");
        builder.append(countryOptions);
        builder.append(", country=");
        builder.append(country);
        builder.append(", equipo=");
        builder.append(equipo);
        builder.append(", checkSO=");
        builder.append(checkSO);
        builder.append("]");
        return builder.toString();
    }

}
