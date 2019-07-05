package MediatorPattern;

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        User robert = new User(chatRoom,"Robert");
        User john = new User(chatRoom,"John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }}
