package ru.sberbank.mvc.dao;

import org.springframework.data.repository.Repository;
import ru.sberbank.mvc.dao.entity.UserModel;

import java.util.Collection;

public interface UserRepository extends Repository<UserModel, String> {

    Collection<UserModel> findAll();

    UserModel save(UserModel entity);

    UserModel findFirstByUuid(String uuid);
}
