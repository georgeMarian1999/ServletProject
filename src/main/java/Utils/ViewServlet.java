package Utils;

import Model.TenisPlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private Repository repository;

    public void init() {
        repository = new Repository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='index.html'>Add New Player</a>");
        out.println("<h1>Players List</h1>");

        out.print("in View sunt acum 1");

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Name</th><th>Country</th><th>Age</th><th>Total trophies</th><th>Grand Slam</th><th>EDIT</th><th>DELETE</th></tr>");
        List<TenisPlayer> playersList=repository.readPlayers();
        out.print("in View sunt acum 1.45");
        out.print(playersList);
        for(TenisPlayer tp : playersList){
            out.print("in View sunt acum 2");
            out.print("<tr><td>"+ tp.getName() +"</td><td>"+tp.getCountry()+"</td><td>"+tp.getAge()+"</td><td>"+tp.getTotalTitles()+"<td>"+tp.getGrandSlamTitles()+
                    "</td><td><a href='EditServlet?id="+tp.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+tp.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();

    }
}