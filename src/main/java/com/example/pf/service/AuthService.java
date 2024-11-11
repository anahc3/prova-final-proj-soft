package com.example.pf.service;

import com.example.pf.dto.RetornarUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private static final String VALIDATE_URL = "http://184.72.80.215/usuario/validate";

    public RetornarUsuarioDTO validarToken(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<RetornarUsuarioDTO> response = restTemplate.exchange(
                VALIDATE_URL, HttpMethod.GET, entity, RetornarUsuarioDTO.class);

        return response.getBody();
    }
}
