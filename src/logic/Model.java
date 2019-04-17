package logic;

import data.Dao;

/*
 * @author alefa
 */
public class Model {

    private Dao db;
    private static Model uniqueInstance;

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }

        return uniqueInstance;
    }

    private Model() {
        db = new Dao();
    }

    public Dao getDb() {
        return db;
    }
}
