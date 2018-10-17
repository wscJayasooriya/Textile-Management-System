/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.custom.GRNBO;
import lk.ijse.LOOPER_gentsWear.dto.GRNDTO;
import lk.ijse.LOOPER_gentsWear.dto.GRNDetailsDTO;
import lk.ijse.LOOPER_gentsWear.dto.GRNPaymentDTO;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.entity.GRN;
import lk.ijse.LOOPER_gentsWear.entity.GRNDetails;
import lk.ijse.LOOPER_gentsWear.entity.GRNDetails_pk;
import lk.ijse.LOOPER_gentsWear.entity.GRNPayment;
import lk.ijse.LOOPER_gentsWear.entity.Item;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.repository.custom.GRNDetailsRepository;
import lk.ijse.LOOPER_gentsWear.repository.custom.GRNPaymentRepository;
import lk.ijse.LOOPER_gentsWear.repository.custom.GRNRepository;
import lk.ijse.LOOPER_gentsWear.repository.custom.ItemRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class GRNBOImpl implements GRNBO{
    
    private GRNRepository gRNRepository;
    private GRNDetailsRepository detailsRepository;
    private ItemRepository itemRepository;
    private GRNPaymentRepository paymentRepository;

    public GRNBOImpl() {
         gRNRepository = (GRNRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.GRN);
         detailsRepository = (GRNDetailsRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.GRN_DETAILS);
         itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ITEM);
         paymentRepository = (GRNPaymentRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.GRN_PAYMENT);
    }

    @Override
    public boolean saveGRN(GRNDTO grndto) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            gRNRepository.setSession(session);
            detailsRepository.setSession(session);
            itemRepository.setSession(session);
            paymentRepository.setSession(session);

            GRN od = new GRN();
            od.setGRNID(grndto.getGRNID());
            od.setDate(grndto.getDate());
            od.setSup_id(grndto.getSup_id());
            od.setBatch_Id(grndto.getBatch_Id());
            od.setQty(grndto.getQty());
            od.setBuyingPrice(grndto.getBuyingPrice());

            GRNPaymentDTO paymentDTO = grndto.getgRNPaymentDTO();
            GRNPayment payment = new GRNPayment();
            payment.setAmount(paymentDTO.getAmount());
            od.setgRNPayment(payment);

            List<GRNDetails> list = new ArrayList<>();
            for (GRNDetailsDTO gRNDetailsDTO : grndto.getList()) {
                ItemDTO itemDto = gRNDetailsDTO.getItemDTO();
                Item item = new Item(itemDto.getiCode(), itemDto.getCategoryName(), itemDto.getDescription(), itemDto.getBrand(), itemDto.getSellingPrice(), itemDto.getQty());
                //Item item=new Item(itemDto.getiCode(), itemDto.getDescription());
                GRNDetails odetails = new GRNDetails();

                odetails.setGrn(od);
                odetails.setItem(item);

                odetails.setgRNDetails_pk(new GRNDetails_pk(od.getGRNID(), item.getiCode()));
                list.add(odetails);

                od.setDetailList(list);
//                int newQty = grndto.getQty()+ item.getQty();
//                item.setQty(newQty);
                itemRepository.update(item);
                
                gRNRepository.save(od);
                //detailsRepository.save(odetails);
                paymentRepository.save(payment);
            }
            session.getTransaction().commit();
            return true;

        }
    }

    @Override
    public List<GRNDTO> getAllGRNs() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
