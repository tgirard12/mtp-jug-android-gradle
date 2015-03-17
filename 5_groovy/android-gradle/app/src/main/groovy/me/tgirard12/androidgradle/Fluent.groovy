package me.tgirard12.androidgradle

import android.os.AsyncTask

/**
 * An implementation of {@link android.os.AsyncTask} which makes it easy to deal with
 * requests/callbacks using Groovy closures
 */
public class Fluent<Result, Progress> extends AsyncTask<Object, Progress, Result> {
    private final Closure<Result> request;
    private final ResultConsumer<Result> then;
    private final Closure progress;

    private Fluent(Closure<Result> request, ResultConsumer<Result> then, Closure progress) {
        this.request = request;
        this.then = then;
        this.progress = progress;
    }


    @Override
    protected Result doInBackground(Object... params) {
        return request.call();
    }

    @Override
    protected void onPostExecute(Result result) {
        then.consume(result);
    }

    @Override
    protected void onProgressUpdate(Progress... values) {
        if (progress!=null) {
            progress.call(values);
        }
    }

    public static interface ResultConsumer<T> {
        void consume(T result);
    }

    public static class FluentAsyncTaskBuilder<Result,Progress> {
        Closure<Result> request;
        Closure progress;

        private FluentAsyncTaskBuilder<Result,Progress> from(Closure<Result> request) {
            this.request = request;
            return this;
        }

        FluentAsyncTaskBuilder<Result,?> onProgress(Closure progress) {
            this.progress = progress;
            return this;
        }

        void then(ResultConsumer<Result> then) {
            Fluent<Result,Progress> resultFluent = new Fluent<Result,Progress>(request, then, progress);
            resultFluent.execute();
        }
    }

    public static <Result,Progress> FluentAsyncTaskBuilder<Result,Progress> async(Closure<Result> request) {
        return new FluentAsyncTaskBuilder<Result,Progress>().from(request);
    }
}
