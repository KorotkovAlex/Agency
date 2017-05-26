/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Саня
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByIDProduct", query = "SELECT p FROM Product p WHERE p.iDProduct = :iDProduct")
    , @NamedQuery(name = "Product.findByNameProduct", query = "SELECT p FROM Product p WHERE p.nameProduct = :nameProduct")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduct")
    private Integer iDProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NameProduct")
    private String nameProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private int price;
    @JoinTable(name = "type", joinColumns = {
        @JoinColumn(name = "IDProductType", referencedColumnName = "IDProduct")}, inverseJoinColumns = {
        @JoinColumn(name = "IDMaterialType", referencedColumnName = "IDMaterial")})
    @ManyToMany
    private List<Material> materialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDProduct")
    private List<Ordering> orderingList;

    public Product() {
    }

    public Product(Integer iDProduct) {
        this.iDProduct = iDProduct;
    }

    public Product(Integer iDProduct, String nameProduct, int price) {
        this.iDProduct = iDProduct;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public Integer getIDProduct() {
        return iDProduct;
    }

    public void setIDProduct(Integer iDProduct) {
        this.iDProduct = iDProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @XmlTransient
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    @XmlTransient
    public List<Ordering> getOrderingList() {
        return orderingList;
    }

    public void setOrderingList(List<Ordering> orderingList) {
        this.orderingList = orderingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProduct != null ? iDProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.iDProduct == null && other.iDProduct != null) || (this.iDProduct != null && !this.iDProduct.equals(other.iDProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Product[ iDProduct=" + iDProduct + " ]";
    }
    
}
