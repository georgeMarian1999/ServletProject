package Utils;

import Model.TenisPlayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private Repository repository = new Repository();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String country=request.getParameter("country");
        String age=request.getParameter("age");
        String totaltrophies=request.getParameter("totaltrophies");
        String grandSlam=request.getParameter("grandslam");

        TenisPlayer tenisPlayer=new TenisPlayer();
        tenisPlayer.setName(name);
        tenisPlayer.setCountry(country);
        tenisPlayer.setAge(Integer.parseInt(age));
        tenisPlayer.setTotalTitles(Integer.parseInt(totaltrophies));
        tenisPlayer.setGrandSlamTitles(Integer.parseInt(grandSlam));

        try {
            repository.deletePlayer(tenisPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("ViewServlet");
    }
}