/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.CashierDTO;
import lk.ijse.LOOPER_gentsWear.service.SuperService;

/**
 *
 * @author Sandun_CJ
 */
public interface CashierService extends SuperService {

    public boolean addCashier(CashierDTO cashier) throws Exception;

    public boolean deleteCashier(String c_id) throws Exception;

    public List<CashierDTO> getAllCasshier() throws Exception;

    public CashierDTO searchCashier(String c_id) throws Exception;
}
