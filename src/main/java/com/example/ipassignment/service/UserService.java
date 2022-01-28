package com.example.ipassignment.service;

import com.example.ipassignment.exceptions.IpApiException;
import com.example.ipassignment.exceptions.IpNotInDesiredCountryException;
import com.example.ipassignment.model.IpApiResponse;
import com.example.ipassignment.model.User;
import com.example.ipassignment.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.ipassignment.constants.AppConstants.IP_ACCEPTED_COUNTRY_KEY;
import static com.example.ipassignment.constants.AppConstants.USER_WELCOME_MESSAGE;

@Service
public class UserService {

    @Autowired
    IpApiService ipApiService;

    @Autowired
    Environment environment;

    public UserResponse register(User user) throws IpApiException, IpNotInDesiredCountryException {
        IpApiResponse ipApiResponse = ipApiService.getDetails(user.getIpAddress());
        validateIpCountry(ipApiResponse);
        return buildUserResponse(user,ipApiResponse);
    }

    private UserResponse buildUserResponse(User user, IpApiResponse ipApiResponse) {
        return UserResponse.builder()
                .city(ipApiResponse.getCity())
                .randomCode(UUID.randomUUID())
                .message(String.format(USER_WELCOME_MESSAGE,user.getUserName(), ipApiResponse.getCity()))
                .build();
    }

    private void validateIpCountry(IpApiResponse ipApiResponse) throws IpNotInDesiredCountryException {
        if(! environment.getProperty(IP_ACCEPTED_COUNTRY_KEY).equalsIgnoreCase(ipApiResponse.getCountry())) {
            throw new IpNotInDesiredCountryException();
        }
    }

}
