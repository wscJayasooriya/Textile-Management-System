/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.SuperBO;
import lk.ijse.LOOPER_gentsWear.dto.AdminDTO;
import lk.ijse.LOOPER_gentsWear.dto.CashierDTO;

/**
 *
 * @author Sandun_CJ
 */
public interface AdminBO extends SuperBO{
    public boolean addAdmin(AdminDTO admin)throws Exception;
    
    public boolean deleteAdmin(int a_id)throws Exception;
    
    public List<AdminDTO> getAllAdmin()throws Exception;
    
    public AdminDTO searchAdmin(int a_id)throws Exception;
}
