package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.LaboratoryMapper;
import cn.lxp.pethospital.mapper.UserMapper;
import cn.lxp.pethospital.model.Laboratory;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    private LaboratoryMapper laboratoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Laboratory> selectLaboratoryList() {
        return laboratoryMapper.selectLaboratoryList();
    }

    @Override
    public int insertLaboratory(Laboratory laboratory) {
        laboratory.setId(IdUtil.simpleUUID());
        laboratory.setIsDel(0);
        User user = userMapper.selectUserByName(laboratory.getUser().getName());
        if (user == null){
            return 0;
        }
        laboratory.setUserId(user.getId());
        return laboratoryMapper.insertLaboratory(laboratory);
    }

    @Override
    public Laboratory selectLaboratoryById(String id) {
        return laboratoryMapper.selectLaboratoryById(id);
    }

    @Override
    public int updateLaboratory(Laboratory laboratory) {
        User user = userMapper.selectUserByName(laboratory.getUser().getName());
        if (user == null){
            return 0;
        }
        laboratory.setUserId(user.getId());
        return laboratoryMapper.updateLaboratory(laboratory);
    }

    @Override
    public int deleteLaboratoryById(String id) {
        return laboratoryMapper.deleteLaboratoryById(id);
    }
}
