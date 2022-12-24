package com.bzl.gambling;

import java.util.Random;

public class Gambling {
    public static void main(String[] args) {
        System.out.println("Hello Gambling simulation");
        Gambling ob = new Gambling(100);
        ob.MonthlyDaysOfPlaying();
    }
    int stake ;
    int tempStake;
    int winOrLoose = 0;
    int totalWinOrLoose = 0;
    boolean resign = false ;
    int dayWon = 0;
    int dayLoose = 0;
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
                winOrLoose -= p;
            } else {
                winOrLoose += p;
                stake = stake + p;
            }
        }else{
            resign = true;
            System.out.println("winorloose : "+winOrLoose);
            totalWinOrLoose += winOrLoose;
            if(winOrLoose > 0){
                dayWon++;
            } else if (winOrLoose < 0) {
                dayLoose++;
            }

        }
    }
    public void fullDayPlay(){
        while (resign == false) {
            betStake(1);
        }
    }
    public void MonthlyDaysOfPlaying(){
        for(int i = 1; i <= 30; i++){
            resign = false;
            stake = tempStake;
            winOrLoose = 0;
            System.out.println("Day : "+i);
            fullDayPlay();
        }
        System.out.println("Total Days won Maximum : " + dayWon + ", Total Days Loose Maximum : " + dayLoose);
        System.out.println("Monthly Days win(positive) or loose(negative) : " + totalWinOrLoose + "$");
        if(totalWinOrLoose > 0){
            System.out.println("Continue Playing ..");
        }else if (totalWinOrLoose < 0){
            System.out.println("Stop Gambling....");
        }
    }

}