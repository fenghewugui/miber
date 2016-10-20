package com.weavedm.shiro.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weavedm.shiro.biz.dao.Oauth2ClientMapper;
import com.weavedm.shiro.model.Oauth2Client;
import com.weavedm.shiro.model.Oauth2ClientExample;
import com.weavedm.shiro.service.ClientService;

/**
 * <p>User: scl
 * <p>Date: 14-2-17
 * <p>Version: 1.0
 */
@Transactional
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private Oauth2ClientMapper clientMapper;

    public Oauth2Client createClient(Oauth2Client client) {

        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());
         clientMapper.insert(client);
         return client;
    }

    public Oauth2Client updateClient(Oauth2Client client) {
         clientMapper.updateByPrimaryKey(client);
         return client;
    }

    public void deleteClient(Long clientId) {
        clientMapper.deleteByPrimaryKey(clientId);
    }

    public Oauth2Client findOne(Long clientId) {
        return clientMapper.selectByPrimaryKey(clientId);
    }

    public List<Oauth2Client> findAll() {
        return clientMapper.selectByExample(new Oauth2ClientExample());
    }

    public Oauth2Client findByClientId(String clientId) {
    	Oauth2ClientExample 	clientExample =new Oauth2ClientExample();
    	clientExample.createCriteria().andClientIdEqualTo(clientId);
        List<Oauth2Client> l =  clientMapper.selectByExample(clientExample);
        if(null!=l&&l.size()>0){
        	return l.get(0);
        }
        return null;
    }

    public Oauth2Client findByClientSecret(String clientSecret) {
    	Oauth2ClientExample 	clientExample =new Oauth2ClientExample();
    	clientExample.createCriteria().andClientSecretEqualTo(clientSecret);
        List<Oauth2Client> l =  clientMapper.selectByExample(clientExample);
        if(null!=l&&l.size()>0){
        	return l.get(0);
        }
        return null;
    }
    public boolean checkClientId(String clientId) {
        return this.findByClientId(clientId) != null;
    }

    public boolean checkClientSecret(String clientSecret) {
        return this.findByClientSecret(clientSecret) != null;
    }
}
