package com.wsh.user.dao;

import com.wsh.user.domain.User;
import com.wsh.util.PerfectQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    private PerfectQueryRunner pqr = new PerfectQueryRunner();
    // 根据username查询得到User对象
    public User queryByUsername(String username){
        String sql = "SELECT * FROM tb_user WHERE username=?";
        User user = new User();
        try {
            user = pqr.query(sql, new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    // 根据email查询得到User对象
    public User queryByEmail(String email){
        String sql = "SELECT * FROM tb_user WHERE email=?";
        User user = new User();
        try {
            user = pqr.query(sql, new BeanHandler<User>(User.class), email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    // 根据code查询得到User对象
    public User queryByCode(String code){
        String sql = "SELECT * FROM tb_user WHERE code=?";
        User user = new User();
        try {
            user = new PerfectQueryRunner().query(sql, new BeanHandler<User>(User.class), code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    // 将User对象form添加到数据库table中
    public void insert(User form){
        String sql = "INSERT INTO tb_user VALUES(?,?,?,?,?,?)";
        try {
            pqr.update(
                    sql,
                    form.getUid(),
                    form.getUsername(),
                    form.getPassword(),
                    form.getEmail(),
                    form.getCode(),
                    form.getState()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 依据code作为查询条件将state状态激活为1(即激活用户)
    public int update(String code){
        String sql = "UPDATE tb_user SET state=1 WHERE code=?";
        int update = 0;
        try {
            update = pqr.update(sql, code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
    //
    public User queryByAdminname(String adminname){
        String sql = "select * from tb_user where username=?";
        User user = new User();
        try {
            user = pqr.query(sql,new BeanHandler<User>(User.class),adminname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
