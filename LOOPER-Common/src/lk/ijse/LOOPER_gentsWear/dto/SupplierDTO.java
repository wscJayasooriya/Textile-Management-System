/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.dto;

/**
 *
 * @author sandun
 */
public class SupplierDTO extends SuperDTO{
    private String sup_id;
    private String sup_name;
    private String tel_no;
    private String nic;
    private String company_name;
    private String company_address;

    public SupplierDTO() {
    }

    public SupplierDTO(String sup_id, String sup_name, String tel_no, String nic, String company_name, String company_address) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.tel_no = tel_no;
        this.nic = nic;
        this.company_name = company_name;
        this.company_address = company_address;
    }

    /**
     * @return the sup_id
     */
    public String getSup_id() {
        return sup_id;
    }

    /**
     * @param sup_id the sup_id to set
     */
    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    /**
     * @return the sup_name
     */
    public String getSup_name() {
        return sup_name;
    }

    /**
     * @param sup_name the sup_name to set
     */
    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    /**
     * @return the tel_no
     */
    public String getTel_no() {
        return tel_no;
    }

    /**
     * @param tel_no the tel_no to set
     */
    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

   

    /**
     * @return the company_name
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * @param company_name the company_name to set
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    /**
     * @return the company_address
     */
    public String getCompany_address() {
        return company_address;
    }

    /**
     * @param company_address the company_address to set
     */
    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" + "sup_id=" + sup_id + ", sup_name=" + sup_name + ", tel_no=" + tel_no + ", nic=" + nic +  ", company_name=" + company_name + ", company_address=" + company_address + '}';
    }
    
    

    

    
    
}
