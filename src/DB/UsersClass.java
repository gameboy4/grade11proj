package DB;

public class UsersClass {
    private int userid;
    private String names;
    private String surname;
    private String username;
    private String password;
    private String permissions;

    public UsersClass() {
    }

    public UsersClass(int userid, String names, String surname, String username, String password, String permissions) {
        this.userid = userid;
        this.names = names;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.permissions = permissions;
    }

    public int getUserid() {
        return userid;
    }

    public String getNames() {
        return names;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
           
    
    
    
}
