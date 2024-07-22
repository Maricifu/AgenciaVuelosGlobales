package com.vuelos.User.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.vuelos.User.domain.entity.Permission;
import config.DatabaseConfig;

public class PermissionRepository {

    public Set<Permission> findPermissionsByRoleId(Long roleId) {
        String sql = "SELECT p.id, p.name FROM permissions p JOIN roles_permissions rp ON p.id = rp.permission_id WHERE rp.role_id = ?";
        Set<Permission> permissions = new HashSet<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, roleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Permission permission = new Permission();
                    permission.setId(resultSet.getLong("id"));
                    permission.setName(resultSet.getString("name"));
                    permissions.add(permission);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return permissions;
    }
}
