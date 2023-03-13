package com.nextyu.demo.tactics;

import com.yanwei.platform.pojo.model.FormulaDTO;
import com.yanwei.platform.pojo.model.FormulaData;
import com.yanwei.platform.pojo.model.GradeEnum;

import java.util.Set;

public class EquationContext {
    private IGetEquation gq;

    /**
     * 策略与简单工厂结合:将实例化具体策略的过程由客户端转移到这里Context类
     */
    public EquationContext(FormulaDTO formulaDTO) {
        if(GradeEnum.ORDINARY_SIMPLE.getVersion()==formulaDTO.getVersion()&& GradeEnum.ORDINARY_SIMPLE.getLevel()==formulaDTO.getLevel()){
            //普通版，简单
            gq = new OrdinarySimpleImpl();
        }else if(GradeEnum.ORDINARY_GENERAL.getVersion()==formulaDTO.getVersion()&& GradeEnum.ORDINARY_GENERAL.getLevel()==formulaDTO.getLevel()) {
            //普通版，一般
            gq = new OrdinaryGeneralImpl();
        }else if(GradeEnum.ORDINARY_DIFFICULT.getVersion()==formulaDTO.getVersion()&& GradeEnum.ORDINARY_DIFFICULT.getLevel()==formulaDTO.getLevel()){
            //普通版，困难
            gq = new OrdinaryDifficultImpl();
        }else if(GradeEnum.ORDINARY_STIMULATION.getVersion()==formulaDTO.getVersion()&& GradeEnum.ORDINARY_STIMULATION.getLevel()==formulaDTO.getLevel()){
            //普通版，刺激
            gq = new OrdinaryStimulationImpl();
        }else if(GradeEnum.ORDINARY_NIGHTMARE.getVersion()==formulaDTO.getVersion()&& GradeEnum.ORDINARY_NIGHTMARE.getLevel()==formulaDTO.getLevel()){
            //普通版，噩梦
            gq = new OrdinaryNightmareImpl();
        }else if(GradeEnum.ADVANCED_SIMPLE.getVersion()==formulaDTO.getVersion()&& GradeEnum.ADVANCED_SIMPLE.getLevel()==formulaDTO.getLevel()){
            //进阶版，普通
            gq = new AdvancedSimpleImpl();
        }else if(GradeEnum.ADVANCED_GENERAL.getVersion()==formulaDTO.getVersion()&& GradeEnum.ADVANCED_GENERAL.getLevel()==formulaDTO.getLevel()){
            //进阶版，一般
            gq = new AdvancedGeneralImpl();
        }else if(GradeEnum.ADVANCED_DIFFICULT.getVersion()==formulaDTO.getVersion()&& GradeEnum.ADVANCED_DIFFICULT.getLevel()==formulaDTO.getLevel()){
            //进阶版，困难
            gq = new AdvancedDifficultImpl();
        }else if(GradeEnum.ADVANCED_STIMULATION.getVersion()==formulaDTO.getVersion()&& GradeEnum.ADVANCED_STIMULATION.getLevel()==formulaDTO.getLevel()){
            //进阶版，刺激
            gq = new AdvancedStimulationImpl();
        }else if(GradeEnum.ADVANCED_NIGHTMARE.getVersion()==formulaDTO.getVersion()&& GradeEnum.ADVANCED_NIGHTMARE.getLevel()==formulaDTO.getLevel()){
            //进阶版，噩梦
            gq = new AdvancedNightmareImpl();
        }
    }

    public Set<FormulaData> getEquation(){
        return gq.equations();
    }
}
