package edu.mum.domain;

public class User {
    static int id = 0;
    private int uid;
    public User() {
        uid = ++id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                '}';
    }
}
