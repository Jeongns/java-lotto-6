package lotto;

public class Error {

    public static <T extends Exception> void assertThrows(Class<T> exceptionClass, String errorMessage) {
        try {
            String message = exceptionClass.getConstructor(String.class).newInstance("[ERROR] " + errorMessage).getMessage();
            System.out.println(message);
        } catch (Exception e) {
            throw new RuntimeException("[ERROR] ", e);
        }
    }
}
