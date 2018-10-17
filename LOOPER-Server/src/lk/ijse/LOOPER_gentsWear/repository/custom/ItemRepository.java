/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.repository.custom;

import lk.ijse.LOOPER_gentsWear.entity.Item;
import lk.ijse.LOOPER_gentsWear.repository.SuperRepository;

/**
 *
 * @author Sandun_CJ
 */
public interface ItemRepository extends SuperRepository<Item, String>{
    
    public Item searchItemByName(String description)throws Exception;
    
}
