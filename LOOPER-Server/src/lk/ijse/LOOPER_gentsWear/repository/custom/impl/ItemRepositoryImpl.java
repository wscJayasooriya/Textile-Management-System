/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.repository.custom.impl;

import lk.ijse.LOOPER_gentsWear.entity.Item;
import lk.ijse.LOOPER_gentsWear.repository.SuperRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.ItemRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class ItemRepositoryImpl extends SuperRepositoryImpl<Item, String> implements ItemRepository {

    private Session session;
    
    
    public ItemRepositoryImpl() {
        
    }

    @Override
    public Item searchItemByName(String description) throws Exception {
        Item get = (Item) session.createQuery("select * from item where description='" + description + "'");
        if (get != null) {
            return get;
        }
        return null;

        

    }

}
