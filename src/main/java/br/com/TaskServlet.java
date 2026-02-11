package br.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.EmployeeDAO;
import br.com.dao.TaskDAO;
import br.com.model.Employee;
import br.com.model.Task;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final TaskDAO dao = new TaskDAO();
	private final EmployeeDAO empdao = new EmployeeDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Task> tasks = dao.findAll();

		req.setAttribute("tasks", tasks);

		List<Employee> employees = empdao.findAll();

		req.setAttribute("employees", employees);

		req.getRequestDispatcher("tasks.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String save = req.getParameter("save");
		String update = req.getParameter("update");
		String delete = req.getParameter("delete");
				
		if(save != null) {
			String title = req.getParameter("title");
			String completed = req.getParameter("completed");
			String emp = req.getParameter("employee");
			
			Task task = new Task();
			task.setTitle(title);
			
			if (completed == null)
				task.setCompleted(false);
			else {
				task.setCompleted(true);
			}
			
			task.setEmployee(empdao.findById(Integer.parseInt(emp)));
			
			dao.save(task);		
		}
		
		if(update != null) {
			
			Long id = Long.parseLong(update);
			String title = req.getParameter("inputTitle" + id);
			String completed = req.getParameter("inputCompleted" + id);
			String emp = req.getParameter("inputEmployee" + id);
			
			Task task = new Task();
			
			task.setId(id);
			
			task.setTitle(title);
			
			if (completed == "false") {
				task.setCompleted(false);
			}
			else {
				task.setCompleted(true);
			}
			
			task.setEmployee(empdao.findById(Integer.parseInt(emp)));
			
			dao.update(task);
			
		}
		
		if(delete != null) {
			
			Long id = Long.parseLong(delete);
			
			dao.deleteById(id);
			
		}

		resp.sendRedirect("tasks");
	}

}
