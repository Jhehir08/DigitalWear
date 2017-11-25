package com.example.joe.digitalwear.mainscreen;

import com.example.joe.digitalwear.data.network.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainScreenPresenter implements MainScreenContract.Presenter {

    private Retrofit retrofit;
    private MainScreenContract.View view;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void loadPost() {
        retrofit.create(PostService.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        view.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        view.setUpFirebase();
                        view.setUpPosts();
                        view.showPosts(posts);
                    }
                });
    }

    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostList();
    }

}
