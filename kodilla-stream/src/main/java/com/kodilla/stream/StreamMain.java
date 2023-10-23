package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum theForum = new Forum();

        Map<Integer,ForumUser> theResultMapOfUsers = theForum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getBirthdate(), LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getPostsQuantity() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        System.out.println("# users: " + theResultMapOfUsers.size());
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> "UserID " +  entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
