package com.wsh.crm.post.service;

import com.wsh.crm.post.domain.CrmPost;
import com.wsh.crm.util.PageBean;

import java.util.List;

public interface PostService {

    List<CrmPost> findByDepId(String depId);

    List<CrmPost> findAll();

    CrmPost findByPostId(String postId);

    void update(CrmPost crmPost);

    void insert(CrmPost crmPost);

    PageBean<CrmPost> findAllPost(int nowPageIndex);
}
