/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.controller;

import lk.ijse.LOOPER_gentsWear.proxy.ProxyHandler;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.custom.ReportService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Sandun_CJ
 */
public class ReportController {
    public static JasperPrint getInvoiceReports() throws Exception {
        ReportService reportsService = (ReportService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.REPORTS);
        return reportsService.getInvoiceReports();

    }
}
