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
import lk.ijse.LOOPER_gentsWear.business.custom.PaymentBO;
import lk.ijse.LOOPER_gentsWear.dto.PaymentDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.PaymentService;

/**
 *
 * @author Sandun_CJ
 */
public class PaymentServiceImpl extends UnicastRemoteObject implements PaymentService, Subject {

    private PaymentBO paymentBO;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<PaymentService> payResBook = new ReservationImpl<>();

    public PaymentServiceImpl() throws Exception {
        paymentBO = (PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);
    }

    @Override
    public boolean addPayment(PaymentDTO payment) throws Exception {
        boolean save = paymentBO.addPayment(payment);
        notifyObservers();
        return save;
    }

    @Override
    public List<PaymentDTO> getAllPayments() throws Exception {
        return paymentBO.getAllPayment();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return payResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return payResBook.release(id);
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
                    Logger.getLogger(PaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

}
