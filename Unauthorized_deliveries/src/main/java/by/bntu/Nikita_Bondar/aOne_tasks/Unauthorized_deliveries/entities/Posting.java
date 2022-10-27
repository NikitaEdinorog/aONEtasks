/**
 * Entity of Postings table consists of:
 *  ID_Posting
 *  Documents_Date
 *  Posting_Date
 *  UserName
 *  isAuthorized
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postings")
public class Posting {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "doc_date", nullable = false)
    private Date docDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "pstng_date", nullable = false)
    private Date postingDate;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "isAuthorized")
    private Boolean isAuthorized;

    public Posting(){};

    public Posting(Long id, Date docDate, Date postingDate, String userName, Boolean isAuthorized) {
        this.id = id;
        this.docDate = docDate;
        this.postingDate = postingDate;
        this.userName = userName;
        this.isAuthorized = isAuthorized;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Posting{" +
                "id=" + id +
                ", docDate=" + docDate +
                ", postingDate=" + postingDate +
                ", userName='" + userName + '\'' +
                ", isAuthorized=" + isAuthorized +
                '}';
    }

}
