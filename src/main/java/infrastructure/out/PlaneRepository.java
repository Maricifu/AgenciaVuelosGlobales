package infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import domain.entity.Plane;
import domain.service.PlaneService;
import infrastructure.config.DatabaseConfig;

public class PlaneRepository implements PlaneService {

    @Override
    public void createPlane(Plane plane) {
        String sql = "INSERT INTO planes (plates, capacity, fabricationDate, statusId, modelId, airlineId) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, plane.getPlates());
            statement.setInt(2, plane.getCapacity());
            statement.setDate(3, Date.valueOf(plane.getFabricationDate()));
            statement.setInt(4, plane.getStatusId());
            statement.setInt(5, plane.getModelId());
            statement.setInt(6, plane.getAirlineId());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    plane.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Plane findPlaneById(Long id) {
        String sql = "SELECT id, plates, capacity, fabricationDate, statusId, modelId, airlineId FROM planes WHERE id = ?";
        Plane plane = null;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    plane = new Plane();
                    plane.setId(resultSet.getInt("id"));
                    plane.setPlates(resultSet.getString("plates"));
                    plane.setCapacity(resultSet.getInt("capacity"));
                    plane.setFabricationDate(resultSet.getDate("fabricationDate").toLocalDate());
                    plane.setStatusId(resultSet.getInt("statusId"));
                    plane.setModelId(resultSet.getInt("modelId"));
                    plane.setAirlineId(resultSet.getInt("airlineId"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plane;
    }

    @Override
    public void updatePlane(Plane plane) {
        String sql = "UPDATE planes SET plates = ?, capacity = ?, fabricationDate = ?, statusId = ?, modelId = ?, airlineId = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, plane.getPlates());
            statement.setInt(2, plane.getCapacity());
            statement.setDate(3, Date.valueOf(plane.getFabricationDate()));
            statement.setInt(4, plane.getStatusId());
            statement.setInt(5, plane.getModelId());
            statement.setInt(6, plane.getAirlineId());
            statement.setInt(7, plane.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlane(Long id) {
        String sql = "DELETE FROM planes WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Plane> findAllPlanes() {
        List<Plane> planes = new ArrayList<>();
        String sql = "SELECT id, plates, capacity, fabricationDate, statusId, modelId, airlineId FROM planes";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Plane plane = new Plane();
                plane.setId(resultSet.getInt("id"));
                plane.setPlates(resultSet.getString("plates"));
                plane.setCapacity(resultSet.getInt("capacity"));
                plane.setFabricationDate(resultSet.getDate("fabricationDate").toLocalDate());
                plane.setStatusId(resultSet.getInt("statusId"));
                plane.setModelId(resultSet.getInt("modelId"));
                plane.setAirlineId(resultSet.getInt("airlineId"));
                planes.add(plane);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planes;
    }
}
