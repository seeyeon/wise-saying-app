package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {

    //인스턴스 변수(객체의 수명을 증가시킴) 선언
    private Scanner sc;
    private int lastId;//명언 id
    //배열에서 리스트로 변경하기
    private List<String> wiseSayings;
    private int wiseSayingsSize; //저장된 명언의 개수

    //생성자에 변수초기화하고함
    App() {
        sc = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new ArrayList<>();
        wiseSayingsSize = 0;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        addTest("하루를 꾸준히 하자", "유퀴즈");
        addTest("나의 죽음을 적에게 알리지 말라", "이순신 장군");

        while (true) {

            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }

        sc.close();
    }

    private void actionAdd() {

        System.out.print("명언 : ");
        String saying = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = addTest(saying, author);  //중국집1개 넘기기

        System.out.println(wiseSaying.id + "번 명언이 등록되었습니다.");
    }

    private WiseSaying addTest(String saying, String author) {

        int id = ++lastId;  //번호는 자동으로 매겨지므로 매개변수로 받을 필요 없다.

        //객체 생성( id, 명언, 작가 3가지 값을 가짐)
        WiseSaying wiseSaying = new WiseSaying(id, saying, author); //객체 생성 후 생성자 활용

        wiseSayings.add(String.valueOf(wiseSaying));
        wiseSayingsSize++;

        //return해야 addTest()에서 id를 활용할 수 있게 된다. 왜냐하면 id의 값의 자동 증가는addTest에서 담당하기 때문ㅇ디ㅏ.
        return wiseSaying;  //return 데이터 타입 = 메서드 타입이


    }

    private void actionList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");

        //for문
        for (int i = wiseSayingsSize - 1; i >= 0; i++) {
            System.out.println(wiseSayings.get(i));
        }
    }

}
