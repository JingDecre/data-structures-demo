package com.decre.data.structures.datastructuresdemo.entity;

public class DoubleNote {

    private String name;

    private String nickName;

    private int no;

    public DoubleNote pre;

    public DoubleNote next;

    public DoubleNote(String name, String nickName, int no) {
        this.name = name;
        this.nickName = nickName;
        this.no = no;
    }

    @Override
    public String toString() {
        return "DoubleNote{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", no=" + no +
                '}';
    }
}
