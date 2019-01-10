/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Product;
import entity.SubCategory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author C3
 */

public class ListDao {
    public List catList(){
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            List<Category> cList= session.createQuery("select al.catName from Category al").list();
            cList.toString();
            session.close();
            return cList;
    }
    
    public List<Category> catListAll(){
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            List<Category> cList= session.createQuery("select al from Category "
                    + "al ").list();
            cList.toString();
            session.close();
            return cList;
    }
    
    
    public List subcatList(String name){
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            List<Category> cList= session.createQuery("select al.subCatName from SubCategory al "
                    + "where al.category.catId  in(select a.catId from Category a where lower(a.catName)='"+name.toLowerCase()+"')").list();
            cList.toString();
            session.close();
            return cList;
    }
    
    
    public List subcatproductList(String name){
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            List<SubCategory> cList= session.createQuery("select al.proName from Product al "
                    + "where al.SubCategory.subCatId  in(select a.subCatId from SubCategory a where lower(a.subCatName)='"+name.toLowerCase()+"')").list();
            cList.toString();
            session.close();
            return cList;
    }
    
    
    public List<Category> catListByName(String name){
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            List<Category> cList= session.createQuery("select al from Category "
                    + "al where lower(catName)='"+name.toLowerCase()+"'").list();
            cList.toString();
            session.close();
            return cList;
    }
    
    public List<SubCategory> subcatListByName(String name){
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            List<SubCategory> cList= session.createQuery("select al from SubCategory "
                    + "al where lower(subCatName)='"+name.toLowerCase()+"'").list();
            cList.toString();
            session.close();
            return cList;
    }
    
    public List allProductList(){
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            List<Product> cList= session.createQuery("select al from Product al").list();
            cList.toString();
            session.close();
            return cList;
    }
    
}
