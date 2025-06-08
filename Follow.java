public class Follow {
    private String follower;
    private String followee;

    public Follow(String follower, String followee) {
        this.follower = follower;
        this.followee = followee;
    }

    public String getFollower() {
        return follower;
    }

    public String getFollowee() {
        return followee;
    }

    @Override
    public String toString() {
        return follower + "," + followee;
    }

    public static Follow fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
            return new Follow(parts[0], parts[1]);
        }
        return null;
    }
}