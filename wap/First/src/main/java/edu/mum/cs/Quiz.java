package edu.mum.cs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Quiz {
    private static String[] questions = {
            "3,1,4,1,5",
            "1,1,2,3,5",
            "1,4,9,16,25",
            "2,3,5,7,11",
            "1,2,4,8,16"
    };

    private static int[] answers = {9,8,36,13,32};
    private ArrayList<Integer> ids = new ArrayList<>();
    private int next = -1;
    private int score = 0;

    public Quiz() {
        for (int i = 0; i < questions.length; i++) {
            ids.add(i);
        }
    }

    public String getProcess(){
        return (answers.length-ids.size())+"/"+answers.length;
    }

    public boolean isOver(){
        return ids.size()==0;
    }

    public boolean isLastQuestion(){
        return ids.size()==1;
    }

    public boolean isBegin(){
        return next!=-1;
    }

    public String shuffle(){
        if (next>=0){
            ids.remove(next);
        }

        int min = 0;
        int max = ids.size();
        int range = max - min;
        next =  (int)(Math.random() * range) + min;
        return questions[ids.get(next)];
    }

    public int checkAnswerAndScore(int ans){
        if (answers[ids.get(next)]==ans)
            score++;
        return score;
    }
}
