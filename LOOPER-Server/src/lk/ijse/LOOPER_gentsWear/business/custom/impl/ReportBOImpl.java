/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.LOOPER_gentsWear.business.custom.ReportBO;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import lk.ijse.jasper.JasperUtil;
import lk.ijse.jasper.Report;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
@Report("lk.ijse.LOOPER_gentsWear.report")
public class ReportBOImpl implements ReportBO {

    private Connection connection;

    @Override
    public JasperPrint getInvoice() throws Exception {
        JasperUtil.init(ReportBOImpl.class);

        JasperReportsContext ctx = JasperUtil.getReportContext();

        try {
            JasperReport progressingJR =  JasperUtil.getCompiledReport("Bill.jasper");
            

            JasperFillManager fillManager = JasperFillManager.getInstance(ctx);

//            HashMap<String, Object> reportParams = new HashMap<>();
//            reportParams.put("state", state);

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.doWork((cnctn) -> {
                connection = cnctn;
            });
            JasperPrint filledReport = fillManager.fill(progressingJR, null, connection);
            return filledReport;
        } catch (JRException ex) {
            Logger.getLogger(ReportBOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    private JasperReport getJasper(String state) throws JRException {
//        switch (state) {
//            case "allocated":
//                return JasperUtil.getCompiledReport("ProgressingShipments.jasper");
//            case "finished":
//                return JasperUtil.getCompiledReport("FinishedShipments.jasper");
//            case "ready":
//                return JasperUtil.getCompiledReport("ReadyShipments.jasper");
//            default:
//                return null;
//        }
//    }

}
