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
public class GRNDetailsDTO extends SuperDTO{
    private ItemDTO itemDTO;
    private GRNDTO grndto;

    public GRNDetailsDTO() {
    }

    public GRNDetailsDTO(ItemDTO itemDTO, GRNDTO grndto) {
        this.itemDTO = itemDTO;
        this.grndto = grndto;
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
     * @return the grndto
     */
    public GRNDTO getGrndto() {
        return grndto;
    }

    /**
     * @param grndto the grndto to set
     */
    public void setGrndto(GRNDTO grndto) {
        this.grndto = grndto;
    }
    
    
}
