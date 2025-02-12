package app.entities;

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
    private LocalDate endDate;
    private LocalDate startDate;

    @OneToMany
    @ToString.Exclude
    private Set<Student> students = new HashSet<>();

    public Course(String description, LocalDate endDate, LocalDate startDate) {
        this.description = description;
        this.endDate = endDate;
        this.startDate = startDate;
    }
}
