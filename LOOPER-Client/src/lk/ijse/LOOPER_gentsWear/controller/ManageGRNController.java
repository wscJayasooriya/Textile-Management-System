/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.GRNDTO;
import lk.ijse.LOOPER_gentsWear.dto.OrderDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNService;
import lk.ijse.LOOPER_gentsWear.service.custom.OrderService;

/**
 *
 * @author Sandun_CJ
 */
public class ManageGRNController {
    public static boolean addGRN(GRNDTO grndto) throws Exception{
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.addGRN(grndto);
    }
    
    public static List<GRNDTO> getAllGRNs() throws Exception{
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.getAllGRNs();
    }
    
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
    }
    
    public static boolean reserveOrder(String grnID) throws Exception{
        GRNService gRNService = (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.reserve(grnID);
    }
    
    public static boolean releaseOrder(String grnID) throws Exception{
        GRNService gRNService =  (GRNService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN);
        return gRNService.release(grnID);
    }   
}
