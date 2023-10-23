package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthdate;
    private final int postsQuantity;

    public ForumUser(final int userId, final String username, final char sex,
                     final LocalDate birthdate, final int postsQuantity) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthdate = birthdate;
        this.postsQuantity = postsQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                ", postsQuantity=" + postsQuantity +
                '}';
    }
}
