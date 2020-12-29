package fftl.SpringbootCRUD2.service;

import fftl.SpringbootCRUD2.domain.MemberTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    Integer save(MemberTO memberTO);
}