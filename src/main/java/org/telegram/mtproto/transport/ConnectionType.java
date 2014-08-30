package org.telegram.mtproto.transport;

/**
 * Type of connection
 */
public class ConnectionType {
    public static final int TYPE_TCP = 0;

    private int id;
    private String host;
    private int port;
    private int connectionType;

    public ConnectionType(int id, String host, int port, int connectionType) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.connectionType = connectionType;
    }

    /**
     * Unique ID of connection
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Host for connection
     *
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * Port for connection
     *
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * Connection type
     *
     * @return connection type, see {@code TYPE_TCP}
     */
    public int getConnectionType() {
        return connectionType;
    }
}
