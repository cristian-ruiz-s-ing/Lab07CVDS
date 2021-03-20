/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();

        //Crear el mapper y usarlo:
        
                   
        System.out.println("+++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++");
        System.out.println("1. Consultas CLIENTE:");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("1.1 Consulta de todos los CLIENTEs:");
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
       // System.out.println(cm.consultarClientes()); 
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("1.2 Consulta de CLIENTES ESPECIFICOS:");
        System.out.println(cm.consultarCliente(2154421));
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println(cm.consultarCliente(2154422));
        
        //System.out.println("1.1 INSERT ItemRentadoACliente:");
        //Date fechai = new Date(120, 11, 24);
        //Date fechaf = new Date(120, 11, 25);
        //cm.agregarItemRentadoACliente(2154421,93 , fechai,fechaf);
        //cm.agregarItemRentadoACliente(2154422,92 , fechai,fechaf);


                 
        System.out.println("+++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++");
        System.out.println("Consultas ITEM:");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("1.1 Consulta de todos los ITEMS:");
        ItemMapper im = sqlss.getMapper(ItemMapper.class);
       // System.out.println(im.consultarItems());
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("1.2 Consulta de ITEMS ESPECIFICOS:");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println(im.consultarItem(92));
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println(im.consultarItem(93));
    
        //Date fechal = new Date(120, 11, 24);
        //TipoItem tipo1 = new TipoItem(90, "Aventura");
        //Item it = new Item(tipo1, 92 , "Indiana Jones" , "Pelicula", fechal, 120, "dvd", "Aventura");
        //im.insertarItem(it);
        //TipoItem tipo2 = new TipoItem(91, "Belico");
        //Date fecha2 = new Date(120, 11, 25);
        //Item it1 = new Item(tipo2, 93  , "The pacific" , "serie", fecha2, 140, "dvd", "Belico");
        //im.insertarItem(it1);
        //System.out.println(im.consultarItem(92));
        //System.out.println(im.consultarItem(93));
        
        sqlss.commit();      
        
        sqlss.close();
    }
}
