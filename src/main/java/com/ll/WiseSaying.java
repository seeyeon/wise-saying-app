package com.ll;

//기본적으로 Object 클래스를 상속받기 때문에 Object클래스의 toString()메서드를 오버라이드하는 것이다.
class WiseSaying /*extends Object*/ {
    int id;
    String saying;
    String author;

    WiseSaying(int id, String saying, String author) {
        this.id = id;
        this.saying = saying;
        this.author = author;

    }

    //Object클래스로 부터 물려받은 toString 메서드 오버라이드해서 출력문 예쁘게 출력
    @Override
    public String toString() {
        return "%d / %s / %s".formatted(id, saying, author);
    }

}
