package org.telegram.mtproto.pq;

import java.net.Socket;

/**
 * PQ Auth result
 */
public class PqAuth {
    private byte[] authKey;
    private long serverSalt;
    private Socket socket;

    public PqAuth(byte[] authKey, long serverSalt, Socket socket) {
        this.authKey = authKey;
        this.serverSalt = serverSalt;
        this.socket = socket;
    }

    /**
     * Auth key
     *
     * @return auth key
     */
    public byte[] getAuthKey() {
        return authKey;
    }

    /**
     * Server salt
     *
     * @return server salt
     */
    public long getServerSalt() {
        return serverSalt;
    }

    /**
     * Socket
     *
     * @return socket
     */
    public Socket getSocket() {
        return socket;
    }
}
