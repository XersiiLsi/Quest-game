package com.game.quest;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "quest", value = "/quest")
public class Quest extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>" + "<link href='./css/main.css' rel='stylesheet' type='text/css'/>");
        out.println("<body onload=\"firstRequest()\">");
        out.println("<div class=\"text\">\n" +
                "        <p>\n" +
                "            Ты поднимаешься, видишь перед собой обломки самолета, начинаешь идти в джунгли.\n" +
                "        </p>\n" +
                "    </div>\n" +
                "    <div class=\"buttions\" method = \"GET\">\n" +
                "        <div class=\"btn-info\" name = \"yes\" >\n" +
                "        <a href=\"#\" class=\"btn\" id=\"yes\">да</a>\n" +
                "        </div>\n" +
                "        <div class=\"btn-info\" name = \"Ok\">\n" +
                        "            <a href=\"#\" class=\"btn\" id=\"Ok\">Пон</a>\n" +
                        "            </div>" +
                "        <div class=\"btn-info\" name = \"no\">\n" +
                "        <a href=\"#\" class=\"btn\" id=\"no\">нет</a>\n" +
                "    </div>\n" +
                "    </div> ");
        out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>");
        out.println("<script src='./js/index.js'></script>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}