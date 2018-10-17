/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import lk.ijse.LOOPER_gentsWear.dto.OrderDetailsDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.OrderDetailsService;

/**
 *
 * @author Sandun_CJ
 */
public class ManageOrderDetailsController {
    
    public static boolean addOrder(OrderDetailsDTO orderDetails) throws Exception {
        OrderDetailsService orderDetailsService = (OrderDetailsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER_DETAILS);
        return orderDetailsService.addOrderDetails(orderDetails);
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDER_DETAILS);
    }
    
}
