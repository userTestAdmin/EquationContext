package com.nextyu.demo.tactics;

import cn.hutool.core.util.RandomUtil;
import com.yanwei.platform.pojo.model.FormulaData;

public class EquationUtil {
    // 获取运算符
    public static String getOp(int index) {
        String string = "";
        switch (index) {
            case 0:
                string = "+";
                break;
            case 1:
                string = "-";
                break;
            case 2:
                string = "*";
                break;
            case 3:
                string = "/";
                break;
        }
        return string;
    }
    // 计算答案
    public static int compute(int a, int b, int index) {
        int sum = 0;
        switch (index) {
            case 0:
                sum = a + b;
                break;
            case 1:
                sum = a - b;
                break;
            case 2:
                sum = a * b;
                break;
            case 3:
                sum = a / b;
                break;
        }
        return sum;
    }
    //获取错误答案
    /*public static int[] getMistake(int answer){
        int[] nums = new int[2];
        nums[0] = answer+ RandomUtil.randomInt(1,10);
        if(answer>2){
            nums[1]=answer-RandomUtil.randomInt(1,answer);
        }else{
            int temp =answer+RandomUtil.randomInt(1,10);
            while (temp==nums[0]){
                temp = answer+RandomUtil.randomInt(1,10);
            }
            nums[1]=temp;
        }
        return nums;
    }*/
    public static int[] getMistake(int answer){
        int[] nums = new int[2];
        if(answer>=50){
            nums[0] = compute(answer,10,(int)(Math.random()*2));
            do{
                nums[1] = compute(answer,RandomUtil.randomInt(1,20),(int)(Math.random()*2));
            }while (nums[0]==nums[1]);
            return nums;
        }
        nums[0] = answer+ RandomUtil.randomInt(1,10);
        if(answer>2){
            nums[1]=answer-RandomUtil.randomInt(1,10);
        }else{
            int temp =answer+RandomUtil.randomInt(1,10);
            while (temp==nums[0]){
                temp = answer+RandomUtil.randomInt(1,10);
            }
            nums[1]=temp;
        }
        return nums;
    }
    // 随机等式
    public static FormulaData getEquality(int index) {
        FormulaData formulaData = new FormulaData();
        int a,b,i,answer;
        switch (index) {
            case 0:
                //99乘法
                a = RandomUtil.randomInt(1,10);
                b = RandomUtil.randomInt(1,10);
                i  = 2;// 运算符
                formulaData.setFormula(a+getOp(i)+b);
                formulaData.setAnswer(compute(a,b,i));
                break;
            case 1:
                //20以内加减
                do{
                    a = RandomUtil.randomInt(1,20);
                    b = RandomUtil.randomInt(1,20);
                    i  = (int) (Math.random() * 2);
                }while (i==1&&a<b);
                formulaData.setFormula(a+getOp(i)+b);
                formulaData.setAnswer(compute(a,b,i));
                break;
            case 2:
                //99乘法对应除法
                a = RandomUtil.randomInt(1,10);
                b = RandomUtil.randomInt(1,10);
                i  = 3;// 运算符
                answer = a*b;
                formulaData.setFormula(answer+getOp(i)+a);
                formulaData.setAnswer(b);
                break;
            case 3:
                //50以内加减
                do{
                    a = RandomUtil.randomInt(1,50);
                    b = RandomUtil.randomInt(1,50);
                    i  = (int) (Math.random() * 2);
                }while(i==1&&a<b);
                formulaData.setFormula(a+getOp(i)+b);
                formulaData.setAnswer(compute(a,b,i));
                break;
            case 4:
                //100以内加减
                a = RandomUtil.randomInt(1,100);
                b = RandomUtil.randomInt(1,100);
                i  = (int) (Math.random() * 2);
                answer = compute(a,b,i);
                while ((i==1&&a<b)||answer<10||answer>100){
                    a = RandomUtil.randomInt(1,100);
                    b = RandomUtil.randomInt(1,100);
                    answer = compute(a,b,i);
                }
                formulaData.setFormula(a+getOp(i)+b);
                formulaData.setAnswer(answer);
                break;
            case 5:
                //2乘以50以内任意数字
                a = RandomUtil.randomInt(1,50);
                i  = 2;// 运算符
                answer = compute(2,a,i);
                formulaData.setFormula(2+getOp(i)+a);
                formulaData.setAnswer(answer);
                break;
            case 6:
                //3乘以30以内任意数字
                a = RandomUtil.randomInt(1,30);
                i  = 2;// 运算符
                answer = compute(3,a,i);
                formulaData.setFormula(3+getOp(i)+a);
                formulaData.setAnswer(answer);
                break;
            case 7:
                //4乘以25以内任意数字
                a = RandomUtil.randomInt(1,25);
                i  = 2;// 运算符
                answer = compute(4,a,i);
                formulaData.setFormula(4+getOp(i)+a);
                formulaData.setAnswer(answer);
                break;
            case 8:
                //5乘以15以内任意数字
                a = RandomUtil.randomInt(1,15);
                i  = 2;// 运算符
                answer = compute(5,a,i);
                formulaData.setFormula(5+getOp(i)+a);
                formulaData.setAnswer(answer);
                break;
            case 9:
                //6乘以12以内任意数字
                a = RandomUtil.randomInt(1,12);
                i  = 2;// 运算符
                answer = compute(6,a,i);
                formulaData.setFormula(6+getOp(i)+a);
                formulaData.setAnswer(answer);
                break;
        }
        return formulaData;
    }
}
