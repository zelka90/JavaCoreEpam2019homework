package homework20191223.storage;

public final class IdGenerator {

    private IdGenerator() {
    }

    private static Long id = 0L;

    public static Long generateId() {
        return ++id;
    }
}
