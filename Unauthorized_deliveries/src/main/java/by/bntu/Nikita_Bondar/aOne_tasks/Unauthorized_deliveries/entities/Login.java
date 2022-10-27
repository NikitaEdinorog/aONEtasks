/**
 * Entity of Logins table consists of:
 *  id
 *  User
 *  isActive
 *  applicationName
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "logins")
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "application")
    private String applicationName;

    public Long getId() {
        return id;
    }

    public Login() {}
    public Login(User user, Boolean isActive, String aplicationName) {
        this.user = user;
        this.isActive = isActive;
        this.applicationName = aplicationName;
    }


    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String aplicationName) {
        this.applicationName = aplicationName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", user=" + user +
                ", isActive=" + isActive +
                ", applicationName='" + applicationName + '\'' +
                '}';
    }
}
