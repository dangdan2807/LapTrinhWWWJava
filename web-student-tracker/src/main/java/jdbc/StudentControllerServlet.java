package jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jdbc.DbUtil.ClassesDbUtil;
import jdbc.DbUtil.StudentDbUtil;
import jdbc.model.Classes;
import jdbc.model.Department;
import jdbc.model.Student;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDbUtil studentDbUtil;
	private ClassesDbUtil classesDbUtil;

	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
			classesDbUtil = new ClassesDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			if (theCommand == null)
				theCommand = "HOME";

			switch (theCommand) {
			case "HOME":
				listClasses(request, response);
				break;
			case "LOAD_LIST_STUDENT":
				listStudents(request, response);
				break;
			case "ADD_STUDERT_PAGE":
				loadAddStudentPage(request, response);
				break;
			case "ADD":
				addStudent(request, response);
				break;
			case "LOAD_STUDENT":
				loadStudent(request, response);
				break;
			case "UPDATE_STUDENT":
				updateStudent(request, response);
				break;
			case "DELETE":
				deleteStudent(request, response);
				break;
			default:
				listStudents(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listClasses(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Classes> classList = classesDbUtil.getClassList();
		request.setAttribute("CLASS_LIST", classList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-classes.jsp");
		dispatcher.forward(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int classId = Integer.parseInt(request.getParameter("classId"));
		
		List<Student> studentList = studentDbUtil.getStudentsByClassId(classId);
		request.setAttribute("STUDENT_LIST", studentList);

		Classes classes = classesDbUtil.getClassById(classId);
		request.setAttribute("CLASS", classes);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

	private void loadAddStudentPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int classId = Integer.parseInt(request.getParameter("classId"));
		request.setAttribute("CLASS_ID", classId);

		List<Classes> classList = classesDbUtil.getClassList();
		request.setAttribute("CLASS_LIST", classList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/add-student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String genderStr = request.getParameter("gender");
		boolean gender = Integer.parseInt(genderStr) > 0;
		String email = request.getParameter("email");
		String imageUrl = request.getParameter("imageUrl");
		String classIdStr = request.getParameter("class");
		int classId = Integer.parseInt(classIdStr);

		if (imageUrl.isEmpty())
			imageUrl = "";

		Classes classes = new Classes(classId);
		Student student = new Student(firstName, lastName, gender, email, imageUrl, classes);

		studentDbUtil.addStudent(student);
		listStudents(request, response);
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
		Student student = studentDbUtil.getStudent(studentId);
		List<Classes> classes = classesDbUtil.getClassList();
		request.setAttribute("THE_STUDENT", student);
		request.setAttribute("CLASS_LIST", classes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String genderStr = request.getParameter("gender");
		boolean gender = Integer.parseInt(genderStr) > 0;
		String email = request.getParameter("email");
		String imageUrl = request.getParameter("imageUrl");
		String classIdStr = request.getParameter("class");
		int classId = Integer.parseInt(classIdStr);

		Classes classes = new Classes(classId);
		Student student = new Student(id, firstName, lastName, gender, email, imageUrl, classes);

		studentDbUtil.updateStudent(student);
		listStudents(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int classId = Integer.parseInt(request.getParameter("classId"));
		
		String theStudentId = request.getParameter("studentId");
		studentDbUtil.deleteStudent(theStudentId);
		
		Classes classes = classesDbUtil.getClassById(classId);
		request.setAttribute("CLASS", classes);
		listStudents(request, response);
	}

}
