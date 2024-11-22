package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //인스턴스 변수(객체의 수명을 증가시킴) 선언
    private final Scanner sc;
    private int lastId;//명언 id
    //배열에서 리스트로 변경하기
    private final List<WiseSaying> wiseSayings;

    //생성자에 변수초기화하고함
    App() {
        sc = new Scanner(System.in);
        lastId = 0;
        wiseSayings= new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        //명렁을 입력받기 전 샘픔을 생성한다.
        makeSampleData();

        while (true) {

            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")){

                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                actionDelete(id);
            }
        }

        sc.close();
    }



    private void makeSampleData() {

        addTest("하루를 꾸준히 하자", "유퀴즈");
        addTest("나의 죽음을 적에게 알리지 말라", "이순신 장군");
    }

    private void actionAdd() {

        System.out.print("명언 : ");
        String saying = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = addTest(saying, author);  //중국집1개 넘기기

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    private WiseSaying addTest(String saying, String author) {

        int id = ++lastId;  //번호는 자동으로 매겨지므로 매개변수로 받을 필요 없다.

        //객체 생성( id, 명언, 작가 3가지 값을 가짐)
        WiseSaying wiseSaying = new WiseSaying(id, saying, author); //객체 생성 후 생성자 활용

        wiseSayings.add(wiseSaying);

        //return해야 addTest()에서 id를 활용할 수 있게 된다. 왜냐하면 id의 값의 자동 증가는addTest에서 담당하기 때문ㅇ디ㅏ.
        return wiseSaying;  //return 데이터 타입 = 메서드 타입이


    }

    private void actionList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");



        for(WiseSaying wiseSaying : wiseSayings.reversed()){
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getSaying(), wiseSaying.getAuthor()));
        }

        //for문
//        for (int i=wiseSayings.size()-1; i>=0; i--) {
//            WiseSaying wiseSaying = wiseSayings.get(i);
//            System.out.println("%d %s %s".formatted(wiseSaying.getId(), wiseSaying.getSaying(), wiseSaying.getAuthor()));
//        }

    }

    private void actionDelete(int id) {


        boolean removed = wiseSayings.removeIf((WiseSaying wiseSaying) -> wiseSaying.getId() == id);

        //wiseSayings.removeIf((WiseSaying wiseSaying) -> wiseSaying.getId() == id);
        //wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
        //wiseSayings.removeIf(w -> w.getId() == id);

        if(removed){
            System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
        }else{
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }



    }

}
