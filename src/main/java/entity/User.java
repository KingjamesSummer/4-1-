package entity;

public class User {
        private String username;
        private String password;
        private String realname;
        private String moblie;
        private int age;

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getRealname() {
        return realname;
    }
    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }
    public String getMoblie() {
        return moblie;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User() {

    }
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password
                +", realname=" + realname + ", mobile=" + moblie
                +", age=" + age + "]";
    }
}
