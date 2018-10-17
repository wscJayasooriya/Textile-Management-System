/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.SuperBO;
import lk.ijse.LOOPER_gentsWear.dto.OrderDTO;

/**
 *
 * @author Sandun_CJ
 */
public interface OrderBO extends SuperBO{
    
    public boolean saveOrder(OrderDTO orders)throws Exception;
    
    public List<OrderDTO> getAllOrders()throws Exception;
    
}
