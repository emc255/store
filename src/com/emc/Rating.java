package com.emc;

public class Rating {
    private final double rate;
    private final double count;

    public Rating(double rate, double count) {
        this.rate = rate;
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public double getCount() {
        return count;
    }
}
