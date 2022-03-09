package com.lhz.house.view;

import com.lhz.house.domain.House;
import com.lhz.house.service.HouseService;
import com.lhz.house.utils.Utility;

import java.sql.SQLOutput;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);


    //1、增加房屋
    public void addHouse() {
        System.out.println("\n================添加房屋================");
        System.out.print("姓名:");
        String name = Utility.readString(8);
        System.out.print("电话:");
        String phone = Utility.readString(11);
        System.out.print("地址:");
        String address = Utility.readString(20);
        System.out.print("月租:");
        int rent = Utility.readInt();
        System.out.print("状态:");
        String state = Utility.readString(5);
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("=================添加房屋成功=============");
        } else {
            System.out.println("=================添加房屋失败=============");
        }
    }


    //2、根据房屋id信息查找房屋
    public void findHouse() {
        System.out.println("=================查找房屋信息===============");
        System.out.print("请输入你要查找的id:");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
            System.out.println();
        } else
            System.out.println("=============没有要查找的房屋===============\n");
    }

    //3、根据id删除房屋信息
    public void deleteHouse() {
        System.out.println("=================删除房屋信息=============");
        System.out.print("请选择待删除房屋编号(-1退出):");
        int deleteId = Utility.readInt();
        if (deleteId == -1) {
            System.out.println("你放弃了删除");
            return;
        }
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            if (!houseService.deleteById(deleteId)) {
                System.out.println("==========无需要删除的房间==============");
            } else {
                System.out.println("==============删除房间成功===============");
            }
        } else {
            System.out.println("你放弃了删除");
        }
    }

    //4、修改房屋信息
    public void updateHouse() {
        System.out.println("=================修改房屋信息===============");
        System.out.print("请选择待修改房屋编号(-1退出):");
        int findId = Utility.readInt();
        if (findId == -1) {
            System.out.println("你放弃修改房屋信息");
            return;
        }

        House house = houseService.findById(findId);
        if (house == null) {
            System.out.println("你要修改的房屋信息不存在");
            return;
        }
        System.out.print("姓名(" + house.getName() + "):");
        String name = Utility.readString(8, "");
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "):");
        String address = Utility.readString(16, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("============修改房屋信息成功==============\n");

    }

    //5、房屋列表
    public void listHouses() {
        System.out.println("\n================房屋列表================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("===============房屋列表显示完毕============\n");
    }

    //6、退出
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    //主菜单
    public void mainMenu() {
        do {
            System.out.println("===============房屋出租系统菜单=============");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退   出");
            System.out.print("请输入您的选择(1-6):");
            key = Utility.readChar();  //接收选择菜单参数

            switch (key) {
                case '1':
                    addHouse(); //增加房屋信息
                    break;
                case '2':
                    findHouse(); //查找房屋
                    break;
                case '3':
                    deleteHouse(); //删除房屋信息
                    break;
                case '4':
                    updateHouse(); //修改房屋信息
                    break;
                case '5':
                    listHouses();  //房屋列表
                    break;
                case '6':
                    exit(); //退出
                    break;
            }
        } while (loop);
    }

}
