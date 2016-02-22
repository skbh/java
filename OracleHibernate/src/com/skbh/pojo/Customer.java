package com.skbh.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class Customer {
   @Id @GeneratedValue(strategy=GenerationType.AUTO)
   public Integer getId() { return id; }
   public void setId(Integer id) { this.id = id; }
   private Integer id;
   private List<CustOrder> custOrders;

   @OneToMany(fetch=FetchType.LAZY,mappedBy="customer",cascade={CascadeType.ALL})
   @OrderBy("custnumber")
   public List<CustOrder> getOrders() { return custOrders; }
   public void setOrders(List<CustOrder> custOrders) { this.custOrders = custOrders; }
}