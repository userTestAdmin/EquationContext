package com.nextyu.demo.tactics;

import cn.hutool.core.util.RandomUtil;
import com.yanwei.platform.pojo.model.FormulaData;
import com.yanwei.platform.pojo.model.GradeEnum;

import java.util.HashSet;
import java.util.Set;

import static com.nextyu.demo.tactics.EquationUtil.*;

/**
 * 普通噩梦级别
 */
public class OrdinaryNightmareImpl implements IGetEquation {
    @Override
    public Set<FormulaData> equations() {
        Set<FormulaData> formulaDataSet = new HashSet<>();
        do{
            int a = RandomUtil.randomInt(0,100);
            int b = RandomUtil.randomInt(0,100);
            int i  = (int) (Math.random() * 2); // 运算符
            if(i==1&&a<b){
                continue;
            }
            String formula = a+getOp(i)+b;
            Integer answer = compute(a,b,i);
            if(answer>200||answer<50){
                continue;
            }
            FormulaData formulaData = new FormulaData();
            formulaData.setFormula(formula);
            formulaData.setAnswer(answer);
            int[] mistake = getMistake(answer);
            formulaData.setWrongAnswerOne(mistake[0]);
            formulaData.setWrongAnswerTwo(mistake[1]);
            formulaData.setDescription(GradeEnum.ORDINARY_NIGHTMARE.getDescription());
            formulaDataSet.add(formulaData);
        }while (formulaDataSet.size()<30);
        return formulaDataSet;
    }
}
