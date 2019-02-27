package com.itacademy.restapiexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.itacademy.restapiexample.model.Post;
import com.itacademy.restapiexample.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv_post;
    PostAdapter adapter;
    ArrayList<Post> posts = new ArrayList<Post>();

    PostRepository postRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_post = findViewById(R.id.lv_posts);

        //Creamos nuestro adapter:
        adapter = new PostAdapter(this, R.layout.row, posts);

        //Lo asignamos a nuestro ListView:
        lv_post.setAdapter(adapter);

        /*Instanciar el controlador*/
        postRepository = new PostRepository();
        /*Definir que queremos hacer si la llamada a la API devuelve datos o error*/
        postRepository.setListener(new PostRepository.PostListener() {
            @Override
            public void onPostsLoaded(List<Post> data) {
                posts.clear(); //borrar el contenido de nuestro array
                posts.addAll(data); //Añadir todos los datos a nuestro array
                adapter.notifyDataSetChanged(); //avisar al adapter de que los datos se han modificado para que refresque el ListView
            }

            @Override
            public void onError() {
                //Mostrar un mensaje de error
                Toast.makeText(getApplicationContext(), "Error al acceder a los Posts", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPostCreated(Post data) {
                //Nada
            }
        });

        //Llamamos a la función que devuelve los Posts
        postRepository.getPostList();


    }

    /*Función que se llama al clicar el botón ADD*/
    public void btnAddPressed(View view) {

        Intent intent = new Intent(this, NewPostActivity.class);
        startActivity(intent);
    }
}
