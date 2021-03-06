package io.vertx.reactivex.test;

import io.reactivex.Observable;
import io.vertx.core.buffer.Buffer;
import io.vertx.reactivex.ObservableHelper;
import io.vertx.rx.java.test.ReadStreamAdapterTestBase;
import io.vertx.rx.java.test.stream.BufferReadStreamImpl;
import io.vertx.rx.java.test.support.SimpleSubscriber;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ObservableReadStreamAdapterTest extends ReadStreamAdapterTestBase<Buffer, Observable<Buffer>> {

  @Override
  protected Observable<Buffer> toObservable(BufferReadStreamImpl stream) {
    return ObservableHelper.toObservable(stream);
  }

  @Override
  protected Buffer buffer(String s) {
    return Buffer.buffer(s);
  }

  @Override
  protected String string(Buffer buffer) {
    return buffer.toString();
  }

  @Override
  protected void subscribe(Observable<Buffer> obs, SimpleSubscriber<Buffer> sub) {
    TestUtils.subscribe(obs, sub);
  }

  @Override
  protected Observable<Buffer> concat(Observable<Buffer> obs1, Observable<Buffer> obs2) {
    return Observable.concat(obs1, obs2);
  }
}
