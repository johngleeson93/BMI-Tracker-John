package controllers;

import play.*;
import play.mvc.*;

import play.Logger;

public class About extends Controller {
    public static void index() {
        Logger.info("Rendering about");
        render("about.html");
    }
}
