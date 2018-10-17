/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.LOOPER_gentsWear.business.BOFactory;
import lk.ijse.LOOPER_gentsWear.business.custom.SupplierBO;
import lk.ijse.LOOPER_gentsWear.dto.SupplierDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.SupplierService;

/**
 *
 * @author Sandun_CJ
 */
public class SupplierServiceImpl extends UnicastRemoteObject implements SupplierService,Subject{
    
    private SupplierBO supplierBO;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<SupplierService> supResBook = new ReservationImpl<>();
    
    public SupplierServiceImpl()throws Exception{
         supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER);
    }

    @Override
    public boolean addSupplier(SupplierDTO supplier) throws Exception {
        boolean save = supplierBO.addSupplier(supplier);
        notifyObservers();
        return save;
    }

    @Override
    public boolean deleteSupplier(String sup_id) throws Exception {
        boolean result=false;
        if(supResBook.reserve(sup_id, this, true)){
             result = supplierBO.deleteSupplier(sup_id);
             notifyObservers();
             if(supResBook.isInternalReservation(sup_id)){
                 release(supplierBO);
             }
        }
        return result;
    }

    @Override
    public boolean deleteSupplierbyName(String name) throws Exception {
        boolean result=false;
        if(supResBook.reserve(name, this, true)){
             result = supplierBO.deleteSupplier(name);
             notifyObservers();
             if(supResBook.isInternalReservation(name)){
                 release(supplierBO);
             }
        }
        return result;
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) throws Exception {
        boolean result=false;
        if(supResBook.reserve(supplier.getSup_id(), this, true)){
            supplierBO.updateSupplier(supplier);
            notifyObservers();
            if(supResBook.isInternalReservation(supplier.getSup_id())){
                release(supplier);
            }
        }
        return result;
    }

    @Override
    public List<SupplierDTO> getAllSupplier() throws Exception {
        return supplierBO.getAllSuppliers();
    }

    @Override
    public SupplierDTO searchSupplier(String sup_id) throws Exception {
        return supplierBO.searchSupplier(sup_id);
    }

    @Override
    public SupplierDTO serachSupplierByName(String name) throws Exception {
        return supplierBO.searchSupplierByName(name);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return supResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return supResBook.release(id);
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        allObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        allObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(()->{
            for (Observer observer : allObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(SupplierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
