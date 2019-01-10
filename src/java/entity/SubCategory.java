package entity;
// Generated Oct 13, 2018 5:50:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * SubCategory generated by hbm2java
 */
public class SubCategory  implements java.io.Serializable {


     private Integer subCatId;
     private Category category;
     private String subCatName;
     private String subCatDesc;
     private Set products = new HashSet(0);

    public SubCategory() {
    }

	
    public SubCategory(Category category, String subCatName, String subCatDesc) {
        this.category = category;
        this.subCatName = subCatName;
        this.subCatDesc = subCatDesc;
    }
    public SubCategory(Category category, String subCatName, String subCatDesc, Set products) {
       this.category = category;
       this.subCatName = subCatName;
       this.subCatDesc = subCatDesc;
       this.products = products;
    }
   
    public Integer getSubCatId() {
        return this.subCatId;
    }
    
    public void setSubCatId(Integer subCatId) {
        this.subCatId = subCatId;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getSubCatName() {
        return this.subCatName;
    }
    
    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }
    public String getSubCatDesc() {
        return this.subCatDesc;
    }
    
    public void setSubCatDesc(String subCatDesc) {
        this.subCatDesc = subCatDesc;
    }
    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }




}


