package com.example.idk.adiitionalResources;

public class WebItems {


    //HTML sidebar item (task)
    public String sidebarElement(String elName) {
        String s = "<li>\n" +
                "        <a href=\"#\">\n" +
                "          <i class=\"bx bx-grid-alt\"></i>\n" +
                "          <span class=\"link_name\">Dashboard</span>\n" +
                "        </a>\n" +
                "        <span class=\"tooltip\">"+elName+"</span>\n" +
                "      </li>";
        return s;
    }
}