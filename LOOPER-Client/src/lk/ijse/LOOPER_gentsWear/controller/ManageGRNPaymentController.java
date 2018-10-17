/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.GRNPaymentDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNPaymentService;

/**
 *
 * @author Sandun_CJ
 */
public class ManageGRNPaymentController {
    public static boolean addGRNPayment(GRNPaymentDTO payment)throws Exception{
        GRNPaymentService paymentService = (GRNPaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN_PAYMENT);
        return paymentService.addGRNPayment(payment);
        
    }
    
    public static List<GRNPaymentDTO> getAllGRnPayment()throws Exception{
        GRNPaymentService paymentService = (GRNPaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN_PAYMENT);
        return  paymentService.getAllGRNPayments();
    }
    
    public static Subject getSubject()throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN_PAYMENT);
    }
    
    public static boolean reservItem(String grn_pId)throws Exception{
        GRNPaymentService paymentService = (GRNPaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN_PAYMENT);
        return paymentService.reserve(grn_pId);
    }
    public static boolean releaseItem(String grn_pId)throws Exception{
        GRNPaymentService paymentService = (GRNPaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN_PAYMENT);
        return paymentService.release(grn_pId);
    }
}
