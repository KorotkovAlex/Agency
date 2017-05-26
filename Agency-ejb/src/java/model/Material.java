/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findByIDMaterial", query = "SELECT m FROM Material m WHERE m.iDMaterial = :iDMaterial")
    , @NamedQuery(name = "Material.findByNameMaterial", query = "SELECT m FROM Material m WHERE m.nameMaterial = :nameMaterial")
    , @NamedQuery(name = "Material.findByPresence", query = "SELECT m FROM Material m WHERE m.presence = :presence")
    , @NamedQuery(name = "Material.findByPrice", query = "SELECT m FROM Material m WHERE m.price = :price")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMaterial")
    private Integer iDMaterial;
    @Size(max = 50)
    @Column(name = "NameMaterial")
    private String nameMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Presence")
    private boolean presence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private int price;
    @ManyToMany(mappedBy = "materialList")
    private List<Product> productList;

    public Material() {
    }

    public Material(Integer iDMaterial) {
        this.iDMaterial = iDMaterial;
    }

    public Material(Integer iDMaterial, boolean presence, int price) {
        this.iDMaterial = iDMaterial;
        this.presence = presence;
        this.price = price;
    }

    public Integer getIDMaterial() {
        return iDMaterial;
    }

    public void setIDMaterial(Integer iDMaterial) {
        this.iDMaterial = iDMaterial;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public boolean getPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDMaterial != null ? iDMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.iDMaterial == null && other.iDMaterial != null) || (this.iDMaterial != null && !this.iDMaterial.equals(other.iDMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Material[ iDMaterial=" + iDMaterial + " ]";
    }
    
}
