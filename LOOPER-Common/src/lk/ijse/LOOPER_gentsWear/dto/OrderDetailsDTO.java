/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.dto;

/**
 *
 * @author Sandun_CJ
 */
public class OrderDetailsDTO extends SuperDTO{
    
    private ItemDTO itemDTO;
    private OrderDTO orderDTO;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(ItemDTO itemDTO, OrderDTO orderDTO) {
        this.itemDTO = itemDTO;
        this.orderDTO = orderDTO;
    }

    /**
     * @return the itemDTO
     */
    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    /**
     * @param itemDTO the itemDTO to set
     */
    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    /**
     * @return the orderDTO
     */
    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    /**
     * @param orderDTO the orderDTO to set
     */
    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
    
    
    
}
