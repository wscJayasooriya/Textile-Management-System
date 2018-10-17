/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.SuperBO;
import lk.ijse.LOOPER_gentsWear.dto.SupplierDTO;

/**
 *
 * @author Sandun_CJ
 */
public interface SupplierBO extends SuperBO{
    
    public boolean addSupplier(SupplierDTO supplier)throws Exception;
    
    public boolean updateSupplier(SupplierDTO supplier)throws Exception;
    
    public boolean deleteSupplier(String supplierId)throws Exception;
    
    public boolean deleteSupplierByName(String name)throws Exception;
    
    public List<SupplierDTO> getAllSuppliers()throws Exception;
    
    public SupplierDTO searchSupplier(String supplierId)throws Exception;
    
    public SupplierDTO searchSupplierByName(String name)throws Exception;
    
}
