package com.ll;

import java.util.ArrayList;
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
        int id =0;

        ArrayList<String> sayings= new ArrayList<>();
        ArrayList<String> authors= new ArrayList<>();
        ArrayList<String> deleteList = new ArrayList<>();
        ArrayList<String> setList = new ArrayList<>();

        while(true){

            System.out.print("명령) ");
            String cmd = sc.nextLine();


            if(cmd.equals("종료")){
                break;
            }else if(cmd.equals("등록")){

                System.out.print("명언 : ");
                String saying = sc.nextLine();
                sayings.add(saying);

                System.out.print("작가 : ");
                String author = sc.nextLine();
                authors.add(author);

                id++;
                System.out.println(id + " 번 명언이 등록되었습니다.");

            }else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                int size = sayings.size();
                for(int i=size-1; i>=0; i--){
                   System.out.println((id--)+"/"+sayings.get(i)+"/"+authors.get(i));
               }
            }else if(cmd.equals("삭제?")){

                System.out.print("id= ");
                String deleteId = sc.nextLine();
                //중복 확인
                if(deleteList.contains(deleteId)){
                    System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
                }else{
                    System.out.println(deleteId + "번 명언이 삭제되었습니다.");
                }
                //중복되지 않는 경우 추가
                deleteList.add(deleteId);

            }else if(cmd.equals("수정?")){
                System.out.print("id= ");
                int setId = sc.nextInt();

                //중복되는 숫자가 있는 경우
                if(setList.contains(setId)){
                    System.out.println(setId+ "번 명언은 존재하지 않습니다.");
                }else{

                    //아닌 경우
                    setList.add(setId);

                    System.out.println("명언(기존) : "+ sayings.get(setId));
                    System.out.print("명언 : " );
                    sayings.set(setId,sc.nextLine());

                    System.out.println("작가(기존) : "+ authors.get(setId));
                    System.out.print("작가 : " );
                    authors.set(setId,sc.nextLine());
                }

            }




        }



    }
}