package ru.sberbank.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.mvc.dao.UserRepository;
import ru.sberbank.mvc.dao.entity.UserModel;
import ru.sberbank.mvc.dto.UserDto;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<UserDto> collectAllUsers() {
        return toDto(userRepository.findAll());
    }

    public UserDto find(String uuid) {
        return toDto(userRepository.findFirstByUuid(uuid));
    }

    @Transactional
    public void persist(UserDto user) {
        UserModel model = toEntity(user);
        if (model.getUuid() == null) {
            model.setUuid(UUID.randomUUID().toString());

        }
        userRepository.save(model);
        // ох уж этот репозиторий. По-идее, эту сущность нужно мержить.
        // Да ещё убедиться что она вообще существует. Видимо, он делает это сам...
    }

    private List<UserDto> toDto(Collection<UserModel> models) {
        return models.stream().map(this::toDto).collect(Collectors.toList());
    }

    private UserDto toDto(UserModel m) {
        return new UserDto(m.getUuid(), m.getName(), m.getPictureId(), m.getProfileText());
    }

    private UserModel toEntity(UserDto m) {
        return new UserModel(m.getUuid(), m.getName(), m.getPictureId(), m.getProfileText());
    }
}
