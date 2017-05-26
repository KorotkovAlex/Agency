package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Material;
import model.Ordering;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-26T01:29:02")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> iDProduct;
    public static volatile ListAttribute<Product, Ordering> orderingList;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile ListAttribute<Product, Material> materialList;
    public static volatile SingularAttribute<Product, String> nameProduct;

}