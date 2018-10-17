/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.SuperBO;
import lk.ijse.LOOPER_gentsWear.dto.CashierDTO;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;

/**
 *
 * @author Sandun_CJ
 */
public interface CashierBO extends SuperBO{
    public boolean addCashier(CashierDTO cashier)throws Exception;
    
    public boolean deleteCashier(String c_id)throws Exception;
    
    public List<CashierDTO> getAllCashiers()throws Exception;
    
    public CashierDTO searchCasshier(String c_id)throws Exception;
}
