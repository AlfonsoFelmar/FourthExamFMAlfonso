package fourthexamfmalfonso;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
     private Map<String, Set<String>> friendsMap;

    public Graph() {
        friendsMap = new HashMap<>();
    }

    public void addUser(String user) {
        friendsMap.putIfAbsent(user, new HashSet<>());
    }

    public void addFriend(String user1, String user2) {
        friendsMap.putIfAbsent(user1, new HashSet<>());
        friendsMap.putIfAbsent(user2, new HashSet<>());
        friendsMap.get(user1).add(user2);
        friendsMap.get(user2).add(user1);
    }

    public void displayFriends() {
        for (var entry : friendsMap.entrySet()) {
            System.out.print(entry.getKey() + "'s friends: ");
            for (String friend : entry.getValue()) {
                System.out.print(friend + " ");
            }
            System.out.println();
        }
    }

    public Set<String> getRecommendedFriends(String user) {
        Set<String> recommended = new HashSet<>();
        Set<String> userFriends = friendsMap.getOrDefault(user, new HashSet<>());

        for (String friend : userFriends) {
            for (String friendsFriend : friendsMap.getOrDefault(friend, new HashSet<>())) {
                if (!userFriends.contains(friendsFriend) && !friendsFriend.equals(user)) {
                    recommended.add(friendsFriend);
                }
            }
        }
        return recommended;
    }
}
