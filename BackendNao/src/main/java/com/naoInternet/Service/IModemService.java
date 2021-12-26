package com.naoInternet.Service;

import com.naoInternet.Entity.Modem;

import java.util.List;

public interface IModemService extends CrudService<Modem>{
    public Modem findByPonSn(String ponSn) throws Exception;
    public List<Modem> findBySupplier(String supplier) throws Exception;
    public List<Modem> findByPon(Long pon) throws Exception;
}
