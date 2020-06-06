package controllers;

import models.Assessment;
import models.Member;
import play.db.jpa.Model;

public class Utility extends Model {
    public double bmi;
    public String Category;

    public Utility() {
    }

    public static double calculateBMI(Member member, Assessment assessmentList) {
        double bmi;
            bmi = (Math.round(assessmentList.getWeight()) / ((member.getHeight() / 100) * (member.getHeight() / 100)));
        return bmi;
    }

    public static String getCategory(double bmi) {
        if (bmi > 30) {
            return "You" +
                    " are" +
                    " obese.";
        } else if ((bmi > 24.99) && (bmi < 30)) {
            return "You're" +
                    " overweight.";
        } else if ((bmi > 18.5) && (bmi < 24.99)) {
            return "You're" +
                    " normal" +
                    "weight.";
        } else
            return "You're" +
                    " under" +
                    "weight.";
    }
}