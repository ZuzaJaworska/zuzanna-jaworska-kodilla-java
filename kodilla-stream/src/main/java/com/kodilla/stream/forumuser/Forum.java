package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1001, "UserOne", 'M', LocalDate.of(1991,3,21), 3));
        userList.add(new ForumUser(1002, "UserTwo", 'F', LocalDate.of(1999, 12, 31), 5));
        userList.add(new ForumUser(1003, "UserThree", 'M', LocalDate.of(2005, 10, 17), 7));
        userList.add(new ForumUser(1004, "UserFour", 'M', LocalDate.of(1980, 4, 5), 0));
        userList.add(new ForumUser(1005, "UserFive", 'M', LocalDate.of(2003, 10, 15), 4));
        userList.add(new ForumUser(1006, "UserSix", 'F', LocalDate.of(1989, 7, 31), 9));
        userList.add(new ForumUser(1007, "UserSeven", 'M', LocalDate.of(1975, 8, 4), 6));
        userList.add(new ForumUser(1008, "UserEight", 'M', LocalDate.of(2004, 6, 19), 0));
        userList.add(new ForumUser(1009, "UserNine", 'M', LocalDate.of(1978, 2, 8), 10));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
