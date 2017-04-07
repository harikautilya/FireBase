package com.example.kautilya.firebase.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kautilya.firebase.Data.Modules;
import com.example.kautilya.firebase.GoogleCloud;
import com.example.kautilya.firebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by mahe on 4/2/2017.
 */

public class LoginRecycleAdapter extends RecyclerView.Adapter<LoginRecycleAdapter.ViewHolder> {

    Context context;
    ArrayList<Modules> modulesArrayList;
    private FirebaseAuth mAuth;
    String uname;
    String pword;
    String TAG="LoginRecycleAdapter";

    public LoginRecycleAdapter(Context context, ArrayList<Modules> modulesArrayList) {
        this.context = context;
        this.modulesArrayList = modulesArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        EditText username;
        EditText password;
        TextView apiname;
        ImageView image;
        Button login;
        Button signup;

        public ViewHolder(View itemView) {
            super(itemView);
            mAuth=FirebaseAuth.getInstance();
            apiname=(TextView)itemView.findViewById(R.id.apiname);
            username=(EditText)itemView.findViewById(R.id.email);
            password=(EditText)itemView.findViewById(R.id.password);
            login=(Button)itemView.findViewById(R.id.login);
            image=(ImageView)itemView.findViewById(R.id.image);
            signup=(Button)itemView.findViewById(R.id.singup);
            mAuth=FirebaseAuth.getInstance();
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.login_card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String text= modulesArrayList.get(position).getName();
        uname=holder.username.getText().toString();
        pword=holder.password.getText().toString();
        holder.apiname.setText(text);
        holder.image.setImageBitmap(modulesArrayList.get(position).getImage());
        holder.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=holder.username.getText().toString();
                pword=holder.password.getText().toString();
                if(TextUtils.isEmpty(uname))
                {
                    Toast.makeText(context,"enter username",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (TextUtils.isEmpty(pword))
                    {
                        Toast.makeText(context,"enter password",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        mAuth.signInWithEmailAndPassword(uname,pword)
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        FirebaseException fbe=(FirebaseException)e;
                                        Toast.makeText(context,fbe.getLocalizedMessage().toString(),Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "signInUserWithEmail:onComplete:" + task.isSuccessful());

                                if (task.isSuccessful()) {
                                    Toast.makeText(context, "Authentication success.",
                                            Toast.LENGTH_SHORT).show();
                                    if(modulesArrayList.get(position).getId()==2) {
                                        Intent intent = new Intent(context, GoogleCloud.class);
                                        context.getApplicationContext().startActivity(intent);
                                    }
                                }
                            }
                        });
                    }
                }

            }
        });
        holder.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=holder.username.getText().toString();
                pword=holder.password.getText().toString();
                if(TextUtils.isEmpty(uname))
                {
                    Toast.makeText(context,"enter username",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (TextUtils.isEmpty(pword))
                    {
                        Toast.makeText(context,"enter password",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {


                        mAuth.createUserWithEmailAndPassword(uname, pword)
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        FirebaseException fbe=(FirebaseException)e;
                                        Toast.makeText(context,fbe.getLocalizedMessage().toString(),Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {

                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                        // If sign in fails, display a message to the user. If sign in succeeds
                                        // the auth state listener will be notified and logic to handle the
                                        // signed in user can be handled in the listener.
                                        if (task.isSuccessful()) {
                                            Toast.makeText(context, "Authentication success.",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modulesArrayList.size();
    }


}
