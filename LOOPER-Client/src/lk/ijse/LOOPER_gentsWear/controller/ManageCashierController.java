/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.CashierDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.CashierService;

/**
 *
 * @author Sandun_CJ
 */
public class ManageCashierController {

    public static boolean addCashier(CashierDTO cashier) throws Exception {
        CashierService cashierService = (CashierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CASHIER);
        return cashierService.addCashier(cashier);

    }
    
    public static boolean deleteCashier(String c_id)throws Exception{
        CashierService cashierService = (CashierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CASHIER);
        return cashierService.deleteCashier(c_id);
    }
    
    public static List<CashierDTO> getAllCashiers()throws Exception{
        CashierService cashierService = (CashierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CASHIER);
        return  cashierService.getAllCasshier();
    }
    
    public static Subject getSubject()throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CASHIER);
    }
    
    public static boolean reserveCashier(String c_id)throws Exception{
        CashierService cashierService = (CashierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CASHIER);
        return cashierService.reserve(c_id);
    }
    public static boolean releaseCashier(String c_id)throws Exception{
        CashierService cashierService = (CashierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CASHIER);
        return cashierService.release(c_id);
    }
    public static CashierDTO searchCashier(String c_id)throws Exception{
        CashierService cashierService = (CashierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CASHIER);
        return cashierService.searchCashier(c_id);
    }
}
