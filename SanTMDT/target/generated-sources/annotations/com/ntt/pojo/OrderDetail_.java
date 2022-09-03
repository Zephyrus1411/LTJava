package com.ntt.pojo;

import com.ntt.pojo.Orderprd;
import com.ntt.pojo.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-03T15:11:23")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Long> unitPrice;
    public static volatile SingularAttribute<OrderDetail, Product> product;
    public static volatile SingularAttribute<OrderDetail, Orderprd> orderprd;
    public static volatile SingularAttribute<OrderDetail, Integer> num;
    public static volatile SingularAttribute<OrderDetail, Integer> id;

}