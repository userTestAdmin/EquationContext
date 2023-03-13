package com.nextyu.demo.tactics;

import cn.hutool.core.util.RandomUtil;
import com.yanwei.platform.pojo.model.FormulaData;
import com.yanwei.platform.pojo.model.GradeEnum;

import java.util.HashSet;
import java.util.Set;

import static com.nextyu.demo.tactics.EquationUtil.*;

/**
 * 普通困难级别
 */
public class OrdinaryDifficultImpl implements IGetEquation {
    @Override
    public Set<FormulaData> equations() {
        Set<FormulaData> formulaDataSet = new HashSet<>();
        do{
            int a = RandomUtil.randomInt(0,20);
            int b = RandomUtil.randomInt(0,20);
            int i  = (int) (Math.random() * 2);
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
            formulaData.setDescription(GradeEnum.ORDINARY_DIFFICULT.getDescription());
            formulaDataSet.add(formulaData);
        }while (formulaDataSet.size()<30);
        return formulaDataSet;
    }
}
