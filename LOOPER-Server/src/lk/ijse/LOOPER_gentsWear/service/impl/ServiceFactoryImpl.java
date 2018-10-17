/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.LOOPER_gentsWear.service.ServiceFactory;
import lk.ijse.LOOPER_gentsWear.service.SuperService;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.AdminServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.CashierServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.GRNDetailsServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.GRNPaymentServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.GRNServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.ItemServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.OrderDetailsServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.OrderServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.PaymentServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.ReportServiceImpl;
import lk.ijse.LOOPER_gentsWear.service.custom.impl.SupplierServiceImpl;

/**
 *
 * @author Sandun_CJ
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    public static ServiceFactory serviceFactory;

    private ServiceFactoryImpl() throws RemoteException {

    }

    public static ServiceFactory getInstance() throws RemoteException {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceTypes types) throws Exception {
        switch (types) {
            case ITEM:
                return new ItemServiceImpl();
            case SUPPLIER:
                return new SupplierServiceImpl();
            case ORDER_DETAILS:
                return new OrderDetailsServiceImpl();
            case ORDERS:
                return new OrderServiceImpl();
            case PAYMENT:
                return new PaymentServiceImpl();
            case GRN_PAYMENT:
                return new GRNPaymentServiceImpl();
            case GRN:
                return new GRNServiceImpl();
            case GRN_DETAILS:
                return new GRNDetailsServiceImpl();
            case CASHIER:
                return new CashierServiceImpl();
            case ADMIN:
                return new AdminServiceImpl();
            case REPORTS:
                return new ReportServiceImpl();
            default:
                return null;
        }
    }

}
