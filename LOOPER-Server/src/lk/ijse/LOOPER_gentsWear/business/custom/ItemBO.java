/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.SuperBO;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;

/**
 *
 * @author Sandun_CJ
 */
public interface ItemBO extends SuperBO{
    
    public boolean addItem(ItemDTO item)throws Exception;
    
    public boolean updateItem(ItemDTO item)throws Exception;
    
    public boolean deleteItem(String itemId)throws Exception;
    
    public List<ItemDTO> getAllItems()throws Exception;
    
    public ItemDTO searchItemByName(ItemDTO dto)throws Exception;
    
    public ItemDTO searchItemCode(String itemCode)throws Exception;
    
}
