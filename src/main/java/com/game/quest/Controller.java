package com.game.quest;

import com.game.quest.important.Information;
import com.game.quest.important.Questions;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "info", value = "/controller")
public class Controller extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        Gson gson = new Gson();
        Information inf = JsonParser.getInfo(req, gson);

        int count = inf.getCount();
        boolean btn = inf.getBtn();

        var data = Questions.getChoice(count, btn);
        String gsonData = JsonParser.getJsonString(gson, data);

        PrintWriter out = response.getWriter();
        out.println(gsonData);

    }
}
