/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom;

import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.GRNPaymentDTO;
import lk.ijse.LOOPER_gentsWear.service.SuperService;

/**
 *
 * @author Sandun_CJ
 */
public interface GRNPaymentService extends SuperService {

    public boolean addGRNPayment(GRNPaymentDTO payment) throws Exception;

    public List<GRNPaymentDTO> getAllGRNPayments() throws Exception;
}
