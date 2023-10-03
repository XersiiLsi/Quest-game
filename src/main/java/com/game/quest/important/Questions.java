package com.game.quest.important;

import com.google.gson.Gson;

import java.util.HashMap;

public class Questions {
    static boolean sheRemember;

    public static HashMap getChoice(int count, boolean btn) {

        HashMap<String, String> data = new HashMap<>();
        boolean transition = false;


        if (count == 0) {
            // banana event (start)
            data.put("202", Events.start.answer);
            data.put("imgId", "bananaEvent");
        } else if (count == 1 && btn) {
            // if yes (monkey event)
            data.put("202", Events.first.answer);
            data.put("imgId", "monkeyEvent");
        } else if (count == 1 && !btn) {
            // if no , go to another question
            data.put("transition", "2");
            data.put("imgId", "berries");
            count = 3;
            transition = true;
        } else if (count == 2 && btn) {
            // if yes (monkey event) give banana + next event (berries)
            data.put("200", Events.firstYes.answer);
            sheRemember = true;
            data.put("202", Events.second.answer);
            data.put("imgId", "berries");
        } else if (count == 2 && !btn) {

            // if no (monkey event) redneck + next event (berries)
            data.put("200", Events.firstNo.answer);
            sheRemember = false;
            data.put("202", Events.second.answer);
            data.put("imgId", "berries");

        }
        if (count == 3 && transition)
            // berries event
            data.put("202", Events.second.answer);
        else if (count == 3 && btn) {
            // eat berries
            data.put("202", Events.secondYes.answer);
            data.put("imgId", "die");
            data.put("end", "true");
        } else if (count == 3 && !btn) {
            // say no! I'm not like this "berries" pf + next event (night)
            data.put("200", Events.secondNo.answer);
            data.put("202", Events.third.answer);
            data.put("imgId", "nightJungle");
        }
        // night event, sleep or no?

        else if (count == 4 && btn) {
            // sleep
            data.put("202", Events.thirdYes.answer);
            // sleep at night events, cause two another methods
            // if you give monkey banana + end
            if (sheRemember) {
                data.put("200", "Ты проснулся и увидел ту самую мартышку, она держала в руках твою сумку в которой была еда, она положила ее рядом с тобой, сверху положив банан, и убежала. \n Ты перекусил, собрался с силами и пошел дальше");
                data.put("imgId", "monkey");
                data.put("202", Events.sixth.answer);
                data.put("endImgId", "end");
                data.put("end", "true");
            }
            // if you redneck + next event spear
            if (!sheRemember) {
                data.put("200", "ты проснулся голодный, но решил не унывать");
                data.put("202", Events.fourth.answer);
                data.put("imgId", "spear");
                data.put("transition", "5");
            }
        } else if (count == 4 && !btn) {
            data.put("202", Events.fourth.answer);
            data.put("200", Events.thirdNo.answer);
            data.put("imgId", "spear");
            data.put("transition", "5");
        }
        // don't sleep (next event with spear)
        else if (count == 5 && !btn) {
            data.put("202", Events.fourth.answer);
            data.put("imgId", "spear");

        } else if (count == 6 && btn) {
            // kill tiger + next event (eat him?)
            data.put("202", Events.fourthYes.answer);
            data.put("imgId", "woundedTiger");
        } else if (count == 6 && !btn) {
            // be a delicious breakfast
            data.put("202", Events.fourthNo.answer);
            data.put("imgId", "deliciousBreakfast");
            data.put("end", "true");
        }
        // eat tiger meat event
        else if (count == 7 && btn) {
            // you eat it
            data.put("200", Events.fifthYes.answer);
            data.put("202", Events.sixth.answer);
            data.put("imgId", "forestFire");
            data.put("endImgId", "end");
            data.put("end", "true");
        } else if (count == 7 && !btn) {
            // lol, nice try (choice another way)
            data.put("202", Events.fifthNo.answer);
            data.put("end", "true");
            data.put("imgId", "die");
        }
        // end
        else if (count == 8) {
            data.put("202", Events.sixth.answer);
            data.put("end", "true");
            data.put("endImgId", "end");
        }

        return data;
    }
}
