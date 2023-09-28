package com.game.quest;


import java.lang.reflect.Type;
import java.util.HashMap;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "info", value = "/controller")
public class Controller extends HttpServlet {
    private int count;
    private boolean sheRemember;
    private boolean btn;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Gson gson = new Gson();
        Information inf = getInfo(req, gson);
        count = inf.count;
        btn = inf.btn;
        boolean transition = false;

        HashMap<String, String> data = new HashMap<>();

        if (count == 0) {
            // banana event (start)
            data.put("202", Events.start.answer);
            data.put("imgId" , Events.start.id);
        } else if (count == 1 && btn) {
            // if yes (monkey event)
            data.put("202", Events.first.answer);
            data.put("imgId" , Events.first.id);
        } else if (count == 1 && !btn) {
            // if no , go to another question
            data.put("transition", "2");
            data.put("imgId" , Events.second.id);
            count = 3;
            transition = true;
        } else if (count == 2 && btn) {
            // if yes (monkey event) give banana + next event (berries)
            data.put("200", Events.firstYes.answer);
            sheRemember = true;
            data.put("202", Events.second.answer);
            data.put("imgId" , Events.second.id);
        } else if (count == 2 && !btn) {


            // if no (monkey event) redneck + next event (berries)
            data.put("200", Events.firstNo.answer);
            sheRemember = false;
            data.put("202", Events.second.answer);
            data.put("imgId" , Events.second.id);

        }
        if (count == 3 && transition)
            // berries event
            data.put("202", Events.second.answer);
        else if (count == 3 && btn) {
            // eat berries
            data.put("202", Events.secondYes.answer);
            data.put("imgId" , "die");
            data.put("end", "true");
        } else if (count == 3 && !btn) {
            // say no! I'm not like this "berries" pf + next event (night)
            data.put("200", Events.secondNo.answer);
            data.put("202", Events.third.answer);
            data.put("imgId" , Events.third.id);
        }
        // night event, sleep or no?

        else if (count == 4 && btn) {
            // sleep
            data.put("202", Events.thirdYes.answer);
            // sleep at night events, cause two another methods
            // if you give monkey banana + end
            if (sheRemember) {
                data.put("200", "Ты проснулся и увидел ту самую мартышку, она держала в руках твою сумку в которой была еда, она положила ее рядом с тобой, сверху положив банан, и убежала. \n Ты перекусил, собрался с силами и пошел дальше");
                data.put("imgId" , "monkey");
                data.put("202", Events.sixth.answer);
                data.put("endImgId" , "end");
                data.put("end", "true");
            }
            // if you redneck + next event spear
            if (!sheRemember) {
                data.put("200", "ты проснулся голодный, но решил не унывать");
                data.put("202", Events.fourth.answer);
                data.put("imgId" , "5");
                data.put("transition", "5");
            }
        } else if (count == 4 && !btn) {
            data.put("202" , Events.fourth.answer);
            data.put("200" , Events.thirdNo.answer);
            data.put("imgId" , "5");
            data.put("transition", "5");
        }
        // don't sleep (next event with spear)
        else if (count == 5 && !btn) {
            data.put("202", Events.fourth.answer);
            data.put("imgId" , Events.fourth.id);

        } else if (count == 6 && btn) {
            // kill tiger + next event (eat him?)
            data.put("202", Events.fourthYes.answer);
            data.put("imgId" , Events.fourthYes.id);
        } else if (count == 6 && !btn) {
            // be a delicious breakfast
            data.put("202", Events.fourthNo.answer);
            data.put("imgId" , Events.fourthNo.id);
            data.put("end", "true");
        }
        // eat tiger meat event
        else if (count == 7 && btn) {
            // you eat it
            data.put("200", Events.fifthYes.answer);
            data.put("202", Events.sixth.answer);
            data.put("imgId" , Events.fifthYes.id);
            data.put("endImgId" , "end");
            data.put("end", "true");
        } else if (count == 7 && !btn) {
            // lol, nice try (choice another way)
            data.put("202", Events.fifthNo.answer);
            data.put("end", "true");
            data.put("imgId" , "die");
        }
        // end
        else if (count == 8) {
            data.put("202", Events.sixth.answer);
            data.put("end", "true");
            data.put("endImgId" , "end");
        }

        String gsonData = getString(gson, data);

        PrintWriter out = response.getWriter();
        out.println(gsonData);


    }

    private static String getString(Gson gson, HashMap<String, String> data) {
        Type typeObject = new TypeToken<HashMap>() {
        }.getType();
        String gsonData = gson.toJson(data, typeObject);
        return gsonData;
    }

    private static Information getInfo(HttpServletRequest req, Gson gson) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        // JSON строка
        String jsonString = sb.toString();
        return gson.fromJson(jsonString, Information.class);
    }
}
