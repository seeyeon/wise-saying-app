package com.ll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.run();
    }

}

class App{

    public void run() {

        System.out.println("===명언 앱===");

        Scanner sc = new Scanner(System.in);

        while( true ){
            System.out.print("명령) ");

            String cmd = sc.nextLine();
            //System.out.println("입력된 명령어: %s".formatted(cmd));

            if (cmd.equals("종료")){
                break;
            }else if(cmd.equals("등록")){

                int count=0;

                System.out.print("명언: ");
                String saying = sc.nextLine();

                System.out.print("작가: ");
                String author = sc.nextLine();

                count++;

                System.out.println(count+"번 명언이 등록되었습니다.");

            }
        }





        sc.close();


    }
}