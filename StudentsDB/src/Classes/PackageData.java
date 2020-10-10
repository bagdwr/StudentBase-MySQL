package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private Student student;
    private ArrayList<Student>allStudents;
    private Users user;
    private ArrayList<Users>allUsers;
    private Integer id;

    public PackageData(){}
    public PackageData(String operationType, Student student)
    {
        this.operationType=operationType;
        this.student=student;
    }
    public PackageData(String operationType)
    {
        this.operationType=operationType;
    }
    public PackageData(String operationType,Users user)
    {
        this.operationType=operationType;
        this.user=user;
    }
    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Student> getStudents() {
        return allStudents;
    }
    public void setAllStudents(ArrayList<Student>students)
    {
        allStudents=students;
    }

    public ArrayList<Users> getAllUsers() {
        return allUsers;
    }
    public void setAllUsers(ArrayList<Users>usersFromServer)
    {
        allUsers=usersFromServer;
    }

    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public void setId(Integer id)
    {
        this.id=id;
    }
    public Integer getId()
    {
        return id;
    }
}
