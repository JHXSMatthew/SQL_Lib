package com.mcndsj.JHXSMatthew.Shared;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class LobbyManager {


    public static LobbyManager databaseManager;

    private BoneCP connectionPool;

    public LobbyManager(){
        try {
            // load the database driver (make sure this is in your classpath!)
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        try {
            // setup the connection pool using BoneCP Configuration
            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl("jdbc:mysql://"+ Config.host+ "/"+Config.lobbydatabase);
            config.setUsername(Config.lobby_user);
            config.setPassword(Config.lobby_password);
            config.setMinConnectionsPerPartition(5);
            config.setMaxConnectionsPerPartition(10);
            config.setPartitionCount(1);
            config.setMaxConnectionAge(3600, TimeUnit.SECONDS);
            // setup the connection pool
            connectionPool = new BoneCP(config);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }


    public static LobbyManager getInstance() {
        if(databaseManager == null)
            databaseManager = new LobbyManager();
        return databaseManager;
    }

    public Connection getConnection() throws SQLException {
        return this.connectionPool.getConnection();
    }

}
