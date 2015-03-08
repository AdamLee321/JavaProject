package database.operations;

import java.sql.Connection;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductOperations {
    Connection conn;

    public ProductOperations(Connection conn){
        this.conn = conn;
    }
}
