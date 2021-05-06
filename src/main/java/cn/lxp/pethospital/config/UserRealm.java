package cn.lxp.pethospital.config;



import cn.lxp.pethospital.mapper.ResourcesMapper;
import cn.lxp.pethospital.model.User;
import cn.lxp.pethospital.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourcesMapper resourcesMapper;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》doGetAuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        List<String> resourcesCodeList = resourcesMapper.selectResourcesCodeByUserId(currentUser.getId());
        HashSet<String> set = new HashSet<>();
        if(resourcesCodeList.get(0) != null){
            set.addAll(resourcesCodeList);
        }
        simpleAuthorizationInfo.setStringPermissions(set);
        HashSet<String> RolesSet = new HashSet<>();
        RolesSet.add(currentUser.getRole().getNameEn());
        simpleAuthorizationInfo.setRoles(RolesSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=》doGetAuthenticationInfo");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.selectUserByUsername(token.getUsername());
        if (user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
