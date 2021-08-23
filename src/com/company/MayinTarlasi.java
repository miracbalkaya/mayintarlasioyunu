package com.company;

import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    int rowNumber,colNumber,size;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    MayinTarlasi(int rowNumber,int colNumber){
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber*colNumber;
    }
     public void run(){
        int row,col,succes=0;
        prepareGame();
        print(map);
         System.out.println("Oyun başladı");
         while (game){
             print(board);
             System.out.println("Satır :");
             row = scanner.nextInt();
             System.out.println("Sütun :");
             col = scanner.nextInt();

             if (row < 0 || row >= rowNumber ){
                 System.out.println("Geçersiz koordinat");
                 continue;
             }
             if (col < 0 || col >= colNumber ){
                 System.out.println("Geçersiz koordinat");
                 continue;
             }
             if (map[row][col] != -1){
                 check(row,col);
                 succes++;
                 if (succes == (size - (size/4))){
                     System.out.println("Tebrikler hiç bir mayına basmadınız");
                     break;
                 }
             }else {
                 game = false;
                 System.out.println("Game Over !");
             }
         }
     }
     public void check(int r,int c){
        if (map[r][c] == 0) {
            if ((c < colNumber -1) && (map[r][c + 1] == -1)) {
                board[r][c]++;
            }
            if ((r < rowNumber -3) && (map[r + 1][c] == -1)) {
                board[r][c]++;
            }
            if ((r > 0) && (map[r - 1][c] == -1)) {
                board[r][c]++;
            }
            if ((c > 0) && (map[r][c - 1] == -1)) {
                board[r][c]++;
            }
            if (board[r][c] == 0){
                board[r][c] = -2;
            }
        }
     }
     public void prepareGame(){
        int randRow,randCol,count=0;
        while (count != (size / 4)){
            randRow=random.nextInt(rowNumber);
            randCol=random.nextInt(colNumber);
            if (map[randRow][randCol] != -1){
                map[randRow][randCol] = -1;
                count++;
            }
        }

     }
     public void print(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if (array[i][j] >= 0)
                    System.out.print(" ");
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
     }
}
