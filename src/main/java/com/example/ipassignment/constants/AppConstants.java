package com.example.ipassignment.constants;

public class AppConstants {
    public final static String IP_ACCEPTED_COUNTRY_KEY = "ip-country-accepted";
    public final static String USER_WELCOME_MESSAGE = "Hi %s, Welcome to %s";
    public static final String IP_API_URL_KEY = "ip-api-url";
    public static final String USER_NAME_REQUIRED = "userName is required";
    public final static String IP_ADDRESS_PATTERN = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    public final static String IP_ADDRESS_ERROR_MESSAGE = "Ip address is not valid, example of valid ip - X.X.X.X where X is in range of 0-255";
    public final static String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[_#$%.])(?=\\S+$).{8,20}$";
    public final static String PASSWORD_PATTERN_ERROR_MESSAGE = "Invalid password, one uppercase,one number and one special symbol [_#$%.] with min 8 characters length is required";
}
