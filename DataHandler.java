import java.io.*;
import java.util.*;

public class DataHandler {
    private static final String USERS_FILE = "users.txt";
    private static final String STORIES_FILE = "stories.txt";
    private static final String FOLLOWS_FILE = "follows.txt";

    
    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null) {
                    users.add(user);
                }
            }
        } catch (FileNotFoundException e) {
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    
    public static void writeUsers(List<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (User user : users) {
                bw.write(user.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static List<Story> readStories() {
        List<Story> stories = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(STORIES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Story story = Story.fromString(line);
                if (story != null) {
                    stories.add(story);
                }
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stories;
    }

    public static void writeStories(List<Story> stories) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STORIES_FILE))) {
            for (Story story : stories) {
                bw.write(story.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static List<Follow> readFollows() {
        List<Follow> follows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FOLLOWS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Follow follow = Follow.fromString(line);
                if (follow != null) {
                    follows.add(follow);
                }
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return follows;
    }

    public static void writeFollows(List<Follow> follows) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FOLLOWS_FILE))) {
            for (Follow follow : follows) {
                bw.write(follow.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}