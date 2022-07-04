package ru.hogwartS.school.Service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwartS.school.Model.Avatar;

import java.io.IOException;
import java.util.Collection;

public interface AvatarService {
    Long uploadAvatar(Long studentId, MultipartFile avatar) throws IOException;

    Avatar findAvatar(Long id);

    Collection<Avatar> getAllAvatarsByPage(int page, int size);
}
