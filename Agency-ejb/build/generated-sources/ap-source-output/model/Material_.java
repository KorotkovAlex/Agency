package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-26T01:29:02")
@StaticMetamodel(Material.class)
public class Material_ { 

    public static volatile SingularAttribute<Material, Integer> price;
    public static volatile SingularAttribute<Material, Integer> iDMaterial;
    public static volatile SingularAttribute<Material, Boolean> presence;
    public static volatile SingularAttribute<Material, String> nameMaterial;
    public static volatile ListAttribute<Material, Product> productList;

}