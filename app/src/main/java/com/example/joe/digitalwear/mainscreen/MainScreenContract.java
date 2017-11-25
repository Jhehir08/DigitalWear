package com.example.joe.digitalwear.mainscreen;

import com.example.joe.digitalwear.data.network.Post;

import java.util.List;

public interface MainScreenContract {
    interface View {
        // show methods
        void showPosts(List<Post> posts);
        void showError(String message);
        void showComplete();

        // set up methods
        void setUpPosts();
        void setUpFirebase();

        void writeToFirebase(String value);
        void readFromFirebase();
    }

    interface Presenter {
        void loadPost();
    }
}
