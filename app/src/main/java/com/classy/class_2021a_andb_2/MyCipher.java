package com.classy.class_2021a_andb_2;

import java.util.Random;

import se.simbio.encryption.Encryption;

public class MyCipher {

    public interface CallBack_StringReady {
        public void stringReturned(String message);
    }

    public static void encrypt(final String message, final CallBack_StringReady callBack_stringReady) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(new Random().nextInt(10) * 500);

                    String key = "Cofdfdffd";
                    String salt = "Cofdfdfdfdffgfdgdfdfgd";
                    byte[] iv = new byte[]{-31, 30, -5, -89, -19, 17, -83, 86, 106, -111, 61, -75, -84, 95, 120, -53};
                    Encryption encryption = Encryption.getDefault(key, salt, iv);

                    String encrypted = encryption.encryptOrNull(message);

                    if (callBack_stringReady != null)
                        callBack_stringReady.stringReturned(encrypted);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void decrypt(final String ecryptedMessage, final CallBack_StringReady callBack_stringReady) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(new Random().nextInt(10) * 5);

                    String key = "Cofdfdffd";
                    String salt = "Cofdfdfdfdffgfdgdfdfgd";
                    byte[] iv = new byte[]{-31, 30, -5, -89, -19, 17, -83, 86, 106, -111, 61, -75, -84, 95, 120, -53};
                    Encryption encryption = Encryption.getDefault(key, salt, iv);

                    String decrypted = encryption.decryptOrNull(ecryptedMessage);

                    if (callBack_stringReady != null)
                        callBack_stringReady.stringReturned(decrypted);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static String encrypt(String message) {
        String key = "Cofdfdffd";
        String salt = "Cofdfdfdfdffgfdgdfdfgd";
        byte[] iv = new byte[]{-31, 30, -5, -89, -19, 17, -83, 86, 106, -111, 61, -75, -84, 95, 120, -53};
        Encryption encryption = Encryption.getDefault(key, salt, iv);

        String encrypted = encryption.encryptOrNull(message);
        return encrypted;
    }

    public static String decrypt(String ecryptedMessage) {
        String key = "Cofdfdffd";
        String salt = "Cofdfdfdfdffgfdgdfdfgd";
        byte[] iv = new byte[]{-31, 30, -5, -89, -19, 17, -83, 86, 106, -111, 61, -75, -84, 95, 120, -53};
        Encryption encryption = Encryption.getDefault(key, salt, iv);

        String decrypted = encryption.decryptOrNull(ecryptedMessage);
        return decrypted;
    }

    private static String encLine(String line) {
        char[] arr = line.toCharArray();
        for (int i = 0; i < line.length(); i++) {
            arr[i] += 50 + (i % 2);
        }
        return String.valueOf(arr);
    }

    private static String decLine(String line) {
        char[] arr = line.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= 50 + (i % 2);
        }
        return String.valueOf(arr);
    }
}
