package ru.netology.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import ru.netology.model.Post;
import ru.netology.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

@Controller
public class PostController {
  public static final String APPLICATION_JSON = "application/json";
  private final PostService service;
  private final Gson gson = new Gson();

  public PostController(PostService service) {
    this.service = service;
  }

  public void all(HttpServletResponse response) throws IOException {
    jsonConvert(response, service.all());
  }

  public void getById(long id, HttpServletResponse response) throws IOException {
    jsonConvert(response, service.getById(id));
  }

  public void save(Reader body, HttpServletResponse response) throws IOException {
    final Post post = gson.fromJson(body, Post.class);
    jsonConvert(response, service.save(post));
  }

  public void removeById(long id, HttpServletResponse response) throws IOException {
    service.removeById(id);
    jsonConvert(response, "post with id=" + id + " deleted successfully");
  }

  private <T> void jsonConvert(HttpServletResponse response, T data) throws IOException {
    response.setContentType(APPLICATION_JSON);
    String toJson = gson.toJson(data);
    response.getWriter().print(toJson);
  }
}
