/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.LOOPER_gentsWear.business.BOFactory;
import lk.ijse.LOOPER_gentsWear.business.custom.ReportBO;
import lk.ijse.LOOPER_gentsWear.service.custom.ReportService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Sandun_CJ
 */
public class ReportServiceImpl extends UnicastRemoteObject implements ReportService {
    
    private ReportBO reportBO;
    
    public ReportServiceImpl() throws RemoteException {
        reportBO = (ReportBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REPORTS);
    }
    
    @Override
    public JasperPrint getInvoiceReports() throws Exception {
        return reportBO.getInvoice();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
