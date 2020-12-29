package fftl.SpringbootCRUD2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberDao extends JpaRepository<Member, Integer> {
    Optional<Member> findByAccount(String account);
}
