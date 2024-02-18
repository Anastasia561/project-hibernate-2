package ua.javarush.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name="category", schema="movie")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Byte id;

    @Column(name="name")
    private String name;

    @UpdateTimestamp
    @Column(name="last_update")
    private Timestamp lastUpdate;

    @ManyToMany
    @JoinTable(name="film_category",
            joinColumns = @JoinColumn(name="category_id", referencedColumnName = "category_id"),
            inverseJoinColumns = @JoinColumn(name="film_id", referencedColumnName = "film_id"))
    private Set<Film> films;
}
