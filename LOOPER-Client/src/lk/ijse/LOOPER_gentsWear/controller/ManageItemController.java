/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.observer.Subject;
import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.SuperService;
import lk.ijse.LOOPER_gentsWear.service.custom.ItemService;

/**
 *
 * @author Sandun_CJ
 */
public class ManageItemController {
    
    public static boolean addItem(ItemDTO item)throws Exception{
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.addItem(item);
        
    }
    
    public static boolean updateItem(ItemDTO item)throws Exception{
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.updateItem(item);
    }
    
    public static boolean deleteItem(String itemCode)throws Exception{
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.deleteItem(itemCode);
    }
    
    public static List<ItemDTO> getAllItems()throws Exception{
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return  itemService.getAllItem();
    }
    
    public static Subject getSubject()throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
    }
    
    public static boolean reservItem(String itemCode)throws Exception{
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.reserve(itemCode);
    }
    public static boolean releaseItem(String itemCode)throws Exception{
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.release(itemCode);
    }
    public static ItemDTO searchItem(String itemCode)throws Exception{
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.searchItem(itemCode);
    }
    
    public static ItemDTO searchItemByName(ItemDTO dto)throws Exception{
        ItemService itemService = (ItemService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        return itemService.serachItemByName(dto);
    }
}   
