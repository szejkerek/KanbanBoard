/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.pols.lab.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import pl.polsl.lab.model.board.Column;
import pl.polsl.lab.model.board.Task;

/**
 *
 * @author Bartłomiej Gordon - bartgor628@student.polsl.pl
 */
@WebServlet(name = "KanbanServlet", urlPatterns = {"/kanban"})
public class KanbanServlet extends HttpServlet {

    @Override
    public void init() {
    }

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _taskName = request.getParameter("taskName");
        String _taskContent = request.getParameter("taskContent");

        String _columnID = request.getParameter("destination");

        
        PrintWriter out = response.getWriter();
        if (_columnID.equals("toDo")) {
            if (!PersistentData.getInstance().inProgress.contains(_taskName) && !PersistentData.getInstance().done.contains(_taskName)&& !PersistentData.getInstance().toDo.contains(_taskName)) {
                PersistentData.getInstance().toDo.addTask(new Task(_taskName, _taskContent));               
            }
            printTasks(out, PersistentData.getInstance().toDo);

        } else if (_columnID.equals("inProgress")) {
            if (!PersistentData.getInstance().inProgress.contains(_taskName) && !PersistentData.getInstance().done.contains(_taskName)&& !PersistentData.getInstance().toDo.contains(_taskName)) {
                PersistentData.getInstance().inProgress.addTask(new Task(_taskName, _taskContent));              
            }
            printTasks(out, PersistentData.getInstance().inProgress);

        } else if (_columnID.equals("done")) {
            if (!PersistentData.getInstance().inProgress.contains(_taskName) && !PersistentData.getInstance().done.contains(_taskName)&& !PersistentData.getInstance().toDo.contains(_taskName)) {
                PersistentData.getInstance().done.addTask(new Task(_taskName, _taskContent));              
            }
            printTasks(out, PersistentData.getInstance().done);
        } else {
            out.println("<p style='color: red'>Error.</p>");
        }

    }

    protected void processDeleteRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String _taskName = request.getParameter("taskName");
        String _columnID = request.getParameter("destination");
        PrintWriter out = response.getWriter();
        if (_columnID.equals("toDo")) {
            PersistentData.getInstance().toDo.removeTask(_taskName);
            printTasks(out, PersistentData.getInstance().toDo);

        } else if (_columnID.equals("inProgress")) {
            PersistentData.getInstance().inProgress.removeTask(_taskName);
            printTasks(out, PersistentData.getInstance().inProgress);

        } else if (_columnID.equals("done")) {
            PersistentData.getInstance().done.removeTask(_taskName);
            printTasks(out, PersistentData.getInstance().done);

        }

    }

    protected void processPutRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String _taskName = request.getParameter("taskName");
        String _taskContent = request.getParameter("taskContent");

        PrintWriter out = response.getWriter();
        if (_taskName == null || _taskContent == null || _taskName.length() == 0 || _taskContent.length() == 0) {
            printTasks(out, PersistentData.getInstance().toDo);
            out.println("<p style='color: red'>All fields have to be filled.</p>");
        } else {

            if (!PersistentData.getInstance().toDo.contains(_taskName) && !PersistentData.getInstance().inProgress.contains(_taskName) && !PersistentData.getInstance().done.contains(_taskName)) {
                Task task = new Task(_taskName, _taskContent);
                PersistentData.getInstance().toDo.addTask(task);
                try {
                    printTasks(out, PersistentData.getInstance().toDo);

                } catch (Exception ex) {
                    printTasks(out, PersistentData.getInstance().toDo);
                    out.println("<p style='color: red'>All fields have to be filled.</p>");
                }
            } else {
                    printTasks(out, PersistentData.getInstance().toDo);
                    out.println("<p style='color: red'>You can't add same task twice!.</p>");
            }

        }

    }

    void printTasks(PrintWriter out, Column column) {
        for (var temp : column.getTasks()) {
            out.println("<tr>");

            out.println("<td>");
            out.println(temp.getTaskName());
            out.println("</td>");

            out.println("<td>");
            out.println(temp.getContent());
            out.println("</td>");

            if (column.getColumnName().equals("toDo")) {
                out.println("<td>");
                out.println("<input type=\"button\" id=\"removeBtn\" value=\"Remove\" onClick=\"removeTask(\'" + temp.getTaskName() + "\', 'toDo');\">");
                out.println("<input type=\"button\" id=\"moveRight\" value=\"Move Right\" onClick=\"removeTask(\'" + temp.getTaskName() + "\', 'toDo'); insertTask(\'" + temp.getTaskName() + "\',\'" + temp.getTaskContent() + "\', 'inProgress'); \">");
                out.println("</td>");

            } else if (column.getColumnName().equals("inProgress")) {
                out.println("<td>");
                out.println("<input type=\"button\" id=\"removeBtn\" value=\"Remove\" onClick=\"removeTask(\'" + temp.getTaskName() + "\', 'inProgress');\">");
                out.println("<input type=\"button\" id=\"moveRight\" value=\"Move Right\" onClick=\"removeTask(\'" + temp.getTaskName() + "\', 'inProgress'); insertTask(\'" + temp.getTaskName() + "\',\'" + temp.getTaskContent() + "\', 'done'); \">");
                out.println("<input type=\"button\" id=\"moveLeft\" value=\"Move Left\" onClick=\"removeTask(\'" + temp.getTaskName() + "\', 'inProgress'); insertTask(\'" + temp.getTaskName() + "\',\'" + temp.getTaskContent() + "\', 'toDo'); \">");
                out.println("</td>");

            } else if (column.getColumnName().equals("done")) {
                out.println("<td>");
                out.println("<input type=\"button\" id=\"removeBtn\" value=\"Remove\" onClick=\"removeTask(\'" + temp.getTaskName() + "\', 'done');\">");
                out.println("<input type=\"button\" id=\"moveLeft\" value=\"Move Left\" onClick=\"removeTask(\'" + temp.getTaskName() + "\', 'done'); insertTask(\'" + temp.getTaskName() + "\',\'" + temp.getTaskContent() + "\', 'inProgress'); \">");
                out.println("</td>");

            }

            out.println("</tr>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processGetRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processPostRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processDeleteRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processPutRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
