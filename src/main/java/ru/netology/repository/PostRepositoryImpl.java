package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepositoryImpl implements PostRepository {
    private final ConcurrentHashMap<Long, Post> posts = new ConcurrentHashMap<>();
    private AtomicLong count = new AtomicLong(0);

    @Override
    public List<Post> all() {
        return posts.values().stream().toList();
    }

    @Override
    public Optional<Post> getById(long id) {
        if (posts.containsKey(id)) {
            return Optional.of(posts.get(id));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(count.incrementAndGet());
            posts.put(post.getId(), post);
            return post;
        }

        if (getById(post.getId()).isPresent()) {
            posts.put(post.getId(), post);
        }
        return post;
    }

    @Override
    public boolean removeById(long id) {
        return posts.remove(id, getById(id).orElseThrow(NotFoundException::new));
    }
}
