/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.reservation.impl;

import java.util.HashMap;
import java.util.Map;
import lk.ijse.LOOPER_gentsWear.service.SuperService;

/**
 *
 * @author Sandun_CJ
 */
public class ReservationImpl<T extends SuperService> {
    
    private static class ResPage<T>{
        
        private T service;
        private boolean interally;

        public ResPage(T service, boolean interally) {
            this.service = service;
            this.interally = interally;
        }

        /**
         * @return the service
         */
        public T getService() {
            return service;
        }

        /**
         * @param service the service to set
         */
        public void setService(T service) {
            this.service = service;
        }

        /**
         * @return the interally
         */
        public boolean isInterally() {
            return interally;
        }

        /**
         * @param interally the interally to set
         */
        public void setInterally(boolean interally) {
            this.interally = interally;
        }
    }
    
    private Map<Object, ResPage<T>> resBook = new HashMap<>();
    
    public boolean reserve(Object key, T service, boolean internally){
        if (resBook.containsKey(key)){
            if (resBook.get(key).service == service){
                return true;
            }else{
                return false;
            }
        }else{
            resBook.put(key, new ResPage<>(service,internally));
            return true;
        }
    }
    
    public boolean isInternalReservation(Object key){
        if (resBook.containsKey(key)){
            return resBook.get(key).interally;
        }else{
            return false;
        }
    }
    
    public boolean release(Object key){
        if (resBook.containsKey(key)){
            resBook.remove(key);
            return true;
        }else{
            return false;
        }
    }
}
