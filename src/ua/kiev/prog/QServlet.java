package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.StringBuilder;
import java.lang.String;
public class QServlet extends HttpServlet {

     static final String TEMPLATE = "<html>" +
            "<head><title>Anketa</title></head>" +
            "<body>%s</body></html>";

    final int[] results = new int[4];

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        StringBuilder res = new StringBuilder();
         String name = req.getParameter("username");
        String surname = req.getParameter("usersurname");
         String age = req.getParameter("selectage");
         String q1 = req.getParameter("question1");
         String q2 = req.getParameter("question2");

         if (name.isEmpty() || surname.isEmpty() || age.isEmpty() ||
                 q1.isEmpty() || q2.isEmpty()){
             res.append("Заполните все поля!!!");
             resp.getWriter().println(String.format(TEMPLATE, res.toString()));
         } else {
             StringBuilder resuser = new StringBuilder();
             resuser.append(name);
             resuser.append(" ");
             resuser.append(surname);


             res.append("<table>");
             res.append("<tr>");
             res.append("<td>");
             res.append("Пользователь");
             res.append("</td>");
             res.append("<td>");
             res.append("Возраст пользователя");
             res.append("</td>");
             res.append("<td>");
             res.append("Замужем/Женат?");
             res.append("</td>");
             res.append("<td>");
             res.append("Есть ли дети?");
             res.append("</td>");
             res.append("</tr>");
             res.append("<tr>");
             res.append("<td>");
             res.append(resuser);
             res.append("</td>");
             res.append("<td>");
             res.append(age);
             res.append("</td>");
             res.append("<td>");
             res.append(q1);
             res.append("</td>");
             res.append("<td>");
             res.append(q2);
             res.append("</td>");
             res.append("</tr>");
             res.append("</table>");
             resp.getWriter().println(String.format(TEMPLATE, res.toString()));
         }
    }
}
