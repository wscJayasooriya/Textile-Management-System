/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.SuperService;
import lk.ijse.LOOPER_gentsWear.service.custom.AdminService;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNDetailsService;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNPaymentService;
import lk.ijse.LOOPER_gentsWear.service.custom.GRNService;
import lk.ijse.LOOPER_gentsWear.service.custom.ItemService;
import lk.ijse.LOOPER_gentsWear.service.custom.OrderDetailsService;
import lk.ijse.LOOPER_gentsWear.service.custom.OrderService;
import lk.ijse.LOOPER_gentsWear.service.custom.PaymentService;
import lk.ijse.LOOPER_gentsWear.service.custom.SupplierService;
import lk.ijse.LOOPER_gentsWear.service.custom.CashierService;
import lk.ijse.LOOPER_gentsWear.service.custom.ReportService;

/**
 *
 * @author Sandun_CJ
 */
public class ProxyHandler implements ServiceFactory {

    private static ProxyHandler proxyHandler;
    private ServiceFactory serviceFactory;
    private ItemService itemService;
    private SupplierService supplierService;
    private OrderService orderService;
    private OrderDetailsService detailsService;
    private PaymentService paymentService;
    private GRNPaymentService gRNPaymentService;
    private GRNService gRNService;
    private GRNDetailsService gRNDetailsService;
    private CashierService cashierService;
    private AdminService adminService;
    private ReportService reportService;

    private ProxyHandler() {
        try {
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:2020/looper_gents");
            itemService = (ItemService) serviceFactory.getService(ServiceTypes.ITEM);
            supplierService = (SupplierService) serviceFactory.getService(ServiceTypes.SUPPLIER);
            detailsService = (OrderDetailsService) serviceFactory.getService(ServiceTypes.ORDER_DETAILS);
            paymentService = (PaymentService) serviceFactory.getService(ServiceTypes.PAYMENT);
            orderService = (OrderService) serviceFactory.getService(ServiceTypes.ORDERS);
            gRNDetailsService = (GRNDetailsService) serviceFactory.getService(ServiceTypes.GRN_DETAILS);
            gRNPaymentService = (GRNPaymentService) serviceFactory.getService(ServiceTypes.GRN_PAYMENT);
            gRNService = (GRNService) serviceFactory.getService(ServiceTypes.GRN);
            cashierService=(CashierService) serviceFactory.getService(ServiceTypes.CASHIER);
            adminService=(AdminService) serviceFactory.getService(ServiceTypes.ADMIN);
            reportService=(ReportService) serviceFactory.getService(ServiceTypes.REPORTS);

        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ProxyHandler getInstance() {
        if (proxyHandler == null) {
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes types) throws Exception {
        switch (types) {
            case ITEM:
                return itemService;
            case SUPPLIER:
                return supplierService;
            case ORDER_DETAILS:
                return detailsService;
            case PAYMENT:
                return paymentService;
            case ORDERS:
                return orderService;
            case GRN_DETAILS:
                return gRNDetailsService;
            case GRN_PAYMENT:
                return gRNPaymentService;
            case GRN:
                return gRNService;
            case CASHIER:
                return cashierService;
            case ADMIN:
                return adminService;
            case REPORTS:
                return reportService;
            default:
                return null;
        }
    }

}
