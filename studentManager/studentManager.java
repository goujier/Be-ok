package studentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class studentManager {
    public static void main(String[] args) {
        //创建集合对象，用于存储学生数据
        ArrayList<student> array = new ArrayList<student>();

        while (true) {
            //编写主页面
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            //用scanner实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //用switch完成操作的选择
            switch (line) {
                case "1":
                    // System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
                   // System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    // System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                   // System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);//JVM退出
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<student> array) {
        //键盘录入数据，显示提示信息
        Scanner sc = new Scanner(System.in);
        String sid;
        while(true) {


            System.out.println("请输入学生学号：");
            sid = sc.nextLine();

            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("你输入的学号已经被使用，请重新输入");
            }
            else{
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();
        //创建学生对象，赋值给学生对象的成员变量
        student s = new student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //将学生对象保存在集合中
        array.add(s);
        //输出添加成功的提示
        System.out.println("添加学生成功");
    }
    //判断学生学号是否被占用
    public static boolean isUsed(ArrayList<student> array,String sid){
        boolean flag=false;
        for(int i=0;i<array.size();i++){
            student s = array.get(i);
            if(s.getSid().equals(sid)){
                flag=true;
                break;
            }
        }
        return flag;
    }
    //查找学生
    public static void findAllStudent(ArrayList<student> array) {
        //判断集合中是否有数据
        if(array.size()==0)
        {
            System.out.println("无信息，请先添加信息再查询");
            return;  //不再往下执行
        }
        System.out.println("学号\t姓名\t年龄\t\t居住地");
        for (int i = 0; i < array.size(); i++) {
            student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress());
        }
    }
    //删除学生
    public static void deleteStudent(ArrayList<student> array){
        //录入删除学生的学号，显示提示信息
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要删除的学生的学号：");
        String sid =sc.nextLine();

        int index=-1;
        //遍历删除
        for(int i=0;i<array.size();i++) {
            student s= array.get(i);
            if(s.getSid().equals(sid)){
                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("该信息不存在，请重新输入");
        }
        else{
            array.remove(index);
            //删除成功提示
            System.out.println("删除成功");
        }
    }
    //修改学生
    public static void updateStudent(ArrayList<student> array){
        //键盘录入要修改的学生学号，输出提示信息
        int index=-1;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要修改的学生学号：");
        String sid=sc.nextLine();

        int i=0;
        for(i=0;i<array.size();i++){
            student student= array.get(i);
            if(student.getSid().equals(sid)){
                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("输入信息不存在，请重新输入");
        }
        else{
            //输入修改后的信息
            System.out.println("请输入学生新姓名：");
            String name=sc.nextLine();
            System.out.println("请输入学生新年龄：");
            String age=sc.nextLine();
            System.out.println("请输入学生新居住地：");
            String address=sc.nextLine();
            //创建学生对象
            student s=new student();
            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);
            //代替集合中原有学生
            array.set(i,s);
            //输出修改完成
            System.out.println("修改学生成功");
        }
    }
}




















