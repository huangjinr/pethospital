package cn.lxp.pethospital.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lxp.pethospital.mapper.LaboratoryMapper;
import cn.lxp.pethospital.mapper.UserMapper;
import cn.lxp.pethospital.model.Laboratory;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.LaboratoryService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    private LaboratoryMapper laboratoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Laboratory> selectLaboratoryList(String name,String animalName) {
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        Map<String, Object> map = new HashMap<>();
        if (name != null && !"".equals(name)){
            map.put("name",name);
        }
        if (animalName != null && !"".equals(animalName)){
            map.put("animalName",animalName);
        }
        if (currentUser.getRole().getRoleType() == 2){
            map.put("userId",currentUser.getId());
        }
        return laboratoryMapper.selectLaboratoryList(map);
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
