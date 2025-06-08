import java.util.*;

public class AppLogic {

    
    public static boolean createUser(String username, String password) {
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            System.out.println("Fields cannot be empty.");
            return false;
        }
        List<User> users = DataHandler.readUsers();
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Username already exists.");
                return false;
            }
        }
        User newUser = new User(username, password);
        users.add(newUser);
        DataHandler.writeUsers(users);
        return true;
    }

   
    public static boolean validateLogin(String username, String password) {
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            System.out.println("Fields cannot be empty.");
            return false;
        }
        List<User> users = DataHandler.readUsers();
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) &&
                user.getPassword().equals(password)) {
                return true; // Successful login
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

   
    public static boolean addStory(String title, String content, String author) {
        if (title == null || title.trim().isEmpty() ||
            content == null || content.trim().isEmpty() ||
            author == null || author.trim().isEmpty()) {
            System.out.println("Fields cannot be empty.");
            return false;
        }
        List<Story> stories = DataHandler.readStories();
        for (Story s : stories) {
            if (s.getTitle().equalsIgnoreCase(title) && s.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Story with this title by the same author already exists.");
                return false;
            }
        }
        Story newStory = new Story(title, content, author);
        stories.add(newStory);
        DataHandler.writeStories(stories);
        return true;
    }

    
    public static boolean updateStory(String title, String author, String newContent) {
        List<Story> stories = DataHandler.readStories();
        boolean found = false;
        for (int i = 0; i < stories.size(); i++) {
            Story s = stories.get(i);
            if (s.getTitle().equalsIgnoreCase(title) && s.getAuthor().equalsIgnoreCase(author)) {
                stories.set(i, new Story(title, newContent, author));
                found = true;
                break;
            }
        }
        if (found) {
            DataHandler.writeStories(stories);
        } else {
            System.out.println("Story not found.");
        }
        return found;
    }

   
    public static boolean deleteStory(String title, String author) {
        List<Story> stories = DataHandler.readStories();
        boolean removed = stories.removeIf(s -> s.getTitle().equalsIgnoreCase(title) && s.getAuthor().equalsIgnoreCase(author));
        if (removed) {
            DataHandler.writeStories(stories);
        } else {
            System.out.println("Story not found.");
        }
        return removed;
    }

   
    public static boolean followUser(String follower, String followee) {
        if (follower.equalsIgnoreCase(followee)) {
            System.out.println("Cannot follow yourself.");
            return false;
        }
        List<Follow> follows = DataHandler.readFollows();
        for (Follow f : follows) {
            if (f.getFollower().equalsIgnoreCase(follower) && f.getFollowee().equalsIgnoreCase(followee)) {
                System.out.println("Already following this user.");
                return false;
            }
        }
        follows.add(new Follow(follower, followee));
        DataHandler.writeFollows(follows);
        return true;
    }

   
    public static boolean unfollowUser(String follower, String followee) {
        List<Follow> follows = DataHandler.readFollows();
        boolean removed = follows.removeIf(f -> f.getFollower().equalsIgnoreCase(follower) && f.getFollowee().equalsIgnoreCase(followee));
        if (removed) {
            DataHandler.writeFollows(follows);
        } else {
            System.out.println("Follow relationship not found.");
        }
        return removed;
    }
}