package DB;

public class UsersClass {
    private int userid;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String permission;

    public UsersClass() {
    }

    public UsersClass(int userid, String name, String surname, String username, String password, String permission) {
        this.userid = userid;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.permission = permission;
    }

    public int getUserid() {
        return userid;
    }

    public String getName() {
        return name;
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

    public String getPermission() {
        return permission;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPermission(String permission) {
        this.permission = permission;
    }
           
    
    
    
}
