package com.nextyu.demo.tactics;

import cn.hutool.core.util.RandomUtil;
import com.yanwei.platform.pojo.model.FormulaData;
import com.yanwei.platform.pojo.model.GradeEnum;

import java.util.HashSet;
import java.util.Set;

import static com.nextyu.demo.tactics.EquationUtil.*;

/**
 * 进阶简单级
 */
public class AdvancedSimpleImpl implements IGetEquation {
    @Override
    public Set<FormulaData> equations() {
        Set<FormulaData> formulaDataSet = new HashSet<>();
        do{
            int a = RandomUtil.randomInt(1,10);
            int b = RandomUtil.randomInt(1,10);
            int i  = 2;// 运算符
            String formula = a+getOp(i)+b;
            Integer answer = compute(a,b,i);
            FormulaData formulaData = new FormulaData();
            formulaData.setFormula(formula);
            formulaData.setAnswer(answer);
            int[] mistake = getMistake(answer);
            formulaData.setWrongAnswerOne(mistake[0]);
            formulaData.setWrongAnswerTwo(mistake[1]);
            formulaData.setDescription(GradeEnum.ADVANCED_SIMPLE.getDescription());
            formulaDataSet.add(formulaData);
        }while (formulaDataSet.size()<30);
        return formulaDataSet;
    }
}
