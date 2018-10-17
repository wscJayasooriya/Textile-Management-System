/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import lk.ijse.LOOPER_gentsWear.business.custom.GRNDetailsBO;
import lk.ijse.LOOPER_gentsWear.dto.GRNDetailsDTO;
import lk.ijse.LOOPER_gentsWear.entity.GRNDetails;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.repository.custom.GRNDetailsRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sandun_CJ
 */
public class GRNDetailsBOImpl implements GRNDetailsBO{
    
    private GRNDetailsRepository detailsRepository;

    public GRNDetailsBOImpl() {
         detailsRepository = (GRNDetailsRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.GRN_DETAILS);
    }
    
    @Override
    public boolean addGRNDetails(GRNDetailsDTO gRNDetailsDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = null;
            detailsRepository.setSession(session);

            GRNDetails details = new GRNDetails();
            details.setItem(details.getItem());
            details.setGrn(details.getGrn());
            try {
                session.beginTransaction();
                boolean result = detailsRepository.save(details);

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
