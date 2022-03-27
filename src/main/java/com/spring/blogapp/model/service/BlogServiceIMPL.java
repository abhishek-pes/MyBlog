package com.spring.blogapp.model.service;

import com.spring.blogapp.model.Blog;
import com.spring.blogapp.model.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceIMPL implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @Override
    public void SaveBlogPosts(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Blog getBlogPostByID(long id) {
        Optional<Blog> optional = blogRepository.findById(id);
        Blog blog = null;
        if(optional.isPresent())
        {
            blog = optional.get();
        }
        else{
            throw new RuntimeException("Blog post not found for id: "+id);
        }
        return blog;
    }

    @Override
    public void deleteBlogPost(long id) {
        this.blogRepository.deleteById(id);
    }
}
