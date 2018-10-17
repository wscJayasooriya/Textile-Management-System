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
import lk.ijse.LOOPER_gentsWear.business.custom.GRNBO;
import lk.ijse.LOOPER_gentsWear.dto.GRNDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNService;

/**
 *
 * @author Sandun_CJ
 */
public class GRNServiceImpl extends UnicastRemoteObject implements GRNService,Subject{
    
    private GRNBO grnbo;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<GRNService> grnResBook = new ReservationImpl<>();
    
    public GRNServiceImpl()throws Exception{
        
         grnbo = (GRNBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GRN);
    }

    @Override
    public boolean addGRN(GRNDTO grndto) throws Exception {
        boolean save = grnbo.saveGRN(grndto);
        notifyObservers();
        return save;
    }

    @Override
    public List<GRNDTO> getAllGRNs() throws Exception {
        return grnbo.getAllGRNs();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return grnResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return grnResBook.release(id);
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
                    Logger.getLogger(GRNServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
