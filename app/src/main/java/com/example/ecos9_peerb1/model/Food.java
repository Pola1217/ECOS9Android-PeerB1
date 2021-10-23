package com.example.ecos9_peerb1.model;

public class Food {

    String time, type;
    int num=1, x, y=50;

    public Food(){
    }

    public Food(int y, int num, String time, String type){

        this.x = 240;
        this.y = y;
        this.num = num;

        this.time = time;
        this.type = type;

    }

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public int getNum() {
        return num;
    }


    public void setNum(int num) {
        this.num = num;
    }


    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }

}
