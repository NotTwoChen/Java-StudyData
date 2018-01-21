package user.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;
import user.bean.User;
import util.NewQueryRunner;

import java.sql.SQLException;

public class UserDao {
    private static NewQueryRunner nqr = new NewQueryRunner();
    private String sql;
    public User queryByUsername(String username){
        sql = "select * from user where username=?";
        User user = new User();
        try {
            user = nqr.query(sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void insert(User user){
        sql = "insert into user values(null,?,?,?,?)";
        try {
            nqr.update(sql,user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
