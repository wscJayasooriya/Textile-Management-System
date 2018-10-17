/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.dto.SupplierDTO;
import lk.ijse.LOOPER_gentsWear.service.SuperService;

/**
 *
 * @author Sandun_CJ
 */
public interface SupplierService extends SuperService{
    
    public boolean addSupplier(SupplierDTO supplier)throws Exception;
    
    public boolean deleteSupplier(String sup_id) throws Exception;
    
    public boolean deleteSupplierbyName(String name)throws Exception;
    
    public boolean updateSupplier(SupplierDTO supplier) throws Exception;
    
    public List<SupplierDTO> getAllSupplier() throws Exception;
    
    public SupplierDTO searchSupplier(String sup_id)throws Exception;
    
    public SupplierDTO serachSupplierByName(String name)throws Exception;
    
}
