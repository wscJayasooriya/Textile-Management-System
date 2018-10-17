/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business;

import lk.ijse.LOOPER_gentsWear.business.custom.impl.AdminBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.CashierBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.GRNBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.GRNDetailsBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.GRNPaymentBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.ItemBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.OrderBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.OrderDetailsBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.PaymentBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.ReportBOImpl;
import lk.ijse.LOOPER_gentsWear.business.custom.impl.SupplierBOImpl;

/**
 *
 * @author Sandun_CJ
 */
public class BOFactory {

    public enum BOTypes {
        ITEM, SUPPLIER, ORDER_DETAILS, ORDERS, PAYMENT, GRN_PAYMENT, GRN_DETAILS, GRN, CASHIER,ADMIN,REPORTS
    }

    private static BOFactory bOFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case ITEM:
                return new ItemBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case ORDER_DETAILS:
                return new OrderDetailsBOImpl();
            case ORDERS:
                return new OrderBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case GRN_DETAILS:
                return new GRNDetailsBOImpl();
            case GRN:
                return new GRNBOImpl();
            case GRN_PAYMENT:
                return new GRNPaymentBOImpl();
            case CASHIER:
                return new CashierBOImpl();
            case ADMIN:
                return new AdminBOImpl();
            case REPORTS:
                return new ReportBOImpl();
            default:
                return null;
        }
    }

}
