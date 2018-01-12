package com.wsh.user.service;

import com.wsh.user.dao.UserDao;
import com.wsh.user.domain.User;
import com.wsh.user.service.exception.*;
import com.wsh.util.Constant;

import java.util.regex.Pattern;

public class UserService{
    private UserDao ud = new UserDao();
    // 注册时首先检查form数据格式是否正确
    public void checkFormat(User form) throws UsernameFormatErrorException, PasswordFormatErrorException, EmailFormatErrorException {
        if (Pattern.matches(Constant.REGEX_NAME,form.getUsername())){
            if (Pattern.matches(Constant.REGEX_PASSWORD,form.getPassword())){
                if (Pattern.matches(Constant.REGEX_EMAIL,form.getEmail())) {
                }else { throw new EmailFormatErrorException(); }
            }else { throw new PasswordFormatErrorException(); }
        }else { throw new UsernameFormatErrorException(); }
    }
    // 其次检查username是否已经存在,email是否已经存在
    public void register(User form) throws EmailHasBeenRegisteredException, UsernameHasBeenRegisteredException {
        if (ud.queryByUsername(form.getUsername()) == null) {
            if (ud.queryByEmail(form.getEmail()) == null) {
                ud.insert(form);
            }else { throw new EmailHasBeenRegisteredException(); }
        }else { throw new UsernameHasBeenRegisteredException(); }
    }
    // 检查激活链接参数code是否存在对应用户,若存在则检查激活状态
    public void active(String code) throws UserNotExistException, UserActivatedException {
        User user = ud.queryByCode(code);
        if (user == null){ throw new UserNotExistException();
        }else if (user.getState() == 1){ throw new UserActivatedException();
        }else { ud.update(code); }
    }
    // 登录时根据参数form的数据查询是否存在对应用户,若存在则检查密码是否对应,若对应则检查激活状态
    public User login(User form) throws UsernameNotExistException, PasswordErrorException, UserNotActiveException {
        User user = ud.queryByUsername(form.getUsername());
        if (user != null){
            if (user.getPassword().equals(form.getPassword())){
                if (user.getState() > 0){
                    return user;
                }else { throw new UserNotActiveException(); }
            }else { throw new PasswordErrorException(); }
        }else { throw new UsernameNotExistException(); }
    }
    //
    public User checkState(String adminname, String password) throws AdminnameExitException, AdminPasswordErrorException {
        User user = ud.queryByAdminname(adminname);
        if (user.getState() != 2){
            throw new AdminnameExitException();
        }else if (!user.getPassword().equals(password)){
            throw new AdminPasswordErrorException();
        }else {
            return user;
        }
    }
}
