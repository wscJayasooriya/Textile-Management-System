/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.PaymentDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.PaymentService;

/**
 *
 * @author Sandun_CJ
 */
public class ManagePaymentController {
    
    public static boolean addPayment(PaymentDTO payment)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
        return paymentService.addPayment(payment);
        
    }
    
    public static List<PaymentDTO> getAllPayment()throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
        return  paymentService.getAllPayments();
    }
    
    public static Subject getSubject()throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
    }
    
    public static boolean reservItem(String pId)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
        return paymentService.reserve(pId);
    }
    public static boolean releaseItem(String pId)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
        return paymentService.release(pId);
    }
}
