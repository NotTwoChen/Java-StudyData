package com.wsh.crm.post.dao;

import com.wsh.crm.post.domain.CrmPost;
import com.wsh.crm.util.PageBean;

import java.util.List;

public interface PostDao {

    List<CrmPost> findByDepId(String depId);

    List<CrmPost> findAll();

    CrmPost queryByPostId(String postId);

    void update(CrmPost crmPost);

    void insert(CrmPost crmPost);

    List<CrmPost> findAll(PageBean<CrmPost> pageBean);
}
