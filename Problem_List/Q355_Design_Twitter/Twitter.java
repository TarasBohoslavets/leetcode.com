package Problem_List.Q355_Design_Twitter;

import java.util.*;

class Twitter {
    private static int timestamp = 0;
    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) return result;

        Set<Integer> users = userMap.get(userId).following;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        for (int user : users) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                pq.add(tweet);
            }
        }

        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            result.add(tweet.id);
            count++;
            if (tweet.next != null) {
                pq.add(tweet.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    private static class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private static class User {
        int id;
        Set<Integer> following;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            following = new HashSet<>();
            following.add(id);
            tweetHead = null;
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }

        public void follow(int followeeId) {
            following.add(followeeId);
        }

        public void unfollow(int followeeId) {
            if (followeeId != id) {
                following.remove(followeeId);
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // [5]

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // [6, 5]

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [5]
    }
}
