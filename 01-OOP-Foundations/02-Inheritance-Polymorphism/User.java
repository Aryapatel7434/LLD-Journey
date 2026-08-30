
import java.security.PublicKey;

public class User {
    private String userId = "";
    private String name = "";

    public User(String userId,String name) throws IllegalAccessException{

        if(userId==null || userId.isBlank()){
            throw new IllegalArgumentException(
                "User ID can't be empty"
            );
        }
        if(name==null || name.isBlank()){
            throw new IllegalAccessException(
                "Name cannot be empty"
            );
        }
        this.userId=userId;
        this.name=name;
    }
    public String getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }

    
}
