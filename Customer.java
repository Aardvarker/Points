package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import com.company.Transaction;


public class Customer implements Comparable<Customer>{

    List<Transaction> Transactions;
    int cID;

    private int totalPoints;


    public Customer() {

    }
    public Customer(int id){
        this.Transactions = new ArrayList<>();
        this.cID = id;
        calcTotals();

    }

    public List<Transaction> getTransactions() {
        return Transactions;
    }

    public void addTransaction(Transaction transaction){
        Transactions.add(transaction);
        calcTotals();
    }

    private void calcTotals(){
        totalPoints = 0;
        for(Transaction T : Transactions){
            totalPoints+=T.gettPoints();


        }
    }
    public void showData(){
        System.out.println("Customer ID: "+cID);
        System.out.println("Total Points:"+totalPoints);

    }
    public int getTotalPoints(){return totalPoints;}

    @Override
    public int compareTo(Customer o) {
        return 0;
    }
}
