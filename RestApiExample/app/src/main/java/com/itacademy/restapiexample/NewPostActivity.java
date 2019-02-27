package com.itacademy.restapiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.itacademy.restapiexample.model.Post;
import com.itacademy.restapiexample.repository.PostRepository;

import java.util.List;

public class NewPostActivity extends AppCompatActivity {
    EditText txt_add_title, txt_add_body;
    PostRepository postRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        txt_add_title = findViewById(R.id.tv_add_title);
        txt_add_body = findViewById(R.id.tv_add_body);

        postRepository = new PostRepository();

        postRepository.setListener(new PostRepository.PostListener() {
            @Override
            public void onPostsLoaded(List<Post> data) {
                //No hacer nada
            }

            @Override
            public void onPostCreated(Post data) {
                Toast.makeText(getApplicationContext(), "Nuevo post creado con ID="+data.getId(), Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "Error al crear el nuevo post", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void btnCreatePressed(View view) {
        //Comprobar si los campos se han rellenado
        if (!"".equals(txt_add_body.getText().toString()) && !"".equals(txt_add_title.getText().toString())) {

            //mandamos los dos textos al controlador:
            postRepository.createPost(txt_add_title.getText().toString(), txt_add_body.getText().toString());
        } else {

            //Mostrar error si no se han rellenado los campos:
            Toast.makeText(getApplicationContext(), "Debes rellenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}
