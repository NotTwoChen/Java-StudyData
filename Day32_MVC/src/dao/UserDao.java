package dao;

import domain.User;
import service.exception.InvalidUsernameException;

public class UserDao {

    public User queryByUsername(String username) {

        if (username.equals("123")){
            // 假装我们去数据库中拿了数据
            User user = new User("123", "123");
            return user;
        }else {
            return null;
        }


    }
}
