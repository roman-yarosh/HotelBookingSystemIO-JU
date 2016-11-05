package hotelbooking;

public class CurrentUser {

    private static CurrentUser instance;
    private User curUser;

    private CurrentUser() {
    }

    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    public User getCurrentUser() {
        return curUser;
    }

    public void setCurrentUser(User currentUser) {
        System.out.println("Current user is " + currentUser);
        this.curUser = currentUser;
    }
}
