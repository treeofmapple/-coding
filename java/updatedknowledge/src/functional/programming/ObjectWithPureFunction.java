package functional.programming;

public class ObjectWithPureFunction {

	private int value = 0;

	public int sum(int a, int b) {
		return a + b;
	}

	public int add(int nextValue) {
		this.value += nextValue;
		return this.value;
	}

	// Higier order function
	public <T> IFactory<T> createFactory(IProducer<T> producer, IConfigurator<T> configurator) {
		return () -> {
			T instance = producer.produce();
			configurator.configure(instance);
			return instance;
		};
	}

}

interface IFactory<T> {
	T create();
}

interface IProducer<T> {
	T produce();
}

interface IConfigurator<T> {
	void configure(T t);
}

interface IClosed<T> {
	public void run();

	public default void doIt() {
		System.out.println("doing it");
	}

	public static void doItStatically() {
		System.out.println("doing it statically");
	}
}