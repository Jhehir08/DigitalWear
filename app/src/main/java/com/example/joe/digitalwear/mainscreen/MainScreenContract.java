package com.example.joe.digitalwear.mainscreen;

import com.example.joe.digitalwear.data.network.Post;

import java.util.List;

public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
