package br.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.EmployeeDAO;
import br.com.model.Employee;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final EmployeeDAO dao = new EmployeeDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Employee> employees = dao.findAll();

		req.setAttribute("employees", employees);

		String idParam = req.getParameter("id");

		if (idParam != null && !idParam.isEmpty()) {
			int id = Integer.parseInt(idParam);

			Employee employee = dao.findById(id);

			req.setAttribute("employee", employee);

			req.setAttribute("active", true);
		} else {
			req.setAttribute("active", false);
		}

		req.getRequestDispatcher("employee.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String action = req.getParameter("action");

		if (action.equals("save")) {

			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String role = req.getParameter("role");

			Employee employee = new Employee(null, firstName, lastName, role);

			dao.save(employee);

		}

		if (action.equals("update")) {

			Integer id = Integer.parseInt(req.getParameter("id"));
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String role = req.getParameter("role");

			Employee employee = new Employee(id, firstName, lastName, role);

			dao.updateEmployee(employee);

		}

		if (action.equals("delete")) {

			Integer id = Integer.parseInt(req.getParameter("id"));

			if (id != null) {
				dao.deleteById(id);
			}

		}

		resp.sendRedirect("employee");

	}
}
