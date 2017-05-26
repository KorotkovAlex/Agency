package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Ordering;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-26T01:29:02")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Integer> iDEmployee;
    public static volatile SingularAttribute<Employee, Integer> premium;
    public static volatile ListAttribute<Employee, Ordering> orderingList;
    public static volatile SingularAttribute<Employee, String> nameEmployee;
    public static volatile SingularAttribute<Employee, String> surnameEmployee;
    public static volatile SingularAttribute<Employee, Integer> wage;

}