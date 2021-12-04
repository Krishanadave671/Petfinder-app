package com.krishana.petfinderapp.fragment;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telephony.TelephonyCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.krishana.petfinderapp.Adapter.FriendAdapter;
import com.krishana.petfinderapp.Model.Friendmodel;
import com.krishana.petfinderapp.Model.UserModel;
import com.krishana.petfinderapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.grpc.stub.StreamObserver;


public class ProfileFragment extends Fragment {
    RecyclerView recyclerView;
    ImageView coverphoto;
    ImageView coverback;
    ImageView checked;
    ImageView profileImage;
    ArrayList<Friendmodel> list;
    TextView username, proffesion;
    FirebaseStorage Storage;
    FirebaseAuth auth;
    FirebaseFirestore db;
    ActivityResultLauncher<String> gallerylauncher ;
    ActivityResultLauncher<String> prolauncher ;


    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        Storage = FirebaseStorage.getInstance();






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        db.collection("Users").document(auth.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot snapshot) {
                if(snapshot.exists()){
                    UserModel user = snapshot.toObject(UserModel.class);
                    Glide.with(getContext())
                            .load(user.getCover_photo())
                            .placeholder(R.drawable.profileimg)
                            .into(coverback);
                    Glide.with(getContext())
                            .load(user.getProfile_image())
                            .placeholder(R.drawable.profileimg)
                            .into(profileImage);
                    username.setText(snapshot.getString("name"));
                    proffesion.setText(snapshot.getString("Profession"));

                }
            }
        });


        prolauncher =   registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

                profileImage.setImageURI(result);


                final StorageReference reference = Storage.getReference().child("profile_photo").child(auth.getUid());
                reference.putFile(result).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(getContext(), "profile photo saved ", Toast.LENGTH_SHORT).show();
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                              Map <String, Object> user = new HashMap<>();

                                db.collection("Users").document(auth.getCurrentUser().getUid()).set(user, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(getContext(), "data stored on firestore", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }
                        });
                    }
                });
            }


        });

        gallerylauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

                    coverback.setImageURI(result);


                    final StorageReference reference = Storage.getReference().child("cover_photo").child(auth.getUid());
                    reference.putFile(result).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getContext(), "Cover photo saved ", Toast.LENGTH_SHORT).show();
                            reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("cover_photo", uri.toString());
                                    db.collection("Users").document(auth.getCurrentUser().getUid()).set(user, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(getContext(), "data stored on firestore", Toast.LENGTH_SHORT).show();

                                        }
                                    });
                                }
                            });
                        }
                    });
                }


        });


      View view = inflater.inflate(R.layout.fragment_profile, container, false);
      recyclerView = view.findViewById(R.id.friendRV);
      coverphoto = view.findViewById(R.id.changecover);
      coverback = view.findViewById(R.id.coverphoto);
      username  = view.findViewById(R.id.nam);
      proffesion = view.findViewById(R.id.prof);
      checked = view.findViewById(R.id.checked);
      profileImage = view.findViewById(R.id.profile_image);

      list = new ArrayList<>();
      list.add(new Friendmodel(R.drawable.algebra));
      list.add(new Friendmodel(R.drawable.dice));
      list.add(new Friendmodel(R.drawable.statistics));
      list.add(new Friendmodel(R.drawable.geometry_tools));
      list.add(new Friendmodel(R.drawable.matrix));
      list.add(new Friendmodel(R.drawable.summation));
      list.add(new Friendmodel(R.drawable.basic_algebra2));
        FriendAdapter friendAdapter = new FriendAdapter(list,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(friendAdapter);
        coverphoto.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {


                gallerylauncher.launch("image/*");
            }
        });
        checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prolauncher.launch("image/*");
            }
        });






      return view;
    }

}