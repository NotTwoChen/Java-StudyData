package com.wsh.crm.post.service.impl;

import com.wsh.crm.post.dao.PostDao;
import com.wsh.crm.post.domain.CrmPost;
import com.wsh.crm.post.service.PostService;
import com.wsh.crm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;
    private PageBean<CrmPost> pageBean;

    @Override
    public List<CrmPost> findByDepId(String depId) {
        return postDao.findByDepId(depId);
    }

    @Override
    public List<CrmPost> findAll() {
        List<CrmPost> posts = postDao.findAll();
        return posts;
    }

    @Override
    public PageBean<CrmPost> findAllPost(int nowPageIndex) {
        pageBean = new PageBean<>(nowPageIndex,findAll().size());
        List<CrmPost> crmPosts = postDao.findAll(pageBean);
        pageBean.setList(crmPosts);
        return pageBean;
    }

    @Override
    public CrmPost findByPostId(String postId) {
        return postDao.queryByPostId(postId);
    }

    @Override
    public void update(CrmPost crmPost) {
        postDao.update(crmPost);
    }

    @Override
    public void insert(CrmPost crmPost) {
        postDao.insert(crmPost);
    }

    public PageBean<CrmPost> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<CrmPost> pageBean) {
        this.pageBean = pageBean;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
