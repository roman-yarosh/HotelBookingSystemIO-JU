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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(userId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", userRegistered=").append(userRegistered);
        sb.append('}');
        return sb.toString();
    }
}
