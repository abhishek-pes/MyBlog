package com.spring.blogapp.model.service;

import com.spring.blogapp.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getAllBlogs();
    void SaveBlogPosts(Blog blog);
    Blog getBlogPostByID(long id);
    void deleteBlogPost(long id);
}
