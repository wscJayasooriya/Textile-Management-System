/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.OrderDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.OrderService;

/**
 *
 * @author Sandun_CJ
 */
public class ManagePlaceOrderController {
    
    public static boolean addOrder(OrderDTO order) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
        return orderService.addOrder(order);
    }
    
    public static List<OrderDTO> getAllOrders() throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
        return orderService.getAllOrders();
    }
    
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
    }
    
    public static boolean reserveOrder(String oid) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
        return orderService.reserve(oid);
    }
    
    public static boolean releaseOrder(String oid) throws Exception{
        OrderService orderService =  (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
        return orderService.release(oid);
    }   
    
}
