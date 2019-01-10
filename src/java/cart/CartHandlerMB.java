/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author aktar
 */
@ManagedBean
@SessionScoped
public class CartHandlerMB {
    
        List<CartBind> cartList= new ArrayList<CartBind>();
        private List<Item> cart = new ArrayList<>();
        int productid;
        String productname;
        int quantity;
        double price;
        double total;
        int cartsize;
        String item="item";
        
        
    Map<Integer, CartBind> map= new HashMap<Integer, CartBind>();

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }
    
    
    
    

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    
    public int getCartsize() {
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    
    
    
    public Map<Integer, CartBind> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartBind> map) {
        this.map = map;
    }
    
    
    
    public List<CartBind> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartBind> cartList) {
        this.cartList = cartList;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

public String processCart(int qty){
    CartBind cb= new CartBind();
    quantity = qty;
    cb.setProductname(productname);
    cb.setQuantity(quantity);
    cb.setPrice(price);
    cb.setTotal(quantity*price);
    
    cartList.add(cb);
    map.put(productid, cb);
    cartsize= cartList.size();
    
    if(cartsize>1){
        item= "items";
        System.out.println(item);
    }

    return null;
}
    


    
}
