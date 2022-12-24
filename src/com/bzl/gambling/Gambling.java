package com.bzl.gambling;

import java.util.Random;

public class Gambling {
    public static void main(String[] args) {
        System.out.println("Hello Gambling simulation");
        Gambling ob = new Gambling(100);
        while (ob.resign == false) {
            ob.betStake(1);
        }
    }
    int stake ;
    int win = 0;
    int tempStake;
    int loose = 0;
    boolean resign = false ;
    public Gambling(int stake){
        this.stake = stake;
        tempStake = stake;
    }
    public void betStake(int p){
        Random r = new Random();
        int i = r.nextInt(2);
        if(stake <= tempStake * 1.5 && stake >= tempStake * 0.5) {
            if (i == 0) {
                stake = stake - p;
                System.out.println("loose");
                loose += p;
            } else {
                System.out.println("win");
                win += p;
                stake = stake + p;
            }
        }else{
            resign = true;
            System.out.println("day "+stake);
        }
    }
}