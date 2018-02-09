package com.wsh.mapper;

import com.wsh.domain.User;
import com.wsh.domain.UserQueryVO;

import java.util.List;

public interface UserDynamicMapper {


    List<User> findUsersByQueryVO(UserQueryVO userQueryVO);

    int findUsersCount(UserQueryVO userQueryVO);

    List<User> findUserList(UserQueryVO userQueryVO);

    int findUsersCount2(UserQueryVO userQueryVO);

    List<User> findUsersByIdList(List<Integer> idList);

}
