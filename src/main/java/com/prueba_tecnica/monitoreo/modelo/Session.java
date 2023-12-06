package com.prueba_tecnica.monitoreo.modelo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "`Session`")
public class Session {
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name="`sessionToken`")
    private String sessionToken;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "`userId`", referencedColumnName = "id")
    private User user;
    @Column(name="`expiresAt`")
    private LocalDateTime expiresAt;
    @Column(name="`createdAt`")
    private LocalDateTime createdAt;
}
