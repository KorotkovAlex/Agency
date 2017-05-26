/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Facades.ClientFacadeLocal;
import Facades.ProductFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.Client;
import model.Product;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
/**
 *
 * @author Саня
 */
@Named(value = "clientManagedBean")
@SessionScoped
public class ClientManagedBean implements Serializable{

    @EJB
    private ClientFacadeLocal clientFacadeLocal;
    private Client client = new Client();
    @EJB
    private ProductFacadeLocal productFacadeLocal;
    private Product product = new Product();
    public ClientManagedBean() {
    }
    
    public List<Client> findAll () {
        return this.clientFacadeLocal.findAll();
    }
    
    public String create() {
        this.clientFacadeLocal.create(getClient());
//        this.productFacadeLocal.addInJoinTable(product.getIDProduct(), client.getIDClient() );
        return "/faces/index.xhtml";        
    }

    public String edit(Client client) {
        this.setClient(client);
        return "edit";
    }
    
    public String edit() {
        this.clientFacadeLocal.edit(this.getClient());
        return "index";
    }
    public void remove(Client client) {
        this.clientFacadeLocal.remove(client);
    }

    public Client find(Object id) {
        return this.clientFacadeLocal.find(id);
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
    
}
