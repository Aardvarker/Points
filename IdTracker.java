package com.company;

public class IdTracker {

    int ID;

    public IdTracker(){
        this.ID = 10000;
    }
    public IdTracker(int start){
        this.ID = start;
    }
    public int makeNewID(){
        ID++;
        return ID;

    }
}
