/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.custom.ItemBO;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.entity.Item;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.repository.custom.ItemRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class ItemBOImpl implements ItemBO {

    private ItemRepository itemRepository;

    public ItemBOImpl() {
        this.itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ITEM);
    }

    @Override
    public boolean addItem(ItemDTO item) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemRepository.setSession(session);
            session.beginTransaction();

            Item i = new Item(item.getiCode(),
                    item.getCategoryName(),
                    item.getDescription(),
                    item.getBrand(),
                    item.getSellingPrice(),
                    item.getQty());

            boolean result = itemRepository.save(i);

            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateItem(ItemDTO item) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemRepository.setSession(session);
            session.beginTransaction();

            Item i = new Item(item.getiCode(),
                    item.getCategoryName(),
                    item.getDescription(),
                    item.getBrand(),
                    item.getSellingPrice(),
                    item.getQty());

            itemRepository.update(i);

            session.getTransaction().commit();
            
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteItem(String itemId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            itemRepository.setSession(session);
            session.beginTransaction();

            Item item = itemRepository.findBy(itemId);
            boolean result = false;

            if (item != null) {
                itemRepository.delete(item);
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
    public List<ItemDTO> getAllItems() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            itemRepository.setSession(session);

            session.beginTransaction();

            List<Item> items = itemRepository.findAll();

            session.getTransaction().commit();

            if (items != null) {

                List<ItemDTO> allItems = new ArrayList<>();

                for (Item item : items) {
                    ItemDTO dto = new ItemDTO(item.getiCode(),
                            item.getCategoryName(),
                            item.getDescription(),
                            item.getBrand(),
                            item.getSellingPrice(),
                            item.getQty());
                    allItems.add(dto);
                }

                return allItems;

            } else {

                return null;
            }

        }
    }

    @Override
    public ItemDTO searchItemByName(ItemDTO dto) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        itemRepository.setSession(session);
        session.beginTransaction();
        Item item = itemRepository.searchItemByName(dto.getDescription());
//        item = (Item) session.createCriteria(item.getClass()).add(Restrictions.eq("description", name)).list().get(0);
        ItemDTO idto = new ItemDTO();
        idto.setiCode(item.getiCode());
        idto.setDescription(item.getDescription());
        idto.setCategoryName(item.getCategoryName());
        idto.setBrand(item.getBrand());
        idto.setQty(item.getQty());
        idto.setSellingPrice(item.getSellingPrice());
        session.getTransaction().commit();
        session.close();
        return idto;
    }

    @Override
    public ItemDTO searchItemCode(String itemCode) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            itemRepository.setSession(session);

            session.beginTransaction();

            Item item = itemRepository.findBy(itemCode);

            session.getTransaction().commit();

            if (item != null) {
                ItemDTO dto = new ItemDTO(item.getiCode(),
                        item.getCategoryName(),
                        item.getDescription(),
                        item.getBrand(),
                        item.getSellingPrice(),
                        item.getQty());
                return dto;
            } else {
                return null;
            }

        }
    }

}
