/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.SuperBO;
import lk.ijse.LOOPER_gentsWear.dto.GRNPaymentDTO;

/**
 *
 * @author Sandun_CJ
 */
public interface GRNPaymentBO extends SuperBO{
    public boolean addGRNPayment(GRNPaymentDTO payment)throws Exception;
    
    public List<GRNPaymentDTO> getAllGRNPayment()throws Exception;
}
