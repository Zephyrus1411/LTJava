package com.ntt.pojo;

import com.ntt.pojo.OrderDetail;
import com.ntt.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-03T15:11:23")
@StaticMetamodel(Orderprd.class)
public class Orderprd_ { 

    public static volatile SingularAttribute<Orderprd, Long> amount;
    public static volatile SingularAttribute<Orderprd, Date> createdDate;
    public static volatile SingularAttribute<Orderprd, Integer> id;
    public static volatile SingularAttribute<Orderprd, User> userId;
    public static volatile SetAttribute<Orderprd, OrderDetail> orderDetailSet;

}