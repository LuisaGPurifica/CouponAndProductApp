package br.com.luisa.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import br.com.luisa.dao.CouponDAO;
import br.com.luisa.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO dao = new CouponDAO();

	public CouponController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("create")) {
			create(request, response);
		} else if (action.equals("find")) {
			find(request, response);
		}

	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expiryDate = request.getParameter("expiryDate");

		Coupon coupon = new Coupon();
		coupon.setCode(couponCode);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expiryDate);

		dao.save(coupon);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<b>Product Created!!</b>");
		out.print("<br/><a href='/CouponAndProduct'>Home</a>");
	}

	public void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("couponCode");
		Coupon coupon = dao.findByCode(couponCode);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<b>Coupon details:</b>");
		out.print(coupon);
		out.print("<b><a href='/CouponAndProduct'>Home</a></b>");
	}

}
