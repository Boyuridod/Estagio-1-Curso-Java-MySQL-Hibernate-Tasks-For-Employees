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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	List<Task> tasks = dao.findAll();

        req.setAttribute("tasks", tasks);
        
        List<Employee> employees = empdao.findAll();

		req.setAttribute("employees", employees);
		
        req.getRequestDispatcher("tasks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String title = req.getParameter("title");
        String completed = req.getParameter("completed");
        String emp = req.getParameter("employee");

        Task task = new Task();
        task.setTitle(title);
        
        if(completed == null)
        	task.setCompleted(false);
        else {
        	task.setCompleted(true);
        }
        
        System.out.println("EMP = " + emp);
        
        task.setEmployee(empdao.findById(Integer.parseInt(emp)));

        dao.save(task);
        
        resp.sendRedirect("tasks");
    }



}
