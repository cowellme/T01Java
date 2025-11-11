package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            var seconds = input();
            long hh = CalculateDate(seconds, "hh");
            long mm = CalculateDate(seconds, "mm");
            long ss = CalculateDate(seconds, "ss");

            if(hh >= 0 && mm >= 0 && ss >= 0)
                output(hh, mm, ss);
            else {
                System.out.print("Could not parse a number. Please, try again");
                break;
            }
        }
    }

    private static long CalculateDate(long seconds, String type) {
        System.out.print("ss: " + seconds);
        if(seconds > 0 ){

            var mm = 0;
            var hh = 0;

            for (;seconds > 59; mm++){
                seconds -= 60;
            }
            if (type.equals("mm")) return mm;

            for (;mm > 59; hh++){
                mm -= 60;
            }

            if (type.equals("hh")) return hh;

            if (type.equals("ss")) return seconds;


        }
        else {
            System.out.print("Incorrect time\n");
            return -1;
        }
        return -1;
    }

    private static void output(long hh, long mm, long ss){

        System.out.printf("%02d:%02d:%02d\n", hh, mm, ss);
    }
    private static long input(){

        long result = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            result = scanner.nextLong();
        }
        catch (Exception e) {
            scanner.close();
            return -1;
        }
        finally {
            scanner.close();
        }
        return result;
    }
}
