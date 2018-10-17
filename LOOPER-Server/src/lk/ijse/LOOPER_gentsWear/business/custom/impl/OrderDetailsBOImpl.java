/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import lk.ijse.LOOPER_gentsWear.business.custom.OrderDetailsBO;
import lk.ijse.LOOPER_gentsWear.dto.OrderDetailsDTO;
import lk.ijse.LOOPER_gentsWear.entity.OrderDetails;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.repository.custom.OrderDetailsRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sandun_CJ
 */
public class OrderDetailsBOImpl implements OrderDetailsBO{
    
    private OrderDetailsRepository detailsRepository;

    public OrderDetailsBOImpl() {
        this.detailsRepository = (OrderDetailsRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDER_DETAILS);
    }
    
    @Override
    public boolean addOrderDetails(OrderDetailsDTO orderDetails) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = null;
            detailsRepository.setSession(session);

            OrderDetails ordersDetails1 = new OrderDetails();
            ordersDetails1.setItem(ordersDetails1.getItem());
            ordersDetails1.setOrder(ordersDetails1.getOrder());
            try {
                session.beginTransaction();
                boolean result = detailsRepository.save(ordersDetails1);

                if (result) {
                    tx.commit();
                    return true;
                } else {
                    tx.rollback();
                    return false;
                }

            } catch (HibernateException e) {
                e.printStackTrace();
                tx.rollback();
                return false;
            } finally {
                session.close();
            }
        }
    }
    
}
