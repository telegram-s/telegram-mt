package org.telegram.mtproto.secure.pq;

import java.math.BigInteger;

/**
 * Solver for pq auth
 */
public class PQSolver {
    private static PQImplementation currentImplementation = new PQLopatin();

    public static void setCurrentImplementation(PQImplementation implementation) {
        currentImplementation = implementation;
    }

    public static BigInteger solvePq(BigInteger src) {
        return new BigInteger("" + currentImplementation.findDivider(src.longValue()));
    }

    private PQSolver() {

    }
}
