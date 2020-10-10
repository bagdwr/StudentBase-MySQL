package Classes;

import java.io.Serializable;

public class Student implements Serializable{
    private Integer id;
    private String fullname;
    private String faculty;
    private String group;

    public Student(Integer id, String fullname, String faculty, String group)
    {
        this.id=id;
        this.fullname=fullname;
        this.faculty=faculty;
        this.group=group;
    }
    public void setId(Integer id)
    {
        this.id=id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setFaculty(String faculty)
    {
        this.faculty=faculty;
    }

    public String getFaculty()
    {
        return faculty;
    }

    public void setGroup(String group)
    {
        this.group=group;
    }

    public String getGroup()
    {
        return group;
    }

    public void setFullname(String fullname)
    {
        this.fullname=fullname;
    }

    public String getFullname()
    {
        return fullname;
    }

    @Override
    public String toString() {
        return  id +" "+fullname+" "+faculty+"-"+group+"\n";
    }
}
