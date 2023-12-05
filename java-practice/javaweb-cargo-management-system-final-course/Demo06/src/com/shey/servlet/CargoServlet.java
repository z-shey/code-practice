package com.shey.servlet;

import com.shey.entity.Cargo;
import com.shey.entity.User;
import com.shey.service.CargoService;
import com.shey.service.CargoServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
/*
@WebServlet(name = "CargoServlet", value = "/CargoServlet")
public class CargoServlet extends BaseServlet {
    private CargoService cargoService;
    private User userLogined;

    public CargoServlet() {
        this.cargoService = new CargoServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = (User) req.getAttribute("loginUser");
        req.setAttribute("loginUser", loginUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("cargo-manger.jsp");
        dispatcher.forward(req, resp);
    }

    public String cargoManger(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Cargo> cargoList = cargoService.cargoList();
        req.setAttribute("cargoList", cargoList);

        return "forward:cargo-manger.jsp";
    }
}
*/
