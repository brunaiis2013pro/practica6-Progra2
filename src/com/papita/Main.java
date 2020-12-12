package com.papita;

import com.papita.dao.ClienteDao;
import com.papita.dao.CocheDao;
import com.papita.dao.RevisionDao;
import com.papita.model.Cliente;
import com.papita.model.Coche;
import com.papita.model.Revision;
import com.papita.util.ConectorBD;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //Cliente cliente1 = new Cliente("HOBS","PEPE","C","S",4441);
        //Cliente cliente = new Cliente("H20","LOLO","CHINA","Beni",441);

        //Cliente kun = new Cliente("AE0","KUN","CHINA","Beni",441);
        //Cliente chavo = new Cliente("H23","CHAVO","JAPON","LAPAZ",321);
        //Cliente max = new Cliente("H24","MAX","COREA","CBBA",651);
        Cliente goku = new Cliente("33","Goku","Lima","#142",401);
        Cliente krilin = new Cliente("22","Krilin","Paris","#55",586);
        Cliente bulma = new Cliente("11","Bulma","Quito","#2",32);


        //CRUD tabla clientes
        ClienteDao clienteDao = new ClienteDao();
        //CREATE
        //clienteDao.addCliente(kun);
        //clienteDao.addCliente(chavo);
        //clienteDao.addCliente(max);
        clienteDao.addCliente(goku);
        clienteDao.addCliente(krilin);
        clienteDao.addCliente(bulma);
        //READ
        /*
        List<Cliente> clientes= clienteDao.getALLClientes();
        for (int i = 0; i <clientes.size() ; i++) {
            Cliente cliente = clientes.get(i);

            System.out.println(cliente);
        }
       */


        //UPDATE
       // Cliente cliente = new Cliente("H20","Pow","Asia","Bol",221);
        //clienteDao.updateCliente(cliente);

        //DELETE
        //clienteDao.deleteCliente("H20");






        //COCHES
        
        Coche coche1 = new Coche("k20","Epson","Kya","Yellow",321.21,goku);
        Coche coche2 = new Coche("Oso","Kye","Sony","Blue",64.8,krilin);
        Coche coche3 = new Coche("J21","Bull","Rya","Red",21.2,bulma);
        //CRUD tabla clientes
        CocheDao cocheDao = new CocheDao();

        //CREATE
        cocheDao.addCoche(coche1);
        cocheDao.addCoche(coche2);
        cocheDao.addCoche(coche3);
        //READ
        List<Coche> coches= cocheDao.getALLCoches();
        for (int i = 0; i <coches.size() ; i++) {
            Coche coche = coches.get(i);

            System.out.println(coche);
        }
        //UPDATE
        Coche coche = new Coche("Oso","Yia","Lg","Green",221.2,krilin);
        cocheDao.updateCoche(coche);

        //DELETE
        cocheDao.deleteCoche("Oso");





        //REVISIONES
        Revision revision1 = new Revision("K23","Aire","Gasoi","TT21",coche1);
        Revision revision2 = new Revision("921","Escap","Dillman","O21",coche3);

        //CRUD tabla revisiones
        RevisionDao revisionDao = new RevisionDao();

        //CREATE
        revisionDao.addRevision(revision1);
        revisionDao.addRevision(revision2);
        //READ
        List<Revision> revisiones= revisionDao.getALLRevisiones();
        for (int i = 0; i <revisiones.size() ; i++) {
            Revision revision = revisiones.get(i);

            System.out.println(revision);
        }
        //UPDATE
        Revision revision = new Revision("921","Gas","Comun","Black",coche3);
        revisionDao.updateRevision(revision);

        //DELETE
        revisionDao.deleteRevision("921");



    }
}
