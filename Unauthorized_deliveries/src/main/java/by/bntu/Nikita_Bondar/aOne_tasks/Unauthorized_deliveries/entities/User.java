/**
 * Entity of User table consists of:
 *  Account_Name
 *  Job_Title
 *  Department
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "account_name", nullable = false, unique = true)
    private String accountName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "department")
    private String department;

    public User() {
    }

    public User(String accountName, String jobTitle, String department) {

        this.accountName = accountName;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountName='" + accountName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

