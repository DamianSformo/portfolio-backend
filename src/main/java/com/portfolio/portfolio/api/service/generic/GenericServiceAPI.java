package com.portfolio.portfolio.api.service.generic;

import com.portfolio.portfolio.domain.mapper.IMapper;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericServiceAPI<ENT, RES, REQ, ID> {

    RES save(REQ request);

    RES getById(ID id);

    void delete(ID id);

    JpaRepository<ENT, ID> getRepository();

    IMapper<ENT, RES, REQ> getMapper();

    MessageSource getMessenger();

    default boolean tokenNotValid(String token){
        return (token.trim().isEmpty());
    }
}
