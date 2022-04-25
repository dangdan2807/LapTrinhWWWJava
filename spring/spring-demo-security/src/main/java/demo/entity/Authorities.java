package demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "authorities", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username", "authorities"})
})
public class Authorities {
    @Column(name = "authority", nullable = false, columnDefinition = "varchar(50)")
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    @Column(name = "username", nullable = false, columnDefinition = "varchar(50)")
    private Set<Users> users;
}
