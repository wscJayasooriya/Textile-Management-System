/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.LOOPER_gentsWear.business.custom.OrderBO;
import lk.ijse.LOOPER_gentsWear.dto.ItemDTO;
import lk.ijse.LOOPER_gentsWear.dto.OrderDTO;
import lk.ijse.LOOPER_gentsWear.dto.OrderDetailsDTO;
import lk.ijse.LOOPER_gentsWear.dto.PaymentDTO;
import lk.ijse.LOOPER_gentsWear.entity.Item;
import lk.ijse.LOOPER_gentsWear.entity.OrderDetails;
import lk.ijse.LOOPER_gentsWear.entity.OrderDetails_pk;
import lk.ijse.LOOPER_gentsWear.entity.Orders;
import lk.ijse.LOOPER_gentsWear.entity.Payment;
import lk.ijse.LOOPER_gentsWear.repository.RepositoryFactory;
import lk.ijse.LOOPER_gentsWear.repository.custom.ItemRepository;
import lk.ijse.LOOPER_gentsWear.repository.custom.OrderDetailsRepository;
import lk.ijse.LOOPER_gentsWear.repository.custom.OrderRepository;
import lk.ijse.LOOPER_gentsWear.repository.custom.PaymentRepository;
import lk.ijse.LOOPER_gentsWear.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sandun_CJ
 */
public class OrderBOImpl implements OrderBO {

    private OrderRepository orderRepository;
    private OrderDetailsRepository orderDetailsRepository;
    private ItemRepository itemRepository;
    private PaymentRepository paymentRepository;

    public OrderBOImpl() {
        this.orderRepository = (OrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDERS);
        this.orderDetailsRepository = (OrderDetailsRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDER_DETAILS);
        this.itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ITEM);
        this.paymentRepository = (PaymentRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PAYMENT);

    }

    @Override
    public boolean saveOrder(OrderDTO orders) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            orderRepository.setSession(session);
            orderDetailsRepository.setSession(session);
            itemRepository.setSession(session);
            paymentRepository.setSession(session);

            Orders od = new Orders();
            od.setoId(orders.getoID());
            od.setoDate(orders.getoDate());
            od.setoTime(orders.getoTime());
            od.setAmount(orders.getAmount());

            PaymentDTO paymentDTO = orders.getPaymentDTO();
            Payment payment = new Payment();
            //payment.setpId(paymentDTO.getpId());
            payment.setGrossAmount(paymentDTO.getGrossAmount());
            payment.setCash(paymentDTO.getCash());
            payment.setBalance(paymentDTO.getBalance());
            od.setPayment(payment);

            List<OrderDetails> list = new ArrayList<>();
            for (OrderDetailsDTO orderDetailsDTO : orders.getList()) {
                ItemDTO itemDto = orderDetailsDTO.getItemDTO();
                Item item = new Item(itemDto.getiCode(), itemDto.getCategoryName(), itemDto.getDescription(), itemDto.getBrand(), itemDto.getSellingPrice(), itemDto.getQty());
                OrderDetails odetails = new OrderDetails();

                odetails.setOrder(od);
                odetails.setItem(item);

                odetails.setOrderDetails_pk(new OrderDetails_pk(od.getoId(), item.getiCode()));
                list.add(odetails);

                od.setDetailList(list);
                itemRepository.update(item);

                orderRepository.save(od);
                orderDetailsRepository.save(odetails);
                paymentRepository.save(payment);
            }
            session.getTransaction().commit();
            return true;

        }
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            orderRepository.setSession(session);

            session.beginTransaction();

            List<Orders> orderses = orderRepository.findAll();

            session.getTransaction().commit();

            if (orderses != null) {

                List<OrderDTO> allOrders = new ArrayList<>();

                for (Orders order : orderses) {
                    OrderDTO dTO = new OrderDTO();
                    dTO.setoID(order.getoId());
                    dTO.setoDate(order.getoDate());
                    allOrders.add(dTO);
                }

                return allOrders;

            } else {

                return null;
            }

        }
    }
}
