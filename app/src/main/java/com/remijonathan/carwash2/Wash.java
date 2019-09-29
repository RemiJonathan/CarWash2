package com.remijonathan.carwash2;

public class Wash {
    final int OUTWASH = 5;
    final int INWASH = 10;

    private int amount;
    private float price;

    public Wash() {
        this.amount = 1;
        this.price = INWASH;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public float getTotalPrice(){
        float discount = 0;
        if (amount>=12) discount = 25;
        return (price*amount)*((100-discount)/100);
    }


}