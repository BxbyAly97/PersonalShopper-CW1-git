package webapp.PersonalShopper.git;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("userName");
		String p = request.getParameter("password");
		String d = request.getParameter("dob");
		String h = request.getParameter("address");
		String e = request.getParameter("email");
		String c = request.getParameter("phone");
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/cust_details", "root", "");
		PreparedStatement ps = con
		.prepareStatement("insert into cust values(?,?,?,?,?,?)");
		ps.setString(1, n);
		ps.setString(2, p);
		ps.setString(3, d);
		ps.setString(4, h);
		ps.setString(5, e);
		ps.setString(6, c);
		int i = ps.executeUpdate();
		if (i > 0)
			out.print("You are successfully registered...");
		} catch (Exception e2) {
			System.out.println(e2);
		}
		out.close();
	}
}


