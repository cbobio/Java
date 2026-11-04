package br_atacadao_corp_login_security.repository;

import br_atacadao_corp_login_security.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TbUser, String> {
    Optional<TbUser> findByEmail(String email);
}
