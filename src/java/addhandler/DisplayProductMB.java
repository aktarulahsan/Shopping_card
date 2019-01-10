/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.ListDao;
import entity.Product;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author C3
 */
@ManagedBean
@SessionScoped
public class DisplayProductMB {
    Product product= new Product();
    private Product selectedProduct;

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public List<Product> getAllProduct(){
        
       List<Product> plist= new ListDao().allProductList();
       return plist;
    }
    
}
