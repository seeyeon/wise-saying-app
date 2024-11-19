package com.ll;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        App app = new App();
        app.run();
        
    }
}

class App{


    public void run() {

        System.out.println("==명언 앱==");
        Scanner sc = new Scanner(System.in);
        int count =0;

        while(true){

            System.out.print("명령) ");
            String cmd = sc.nextLine();


            if(cmd.equals("종료")){
                break;
            }else if(cmd.equals("등록")){


                String saying=" ";
                String author=" ";

                System.out.print("명언 : ");
                saying = sc.nextLine();

                System.out.print("작가 : ");
                author = sc.nextLine();

                count++;
                System.out.println(count + " 번 명언이 등록되었습니다.");

            }




        }



    }
}