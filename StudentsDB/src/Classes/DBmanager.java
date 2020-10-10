package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBmanager {
    private Connection connection;
    public void connect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/stdteachdb?useUnicode=true&serverTimezone=UTC","root","");
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void AddUser(Users user)
    {
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO user (id,fullname,email,login,password) "+"VALUES(null,?,?,?,?);");
            statement.setString(1,user.getFullname());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getLogin());
            statement.setString(4,user.getPassword());
            statement.executeUpdate();
            statement.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void AddStudent(Student student)
    {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students (id,fullname,faculty,groupName)"
                    + "VALUES(null,?,?,?);");
            statement.setString(1,student.getFullname());
            statement.setString(2,student.getFaculty());
            statement.setString(3,student.getGroup());
            statement.executeUpdate();
            statement.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public ArrayList<Student>getAllStudents()
    {
        ArrayList<Student>ListStudent=new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                Integer id=resultSet.getInt("id");
                String fullname=resultSet.getString("fullname");
                String faculty=resultSet.getString("faculty");
                String groupName=resultSet.getString("groupName");
                ListStudent.add(new Student(id,fullname,faculty,groupName));
            }
            statement.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return ListStudent;
    }
    public ArrayList<Users>getAllUsers()
    {
        ArrayList<Users>usersToClient=new ArrayList<>();
        try {
              PreparedStatement statement=connection.prepareStatement("SELECT* FROM user");
              ResultSet resultSet=statement.executeQuery();
              while (resultSet.next())
              {
                  Integer id=resultSet.getInt("id");
                  String fullname=resultSet.getString("fullname");
                  String email=resultSet.getString("email");
                  String login=resultSet.getString("login");
                  String password=resultSet.getString("password");
                  usersToClient.add(new Users(id,fullname,email,login,password));
              }
              statement.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return usersToClient;
    }
    public void DeleteById(Integer id)
    {
        try {
            PreparedStatement statement=connection.prepareStatement("DELETE FROM students WHERE id="+id+";");
            statement.executeUpdate();
            statement.close();
        }catch (Exception ex)
        {
             ex.printStackTrace();
        }
    }
}
