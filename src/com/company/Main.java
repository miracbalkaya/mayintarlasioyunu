package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int row,column;
        System.out.println("Mayın tarlasına hoşgeldiniz");
        System.out.println("Oynamak istedeğiniz satır ve sütun değerlerini girin\n :");
        System.out.println("Satır sayısı :");
        row=scanner.nextInt();
        System.out.println("Sütun sayısı :");
        column=scanner.nextInt();

        MayinTarlasi mayinTarlasi = new MayinTarlasi(row,column);
        mayinTarlasi.run();
    }
}
