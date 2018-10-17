/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.custom.SupplierBO;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.dto.SupplierDTO;
import lk.ijse.LOOPER_gentsWear.entity.Item;
import lk.ijse.LOOPER_gentsWear.entity.Supplier;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.repository.custom.SupplierRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class SupplierBOImpl implements SupplierBO{
    
    private SupplierRepository supplierRepository;
    
    public SupplierBOImpl(){
         supplierRepository = (SupplierRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SUPPLIER);
    }

    @Override
    public boolean addSupplier(SupplierDTO supplier) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierRepository.setSession(session);
            session.beginTransaction();

            Supplier s = new Supplier(supplier.getSup_id(),
                    supplier.getSup_name(),
                    supplier.getTel_no(),
                    supplier.getNic(),
                    supplier.getCompany_name(),
                    supplier.getCompany_address());

            boolean result = supplierRepository.save(s);

            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierRepository.setSession(session);
            session.beginTransaction();

            Supplier s = new Supplier(supplier.getSup_id(),
                    supplier.getSup_name(),
                    supplier.getTel_no(),
                    supplier.getNic(),
                    supplier.getCompany_name(),
                    supplier.getCompany_address());

            supplierRepository.update(s);

            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSupplier(String supplierId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierRepository.setSession(session);
            session.beginTransaction();

            Supplier supplier = supplierRepository.findBy(supplierId);
            boolean result = false;

            if (supplier != null) {
                supplierRepository.delete(supplier);
            }
            session.getTransaction().commit();
            result=true;
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            supplierRepository.setSession(session);

            session.beginTransaction();

            List<Supplier> suppliers = supplierRepository.findAll();

            session.getTransaction().commit();

            if (suppliers != null) {

                List<SupplierDTO> allSuppliers = new ArrayList<>();

                for (Supplier supplier : suppliers) {
                    SupplierDTO dto = new SupplierDTO(supplier.getSup_id(),
                            supplier.getSup_name(),
                            supplier.getTel_no(),
                            supplier.getNic(),
                            supplier.getCompany_name(),
                            supplier.getCompany_address());
                    allSuppliers.add(dto);
                }

                return allSuppliers;

            } else {

                return null;
            }

        }
    }

    @Override
    public SupplierDTO searchSupplier(String supplierId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            supplierRepository.setSession(session);

            session.beginTransaction();

            Supplier supplier = supplierRepository.findBy(supplierId);

            session.getTransaction().commit();

            if (supplier != null) {
                SupplierDTO dto = new SupplierDTO(supplier.getSup_id(),
                        supplier.getSup_name(),
                        supplier.getTel_no(),
                        supplier.getNic(),
                        supplier.getCompany_name(),
                        supplier.getCompany_address());
                return dto;
            } else {
                return null;
            }

        }
    }

    @Override
    public SupplierDTO searchSupplierByName(String name) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            supplierRepository.setSession(session);

            session.beginTransaction();

            Supplier supplier = supplierRepository.findBy(name);

            session.getTransaction().commit();

            if (supplier != null) {
                SupplierDTO dto = new SupplierDTO(supplier.getSup_id(),
                        supplier.getSup_name(),
                        supplier.getTel_no(),
                        supplier.getNic(),
                        supplier.getCompany_name(),
                        supplier.getCompany_address());
                return dto;
            } else {
                return null;
            }

        }
    }

    @Override
    public boolean deleteSupplierByName(String name) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            supplierRepository.setSession(session);
            session.beginTransaction();

            Supplier supplier = supplierRepository.findBy(name);
            boolean result = false;

            if (supplier != null) {
                supplierRepository.delete(supplier);
            }
            session.getTransaction().commit();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
