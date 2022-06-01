package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agent extends Entity{
    int zipcode;
    int prodDelivered=0;
    static HashMap<Integer,Agent> agentList=new HashMap<>();
    public Agent(Scanner scanner)
    {
        super(scanner);
        System.out.println("Enter the zipcode:");
        this.zipcode=scanner.nextInt();
        System.out.println("Delivery Agent created");
    }

    public void printObj() {
        super.printObj();
        System.out.println("Zipcode: "+this.zipcode+" Number of products delivered: "+this.prodDelivered);

    }
    public static void printAgents()
    {
        int i = 1;
        for (Map.Entry<Integer, Agent> e : agentList.entrySet())
        {
            if(e.getValue().isDeleted)continue;
            System.out.print(i + ". ");
            e.getValue().printObj();
            i++;
        }
    }
    public static void deleteAgent(Scanner scanner)
    {
        Agent.printAgents();
        System.out.println("Enter the id of entity you want to delete:");
        int temp=scanner.nextInt();
        Agent.agentList.get(temp).isDeleted=true;

    }
}
