package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Ordering;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-26T01:29:02")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> address;
    public static volatile ListAttribute<Client, Ordering> orderingList;
    public static volatile SingularAttribute<Client, String> surnameClient;
    public static volatile SingularAttribute<Client, String> nameClient;
    public static volatile SingularAttribute<Client, Integer> iDClient;
    public static volatile SingularAttribute<Client, String> email;

}