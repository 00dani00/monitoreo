package com.prueba_tecnica.monitoreo.modelo;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "\"User\"")
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name="email")
    private String email;
    @Column(name="`emailVerified`")
    private LocalDateTime emailVerified;
    @Column(name="`termsAndConditionsAccepted`")
    private LocalDateTime termsAndConditionsAccepted;
    @Column(name="name")
    private String name;
    @Column(name="image")
    private String image;
    @Column(name="position")
    private String position;
    @Column(name="`createdAt`")
    private LocalDateTime createdAt;
    @Column(name="`updatedAt`")
    private LocalDateTime updatedAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "`roleId`", referencedColumnName = "id")
    private Role role;
    @JoinTable(
            name = "`_CountryToUser`",
            joinColumns = @JoinColumn(name = "`B`", nullable = false),
            inverseJoinColumns = @JoinColumn(name="`A`", nullable = false)
    )
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @ToString.Exclude
    private List<Country> countries = new ArrayList<Country>();
}
