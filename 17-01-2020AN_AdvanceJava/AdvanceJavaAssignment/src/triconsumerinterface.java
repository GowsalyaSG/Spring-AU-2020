
@FunctionalInterface
public interface triconsumerinterface<T,U,V> {
	void accept(T t, U u, V v);
}