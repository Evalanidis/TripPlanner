/*
* @author Valanidis Efstathios
* @literal evalanidis@gmail.com
* @since 24/10/2017
* */

import java.util.Scanner;
import static java.lang.Math.abs;


public class TripPlanner {

    static Scanner input = new Scanner(System.in);
    static double earthRadius = 6371.0;
    static String name,destination,currencySymbol;
    static int days,hours,sumHours,sumMinutes,sumSeconds,noon, midnight;
    static float money,moneyPerDayUSD,moneyConversion,moneyRate,moneyPerDay,squareArea,miles;
    static double lat1,lat2,latitude1,latitude2,longitude1,longitude2,dLat,dLong,hav1,hav2,sum,d;

    public static void main(String[] args){
        greeting();
        travelTimeAndBudget();
        timeDifference();
        countryArea();
        haversiveFormula();

    }
    /*
    * the greeting method is used for greeting the user and to get his/her name and travel
    * destination
    * */
    public static void greeting(){
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        name = input.nextLine();
        System.out.print("Nice to meet you " + name+ ", where are you travelling to? ");
        destination = input.nextLine();
        System.out.println("Great! "+destination+" sounds like a great trip");
        System.out.println("***********\n");
    }

    /*
    * the travelTimeAndBudget method gets the days the user is going to spend in the his/her travel destination
    * and it also gets the budget of the user and the exchange rate of his destination.
    * The program returns how many hours, minutes and seconds the user is going to spend on his/her destination
    * The method also returns how much must his daily budget be in user's countrys currency
    * and in his destination's currency
    * */
    public static void travelTimeAndBudget(){
        System.out.print("How many days are they going to spend in their destination? ");
        days = input.nextInt();
        System.out.print("What is their total budget for the trip in USD? ");
        money = input.nextFloat();
        System.out.print("What is the currency symbol for their destination? ");
        currencySymbol = input.next();
        System.out.print("How many "+currencySymbol+" are there in 1 USD? ");
        moneyRate = input.nextFloat();
        sumHours = days * 24;
        sumMinutes = sumHours *60;
        sumSeconds = sumMinutes *60;
        moneyConversion = money * moneyRate;
        moneyPerDay = moneyConversion/days;
        moneyPerDayUSD = money/days;
        System.out.println("If you are travelling for "+days+" days that is the same as "+sumHours+
                " hours or "+sumMinutes+" minutes or "+sumSeconds+" seconds.");
        System.out.println("If you are going to to spend $"+money+" USD that means per day you can spend up to $" +
                moneyPerDayUSD+" USD.");
        System.out.println("Your total budget in "+currencySymbol+" is "+moneyConversion+
                " which per day is "+moneyPerDay+" "+currencySymbol);
        System.out.println("***********\n");
    }

    /*
    * the timeDifference method gets from the user the time difference between his/hers location
    * and his/hers destination and tell him what time will be in his destination when in his
    * country is midnight and noon. the time is calculated in 24-hour system.
    * */
    public static void timeDifference(){
        System.out.print("What is  the time difference, in hours, between your home and your destination? ");
        hours = input.nextInt();
        midnight = abs((24 + hours) % 24);
        noon = abs((12 + hours)%24);
        System.out.print("That means that when it is midnight at home it will be "
        +midnight+":00 in your travel destination and when it is noon at home it will be "
        +noon+":00");
        System.out.println("***********\n");

    }

    /*
    * the countryArea method gets the square area (km^2) of your  destination's country
    * and convert it to square miles
    * */

    public static void countryArea(){
        System.out.print("What is the square area of your destination country in km^2? ");
        squareArea = input.nextFloat();
        miles = (float)(squareArea * 0.386102);
        System.out.print("In miles^2 that is "+miles);
    }


    /*
    * the haversiveFormula method gets the latitude and longitude of user's location
    * and latitude and longitude of user's destination and calculate the destination of the
    * two locations in km
    * */
    public static void haversiveFormula(){
        System.out.print("What is the latitude of your location in degrees? ");
        latitude1 = input.nextDouble();
        System.out.print("What is the longitude of your location in degrees? ");
        longitude1 = input.nextDouble();
        System.out.print("What is the latitude of your destination in degrees? ");
        latitude2 = input.nextDouble();
        System.out.print("What is the longitude of your destination in degrees? ");
        longitude2 = input.nextDouble();
        
        lat1=latitude1;
        lat2=latitude2;

        dLat = Math.toRadians(latitude2 - latitude1);
        dLong = Math.toRadians(longitude2 - longitude1);
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);

        hav1 = Math.pow(Math.sin(dLat/2),2);
        hav2 = Math.pow(Math.sin(dLong/2),2);

        sum = hav1 + Math.cos(latitude1) * Math.cos(latitude2) * hav2;
        d = 2 * Math.atan2(Math.sqrt(sum),Math.sqrt(1-sum));
        d = (float)(d * earthRadius);

        System.out.print("Your location's latitude is "+lat1+" and longitude is "+longitude1+"\n");
        System.out.print("Your destination's latitude is "+lat2+" and longitude is "+longitude2+"\n");
        System.out.printf("Using the Haversive formula the distance between your location and your destination is %.2f km",d);

    }

}
