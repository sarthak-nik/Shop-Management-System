package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Shop extends Entity{
    int zipcode;
    static HashMap<Integer,Shop> shopList=new HashMap<>();
    HashMap<Integer,Integer> productQuantity=new HashMap<>();
    public Shop(Scanner scanner)
    {
        super(scanner);
        System.out.println("Enter the zipcode:");
        this.zipcode=scanner.nextInt();
        System.out.println("Shop created");
    }

    public void printObj() {
        super.printObj();
        System.out.println("Zipcode: "+this.zipcode);
    }
    public static void printShops()
    {
        int i = 1;
        for (Map.Entry<Integer, Shop> e : shopList.entrySet())
        {
            if(e.getValue().isDeleted)continue;
            System.out.print(i + ". ");
            e.getValue().printObj();
            i++;
        }
    }
    public static void deleteShop(Scanner scanner)
    {
        Shop.printShops();
        System.out.println("Enter the id of entity you want to delete:");
        int temp=scanner.nextInt();
        Shop.shopList.get(temp).isDeleted=true;

    }
    public void addProduct(Product product,int copies)
    {
        if(productQuantity.containsKey(product.id))
        {
            int temp=productQuantity.get(product.id);
            productQuantity.put(product.id,copies+temp);
        }
        else
        {
            productQuantity.put(product.id,copies);
        }
    }
    public void listInventory()
    {
        if(productQuantity.isEmpty())
        {
            System.out.println("Inventory is empty");
        }
        else
        {
            int i = 1;
            for (Map.Entry<Integer, Integer> e : productQuantity.entrySet())
            {
                Product p=Product.productList.get(e.getKey());
                if(p.isDeleted)continue;
                System.out.println(i + ". Product Id: " + p.id + " Name: " + p.name + " Copies: " + e.getValue());
                i++;
            }
        }
    }
}
