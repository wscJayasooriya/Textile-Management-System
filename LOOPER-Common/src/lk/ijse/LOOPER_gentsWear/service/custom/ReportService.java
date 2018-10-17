/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom;

import lk.ijse.LOOPER_gentsWear.service.SuperService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Sandun_CJ
 */
public interface ReportService extends SuperService{
    public JasperPrint getInvoiceReports() throws Exception;
}
