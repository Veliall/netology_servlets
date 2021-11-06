package ru.netology.repository;

import ru.netology.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * @author Igor Khristiuk on 06.11.2021
 */
public interface PostRepository {
    List<Post> all();

    Optional<Post> getById(long id);

    Post save(Post post);

    boolean removeById(long id);
}
