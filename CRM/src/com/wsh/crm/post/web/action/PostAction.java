package com.wsh.crm.post.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.crm.post.domain.CrmPost;
import com.wsh.crm.post.service.PostService;
import com.wsh.crm.util.MD5_UUID_Util;
import com.wsh.crm.util.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@Scope("prototype")
public class PostAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

    @Autowired
    private PostService postService;
    private HttpServletRequest request;
    private HttpServletResponse response;
    @Autowired
    private CrmPost crmPost;
    private String depId;
    private String nowPageIndex;

    public String findByDepId() throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<CrmPost> posts = postService.findByDepId(depId);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"crmStaffs","crmDepartment"});
        JSONArray jsonArray = JSONArray.fromObject(posts,jsonConfig);
        response.getWriter().write(jsonArray.toString());
        return NONE;
    }
    public String findAll(){
        List<CrmPost> posts = postService.findAll();
        request.setAttribute("crmPosts",posts);
        return SUCCESS+"2";
    }
    public String findAllPost(){
        if (nowPageIndex == null){
            nowPageIndex = "1";
        }
        PageBean<CrmPost> pageBean = postService.findAllPost(Integer.parseInt(nowPageIndex));
        request.setAttribute("pageBean",pageBean);
        return "allPost";
    }
    public String editPost(){
        String postId = crmPost.getPostId();
        CrmPost crmPost = postService.findByPostId(postId);
        request.setAttribute("crmPost",crmPost);
        return "edit";
    }
    public String update(){
        if (crmPost.getPostId()!=null&&!crmPost.getPostId().equals("")) {
            postService.update(crmPost);
        }else {
            crmPost.setPostId(MD5_UUID_Util.getUuid());
            postService.insert(crmPost);
        }
        return "update";
    }

    public String getNowPageIndex() {
        return nowPageIndex;
    }

    public void setNowPageIndex(String nowPageIndex) {
        this.nowPageIndex = nowPageIndex;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public CrmPost getCrmPost() {
        return crmPost;
    }

    public void setCrmPost(CrmPost crmPost) {
        this.crmPost = crmPost;
    }

    @JSON(serialize = false)
    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        response = httpServletResponse;
    }
}
