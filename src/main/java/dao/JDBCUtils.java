package dao;

import model.ingredients.*;
import model.salads.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    private static JDBCConnectionPool connectionPool;

    public static JDBCConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            Properties props = readProperties("jdbc.properties");
            connectionPool = new JDBCConnectionPool(
                    props.getProperty("jdbc.Driver"),
                    props.getProperty("jdbc.url"),
                    props.getProperty("jdbc.user"),
                    props.getProperty("jdbc.password")
            );
        }

        return connectionPool;
    }

    private static Properties readProperties(String fileResourceName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = JDBCUtils.class.getClassLoader().getResourceAsStream(fileResourceName);
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public static Collection<Salad> getSalads(Connection conn) {
        List<Salad> list = new ArrayList<>();
        String sql = "select * from salads";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");

                try {
                    Class c = Class.forName("model.salads." + type);
                    Salad salad = (Salad) c.newInstance();
                    salad.setId(id);
                    list.add(salad);
                }
                catch (ClassNotFoundException e)
                {
                    Salad salad = new Salad(name);
                    salad.setId(id);
                    list.add(salad);
                }
                catch (InstantiationException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public static void deleteSalads(Connection conn, String[] list)
    {
        String sql = "delete from salads where id = ?";
        PreparedStatement pstm = null;
        if(list != null && list.length > 0) {
            for (String id : list) {
                try {
                    pstm = conn.prepareStatement(sql);
                    pstm.setString(1, id);
                    pstm.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addIngredient(Connection conn, Ingredient ingredient, int id)
    {
        String sql = "insert into ingredients (type, name, caloricity, weight, salad_id) values(?,?,?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, ingredient.getName());
            pstm.setString(2,ingredient.getName());
            pstm.setDouble(3, ingredient.getCaloricity());
            pstm.setDouble(4, ingredient.getWeight());
            pstm.setInt(5,id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static Collection<Ingredient> getIngredients(Connection conn, int id) {
        List<Ingredient> list = new ArrayList<>();
        String sql = "select * from ingredients where salad_id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                String type = rs.getString("type");
                String name = rs.getString("name");
                double caloricity = rs.getDouble("caloricity");
                double weight = rs.getDouble("weight");

                try {
                    Class c = Class.forName("model.ingredients." + type);
                    Ingredient ingredient = (Ingredient)c.newInstance();
                    list.add(ingredient);
                }
                catch (ClassNotFoundException e)
                {
                    Ingredient ingredient = new Ingredient(name, caloricity, weight);
                    list.add(ingredient);
                }
                catch (InstantiationException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
    
}
