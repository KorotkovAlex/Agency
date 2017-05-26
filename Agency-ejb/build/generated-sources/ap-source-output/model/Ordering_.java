package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Client;
import model.Employee;
import model.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-26T01:29:02")
@StaticMetamodel(Ordering.class)
public class Ordering_ { 

    public static volatile SingularAttribute<Ordering, Date> date;
    public static volatile SingularAttribute<Ordering, Employee> iDEmployee;
    public static volatile SingularAttribute<Ordering, Product> iDProduct;
    public static volatile SingularAttribute<Ordering, Integer> iDOrdering;
    public static volatile SingularAttribute<Ordering, Client> iDClient;
    public static volatile SingularAttribute<Ordering, Integer> quartity;

}