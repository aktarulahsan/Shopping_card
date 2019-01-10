/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author aktar
 */
@ManagedBean
@SessionScoped
public class Singleproduct {
    
    Item pro = new Item();

    public Item getPro() {
        return pro;
    }

    public void setPro(Item pro) {
        this.pro = pro;
    }
    
    
    public String showproduct(Product p){
    
        Item i= new Item();
        i.setP(p);
        pro.setP(p);
        
        System.out.println(pro);
        return "product-page";
    
    }
    
    
}
