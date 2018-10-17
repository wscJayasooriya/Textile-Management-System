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
import lk.ijse.LOOPER_gentsWear.business.custom.ItemBO;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.observer.Observer;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.reservation.impl.ReservationImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.ItemService;

/**
 *
 * @author Sandun_CJ
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService,Subject{
    
    private ItemBO itemBO;
    private static ArrayList<Observer> allObservers = new ArrayList<>();
    private static ReservationImpl<ItemService> itemResBook = new ReservationImpl<>();
    
    public ItemServiceImpl()throws Exception{
        
         itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    }

    @Override
    public boolean addItem(ItemDTO item) throws Exception {
        boolean save = itemBO.addItem(item);
        notifyObservers();
        return save;
    }

    @Override
    public boolean deleteItem(String itemCode) throws Exception {
        boolean result=false;
        if(itemResBook.reserve(itemCode, this, true)){
             result = itemBO.deleteItem(itemCode);
             notifyObservers();
             if(itemResBook.isInternalReservation(itemCode)){
                 release(itemCode);
             }
        }
        return result;
    }

    @Override
    public boolean updateItem(ItemDTO item) throws Exception {
        boolean result=false;
        if(itemResBook.reserve(item.getiCode(), this, true)){
            itemBO.updateItem(item);
            notifyObservers();
            if(itemResBook.isInternalReservation(item.getiCode())){
                release(item);
            }
        }
        return result;
    }

    @Override
    public List<ItemDTO> getAllItem() throws Exception {
       return itemBO.getAllItems();
    }


    @Override
    public boolean reserve(Object id) throws Exception {
        return itemResBook.reserve(id, this, true);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return itemResBook.release(id);
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
                    Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    

    @Override
    public ItemDTO serachItemByName(ItemDTO dto) throws Exception {
        return itemBO.searchItemByName(dto);
    }

    @Override
    public ItemDTO searchItem(String itemCode) throws Exception {
        return itemBO.searchItemCode(itemCode);
    }
    
}
