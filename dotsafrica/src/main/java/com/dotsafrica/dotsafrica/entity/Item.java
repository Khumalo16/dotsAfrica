package com.dotsafrica.dotsafrica.entity;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Getter
@Setter
@ToString

@NoArgsConstructor
@Entity
@Table(name="Item")
public class Item {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="'Label is blank")
    @Column(
        name = "label",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT "
    )
    private String label;   
    
    @NotBlank(message="'Discription is blank")
    @Column(
        name = "discription",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT "
    )
    private String discription;

    @Column(
        name = "status",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT "
    )
    private String status;

    @CreationTimestamp
    @Column(
        name = "timestamp",
        nullable = false,
        updatable = false
    )
    private Date timestamp;

    @UpdateTimestamp
    @Column(
        name = "updated_at",
        nullable = false,
        updatable = true
    )
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser user;
    
}
