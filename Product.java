package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Product extends Entity{
    public int manufacturerId;
    static HashMap<Integer,Product> productList=new HashMap<>();
    public Product(Scanner scanner)
    {
        super(scanner);
        this.setManufacturer(scanner);
        System.out.println("Product created");
    }


    public void printObj() {
        super.printObj();
        System.out.println("Manufacturer Id: "+this.manufacturerId);
    }
    public static void printProducts()
    {
        int i = 1;
        for (Map.Entry<Integer, Product> e : productList.entrySet())
        {
            if(e.getValue().isDeleted)continue;
            System.out.print(i + ". ");
            e.getValue().printObj();
            i++;
        }
    }
    public static void deleteProduct(Scanner scanner)
    {
        Product.printProducts();
        System.out.println("Enter the id of entity you want to delete:");
        int temp=scanner.nextInt();
        Product.productList.get(temp).isDeleted=true;
    }
    public void setManufacturer(Scanner scanner)
    {
        Manufacturer.printManufacturers();
        System.out.println("Enter the id of manufacturer of the product from the list above: ");
        this.manufacturerId=scanner.nextInt();
        Manufacturer.manufacturerList.get(this.manufacturerId).products.add(this.id);
    }

}
