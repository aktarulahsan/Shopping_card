/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.AddDao;
import dao.ListDao;
import entity.Product;
import entity.SubCategory;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author aktar
 */
@ManagedBean
@SessionScoped
public class productMB {
 Product product = new Product();
    SubCategory subcat= new SubCategory();
    String subcatname;
    String catname="";
    String productname="";
    
    List<SubCategory>listSubCat;
    
    UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    
    
    
    
    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public List<SubCategory> getListSubCat() {
        return listSubCat;
    }

    public void setListSubCat(List<SubCategory> listSubCat) {
        this.listSubCat = listSubCat;
    }
    
    public String addProduct(){
        upload();
        listSubCat = new ListDao().subcatListByName(subcatname);
        subcat.setSubCatId(listSubCat.get(0).getSubCatId());
        product.setSubCategory(subcat);
        product.setProName(product.getProName());
        product.setProQty(product.getProQty());
        product.setProPrice(product.getProPrice());
        product.setProUrl(product.getProUrl());
        product.setProDesc(product.getProDesc());
        boolean status= new AddDao().addProduct(product);
        if(status){
           FacesContext.getCurrentInstance().addMessage(null, new
 FacesMessage(FacesMessage.SEVERITY_INFO,"Product Save",""));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new
 FacesMessage(FacesMessage.SEVERITY_INFO,"Product not  Save",""));
        }
     return null;
    }
    
    
    public String updatepro(){
        upload();
        listSubCat= new ListDao().subcatListByName(subcatname);
        subcat.setSubCatId(listSubCat.get(0).getSubCatId());
        product.setProName(catname);
        
        return null;
    }
    
    
    
public void upload(){
    if(file !=null){
    
        try {
            FacesContext context= FacesContext.getCurrentInstance();
            ServletContext servletcontext = (ServletContext)context.getExternalContext().getContext();
        String dbpath = servletcontext.getRealPath("/");
        String webcut= dbpath.substring(0, dbpath.lastIndexOf("\\"));
        String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
        String mainURLpath= buildcut.substring(0, buildcut.lastIndexOf("\\"));
        
        InputStream inputstream = file.getInputstream();
        String path= mainURLpath+"\\web\\resources\\imeges\\"+file.getFileName();
        
        File destFile= new File(path);
            System.out.println(path);
        if(!destFile.exists()){
            FileUtils.copyInputStreamToFile(inputstream, destFile);
        }
        
        product.setProUrl(file.getFileName().toString());
        } catch (Exception e) { 
        }
        
        
    }
}

public List<SelectItem> getSubCategoryName(){
    List<SelectItem> subcatname= new ListDao().subcatList(catname);
    return subcatname; 
    
}    
 public List<SelectItem> getSubcatProductname(){
     List<SelectItem> porductname= new ListDao().subcatproductList(productname);
     return porductname;
     
     
     //for sub ca
 }
    
}
