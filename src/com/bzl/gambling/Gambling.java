package com.bzl.gambling;

import java.util.Random;

public class Gambling {
    public static void main(String[] args) {
        System.out.println("Hello Gambling simulation");
    }
    int stake = 100;
    int bet = 1;
    int win = 0;
    int loose = 0;
    public void bet(int p){
        Random r = new Random();
        int i = r.nextInt(2);
        if(i == 0){
            stake = stake - p;
            System.out.println("loose");
            loose += p;
        }else{
            System.out.println("win");
            win += p;
            stake = stake + p;
        }
    }
}