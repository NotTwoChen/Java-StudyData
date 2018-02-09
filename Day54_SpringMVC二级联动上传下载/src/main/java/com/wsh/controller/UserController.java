package com.wsh.controller;

import com.wsh.domain.Depart;
import com.wsh.domain.Post;
import com.wsh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(User user, Model model){
        user.setId(1);
        user.setPostId(1);
        model.addAttribute("user",user);
//        return "/listStaff";
        return "/upload";
    }

    @RequestMapping("/listStaff")
    @ResponseBody
    public List<Post> listStaff(Depart depart){
//        List<Post> posts = depart.getPosts();
        List<Post> posts = new ArrayList<>();
        if (depart.getId() == -1){
            System.out.println(depart.getId());
            posts.clear();
        }else if (depart.getId() == 0){
            System.out.println(depart.getId());
            Post post1 = new Post(0, "奉东坝", 0);
            Post post2 = new Post(1, "康晋府", 0);
            Post post3 = new Post(2, "安讷庄", 0);
            posts.add(post1);
            posts.add(post2);
            posts.add(post3);
        }else if (depart.getId() == 1){
            System.out.println(depart.getId());
            Post post1 = new Post(3, "临苏区", 0);
            Post post2 = new Post(4, "定蒲乡", 0);
            Post post3 = new Post(5, "牟清峰", 0);
            Post post4 = new Post(6, "镇获崖", 0);
            posts.add(post1);
            posts.add(post2);
            posts.add(post3);
            posts.add(post4);
        }else if (depart.getId() == 2){
            System.out.println(depart.getId());
            Post post = new Post(7, "漠安港", 0);
            posts.add(post);
        }else if (depart.getId() == 3){
            System.out.println(depart.getId());
            Post post1 = new Post(8, "宁丽县", 0);
            Post post2 = new Post(9, "德中洞", 0);
            posts.add(post1);
            posts.add(post2);
        }
        return posts;
    }
    @RequestMapping("/upload")
    public String upload(MultipartFile items_pic) throws IOException {
        String originalFilename = items_pic.getOriginalFilename();
        if (originalFilename != null && originalFilename.length() > 0){
            String pic_path = "/Users/lanou3g/Java-StudyData/web/temp";
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File file = new File(pic_path, newFileName);
            items_pic.transferTo(file);
        }
        return "success";
    }

}
