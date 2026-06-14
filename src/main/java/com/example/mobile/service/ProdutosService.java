package com.example.mobile.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mobile.entity.Produtos;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class ProdutosService {

    private static final String COLLECTION = "produtos";

    public String salvar(Produtos produto) throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        if (produto.getId() == null || produto.getId().isEmpty()) {

            produto.setCriado_em(LocalDateTime.now());
            DocumentReference docRef =
                    firestore.collection(COLLECTION).document();
            produto.setId(docRef.getId());
            docRef.set(produto).get();
            return docRef.getId();
        }

        firestore.collection(COLLECTION)
                 .document(produto.getId())
                 .set(produto)
                 .get();
        return produto.getId();
    }

    public Produtos buscarPorId(String id) throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();
        DocumentSnapshot document =
                firestore.collection(COLLECTION)
                         .document(id)
                         .get()
                         .get();

        if (document.exists()) {
            return document.toObject(Produtos.class);
        }
        return null;
    }

    public List<Produtos> listarTodos() throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future =
                firestore.collection(COLLECTION).get();
        List<QueryDocumentSnapshot> documents =
                future.get().getDocuments();

        List<Produtos> produtos = new ArrayList<>();

        for (DocumentSnapshot document : documents) {

            Produtos produto =
                    document.toObject(Produtos.class);
            if (produto != null) {
                produtos.add(produto);
            }
        }
        return produtos;
    }

    public void excluir(String id) throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        firestore.collection(COLLECTION)
                 .document(id)
                 .delete()
                 .get();
    }
}