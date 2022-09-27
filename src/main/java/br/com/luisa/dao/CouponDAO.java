package br.com.luisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.luisa.model.Coupon;
import br.com.luisa.util.ConnectionUtil;

public class CouponDAO {

	public void save(Coupon coupon) {
		Connection con = ConnectionUtil.getConnection();

		try {
			PreparedStatement statement = con
					.prepareStatement("insert into coupon (code,discount,exp_date) values(?,?,?)");

			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Coupon findByCode(String code) {
		Coupon coupon = new Coupon();
		Connection con = ConnectionUtil.getConnection();

		try {
			PreparedStatement statement = con.prepareStatement("select from * coupon where code=?");
			statement.setString(1, code);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				coupon.setId(resultSet.getInt(1));
				coupon.setCode(resultSet.getString(2));
				coupon.setDiscount(resultSet.getBigDecimal(3));
				coupon.setExpDate(resultSet.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return coupon;
	}

}
