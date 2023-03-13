package com.nextyu.demo.tactics;

import com.yanwei.platform.pojo.model.FormulaData;
import com.yanwei.platform.pojo.model.GradeEnum;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.nextyu.demo.tactics.EquationUtil.*;
/**
 * 进阶困难级
 */
public class AdvancedDifficultImpl implements IGetEquation {
    @Override
    public Set<FormulaData> equations() {
        Set<FormulaData> formulaDataSet = new HashSet<>();
        do{
            //抽签获取等式
            int[] numbers = {0,2,3};
            Random random = new Random();
            int index = numbers[random.nextInt(numbers.length)];
            FormulaData formulaData = getEquality(index);
            int[] mistake = getMistake(formulaData.getAnswer());
            formulaData.setWrongAnswerOne(mistake[0]);
            formulaData.setWrongAnswerTwo(mistake[1]);
            formulaData.setDescription(GradeEnum.ADVANCED_DIFFICULT.getDescription());
            formulaDataSet.add(formulaData);
        }while (formulaDataSet.size()<30);
        return formulaDataSet;
    }
}
