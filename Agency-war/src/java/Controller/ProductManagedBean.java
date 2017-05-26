/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Facades.MaterialFacadeLocal;
import Facades.ProductFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import model.Material;
import model.Product;

/**
 *
 * @author Саня
 */
@Named(value = "productManagedBean")
@SessionScoped
public class ProductManagedBean implements Serializable{
    
    @EJB
    private ProductFacadeLocal productFacadeLocal;
    private Product product = new Product();
    @EJB
    private MaterialFacadeLocal materialFacadeLocal;
    private Material material = new Material();
    /**
     * Creates a new instance of ProductManagedBean
     */
    public ProductManagedBean() {
    }
    
    /**
     * Creates a new instance of UserManagedBean
     */

    
    public List<Product> findAll () {
        return this.productFacadeLocal.findAll();
    }
    
    public String create() {
        Product product1 = product;
        Product product2 = this.product;
        material.getIDMaterial();
        this.productFacadeLocal.create(product);
        //this.materialFacadeLocal.create(material);
        this.productFacadeLocal.addInJoinTable(product.getIDProduct(),material.getIDMaterial());
        return "/faces/index.xhtml";
        
    }

    public String edit(Product product) {
        this.product = product;
        return "update";
    }
    
    public String edit() {
        this.productFacadeLocal.edit(this.product);
        return "/faces/index.xhtml";
    }
    public void remove(Product product) {
        this.productFacadeLocal.remove(product);
    }

    public Product find(Object id) {
        return this.productFacadeLocal.find(id);
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
     public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
