import java.util.Arrays;

public class User {
    private String username;
    private String password;
    private String gender;
    private String[] hobbies;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public User(String username, String password, String gender, String[] hobbies) {

        this.username = username;
        this.password = password;
        this.gender = gender;
        this.hobbies = hobbies;
    }

    public User() {

    }
}