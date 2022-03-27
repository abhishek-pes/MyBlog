package com.spring.blogapp.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Blog_Title")
    private String BlogTitle;

    @Column(name = "Blog_Content")
    private  String BlogContent;

    @Column(name = "Author_name")
    private String AuthorName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return BlogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        BlogTitle = blogTitle;
    }

    public String getBlogContent() {
        return BlogContent;
    }

    public void setBlogContent(String blogContent) {
        BlogContent = blogContent;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }
}
