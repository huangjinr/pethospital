package cn.lxp.pethospital.service.impl;

import cn.lxp.pethospital.mapper.IncomeMapper;
import cn.lxp.pethospital.model.Income;
import cn.lxp.pethospital.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeMapper incomeMapper;

    @Override
    public List<Income> selectIncomeList() {
        return incomeMapper.selectIncomeList();
    }
}
