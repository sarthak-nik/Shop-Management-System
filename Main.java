package com.company;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    public static void Menu1()
    {
        System.out.println("1.Create An Entity\n2.Delete an Entity\n3.Print Entities\n" +
                           "4.Add copies of a product to shop\n5.List inventory of a shop\n" +
                           "6.List products of a manufacturer\n7.List the purchase history of Customer\n" +
                           "8.Add an order\n9.Process order\n10.exit");
    }
    public static void Menu2()
    {
        System.out.println("Select the entity:\n1.Manufacturer\n"+
                "2.Customer\n3.Product\n4.Shops and Warehouses\n5.Agent\n");
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int temp,temp1,temp2;

        while(true)
        {
            Menu1();
            temp1= scanner.nextInt();
            if(temp1==10)break;
            switch(temp1)
            {
                case 1:
                    //Creating Entity
                    Menu2();
                    temp2=scanner.nextInt();
                    switch(temp2)
                    {
                        case 1:
                            Manufacturer m=new Manufacturer(scanner);
                            Manufacturer.manufacturerList.put(m.id,m);

                            break;
                        case 2:
                            Customer c=new Customer(scanner);
                            Customer.customerList.put(c.id,c);
                            break;
                        case 3:
                            Product p=new Product(scanner);
                            Product.productList.put(p.id,p);

                            break;
                        case 4:
                            Shop s=new Shop(scanner);
                            Shop.shopList.put(s.id,s);
                            break;
                        case 5:
                            Agent a=new Agent(scanner);
                            Agent.agentList.put(a.id,a);
                            break;
                    }
                    break;
                case 2:
                    //deleting Entity
                    Menu2();
                    temp2=scanner.nextInt();
                    switch(temp2)
                    {
                        case 1:
                            Manufacturer.deleteManufacturer(scanner);
                            break;
                        case 2:
                            Customer.deleteCustomer(scanner);
                            break;
                        case 3:
                            Product.deleteProduct(scanner);
                            break;
                        case 4:
                            Shop.deleteShop(scanner);
                            break;
                        case 5:
                            Agent.deleteAgent(scanner);
                            break;
                        default:

                    }

                    break;
                case 3:
                    //printing entities
                    Menu2();
                    temp2=scanner.nextInt();
                    switch(temp2)
                    {
                        case 1:
                            Manufacturer.printManufacturers();
                            break;
                        case 2:
                            Customer.printCustomers();
                            break;
                        case 3:
                            Product.printProducts();
                            break;
                        case 4:
                            Shop.printShops();
                            break;
                        case 5:
                            Agent.printAgents();
                            break;
                        default:

                    }
                    break;
                case 4:
                    //adding product to shop
                    Shop.printShops();
                    System.out.println("Enter the id of shop in which you want to add product: ");
                    temp= scanner.nextInt();
                    Product.printProducts();
                    System.out.println("Enter the id of product you want to add: ");
                    int pId=scanner.nextInt();
                    System.out.println("Enter the number of copies you want to add: ");
                    int copies= scanner.nextInt();
                    Shop.shopList.get(temp).addProduct(Product.productList.get(pId),copies);
                    break;
                case 5:
                    //listing inventory of shop
                    Shop.printShops();
                    System.out.println("Enter the id of Shop: ");
                    temp= scanner.nextInt();
                    Shop.shopList.get(temp).listInventory();
                    break;
                case 6:
                    //listing products of a manufacturer
                    Manufacturer.printManufacturers();
                    System.out.println("Enter the id of manufacturer: ");
                    temp= scanner.nextInt();
                    Manufacturer.manufacturerList.get(temp).listProducts();
                    break;
                case 7:
                    //printing purchase history of customer
                    Customer.printCustomers();
                    System.out.println("Enter the id of the customer for the purchase history:");
                    temp=scanner.nextInt();
                    Customer.customerList.get(temp).printHistory();
                    break;
                case 8:
                    //adding a new order
                    Order order=new Order();
                    Customer.printCustomers();
                    System.out.println("Enter the customer Id: ");
                    order.customer_Id=scanner.nextInt();
                    Product.printProducts();
                    System.out.println("Enter the product Id: ");
                    order.product_Id=scanner.nextInt();
                    System.out.println("Enter the zipcode: ");
                    order.zipcode=scanner.nextInt();
                    System.out.println("Enter number of copies of a product: ");
                    order.copies=scanner.nextInt();
                    Order.orderList.add(order);
                    break;
                case 9:
                    //process order
                    for(int i=0;i<Order.orderList.size();i++)
                    {
                        Order order1=Order.orderList.get(i);
                        System.out.println(i+1+". Customer_Id: "+order1.customer_Id+
                                            " Product_Id: "+ order1.customer_Id+
                                             " zipcode: "+ order1.zipcode+
                                             " copies: "+order1.copies);
                    }
                    System.out.println("Select the order to be processed: ");
                    temp=scanner.nextInt();
                    if(Order.orderList.get(temp-1).processOrder()==0)
                    {
                        Order.orderList.remove(temp-1);
                    }
                    break;
            }
        }


    }
}

