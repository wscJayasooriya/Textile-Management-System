/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.custom.GRNPaymentBO;
import lk.ijse.LOOPER_gentsWear.dto.GRNPaymentDTO;
import lk.ijse.LOOPER_gentsWear.dto.PaymentDTO;
import lk.ijse.LOOPER_gentsWear.entity.GRNPayment;
import lk.ijse.LOOPER_gentsWear.entity.Payment;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.repository.custom.GRNPaymentRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class GRNPaymentBOImpl implements GRNPaymentBO{
    
    private GRNPaymentRepository paymentRepository;

    public GRNPaymentBOImpl() {
         paymentRepository = (GRNPaymentRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.GRN_PAYMENT);
    }

    @Override
    public boolean addGRNPayment(GRNPaymentDTO payment) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            paymentRepository.setSession(session);
            session.beginTransaction();

            GRNPayment pay = new GRNPayment(payment.getAmount());

            boolean result = paymentRepository.save(pay);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<GRNPaymentDTO> getAllGRNPayment() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            paymentRepository.setSession(session);

            session.beginTransaction();

            List<GRNPayment> payments = paymentRepository.findAll();

            session.getTransaction().commit();

            if (payments != null) {

                List<GRNPaymentDTO> allPayments = new ArrayList<>();

                for (GRNPayment payment : payments) {
                    GRNPaymentDTO dto = new GRNPaymentDTO(payment.getGrn_pId(),
                            payment.getAmount());
                    allPayments.add(dto);
                }

                return allPayments;

            } else {

                return null;
            }

        }
    }
    
}
