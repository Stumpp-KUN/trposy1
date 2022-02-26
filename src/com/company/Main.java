package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sd=new Scanner(System.in);
        System.out.println("Vvedite kol-vo studentov");
        int x=sd.nextInt();
        Abiturient[] fs=new Abiturient[x];
        Main fd=new Main();
        boolean[] mark=new boolean[x];
        int[] coin=new int[x];
        int[] bestStud=new int[x];

        for(int i=0;i<x;i++){
            System.out.println("Vvedite kol-vo ocenok studenta po predmetam");
            int count=sd.nextInt();
            int[][] marks=new int[3][count];

            for(int t=0;t<3;t++){
                switch (t){
                    case 0: {
                        System.out.println("Vvedite otmetki po math");
                        for(int q=0;q<count;q++){
                            marks[0][q]=sd.nextInt();
                        }
                    }
                    break;

                    case 1:{
                        System.out.println("Vvedite otmitki po angl");
                        for(int w=0;w<count;w++){
                            marks[1][w]=sd.nextInt();
                        }
                    }
                    break;

                    case 2:{
                        System.out.println("Vvedite otmetki po prog");
                        for(int e=0;e<count;e++){
                            marks[2][e]=sd.nextInt();
                        }
                    }
                    break;

                }
            }

            System.out.println("Vvedite id, familiy, imya, otchestvo, adres, nomer studenta: ");
            fs[i]=new Abiturient(sd.nextInt(),sd.next(),sd.next(),sd.next(), sd.next(), sd.nextInt(),marks);
            mark[i]=fd.badMarks(marks,count);
            coin[i]=fs[i].getMarks(i,count);
            bestStud[i]=fs[i].getMarks(i,count);
        }

        System.out.println("1) ");
        System.out.println("studenti s neudovletvorit otmetkami: ");
        for(int i=0;i<x;i++){
            if(mark[i]!=true){
                System.out.print("Student: ");
                System.out.println(fs[i].getSurname(i));
            }
        }

        System.out.println("2)");
        System.out.println("Введите сумму баллов по предметам");
        int sumM=sd.nextInt();
        for(int i=0;i<x;i++){
            if(fd.coinCheck(coin[i],sumM)!=false){
                System.out.println("Student imeet bali vishe zadannoi");
                System.out.println(fs[i].getSurname(i));
            }
        }

        System.out.println("3)");
        System.out.println("Выберите число студентов имеющих самый большой балл");
        int bt=sd.nextInt();
        if(bt<=x){
            int[] fds=new int[bt];
            int maxNum=0;
            for(int j=0;j<bt;j++) {
                for (int i = 0; i < coin.length; i++) {
                    if (maxNum < coin[i]) {
                        maxNum = coin[i];
                        fds[j] = i;
                    }
                }
                coin[fds[j]]=0;
                maxNum=0;
            }

            System.out.println("Лучшие студенты: ");
            for(int i=0;i<bt;i++){
                System.out.println(fs[fds[i]].getSurname(fds[i]));
            }
        }
        else System.out.println("Неверное количество!");



    }
    public boolean badMarks(int [][] x,int count){

        for(int i=0;i<3;i++){
            for(int j=0;j<count;j++){
                if(x[i][j]<4){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean coinCheck(int mark,int sum){
        if(mark>=sum){
            return true;
        }
        else return false;
    }
}




class Abiturient{

    private int id;
    private String surname;
    private String name;
    private String otchestvo;
    private String street;
    private int number;
    private int[][] marks;


    public Abiturient(int x, String z, String c, String v, String b, int n, int[][] marks ){
        this.id=x;
        this.surname=z;
        this.name=c;
        this.otchestvo=v;
        this.street=b;
        this.number=n;
        this.marks=marks;


    }


    public String getSurname(int id){
        return surname;
    }


    public int getMarks(int id,int count){
        int k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<count;j++){
                k+=marks[i][j];
            }
        }
        return k;

    }


}
