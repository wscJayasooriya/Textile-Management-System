/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.OrderDTO;
import lk.ijse.LOOPER_gentsWear.service.SuperService;

/**
 *
 * @author Sandun_CJ
 */
public interface OrderService extends SuperService{
    
    public boolean addOrder(OrderDTO order) throws Exception;
    
    public List<OrderDTO> getAllOrders()throws Exception;
    
}
