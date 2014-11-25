package ru.qatools.school.twister.view;

import ru.qatools.school.twister.models.Post;
import ru.qatools.school.twister.models.User;

import java.util.List;

/*
 * Created by ashchogoleva on 25.11.14.
 */
public class ViewData {

    public User authUser;
    public Post post;
    public List<Post> posts;
    public User profile;


    public User getAuthUser() {
        return authUser;
    }

    public Post getPost() {
        return post;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public User getProfile() {
        return profile;
    }
}
