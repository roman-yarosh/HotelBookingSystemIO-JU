package hotelbooking;

public class User implements HasGetIdMethod {


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

    @Override
    public long getId() {
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
