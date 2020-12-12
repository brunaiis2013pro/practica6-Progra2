package com.papita.dao;

import com.papita.model.Revision;
import com.papita.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevisionDao {
    private Connection connection;

    public RevisionDao() {
        connection = ConectorBD.getConnection();
    }

    public void addRevision(Revision revision){
        try{


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO revisiones (codigo, filtro, aceite, frenos) VALUES (?, ?, ?, ?)"

            );
            preparedStatement.setString(1, revision.getCodigo());
            preparedStatement.setString(2, revision.getFiltro());
            preparedStatement.setString(3, revision.getAceite());
            preparedStatement.setString(4, revision.getFrenos());

            preparedStatement.executeUpdate();

            System.out.println(revision + "realizada");
        } catch (SQLException e){
            System.out.println("Error al realizar la revision: "+ e.getMessage());
        }
    }

    public void updateRevision(Revision revision){
        try{


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE revisiones SET codigo=?, filtro=?, aceite=?, frenos=? WHERE codigo=?"

            );
            preparedStatement.setString(1, revision.getCodigo());
            preparedStatement.setString(2, revision.getFiltro());
            preparedStatement.setString(3, revision.getAceite());
            preparedStatement.setString(4, revision.getFrenos());

            preparedStatement.setString(5, revision.getCodigo());
            preparedStatement.executeUpdate();

            System.out.println(revision + "editada");
        } catch (SQLException e){
            System.out.println("Error al editar la revision: "+ e.getMessage());
        }
    }

    public void deleteRevision(String codigo){
        try{


            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM revisiones WHERE codigo=?"

            );
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();

            System.out.println(codigo + "eliminado");
        } catch (SQLException e){
            System.out.println("Error al eliminar la revision: "+ e.getMessage());
        }
    }

    public List<Revision> getALLRevisiones(){
        List<Revision> revisiones = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM revisiones");
            while(resultSet.next()){
                Revision revision = new Revision();
                revision.setCodigo(resultSet.getString("codigo"));
                revision.setFiltro(resultSet.getString("filtro"));
                revision.setAceite(resultSet.getString("aceite"));
                revision.setFrenos(resultSet.getString("frenos"));


                revisiones.add(revision);
            }


        }catch (SQLException e){
            System.out.println("Error al listar las revisiones: "+ e.getMessage());
        }
        return revisiones;
    }
}
