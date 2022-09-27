package br.com.luisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.luisa.model.Product;
import br.com.luisa.util.ConnectionUtil;

public class ProductDAO {

	public void save(Product product) {

		Connection con = ConnectionUtil.getConnection();

		try {
			PreparedStatement statement = con
					.prepareStatement("insert into product (name,description,price) values(?,?,?)");

			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.setBigDecimal(3, product.getPrice());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
