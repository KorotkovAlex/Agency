/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Саня
 */
@Entity
@Table(name = "ordering")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordering.findAll", query = "SELECT o FROM Ordering o")
    , @NamedQuery(name = "Ordering.findByIDOrdering", query = "SELECT o FROM Ordering o WHERE o.iDOrdering = :iDOrdering")
    , @NamedQuery(name = "Ordering.findByDate", query = "SELECT o FROM Ordering o WHERE o.date = :date")
    , @NamedQuery(name = "Ordering.findByQuartity", query = "SELECT o FROM Ordering o WHERE o.quartity = :quartity")})
public class Ordering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOrdering")
    private Integer iDOrdering;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quartity")
    private int quartity;
    @JoinColumn(name = "IDEmployee", referencedColumnName = "IDEmployee")
    @ManyToOne(optional = false)
    private Employee iDEmployee;
    @JoinColumn(name = "IDProduct", referencedColumnName = "IDProduct")
    @ManyToOne(optional = false)
    private Product iDProduct;
    @JoinColumn(name = "IDClient", referencedColumnName = "IDClient")
    @ManyToOne(optional = false)
    private Client iDClient;

    public Ordering() {
    }

    public Ordering(Integer iDOrdering) {
        this.iDOrdering = iDOrdering;
    }

    public Ordering(Integer iDOrdering, Date date, int quartity) {
        this.iDOrdering = iDOrdering;
        this.date = date;
        this.quartity = quartity;
    }

    public Integer getIDOrdering() {
        return iDOrdering;
    }

    public void setIDOrdering(Integer iDOrdering) {
        this.iDOrdering = iDOrdering;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuartity() {
        return quartity;
    }

    public void setQuartity(int quartity) {
        this.quartity = quartity;
    }

    public Employee getIDEmployee() {
        return iDEmployee;
    }

    public void setIDEmployee(Employee iDEmployee) {
        this.iDEmployee = iDEmployee;
    }

    public Product getIDProduct() {
        return iDProduct;
    }

    public void setIDProduct(Product iDProduct) {
        this.iDProduct = iDProduct;
    }

    public Client getIDClient() {
        return iDClient;
    }

    public void setIDClient(Client iDClient) {
        this.iDClient = iDClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOrdering != null ? iDOrdering.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordering)) {
            return false;
        }
        Ordering other = (Ordering) object;
        if ((this.iDOrdering == null && other.iDOrdering != null) || (this.iDOrdering != null && !this.iDOrdering.equals(other.iDOrdering))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ordering[ iDOrdering=" + iDOrdering + " ]";
    }
    
}
