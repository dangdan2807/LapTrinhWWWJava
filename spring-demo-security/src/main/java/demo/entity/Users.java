package demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "username", nullable = false, columnDefinition = "varchar(50)")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(68)")
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT")
    private int enabled;

    public Users(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String username) {
        this.username = username;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

}
