package com.naoInternet.Service;

import com.naoInternet.Entity.Client;

import java.util.List;


public interface IClientService extends CrudService<Client>{
    public Client findByNumberId(Long numberId) throws Exception;
    public List<Client> findByName(String name) throws Exception;
    public List<Client> findByLastName(String lastName) throws Exception;
    public List<Client> findByNameAndLastName(String name, String lastName) throws Exception;
}

