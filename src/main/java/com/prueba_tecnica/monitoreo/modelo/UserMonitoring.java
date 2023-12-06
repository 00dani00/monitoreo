package com.prueba_tecnica.monitoreo.modelo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "\"UserMonitoring\"")
public class UserMonitoring {
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name="usage")
    private String usage;
    @Column(name="description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "`userId`", referencedColumnName = "id")
    private User user;
    @Column(name="`createdAt`")
    private LocalDateTime createdAt;
}
