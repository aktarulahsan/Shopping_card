package entity;
// Generated Oct 13, 2018 5:50:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product  implements java.io.Serializable {


     private Integer proId;
     private SubCategory subCategory;
     private String proName;
     private int proQty;
     private double proPrice;
     private String proUrl;
     private String proDesc;
     private Set proOrderDetailses = new HashSet(0);

    public Product() {
    }

	
    public Product(SubCategory subCategory, String proName, int proQty, double proPrice, String proUrl, String proDesc) {
        this.subCategory = subCategory;
        this.proName = proName;
        this.proQty = proQty;
        this.proPrice = proPrice;
        this.proUrl = proUrl;
        this.proDesc = proDesc;
    }
    public Product(SubCategory subCategory, String proName, int proQty, double proPrice, String proUrl, String proDesc, Set proOrderDetailses) {
       this.subCategory = subCategory;
       this.proName = proName;
       this.proQty = proQty;
       this.proPrice = proPrice;
       this.proUrl = proUrl;
       this.proDesc = proDesc;
       this.proOrderDetailses = proOrderDetailses;
    }
   
    public Integer getProId() {
        return this.proId;
    }
    
    public void setProId(Integer proId) {
        this.proId = proId;
    }
    public SubCategory getSubCategory() {
        return this.subCategory;
    }
    
    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
    public String getProName() {
        return this.proName;
    }
    
    public void setProName(String proName) {
        this.proName = proName;
    }
    public int getProQty() {
        return this.proQty;
    }
    
    public void setProQty(int proQty) {
        this.proQty = proQty;
    }
    public double getProPrice() {
        return this.proPrice;
    }
    
    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }
    public String getProUrl() {
        return this.proUrl;
    }
    
    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
    }
    public String getProDesc() {
        return this.proDesc;
    }
    
    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }
    public Set getProOrderDetailses() {
        return this.proOrderDetailses;
    }
    
    public void setProOrderDetailses(Set proOrderDetailses) {
        this.proOrderDetailses = proOrderDetailses;
    }




}


