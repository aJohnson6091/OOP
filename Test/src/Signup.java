
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/signup"})
public class Signup extends HttpServlet{
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/plain");
        var pw = resp.getWriter();
        var name = req.getParameter("user");
        var password = req.getParameter("password");
        var realName = req.getParameter("realName");
        User user = new User(name,password,realName);
        if( name == null ){
            pw.printf("No username provided");
        } else if(password == null){
            pw.printf("No passowrd provided");
        }else if(realName == null){
            pw.printf("No real name provided");
        }else {
            if(Main.usernames.contains(name)){
                pw.printf("Username exists");
            }else{
               Main.usernames.add(name);
               Main.users.add(user);
               pw.printf("Account created\n");
               pw.printf("Your username is: "+  name);
               pw.printf("\nYour password is: "+  password);
               pw.printf("\nYour realname is: "+  realName);
               pw.printf("\nThis seems safe.");
               
            }
        }
    }
}
