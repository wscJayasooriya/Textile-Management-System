/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.LOOPER_gentsWear.dto.CashierDTO;
import lk.ijse.LOOPER_gentsWear.entity.Cashier;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;
import lk.ijse.LOOPER_gentsWear.business.custom.CashierBO;
import lk.ijse.LOOPER_gentsWear.repository.custom.CashierRepository;

/**
 *
 * @author Sandun_CJ
 */
public class CashierBOImpl implements CashierBO {

    private CashierRepository cashierRepository;

    public CashierBOImpl() {
        cashierRepository = (CashierRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CASHIER);
    }

    @Override
    public boolean addCashier(CashierDTO cashier) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            cashierRepository.setSession(session);
            session.beginTransaction();

            Cashier cs = new Cashier(cashier.getC_id(),
                    cashier.getC_name(),
                    cashier.getC_password());

            boolean result = cashierRepository.save(cs);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteCashier(String c_id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            cashierRepository.setSession(session);
            session.beginTransaction();

            Cashier cashier = cashierRepository.findBy(Integer.parseInt(c_id));
            boolean result = false;

            if (cashier != null) {
                cashierRepository.delete(cashier);
            }
            session.getTransaction().commit();
            result = true;
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CashierDTO> getAllCashiers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            cashierRepository.setSession(session);

            session.beginTransaction();

            List<Cashier> cashiers = cashierRepository.findAll();

            session.getTransaction().commit();

            if (cashiers != null) {

                List<CashierDTO> allCashiers = new ArrayList<>();

                for (Cashier cashier : cashiers) {
                    CashierDTO dto = new CashierDTO(cashier.getC_id(),
                            cashier.getC_name(),
                            cashier.getC_password());
                    allCashiers.add(dto);
                }
                return allCashiers;

            } else {

                return null;
            }

        }
    }

    @Override
    public CashierDTO searchCasshier(String c_id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            cashierRepository.setSession(session);

            session.beginTransaction();

            Cashier cashier = cashierRepository.findBy(Integer.parseInt(c_id));

            session.getTransaction().commit();

            if (cashier != null) {
                CashierDTO dto = new CashierDTO(cashier.getC_id(),
                        cashier.getC_name(),
                        cashier.getC_password());
                return dto;
            } else {
                return null;
            }

        }
    }

}
