/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Facades.MaterialFacadeLocal;
import Facades.ClientFacadeLocal;
import Facades.EmployeeFacadeLocal;
import Facades.ProductFacadeLocal;
import Facades.OrderingFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import model.Client;
import model.Material;
import model.Product;
import model.Ordering;
import model.Employee;
/**
 *
 * @author Саня
 */
@Named(value = "orderingManagedBean")
@SessionScoped
public class OrderingManagedBean implements Serializable{

    /**
     * Creates a new instance of OrderingManagedBean
     */
    @EJB
    private ProductFacadeLocal productFacadeLocal;
    private Product product = new Product();
    
    @EJB
    private ClientFacadeLocal clientFacadeLocal;
    private Client client = new Client();    
    
    @EJB
    private OrderingFacadeLocal orderingFacadeLocal;
    private Ordering ordering = new Ordering();
    
    @EJB
    private EmployeeFacadeLocal employeeFacadeLocal;
    private Employee employee = new Employee();
    
    public OrderingManagedBean() {
    }
        
    public List<Ordering> findAll () {
        return this.orderingFacadeLocal.findAll();
    }
    
    public String create() {
        ordering.setIDClient(client);
        ordering.setIDEmployee(employee);
        ordering.setIDProduct(product);
        this.orderingFacadeLocal.create(ordering);
        //this.materialFacadeLocal.create(material);
        //this.productFacadeLocal.addInJoinTable(product.getIDProduct(),material.getIDMaterial());
        return "/faces/index.xhtml";
        
    }

    public String edit(Ordering ordering) {
        this.setOrdering(ordering);
        return "update";
    }
    
    public String edit() {
        this.orderingFacadeLocal.edit(this.getOrdering());
        return "/faces/index.xhtml";
    }
    
    public void remove(Ordering ordering) {
        this.orderingFacadeLocal.remove(ordering);
    }

    public Ordering find(Object id) {
        return this.orderingFacadeLocal.find(id);
    }
    
    
    
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//    
//     public Material getMaterial() {
//        return material;
//    }
//
//    public void setMaterial(Material material) {
//        this.material = material;
//    }

    /**
     * @return the ordering
     */
    public Ordering getOrdering() {
        return ordering;
    }

    /**
     * @param ordering the ordering to set
     */
    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
