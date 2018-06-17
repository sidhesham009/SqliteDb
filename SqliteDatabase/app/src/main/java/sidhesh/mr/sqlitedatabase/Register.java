package sidhesh.mr.sqlitedatabase;

/**
 * Created by Felix-ITS on 22-02-2018.
 */

public class Register {

    public Register() {
        this.name = name;
        this.email = email;
        this.passwrd = passwrd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public String name, email, passwrd;
}
