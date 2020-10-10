package Classes;

import java.io.Serializable;

public class Users implements Serializable {
    private Integer id;
    private String fullname;
    private String login;
    private String password;
    private String email;

    public Users(Integer id,String fullname,String email,String login,String password)
    {
        this.id=id;
        this.email=email;
        this.login=login;
        this.password=password;
        this.fullname=fullname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id+" "+fullname+" "+email+" "+login+" "+password+"\n";
    }
}
