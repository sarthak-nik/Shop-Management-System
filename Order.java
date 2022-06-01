package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Order{
    int customer_Id=0;
    int product_Id=0;
    int manufacturer_Id=0;
    int shop_Id=0;
    int agent_Id=0;
    int zipcode=0;
    int copies=0;
    static ArrayList<Order> orderList=new ArrayList<>();

    public int processOrder()
    {
        manufacturer_Id=Product.productList.get(product_Id).manufacturerId;
        for (Map.Entry<Integer, Shop> e : Shop.shopList.entrySet())
        {
            if(!e.getValue().isDeleted && e.getValue().zipcode==this.zipcode && e.getValue().productQuantity.get(product_Id)>=copies)
            {
                shop_Id=e.getValue().id;
            }
        }
        int temp=Integer.MAX_VALUE;
        for (Map.Entry<Integer, Agent> e : Agent.agentList.entrySet())
        {
            if(!e.getValue().isDeleted && e.getValue().zipcode==this.zipcode && e.getValue().prodDelivered<temp)
            {
                agent_Id=e.getValue().id;
                temp=e.getValue().prodDelivered;
            }
        }
        if (Customer.customerList.get(customer_Id).isDeleted ||
                Manufacturer.manufacturerList.get(manufacturer_Id).isDeleted ||
                Product.productList.get(product_Id).isDeleted)
        {
            System.out.println("Unable to process order");
        }
        else if(shop_Id==0 || agent_Id==0)System.out.println("Unable to process order");
        else
        {
            int temp1=Shop.shopList.get(shop_Id).productQuantity.get(product_Id);
            Shop.shopList.get(shop_Id).productQuantity.put(product_Id,temp1-copies);
            Agent.agentList.get(agent_Id).prodDelivered++;
            Customer.customerList.get(customer_Id).purchaseHistory.add(this);
            System.out.println("Order Executed");
            return 0;
        }
        return -1;
    }

}