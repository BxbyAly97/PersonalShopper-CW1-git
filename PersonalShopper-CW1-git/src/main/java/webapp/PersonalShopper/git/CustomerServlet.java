package webapp.PersonalShopper.git;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// Init the import
	private String jdbcURL = "jdbc:mysql://localhost:3306/cust_details";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private static final String INSERT_USERS_SQL = "INSERT INTO cust" + " (name, password, dob, address, email, phone) VALUES " +
	" (?, ?, ?, ? ,?, ?);";
	private static final String SELECT_USER_BY_ID = "select name,password,dob,address,email,phone from cust where name =?";
	private static final String SELECT_ALL_USERS = "select * from cust";
	private static final String DELETE_USERS_SQL = "delete from cust where name = ?;";
	private static final String UPDATE_USERS_SQL = "update cust set name = ?,password= ?,dob =?,address =?, email =?,phone =? where name = ?;";
	
	
	// Setting for Database Connection
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		System.out.println("action is " + action);
		
		try {
			switch (action) {
				case "/CustomerServlet/new":
					showNewForm(request, response);
					break;
				case "/CustomerServlet/edit":
					showEditForm(request, response);
					break;
				case "/CustomerServlet/update":
					updateCust(request, response);
					break;
				default:
					listCust(request, response);
					break;
				}
		} catch (SQLException ex) {
		throw new ServletException(ex);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listCust(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException
	{
		List < Customer > users = new ArrayList < > ();
		
		try (Connection connection = getConnection();
				
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
				System.out.println(preparedStatement);
				
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();
				
				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String name = rs.getString("name");
					String password = rs.getString("password");
					String dob = rs.getString("dob");
					String address = rs.getString("address");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					users.add(new Customer(name, password, dob, address, email, phone));
					System.out.println(name);
				}
				
			} catch (SQLException e) {
				printSQLException(e);
				
			}
		//List < User > listUser = databaseOperations.selectAllUsers();
		
		System.out.println("total user is: " + users.size());
		request.setAttribute("listCust", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("custInfo.jsp");
		dispatcher.forward(request, response);
	}
	
	//method to redirect to register page
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("regPage.jsp");
			dispatcher.forward(request, response);
		}
	
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		System.out.println("comes to showEditForm");
		
		//get parameter passed in the URL
		String name = request.getParameter("name");
		Customer existingUser = new Customer();
		
		//database operation, get data for existing user
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, name);
			System.out.println(preparedStatement);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
			name = rs.getString("name");
			String password = rs.getString("password");
			String dob = rs.getString("dob");
			String address = rs.getString("address");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			existingUser = new Customer(name, password, dob, address, email, phone);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		//Serve up the custEdit.jsp
				request.setAttribute("user", existingUser);
				request.getRequestDispatcher("/custEdit.jsp").forward(request, response);
				
	}
	
	//method to update the user data
		private void updateCust(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException {
		System.out.println("comes to updateCust");
		
			//get values from the request
			String oriName = request.getParameter("oriName");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String dob = request.getParameter("dob");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			System.out.println(name);
			System.out.println(password);
			System.out.println(dob);
			System.out.println(address);
			System.out.println(email);
			System.out.println(phone);
		
			//database operation
			try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
				statement.setString(1, name);
				statement.setString(2, password);
				statement.setString(3, dob);
				statement.setString(4, address);
				statement.setString(5, email);
				statement.setString(6, phone);
				statement.setString(7, oriName);
				
				statement.executeUpdate();
			}
			//redirect us back to CustomerServlet 
			response.sendRedirect("http://localhost:8085//PersonalShopper-CW1-git/CustomerServlet");
			}

	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
