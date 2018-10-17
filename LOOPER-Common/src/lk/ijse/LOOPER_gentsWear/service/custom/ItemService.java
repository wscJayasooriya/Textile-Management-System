/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.service.SuperService;

/**
 *
 * @author Sandun_CJ
 */
public interface ItemService extends SuperService{
    
    public boolean addItem(ItemDTO item)throws Exception;
    
    public boolean deleteItem(String itemCode) throws Exception;
    
    public boolean updateItem(ItemDTO item) throws Exception;
    
    public List<ItemDTO> getAllItem() throws Exception;
    
    public ItemDTO searchItem(String itemCode)throws Exception;
    
    public ItemDTO serachItemByName(ItemDTO dto)throws Exception;
}
