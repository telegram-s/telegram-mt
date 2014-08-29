package org.telegram.mtproto;

import org.junit.*;

import static org.junit.Assert.*;

import org.telegram.mtproto.pq.Authorizer;
import org.telegram.mtproto.pq.PqAuth;
import org.telegram.mtproto.state.ConnectionInfo;
import org.telegram.mtproto.state.MemoryProtoState;
import org.telegram.tl.TLMethod;
import org.telegram.tl.TLObject;

/**
 * Created by ex3ndr on 29.08.14.
 */
public class MTProtoTest {

    private static final ConnectionInfo[] CONNECTION_INFOS = new ConnectionInfo[]{
            new ConnectionInfo(0, 0, "173.240.5.1", 443)
    };

    private PqAuth auth;

    @Before
    public void initAuth() {
        Authorizer authorizer = new Authorizer();
        auth = authorizer.doAuth(CONNECTION_INFOS);
    }

    @Test
    public void testAuthKey() {
        Authorizer authorizer = new Authorizer();
        PqAuth auth = authorizer.doAuth(CONNECTION_INFOS);
        assertNotNull(auth);
    }

    @Test(timeout = 15000)
    public void testPing() {


        MTProto proto = new MTProto(new MemoryProtoState(auth.getAuthKey(), "173.240.5.1", 443), new MTProtoCallback() {
            @Override
            public void onSessionCreated(MTProto proto) {

            }

            @Override
            public void onAuthInvalidated(MTProto proto) {

            }

            @Override
            public void onApiMessage(byte[] message, MTProto proto) {

            }

            @Override
            public void onRpcResult(int callId, byte[] response, MTProto proto) {

            }

            @Override
            public void onRpcError(int callId, int errorCode, String message, MTProto proto) {

            }

            @Override
            public void onConfirmed(int callId) {

            }
        }, new CallWrapper() {
            @Override
            public TLObject wrapObject(TLMethod srcRequest) {
                return srcRequest;
            }
        }, 1, MTProto.MODE_GENERAL);
        final Object lock = new Object();
        final Boolean[] res = new Boolean[1];

        proto.ping(0, 15000, new PingCallback() {
            @Override
            public void onPingSuccess(long id) {
                synchronized (lock) {
                    res[0] = true;
                    lock.notifyAll();
                }
            }

            @Override
            public void onPingTimeout(long id) {

            }
        });

        synchronized (lock) {
            if (res[0] != null && res[0]) {
                return;
            }
            try {
                lock.wait();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
