package com.open.myrxjavause.rxjava_basic_mode;

public class ObservableCreate <T>  extends Observable{


    ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        observer.onSubscribe();
        //核心逻辑
        CreateEmitter createEmitter = new CreateEmitter(observer);
        source.subscribe(createEmitter);
    }


    /**
     * 发射器的实现类
     */
    static final class CreateEmitter<T> implements Emitter<T>{

        final Observer<T> observer;

        public CreateEmitter(Observer<T> observer){
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }

        @Override
        public void onError(Throwable e) {
            observer.onError(e);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }
    }
}
