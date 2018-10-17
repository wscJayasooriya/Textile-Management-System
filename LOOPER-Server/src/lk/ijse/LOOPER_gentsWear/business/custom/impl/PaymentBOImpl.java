/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.custom.PaymentBO;
import lk.ijse.LOOPER_gentsWear.dto.PaymentDTO;
import lk.ijse.LOOPER_gentsWear.entity.Payment;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.repository.custom.PaymentRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class PaymentBOImpl implements PaymentBO {

    private PaymentRepository paymentRepository;

    public PaymentBOImpl() {
        paymentRepository = (PaymentRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PAYMENT);
    }

    @Override
    public boolean addPayment(PaymentDTO payment) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            paymentRepository.setSession(session);
            session.beginTransaction();

            Payment pay = new Payment(payment.getGrossAmount(),
                    payment.getCash(),
                    payment.getBalance());

            boolean result = paymentRepository.save(pay);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            paymentRepository.setSession(session);

            session.beginTransaction();

            List<Payment> payments = paymentRepository.findAll();

            session.getTransaction().commit();

            if (payments != null) {

                List<PaymentDTO> allPayments = new ArrayList<>();

                for (Payment payment : payments) {
                    PaymentDTO dto = new PaymentDTO(payment.getpId(),
                            payment.getGrossAmount(),
                            payment.getCash(),
                            payment.getBalance());
                    allPayments.add(dto);
                }

                return allPayments;

            } else {

                return null;
            }

        }
    }

}
