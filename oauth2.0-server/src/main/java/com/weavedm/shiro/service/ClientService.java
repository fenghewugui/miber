package com.weavedm.shiro.service;

import java.util.List;

import com.weavedm.shiro.model.Oauth2Client;

/**
 */
public interface ClientService {

    public Oauth2Client createClient(Oauth2Client Client);
    public Oauth2Client updateClient(Oauth2Client Client);
    public void deleteClient(Long ClientId);

    Oauth2Client findOne(Long ClientId);

    List<Oauth2Client> findAll();

    Oauth2Client findByClientId(String ClientId);
    Oauth2Client findByClientSecret(String ClientSecret);



    public boolean checkClientId(String clientId);

    public boolean checkClientSecret(String clientSecret);
}
