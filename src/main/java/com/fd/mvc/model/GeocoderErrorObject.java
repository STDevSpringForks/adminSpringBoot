package com.fd.mvc.model;

/**
 * Simple record to hold geocoding error information.
 */
public record GeocoderErrorObject(int id, String formatAddress, String errorMessage) {}
