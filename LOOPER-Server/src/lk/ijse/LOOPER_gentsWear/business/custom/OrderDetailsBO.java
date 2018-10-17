/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom;

import lk.ijse.LOOPER_gentsWear.business.SuperBO;
import lk.ijse.LOOPER_gentsWear.dto.OrderDetailsDTO;

/**
 *
 * @author Sandun_CJ
 */
public interface OrderDetailsBO extends SuperBO{
    
    public boolean  addOrderDetails(OrderDetailsDTO orderDetails) throws Exception;
    
}
