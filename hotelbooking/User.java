package hotelbooking;

public class User {

    private long userId;
    private String firstName;
    private String lastName;
    private boolean userRegistered;

    public User(long userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setUserRegistered(boolean userRegistered) {
        this.userRegistered = userRegistered;
    }

    public boolean isUserRegistered() {
        return userRegistered;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userRegistered=" + userRegistered +
                '}';
    }
}
