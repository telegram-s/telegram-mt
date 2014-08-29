package org.telegram.mtproto;

import org.junit.*;

import static org.junit.Assert.*;

import org.telegram.mtproto.pq.Authorizer;
import org.telegram.mtproto.pq.PqAuth;
import org.telegram.mtproto.state.ConnectionInfo;

/**
 * Created by ex3ndr on 29.08.14.
 */
public class MTProtoTest {
    @Test
    public void testAuthKey() {
        Authorizer authorizer = new Authorizer();
        PqAuth auth = authorizer.doAuth(new ConnectionInfo[]{new ConnectionInfo(0, 0, "173.240.5.1", 443)});
        assertNotNull(auth);
    }
}
