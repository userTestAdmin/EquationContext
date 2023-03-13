package com.nextyu.demo.tactics;

import com.yanwei.platform.pojo.model.FormulaData;
import com.yanwei.platform.pojo.model.GradeEnum;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.nextyu.demo.tactics.EquationUtil.*;
/**
 * 进阶刺激级
 */
public class AdvancedStimulationImpl implements IGetEquation {
    @Override
    public Set<FormulaData> equations() {
        Set<FormulaData> formulaDataSet = new HashSet<>();
        do{
            //抽签获取等式
            int[] numbers = {0,2,4};
            Random random = new Random();
            int index = numbers[random.nextInt(numbers.length)];
            FormulaData formulaData = getEquality(index);
            int[] mistake = getMistake(formulaData.getAnswer());
            formulaData.setWrongAnswerOne(mistake[0]);
            formulaData.setWrongAnswerTwo(mistake[1]);
            formulaData.setDescription(GradeEnum.ADVANCED_STIMULATION.getDescription());
            formulaDataSet.add(formulaData);
        }while (formulaDataSet.size()<30);
        return formulaDataSet;
    }
}
