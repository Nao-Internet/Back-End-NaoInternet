package com.naoInternet.Service;

import com.naoInternet.Entity.AttachedModem;


import java.util.Date;
import java.util.List;

public interface IAttachedModemService extends CrudService<AttachedModem>{
    public AttachedModem findByClientCode(Long clientCode) throws Exception;
    public List<AttachedModem> findByPlan(String plan) throws Exception;
    public List<AttachedModem> find(Date establishmentDate) throws Exception;
}
