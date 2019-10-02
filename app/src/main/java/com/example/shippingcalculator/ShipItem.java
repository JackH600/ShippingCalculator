package com.example.shippingcalculator;

public class ShipItem {

    private double mounces;
    private double baseCost = 3;




    public double getBaseCost() {
        if(mounces >= 30){
            return 4;
        }else{
            return baseCost;
        }
    }

    public double getAddedCost(){
        if(mounces > 16){
            double difference = mounces - 16;
            return Math.ceil(difference / 4)* 0.50;
        }
        else{
            return 0.00;
        }
    }
    public double getTotalCost(){
        return getBaseCost() + getAddedCost();

    }

    public void setOunces(double mounces) {
        this.mounces = mounces;
    }
}
