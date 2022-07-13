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

    @NotBlank(message="'Name of the item  is blank")
    @Column(
        name = "label",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT "
    )
    private String label;   
    
    @NotBlank(message="'Name of the item  is blank")
    @Column(
        name = "description",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT "
    )
    private String decription;

    @Column(
        name = "status",
        updatable = true,
        nullable = false,
        columnDefinition = "TEXT "
    )
    private String status;

    @CreationTimestamp
    @Column(
        name = "create_at",
        nullable = false,
        updatable = false
    )
    private Date create_at;

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
