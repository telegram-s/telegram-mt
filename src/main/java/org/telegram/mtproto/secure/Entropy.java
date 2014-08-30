package org.telegram.mtproto.secure;

import java.security.SecureRandom;

import static org.telegram.mtproto.secure.CryptoUtils.xor;

/**
 * Random number generation
 */
public final class Entropy {
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generating random seed
     *
     * @param size size of seed
     * @return random seed
     */
    public static byte[] generateSeed(int size) {
        synchronized (random) {
            return random.generateSeed(size);
        }
    }

    /**
     * Generating random xored seed
     *
     * @param sourceSeed source seed
     * @return randomized seed
     */
    public static byte[] generateSeed(byte[] sourceSeed) {
        synchronized (random) {
            return xor(random.generateSeed(sourceSeed.length), sourceSeed);
        }
    }

    /**
     * Generating random id
     *
     * @return random id
     */
    public static long generateRandomId() {
        synchronized (random) {
            return random.nextLong();
        }
    }

    /**
     * Generating random int
     *
     * @return random int
     */
    public static int randomInt() {
        synchronized (random) {
            return random.nextInt();
        }
    }

    /**
     * Feeding entropy by random data
     *
     * @param data random data
     */
    public static void feedEntropy(byte[] data) {
        synchronized (random) {
            random.setSeed(data);
        }
    }
}
