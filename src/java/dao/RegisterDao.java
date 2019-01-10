/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author aktar
 */
public class RegisterDao {
    
    public boolean updateproduct(Product p){
        try {
            SessionFactory sf= HibernateUtil.getSessionFactory();
            Session s= sf.openSession();
            s.beginTransaction();
            
            s.update(p);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    
    
    }
    
    
    
}
