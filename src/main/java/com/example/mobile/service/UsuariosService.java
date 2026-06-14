package com.example.mobile.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mobile.entity.Usuarios;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class UsuariosService {

    private static final String COLLECTION = "usuarios";

    public String salvar(Usuarios usuario) throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        if (usuario.getUid() == null || usuario.getUid().isEmpty()) {

            usuario.setCriado_em(LocalDateTime.now());

            DocumentReference docRef =
                    firestore.collection(COLLECTION).document();

            usuario.setUid(docRef.getId());

            docRef.set(usuario).get();

            return docRef.getId();
        }

        firestore.collection(COLLECTION)
                 .document(usuario.getUid())
                 .set(usuario)
                 .get();

        return usuario.getUid();
    }
    public Usuarios buscarPorId(String uid) throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        DocumentSnapshot document =
                firestore.collection(COLLECTION)
                         .document(uid)
                         .get()
                         .get();

        if (document.exists()) {
            return document.toObject(Usuarios.class);
        }

        return null;
    }

    public List<Usuarios> listarTodos() throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future =
                firestore.collection(COLLECTION).get();

        List<QueryDocumentSnapshot> documents =
                future.get().getDocuments();

        List<Usuarios> usuarios = new ArrayList<>();

        for (DocumentSnapshot document : documents) {

            Usuarios usuario =
                    document.toObject(Usuarios.class);

            if (usuario != null) {
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }
    public void excluir(String uid) throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        firestore.collection(COLLECTION)
                 .document(uid)
                 .delete()
                 .get();
    }
}