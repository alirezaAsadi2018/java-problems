package ir.javacup.traffic;

import java.util.List;

public class Context<T, I> {
    private Observable<T> observable;
    private Transformer<T, I> transformer;

    public Context<T,I> observable(Observable<T> observable) {
        this.observable = observable;
        return this;
    }

    public Context<T,I> subscriber(Subscriber<T> subscriber) {
        observable.subscribe(subscriber);
        return this;
    }

    public Context<T,I> transformer(Transformer<T, I> transformer) {
        this.transformer = transformer;
        return this;
    }

    public void run(List<I> list) {
        for (I i : list) {
            T transformed = transformer.transform(i);
            observable.push(transformed);
        }
    }
}
