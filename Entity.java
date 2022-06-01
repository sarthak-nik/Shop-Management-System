package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Entity {
    public int id;
    public static int id_count=0;
    public String name;
    boolean isDeleted=false;
    public Entity(Scanner scanner)
    {
        this.id=++id_count;
        System.out.println("Enter the name:");
        scanner.nextLine();
        this.name= scanner.nextLine();

    }
    public void printObj(){
        System.out.print("Id: "+this.id+" Name: "+this.name+" ");
    }

}
