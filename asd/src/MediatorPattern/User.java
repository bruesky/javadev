package MediatorPattern;

public class User {
    private String name;
    private ChatRoom chatRoom;


    public String getName() {
        return name;
    }

    public User(ChatRoom chatRoom,String name){
        this.chatRoom = chatRoom;
        this.name = name;
    }

    public void sendMessage(String message){
        this.chatRoom.showMessage(this,message);
    }
}
