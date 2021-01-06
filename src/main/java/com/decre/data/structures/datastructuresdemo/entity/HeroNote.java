package com.decre.data.structures.datastructuresdemo.entity;

import lombok.Data;

/**
 * @className: HeroNote
 * @description: 英雄节点
 * @author: decre
 * @date: 2021/1/5
 **/
@Data
public class HeroNote {

    private int no; // 序号

    private String name; // 名字

    private String nickName; // 昵称

    private HeroNote next;

    public HeroNote(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNote{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
