package ru.netology.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Igor Khristiuk on 07.11.2021
 */
@FunctionalInterface
public interface Handler {

    void handle(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
