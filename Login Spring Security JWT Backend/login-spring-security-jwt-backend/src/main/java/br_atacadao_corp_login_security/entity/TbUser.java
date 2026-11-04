package br_atacadao_corp_login_security.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class TbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", length = 150)
    private String name ;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 300)
    private String password;
}
