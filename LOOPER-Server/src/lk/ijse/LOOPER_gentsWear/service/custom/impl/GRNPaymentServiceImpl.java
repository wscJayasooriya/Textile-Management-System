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
import lk.ijse.LOOPER_gentsWear.business.custom.GRNPaymentBO;
import lk.ijse.LOOPER_gentsWear.dto.GRNPaymentDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNPaymentService;

/**
 *
 * @author Sandun_CJ
 */
public class GRNPaymentServiceImpl extends UnicastRemoteObject implements GRNPaymentService, Subject{
    
    private GRNPaymentBO paymentBO;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<GRNPaymentService> grnPayResBook = new ReservationImpl<>();
    
    public GRNPaymentServiceImpl() throws Exception {
        paymentBO = (GRNPaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GRN_PAYMENT);
    }

    @Override
    public boolean addGRNPayment(GRNPaymentDTO payment) throws Exception {
        boolean save = paymentBO.addGRNPayment(payment);
        notifyObservers();
        return save;
    }

    @Override
    public List<GRNPaymentDTO> getAllGRNPayments() throws Exception {
        return paymentBO.getAllGRNPayment();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return grnPayResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return grnPayResBook.release(id);
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
                    Logger.getLogger(GRNPaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
