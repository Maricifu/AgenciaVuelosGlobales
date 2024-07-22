package com.vuelos.User.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.vuelos.User.domain.entity.Role;
import config.DatabaseConfig;

public class RoleRepository {

    public Set<Role> findRolesByUserId(Long userId) {
        String sql = "SELECT r.id, r.name FROM roles r JOIN users_roles ur ON r.id = ur.role_id WHERE ur.user_id = ?";
        Set<Role> roles = new HashSet<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Role role = new Role();
                    role.setId(resultSet.getLong("id"));
                    role.setName(resultSet.getString("name"));
                    roles.add(role);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }
}
