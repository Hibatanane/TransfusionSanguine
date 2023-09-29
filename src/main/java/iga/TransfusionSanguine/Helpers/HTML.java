package iga.TransfusionSanguine.Helpers;

public class HTML {
    public static String htmlEmailTemplate(String token , int code){
        String url = "http://localhost:1100/verify?token=" +token + "&code="+ code+"";
        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Email</title>\n" +
                "    <link rel=\"stylesheet\" href=\"assets/css/email.css\">\n" +
                "    <style>\n" +
                " *\n" +
                " {\n" +
                "     box-sizing: border-box;\n" +
                "     font-family: 'Courier New', Courier, monospace;\n" +
                " }\n" +
                " body\n" +
                " {\n" +
                "     height: 100vh;\n" +
                "     background-color: rgba(241, 241, 241, 0.911);\n" +
                "     display: flex;\n" +
                "     align-items: center;\n" +
                "     justify-content: center;\n" +
                " }\n" +
                " .wrapper\n" +
                " {\n" +
                "     width: 550px;\n" +
                "     height: auto;\n" +
                "     padding: 15px;\n" +
                "    background-color:  white;\n" +
                "    border-radius: 7px;\n" +
                " }\n" +
                " .email-msg-header\n" +
                " {\n" +
                "     text-align: center;\n" +
                " }\n" +
                "\n" +
                ".company-name\n" +
                "{\n" +
                " width: 100%;\n" +
                " font-size: 25px;\n" +
                " color: rgb(107, 107, 255);\n" +
                " text-align: center;\n" +
                "}\n" +
                ".welcome-text\n" +
                "{\n" +
                "    text-align: center;\n" +
                "}\n" +
                ".verify-account-btn\n" +
                "{\n" +
                "    padding: 15px;\n" +
                "    background-color: rgb(107, 107, 255);\n" +
                "    text-align: center;\n" +
                "    color: white;\n" +
                "    border-radius: 5px;\n" +
                "}\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <h2 class=\"email-msg-header\">\n" +
                "            Bienvenue  <br>\n" +
                "        </h2>\n" +
                "        <div class=\"company-name\">\n" +
                "           Nabd Al Hayat \n" +
                "        </div>\n" +
                "        <hr>\n" +
                "        <p class=\"welcome-text\">\n" +
                "          Merci pour votre inscription. Pour verifier votre compte veuillez cliquer sur le bouton en dessous\n" +
                "        </p>\n" +
                "        <br><br>\n" +
                "        <center>\n" +
                "            <a href="+url+"' class=\"verify-account-btn\" role=\"button\">Valider</a>\n" +
                "        </center>\n" +
                "\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";

        return emailTemplate;
    }

}
