package itutube.models;

/**
 * A method that supplies a type of object and throws an exception type.
 * This is very much like a normal Supplier, but allows for it to throw checked exceptions.
 * @param <ReturnType> The type of object to return.
 * @param <ExceptionType> The type of exception that can be thrown.
 */
@FunctionalInterface
public interface CheckedSupplier<ReturnType, ExceptionType extends Exception> {
    ReturnType get() throws ExceptionType;
}