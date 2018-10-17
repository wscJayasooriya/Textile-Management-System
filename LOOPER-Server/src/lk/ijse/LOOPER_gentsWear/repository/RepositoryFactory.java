/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.repository;

import lk.ijse.LOOPER_gentsWear.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.CashierRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.GRNDetailsRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.GRNPaymentRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.GRNRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.ItemRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.OrderDetailsRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.OrderRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.PaymentRepositoryImpl;
import lk.ijse.LOOPER_gentsWear.repository.custom.impl.SupplierRepositoryImpl;

/**
 *
 * @author Sandun_CJ
 */
public class RepositoryFactory {

    public enum RepositoryTypes {
        ITEM, SUPPLIER,ORDER_DETAILS,ORDERS,PAYMENT,GRN_PAYMENT,GRN_DETAILS,GRN,CASHIER,ADMIN
    }

    public static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {

    }

    public static RepositoryFactory getInstance() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryTypes types) {
        switch (types) {
            case ITEM:
                return new ItemRepositoryImpl();
            case SUPPLIER:
                return new SupplierRepositoryImpl();
            case ORDER_DETAILS:
                return new OrderDetailsRepositoryImpl();
            case ORDERS:
                return new OrderRepositoryImpl();
            case PAYMENT:
                return new PaymentRepositoryImpl();
            case GRN_DETAILS:
                return new GRNDetailsRepositoryImpl();
            case GRN:
                return new GRNRepositoryImpl();
            case GRN_PAYMENT:
                return new GRNPaymentRepositoryImpl();
            case CASHIER:
                return new CashierRepositoryImpl();
            case ADMIN:
                return new AdminRepositoryImpl();
            default:
                return null;
        }
    }

}
