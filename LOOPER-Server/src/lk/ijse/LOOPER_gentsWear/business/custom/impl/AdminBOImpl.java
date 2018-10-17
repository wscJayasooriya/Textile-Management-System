/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.custom.AdminBO;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.dto.AdminDTO;
import lk.ijse.LOOPER_gentsWear.entity.Admin;
import lk.ijse.LOOPER_gentsWear.repository.custom.AdminRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class AdminBOImpl implements AdminBO {

    private AdminRepository adminRepository;

    public AdminBOImpl() {
        adminRepository = (AdminRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADMIN);
    }

    @Override
    public boolean addAdmin(AdminDTO admin) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            adminRepository.setSession(session);
            session.beginTransaction();

            Admin ad = new Admin(admin.getA_id(),
                    admin.getA_name(),
                    admin.getA_password());

            boolean result = adminRepository.save(ad);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteAdmin(int a_id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            adminRepository.setSession(session);
            session.beginTransaction();

            Admin admin = adminRepository.findBy(a_id);
            boolean result = false;

            if (admin != null) {
                adminRepository.delete(admin);
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
    public List<AdminDTO> getAllAdmin() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            adminRepository.setSession(session);

            session.beginTransaction();

            List<Admin> admins = adminRepository.findAll();

            session.getTransaction().commit();

            if (admins != null) {

                List<AdminDTO> allAdmins = new ArrayList<>();

                for (Admin admin : admins) {
                    AdminDTO dto = new AdminDTO(admin.getA_id(),
                            admin.getA_name(),
                            admin.getA_password());
                    allAdmins.add(dto);
                }
                return allAdmins;

            } else {

                return null;
            }

        }
    }

    @Override
    public AdminDTO searchAdmin(int a_id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            adminRepository.setSession(session);

            session.beginTransaction();

            Admin admin = adminRepository.findBy(a_id);

            session.getTransaction().commit();

            if (admin != null) {
                AdminDTO dto = new AdminDTO(admin.getA_id(),
                        admin.getA_name(),
                        admin.getA_password());
                return dto;
            } else {
                return null;
            }

        }
    }

    

}
