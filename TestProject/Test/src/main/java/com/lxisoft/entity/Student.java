package com.lxisoft.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private String age;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id",
    nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "COURSE_ID", referencedColumnName = "id",
                    nullable = false, updatable = false) })
	private List<Course> courses;
    
    public Student() {
    }

    public Student(Integer id, String name, String age, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }
	
	public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public List<Course> getCourses() {
        return courses;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
	
	public void addCourse(Course course) {
		this.courses.add(course);
		course.getStudents().add(this);
	}

	public void removeCourse(Course course) {
		this.getCourses().remove(course);
		course.getStudents().remove(this);
	}

	public void removeCourses() {
		for (Course course : new HashSet<>(courses)) {
			removeCourse(course);
		}
	}
}