package com.example.ipassignment.service;

import com.example.ipassignment.exceptions.IpApiException;
import com.example.ipassignment.model.IpApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.example.ipassignment.constants.AppConstants.IP_API_URL_KEY;

@Service
public class IpApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    public IpApiResponse getDetails(String ipAddress) throws IpApiException {
        ResponseEntity<IpApiResponse> response;
        try {
            response = restTemplate.getForEntity(environment.getProperty(IP_API_URL_KEY) + ipAddress, IpApiResponse.class);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new IpApiException();
        }
    }
}
