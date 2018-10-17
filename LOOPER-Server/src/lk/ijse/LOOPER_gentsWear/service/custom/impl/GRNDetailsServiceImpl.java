/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.LOOPER_gentsWear.business.BOFactory;
import lk.ijse.LOOPER_gentsWear.business.custom.GRNDetailsBO;
import lk.ijse.LOOPER_gentsWear.dto.GRNDetailsDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNDetailsService;

/**
 *
 * @author Sandun_CJ
 */
public class GRNDetailsServiceImpl extends UnicastRemoteObject implements GRNDetailsService,Subject{
    
    private GRNDetailsBO detailsBO;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<GRNDetailsService> grnDetailsResBook = new ReservationImpl<>();
    
    public GRNDetailsServiceImpl()throws Exception{
        
         detailsBO = (GRNDetailsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GRN_DETAILS);
    }

    @Override
    public boolean addGRNDetails(GRNDetailsDTO details) throws Exception {
        boolean save = detailsBO.addGRNDetails(details);
        notifyObservers();
        return save;
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return grnDetailsResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return grnDetailsResBook.release(id);
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
                    Logger.getLogger(GRNDetailsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
