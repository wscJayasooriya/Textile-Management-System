/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import lk.ijse.LOOPER_gentsWear.dto.GRNDetailsDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNDetailsService;

/**
 *
 * @author Sandun_CJ
 */
public class ManageGRNDetailsController {
    public static boolean addOrder(GRNDetailsDTO gRNDetails) throws Exception {
        GRNDetailsService gRNDetailsService = (GRNDetailsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN_DETAILS);
        return gRNDetailsService.addGRNDetails(gRNDetails);
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GRN_DETAILS);
    }
}
