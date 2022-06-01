package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Customer extends Entity{
    public int zipcode;
    static HashMap<Integer,Customer> customerList=new HashMap<>();
    ArrayList<Order> purchaseHistory=new ArrayList<>();
    public Customer(Scanner scanner)
    {
        super(scanner);
        System.out.println("Enter the zipcode:");
        this.zipcode=scanner.nextInt();
        System.out.println("Customer created");
    }

    public void printObj() {
        super.printObj();
        System.out.println("Zipcode: "+this.zipcode);
    }
    public static void printCustomers()
    {
        int i = 1;
        for (Map.Entry<Integer, Customer> e : customerList.entrySet())
        {
            if(e.getValue().isDeleted)continue;
            System.out.print(i + ". ");
            e.getValue().printObj();
            i++;
        }
    }
    public static void deleteCustomer(Scanner scanner)
    {
        Customer.printCustomers();
        System.out.println("Enter the id of entity you want to delete:");
        int temp=scanner.nextInt();
        Customer.customerList.get(temp).isDeleted=true;

    }
    public void printHistory()
    {
        for(int i=0;i<purchaseHistory.size();i++)
        {
            Order order=purchaseHistory.get(i);
            System.out.println(i+1+". Product Id: "+order.product_Id+" Product copies: "+order.copies+" Shop Id: "+order.shop_Id+" Zipcode: "+
                                order.zipcode+" Delivery Agent Id: "+order.agent_Id);
        }
    }

}
