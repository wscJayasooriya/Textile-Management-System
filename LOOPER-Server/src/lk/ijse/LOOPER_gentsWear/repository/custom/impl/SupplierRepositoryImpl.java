/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.repository.custom.impl;

import lk.ijse.LOOPER_gentsWear.entity.Item;
import lk.ijse.LOOPER_gentsWear.entity.Supplier;
import lk.ijse.LOOPER_gentsWear.repository.SuperRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.SupplierRepository;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class SupplierRepositoryImpl extends SuperRepositoryImpl<Supplier,String> implements SupplierRepository{

    private Session session;
    
    public SupplierRepositoryImpl() {
    
    }

    @Override
    public Supplier searchSupplierByName(String name) throws Exception {
        Supplier  get = (Supplier) session.createQuery("from Supplier where sup_name='"+name+"'");
        return get;
    }
    
}
