package com.company;


import java.time.LocalDate;

public class Transaction implements Comparable< Transaction >{

    double tTotal;
    int tPoints;
    LocalDate tDate;
    private int TRANSACTION_ID;
    private int customerID;


    public Transaction(double total, LocalDate dt, int id, int custId) {
        this.tTotal = total;
        this.tPoints = calcPoints();
        this.tDate = dt;
        this.TRANSACTION_ID = id;
        this.customerID = custId;
    }

    public double getTotal() {
        return tTotal;
    }

    public int gettPoints() {
        return tPoints;
    }

    public LocalDate getDate() {
        return tDate;
    }

    public int getTRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    public int getCustomerID() {return customerID;}
    private int calcPoints() {
        int singlePoints = 0;
        int doublePoints = 0;

        if (tTotal > 100) {
            doublePoints = (int) ((tTotal % 100) * 2);
            //System.out.println("Double Points: "+doublePoints);
        }
        if (tTotal > 50) {
            int tot = (int) tTotal;
            if (tot > 100) tot -= (tot % 100);  //tot is now all dollars under 100
            singlePoints = (int) (tot - 50);
            //  System.out.println("Single Points: "+ singlePoints);
        }

        int totalPoints = singlePoints + doublePoints;
        //System.out.println("Total Points: "+totalPoints);
        return totalPoints;
    }

    @Override
    public int compareTo(Transaction t) {

        if (this.getDate().isBefore(t.getDate())) return -1;
        if(this.getDate().isAfter(t.getDate())) return 1;
        else return 0;
    }
}

