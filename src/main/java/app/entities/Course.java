package app.entities;

import app.enums.CourseName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@DynamicUpdate
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private CourseName courseName;
    private LocalDate endDate;
    private LocalDate startDate;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    private Teacher teacher;

    public Course(String description, LocalDate endDate, LocalDate startDate) {
        this.description = description;
        this.endDate = endDate;
        this.startDate = startDate;
    }
}
