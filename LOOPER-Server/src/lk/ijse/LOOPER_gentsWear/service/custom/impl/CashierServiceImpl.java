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
import lk.ijse.LOOPER_gentsWear.dto.CashierDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.CashierService;
import lk.ijse.LOOPER_gentsWear.business.custom.CashierBO;

/**
 *
 * @author Sandun_CJ
 */
public class CashierServiceImpl extends UnicastRemoteObject implements CashierService,Subject{
    
    private CashierBO cashierBO;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<CashierService> cashierResBook = new ReservationImpl<>();
    
    public CashierServiceImpl()throws Exception{
        
         cashierBO = (CashierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CASHIER);
    }

    @Override
    public boolean addCashier(CashierDTO cashier) throws Exception {
        boolean save = cashierBO.addCashier(cashier);
        notifyObservers();
        return save;
    }

    @Override
    public boolean deleteCashier(String c_id) throws Exception {
        boolean result=false;
        if(cashierResBook.reserve(c_id, this, true)){
             result = cashierBO.deleteCashier(c_id);
             notifyObservers();
             if(cashierResBook.isInternalReservation(c_id)){
                 release(c_id);
             }
        }
        return result;
    }

    @Override
    public List<CashierDTO> getAllCasshier() throws Exception {
        return cashierBO.getAllCashiers();
    }

    @Override
    public CashierDTO searchCashier(String c_id) throws Exception {
        return cashierBO.searchCasshier(c_id);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return cashierResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return cashierResBook.release(id);
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
                    Logger.getLogger(CashierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
