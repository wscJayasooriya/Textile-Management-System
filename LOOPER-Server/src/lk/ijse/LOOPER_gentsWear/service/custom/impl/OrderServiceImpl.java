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
import lk.ijse.LOOPER_gentsWear.business.custom.OrderBO;
import lk.ijse.LOOPER_gentsWear.dto.OrderDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.OrderService;

/**
 *
 * @author Sandun_CJ
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService,Subject{
    
    private OrderBO orderBO;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<OrderService> order_ResBook = new ReservationImpl<>();
    
    public OrderServiceImpl()throws Exception{
        
         orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERS);
    }

    @Override
    public boolean addOrder(OrderDTO order) throws Exception {
        boolean save = orderBO.saveOrder(order);
        notifyObservers();
        return save;
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        return orderBO.getAllOrders();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return order_ResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return order_ResBook.release(id);
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
                    Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
