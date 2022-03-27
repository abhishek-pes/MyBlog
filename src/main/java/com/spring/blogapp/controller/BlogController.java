package com.spring.blogapp.controller;

import com.spring.blogapp.model.Blog;
import com.spring.blogapp.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    //Display list of all blog posts
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listBlogs",blogService.getAllBlogs());
        return "index";
    }

    // Create model attribute to bind the form data
    @GetMapping("/createNewPost")
    public  String showCreatePost(Model model){
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        return "new_blog";
    }

    @PostMapping("/saveBlog")
    public String saveBlog(@ModelAttribute("blog") Blog blog){
        // save blog post details to database
        blogService.SaveBlogPosts(blog);
        return "redirect:/";
    }

    // controller to handle update of data
    @GetMapping("showFormForUpdate/{id}")
    public  String updateBlog(@PathVariable (value = "id") long id, Model model){
        // get blog from the service
        Blog blog = blogService.getBlogPostByID(id);

        // set blog as a model to pre-populate the form
        model.addAttribute("blog",blog);
        return "update_blog";
    }

    // controller to delete blog post
    @GetMapping("deleteBlogPost/{id}")
    public String deleteBlog(@PathVariable (value = "id") long id){

        // call the delete service
        this.blogService.deleteBlogPost(id);

        return "redirect:/";
    }
}
