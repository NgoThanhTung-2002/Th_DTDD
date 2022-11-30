package thanhtung.example.baikt;

public class User {
    String name, lastMessage, country, phoneNo, lastMsgTime;
    int imageId;

    public User(String name, String lastMessage, String country, String phoneNo, String lastMsgTime, int imageId) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.country = country;
        this.phoneNo = phoneNo;
        this.lastMsgTime = lastMsgTime;
        this.imageId = imageId;
    }
}
