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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByIDEmployee", query = "SELECT e FROM Employee e WHERE e.iDEmployee = :iDEmployee")
    , @NamedQuery(name = "Employee.findBySurnameEmployee", query = "SELECT e FROM Employee e WHERE e.surnameEmployee = :surnameEmployee")
    , @NamedQuery(name = "Employee.findByNameEmployee", query = "SELECT e FROM Employee e WHERE e.nameEmployee = :nameEmployee")
    , @NamedQuery(name = "Employee.findByWage", query = "SELECT e FROM Employee e WHERE e.wage = :wage")
    , @NamedQuery(name = "Employee.findByPremium", query = "SELECT e FROM Employee e WHERE e.premium = :premium")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEmployee")
    private Integer iDEmployee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "SurnameEmployee")
    private String surnameEmployee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NameEmployee")
    private String nameEmployee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Wage")
    private int wage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Premium")
    private int premium;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDEmployee")
    private List<Ordering> orderingList;

    public Employee() {
    }

    public Employee(Integer iDEmployee) {
        this.iDEmployee = iDEmployee;
    }

    public Employee(Integer iDEmployee, String surnameEmployee, String nameEmployee, int wage, int premium) {
        this.iDEmployee = iDEmployee;
        this.surnameEmployee = surnameEmployee;
        this.nameEmployee = nameEmployee;
        this.wage = wage;
        this.premium = premium;
    }

    public Integer getIDEmployee() {
        return iDEmployee;
    }

    public void setIDEmployee(Integer iDEmployee) {
        this.iDEmployee = iDEmployee;
    }

    public String getSurnameEmployee() {
        return surnameEmployee;
    }

    public void setSurnameEmployee(String surnameEmployee) {
        this.surnameEmployee = surnameEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
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
        hash += (iDEmployee != null ? iDEmployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.iDEmployee == null && other.iDEmployee != null) || (this.iDEmployee != null && !this.iDEmployee.equals(other.iDEmployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Employee[ iDEmployee=" + iDEmployee + " ]";
    }
    
}
