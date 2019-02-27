package com.itacademy.restapiexample.repository;


import com.itacademy.restapiexample.model.Post;
import com.itacademy.restapiexample.rest.MyService;
import com.itacademy.restapiexample.rest.RetrofitInstance;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* Esta clase contiene todas las llamadas de extracción de datos
 * Utiliza un listener para avisar a la activity de que ha recibido los datos o hay error.
 *
 * */

public class PostRepository {
    MyService service = RetrofitInstance.getRetrofitInstance().create(MyService.class);
    private static List<Post> posts = new ArrayList<Post>();
    private PostListener listener;


    public void getPostList() {
        Call<List<Post>> call = service.listPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                listener.onPostsLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                listener.onError();
            }
        });

    }

    public void createPost(String title, String body) {
        //Crear un post con el titulo y body que tenemos:
        Post p = new Post(title, body);

        //Llamar a la API para crearlo
        Call<Post> call = service.savePost(p);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                listener.onPostCreated(response.body());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                listener.onError();
            }
        });

    }

    public void setListener(PostRepository.PostListener listener) {
        this.listener = listener;
    }

    public interface PostListener {

        public void onPostsLoaded(List<Post> data);

        public void onError();

        public void onPostCreated(Post data);
    }
}
