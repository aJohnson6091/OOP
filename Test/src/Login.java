import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/plain");
        var pw = resp.getWriter();
        var name = req.getParameter("user");
        var password = req.getParameter("password");
        User flag = null;
        if( name == null || !Main.usernames.contains(name)){
            pw.printf("No valid username provided");
        } else if(password == null){
            pw.printf("No passowrd provided");
        } else {
            for(User user: Main.users){
                if(name.equals(user.name) && password.equals(user.password)){
                    flag= user;                   
                }  
            }
            if(flag == null){
                pw.printf("\nBad password provided");
            }else{
                var sess = req.getSession();
                sess.setAttribute("name", flag.name );
                sess.setAttribute("realname", flag.realName);
                pw.printf("UserName: "+flag.name);
                pw.printf("\nReal Name: "+flag.realName);
            }
            
        }
    }

}
