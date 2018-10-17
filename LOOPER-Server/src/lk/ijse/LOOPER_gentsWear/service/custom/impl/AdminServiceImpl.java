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
import lk.ijse.LOOPER_gentsWear.business.custom.AdminBO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.dto.AdminDTO;
import lk.ijse.LOOPER_gentsWear.service.custom.AdminService;

/**
 *
 * @author Sandun_CJ
 */
public class AdminServiceImpl extends UnicastRemoteObject implements AdminService,Subject{
    
    private AdminBO adminBO;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<AdminService> adminResBook = new ReservationImpl<>();
    
    public AdminServiceImpl()throws Exception{
        
         adminBO = (AdminBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ADMIN);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return adminResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return adminResBook.release(id);
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
                    Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean addAdmin(AdminDTO admin) throws Exception {
        boolean save = adminBO.addAdmin(admin);
        notifyObservers();
        return save;
    }

    @Override
    public boolean deleteAdmin(int a_id) throws Exception {
        boolean result=false;
        if(adminResBook.reserve(a_id, this, true)){
             result = adminBO.deleteAdmin(a_id);
             notifyObservers();
             if(adminResBook.isInternalReservation(a_id)){
                 release(a_id);
             }
        }
        return result;
    }

    @Override
    public List<AdminDTO> getAllAdmin() throws Exception {
        return adminBO.getAllAdmin();
    }

    @Override
    public AdminDTO searchAdmin(int a_id) throws Exception {
        return adminBO.searchAdmin(a_id);
    }
    
}
