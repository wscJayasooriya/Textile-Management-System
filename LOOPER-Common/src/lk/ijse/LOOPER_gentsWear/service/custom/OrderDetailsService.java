/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom;

import lk.ijse.LOOPER_gentsWear.dto.OrderDetailsDTO;
import lk.ijse.LOOPER_gentsWear.service.SuperService;

/**
 *
 * @author Sandun_CJ
 */
public interface OrderDetailsService extends SuperService{
    
    public boolean addOrderDetails(OrderDetailsDTO orderDetails) throws Exception;
    
}
