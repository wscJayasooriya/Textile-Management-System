/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.resource;

import java.io.File;
import lk.ijse.LOOPER_gentsWear.entity.Admin;
import lk.ijse.LOOPER_gentsWear.entity.Cashier;
import lk.ijse.LOOPER_gentsWear.entity.GRN;
import lk.ijse.LOOPER_gentsWear.entity.GRNDetails;
import lk.ijse.LOOPER_gentsWear.entity.GRNPayment;
import lk.ijse.LOOPER_gentsWear.entity.Item;
import lk.ijse.LOOPER_gentsWear.entity.OrderDetails;
import lk.ijse.LOOPER_gentsWear.entity.Orders;
import lk.ijse.LOOPER_gentsWear.entity.Payment;
import lk.ijse.LOOPER_gentsWear.entity.Supplier;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Sandun_CJ
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    private static StandardServiceRegistry registry;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            // (1) 
            File hibernateProperties = new File("setting/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();
            
            // (2)
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Supplier.class)
                    .addAnnotatedClass(OrderDetails.class)
                    .addAnnotatedClass(Orders.class)
                    .addAnnotatedClass(Payment.class)
                    .addAnnotatedClass(GRNDetails.class)
                    .addAnnotatedClass(GRN.class)
                    .addAnnotatedClass(GRNPayment.class)
                    .addAnnotatedClass(Cashier.class)
                    .addAnnotatedClass(Admin.class)
                    .buildMetadata().buildSessionFactory();
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            
            StandardServiceRegistryBuilder.destroy(registry);
            
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
