package it.craftopoly.co_lobby.schema;

public class User {

    private int user_id;
    private String username;
    private int level;
    private String created_on;
    private int rank_id;


    // Getters and setters
    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCreatedOn() {
        return created_on;
    }

    public void setCreatedOn(String createdOn) {
        this.created_on = createdOn;
    }

    public int getRankId() {
        return rank_id;
    }

    public void setRankId(int rankId) {
        this.rank_id = rankId;
    }

}
