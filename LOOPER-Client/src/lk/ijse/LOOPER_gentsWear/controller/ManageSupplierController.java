/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.dto.SupplierDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.ItemService;
import lk.ijse.LOOPER_gentsWear.service.custom.SupplierService;

/**
 *
 * @author Sandun_CJ
 */
public class ManageSupplierController {
    public static boolean addSupplier(SupplierDTO supplier)throws Exception{
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.addSupplier(supplier);
    }
    
    public static boolean updateSupplier(SupplierDTO supplier)throws Exception{
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.updateSupplier(supplier);
    }
    
    public static boolean deleteSupplier(String sup_id)throws Exception{
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.deleteSupplier(sup_id);
    }
    
    public static List<SupplierDTO> getAllSuppliers()throws Exception{
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return  supplierService.getAllSupplier();
    }
    
    public static Subject getSubject()throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
    }
    
    public static boolean reservSupplier(String sup_id)throws Exception{
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.reserve(sup_id);
    }
    public static boolean releaseSupplier(String sup_id)throws Exception{
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.release(sup_id);
    }
    
    public static SupplierDTO searchSupplierbyId(String sup_id)throws Exception{
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.searchSupplier(sup_id);
    }
    
    public static SupplierDTO searchSupplierbyName(String name)throws Exception{
        SupplierService supplierService = (SupplierService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SUPPLIER);
        return supplierService.searchSupplier(name);
    }
}
