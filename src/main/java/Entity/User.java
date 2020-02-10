package Entity;

public class User {
    private int user_Id;
    private String name;
    private String surName;

    public User() {
    }

    public User(int userId, String name, String surName) {
        this.user_Id = user_Id;
        this.name = name;
        this.surName = surName;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int userId) {
        this.user_Id = user_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
