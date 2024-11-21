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
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);

        int lastId=0;//명언 번호

        WiseSaying lastWiseSaying = null;

        while(true){

            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if(cmd.equals("종료")){
                break;
            }else if(cmd.equals("등록")){
                System.out.print("명언 : ");
                String saying = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                int id = ++lastId;

                //객체 생성( id, 명언, 작가 3가지 값을 가짐)
                WiseSaying wiseSaying = new WiseSaying(id,saying,author); //객체 생성 후 생성자 활용

                //제대로 값이 들어가는 지 확인!
                System.out.println(wiseSaying); //리모컨(주소값)이 출력됨

                lastWiseSaying = wiseSaying; // 값을 저장한 객체에 대한 정보 저장


                System.out.println(id+"번 명언이 등록되었습니다.");
            }else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-----------------------");
                try{
                    System.out.println(lastWiseSaying.id+"/"+lastWiseSaying.saying+"/"+lastWiseSaying.author);
                }catch(NullPointerException e){
                    System.out.println("등록을 하고 목록을 출력하세요~");
                }
            }
        }
    }
}

//기본적으로 Object 클래스를 상속받기 때문에 Object클래스의 toString()메서드를 오버라이드하는 것이다.
class WiseSaying /*extends Object*/{
    int id;
    String saying;
    String author;

    WiseSaying(int id, String saying, String author){
        this.id=id;
        this.saying=saying;
        this.author=author;

    }

    //Object클래스로 부터 물려받은 toString 메서드 오버라이드해서 출력문 예쁘게 출력
    @Override
    public String toString(){
        return "WiseSaying (id=%d, saying=%s, author=%s)".formatted(id,saying,author);
    }

}