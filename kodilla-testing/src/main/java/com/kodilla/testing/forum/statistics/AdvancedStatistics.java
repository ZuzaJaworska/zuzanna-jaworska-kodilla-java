package com.kodilla.testing.forum.statistics;

import java.lang.*;

public class AdvancedStatistics {

    private int usersAll;
    private int postsAll;
    private int commentsAll;

    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    //getters
    public int getUsersAll() {
        return usersAll;
    }

    public int getPostsAll() {
        return postsAll;
    }

    public int getCommentsAll() {
        return commentsAll;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvancedStatistics that = (AdvancedStatistics) o;

        if (usersAll != that.usersAll) return false;
        if (postsAll != that.postsAll) return false;
        if (commentsAll != that.commentsAll) return false;
        if (Double.compare(averagePostsPerUser, that.averagePostsPerUser) != 0) return false;
        if (Double.compare(averageCommentsPerUser, that.averageCommentsPerUser) != 0) return false;
        return Double.compare(averageCommentsPerPost, that.averageCommentsPerPost) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = usersAll;
        result = 31 * result + postsAll;
        result = 31 * result + commentsAll;
        temp = Double.doubleToLongBits(averagePostsPerUser);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(averageCommentsPerUser);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(averageCommentsPerPost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //METHODS

    //average number of posts per user
    public double calcAvgPostsPerUser() {
        if (usersAll > 0) {
            return (double) postsAll / usersAll;
        } else {
            return 0;
        }
    }

    //average number of comments per user
    public double calcAvgCommentsPerUser() {
        if (usersAll > 0) {
            return (double) commentsAll / usersAll;
        } else {
            return 0;
        }
    }

    //average number of comments per post
    public double calcAvgCommentsPerPost() {
        if (postsAll > 0) {
            return (double) commentsAll / postsAll;
        } else {
            return 0;
        }
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersAll = statistics.usersNames().size();
        postsAll = statistics.postsCount();
        commentsAll = statistics.commentsCount();
        averagePostsPerUser = calcAvgPostsPerUser();
        averageCommentsPerUser = calcAvgCommentsPerUser();
        averageCommentsPerPost = calcAvgCommentsPerPost();
    }
}
