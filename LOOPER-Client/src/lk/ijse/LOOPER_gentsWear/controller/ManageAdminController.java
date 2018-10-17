/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.AdminDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.AdminService;

/**
 *
 * @author Sandun_CJ
 */
public class ManageAdminController {

    public static boolean addAdmin(AdminDTO admin) throws Exception {
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
        return adminService.addAdmin(admin);

    }
    
    public static boolean deleteAdmin(int a_id)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
        return adminService.deleteAdmin(a_id);
    }
    
    public static List<AdminDTO> getAllAdmins()throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
        return  adminService.getAllAdmin();
    }
    
    public static Subject getSubject()throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
    }
    
    public static boolean reserveAdmin(int a_id)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
        return adminService.reserve(a_id);
    }
    public static boolean releaseAdmin(int a_id)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
        return adminService.release(a_id);
    }
    public static AdminDTO searchAdmin(int a_id)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ADMIN);
        return adminService.searchAdmin(a_id);
    }
}
