package Utils;

import Model.TenisPlayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    private final Repository repository = new Repository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

//        String id = request.getParameter("id");
        String name=request.getParameter("name");
        String country=request.getParameter("country");
        String age=request.getParameter("age");
        String totaltrophies=request.getParameter("totaltrophies");
        String grandSlam=request.getParameter("grandslam");

        TenisPlayer tenisPlayer=new TenisPlayer();
//        tenisPlayer.setId(Integer.parseInt(id));
        tenisPlayer.setName(name);
        tenisPlayer.setCountry(country);
        tenisPlayer.setAge(Integer.parseInt(age));
        tenisPlayer.setTotalTitles(Integer.parseInt(totaltrophies));
        tenisPlayer.setGrandSlamTitles(Integer.parseInt(grandSlam));

        int status = 0;
        try {
            status = repository.savePlayer(tenisPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(status == 0){
            out.print("<p>Player saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }else{
            out.println("Sorry! unable to save player");
        }
        out.close();
    }

}