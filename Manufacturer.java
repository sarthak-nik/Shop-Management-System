package com.company;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Manufacturer extends Entity{
    static HashMap<Integer,Manufacturer> manufacturerList=new HashMap<>();
    public ArrayList<Integer> products=new ArrayList<>();
    public Manufacturer(Scanner scanner)
    {
        super(scanner);
        System.out.println("Manufacturer created");
    }

    @Override
    public void printObj() {
        super.printObj();
        System.out.println();
    }

    public static void printManufacturers()
    {
        int i = 1;
        for (Map.Entry<Integer, Manufacturer> e : manufacturerList.entrySet())
        {
            if(e.getValue().isDeleted)continue;
            System.out.print(i + ". ");
            e.getValue().printObj();
            i++;
        }
    }
    public static void deleteManufacturer(Scanner scanner)
    {
        Manufacturer.printManufacturers();
        System.out.println("Enter the id of manufacturer you want to delete:");
        int temp=scanner.nextInt();
        Manufacturer.manufacturerList.get(temp).isDeleted=true;
    }
    public void listProducts()
    {
        if(products.size()>0)
        {
            System.out.print("Product List: ");
            int productId;
            for (int i = 0; i < products.size(); i++) {
                productId=products.get(i);
                if(Product.productList.get(i).isDeleted)continue;
                System.out.println("[Id: " + productId + "] ");
            }
        }
        else
        {
            System.out.println("Products list is empty");
        }
    }

}
