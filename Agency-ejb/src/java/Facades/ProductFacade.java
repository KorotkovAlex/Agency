/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Material;
import model.Product;

/**
 *
 * @author Саня
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    @PersistenceContext(unitName = "Agency-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    @Override
    public void addInJoinTable(Integer idProduct, Integer idMaterial) {        
        Product product = em.find(Product.class, idProduct);
        Material material = em.find(Material.class, idMaterial);
        product.getMaterialList().add(material);
        material.getProductList().add(product);
    }
}
