package app.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@DynamicUpdate
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Setter
    @ManyToOne
    @ToString.Exclude
    private Course course;

    @PrePersist
    private void addCreated(){
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void addUpdated(){
        updatedAt = LocalDateTime.now();
    }


}
