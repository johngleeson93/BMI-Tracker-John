package controllers;

import models.Assessment;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

import models.Member;

public class Dashboard extends Controller {

    public static void addAssessment(double weight, double chest, double thigh, double upperArm, double waist, double hips) {
        Member member = Accounts.getLoggedInMember();
        Assessment assessment = new Assessment(weight, chest, thigh, upperArm, waist, hips);
        member.assessmentList.add(0,assessment);
        member.save();
        Logger.info("Adding Assessment");
        redirect("/dashboard");
    }

    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Assessment> assessmentList = member.assessmentList;
        double bmi = Utility.calculateBMI(member, assessmentList.get(-1));
        String getCategory = Utility.getCategory(bmi);
        render("dashboard.html", member, assessmentList, bmi, getCategory);
    }
}

