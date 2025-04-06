package com.example.servlet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.servlet.discover.LocalFile;

@WebServlet("/filelist")
public class FileListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        if (path == null || path.isEmpty()) {
            path = System.getProperty("user.home") // Путь по умолчанию
                    .replace("\\", "/");
        }


        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Directory not found");
            return;
        }

        List<LocalFile> items = new ArrayList<>();
        for (File file : directory.listFiles()) {
            items.add(new LocalFile(file));
        }

        // Получение пути к родительской директории
        File previousDirectory = directory.getParentFile();
        String previousPath;

        if (previousDirectory.exists()) {
            previousPath = previousDirectory
                    .getAbsolutePath()
                    .replace("\\", "/");
        } else {
            previousPath = System.getProperty("user.home")
                    .replace("\\", "/");
        }

        request.setAttribute("previousPath", previousPath);
        request.setAttribute("currentPath", path);
        request.setAttribute("Items", items);

        request.setAttribute("currentDate", new Date());
        request.getRequestDispatcher("filelist.jsp").forward(request, response);

    }
}