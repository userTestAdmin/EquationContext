package com.nextyu.demo.tactics;

import cn.hutool.core.util.RandomUtil;
import com.yanwei.platform.pojo.model.FormulaData;
import com.yanwei.platform.pojo.model.GradeEnum;

import java.util.HashSet;
import java.util.Set;

import static com.nextyu.demo.tactics.EquationUtil.compute;
import static com.nextyu.demo.tactics.EquationUtil.getMistake;
import static com.nextyu.demo.tactics.EquationUtil.getOp;

/**
 * 普通简单&一般级别
 */
public class OrdinarySimpleImpl implements IGetEquation {
    @Override
    public Set<FormulaData> equations() {
        Set<FormulaData> formulaDataSet = new HashSet<>();
        do{
            int a = RandomUtil.randomInt(0,10);
            int b = RandomUtil.randomInt(0,10);
            int i  = (int) (Math.random() * 2); // 运算符
            if(i==1&&a<b){
                continue;
            }
            String formula = a+getOp(i)+b;
            Integer answer = compute(a,b,i);
            FormulaData formulaData = new FormulaData();
            formulaData.setFormula(formula);
            formulaData.setAnswer(answer);
            int[] mistake = getMistake(answer);
            formulaData.setWrongAnswerOne(mistake[0]);
            formulaData.setWrongAnswerTwo(mistake[1]);
            formulaData.setDescription(GradeEnum.ORDINARY_SIMPLE.getDescription());
            formulaDataSet.add(formulaData);
        }while (formulaDataSet.size()<30);

        return formulaDataSet;
    }
}
