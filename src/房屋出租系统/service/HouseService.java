package com.lhz.house.service;

import com.lhz.house.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNum = 1;  //列表中房屋个数
    private int idCount = 1;  //房屋信息编号

    //构造器
    public HouseService(int size) {
        houses = new House[size];

        houses[0] = new House(1, "jack", "112", "海淀区", 200, "未出租");

    }


    //1、新增房屋信息
    public boolean add(House newHouse) {
        if (houseNum >= houses.length) {
            System.out.println("已满，不能添加");
            return false;
        }

        houses[houseNum++] = newHouse;
        newHouse.setId(++idCount);

        return true;
    }

    //2、4、根据Id查找房屋信息
    public House findById(int findId) {
        for (int i = 0; i < houseNum; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    //3、通过ID删除房屋信息
    public boolean deleteById(int findId) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (findId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }

        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
        return true;
    }

    //5、房屋列表
    public House[] list() {
        return houses;
    }
}
