/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.startup;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.LOOPER_gentsWear.service.impl.ServiceFactoryImpl;

/**
 *
 * @author Sandun_CJ
 */
public class ServerStart {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(2020);
            registry.rebind("looper_gents", ServiceFactoryImpl.getInstance());
            System.out.println("Server Stared Successfully...");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
