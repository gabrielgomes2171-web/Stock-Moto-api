package com.example.mobile.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mobile.entity.Orcamentos;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class OrcamentosService {

    private static final String COLLECTION = "orcamentos";

    public String salvar(Orcamentos orcamento) throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        if (orcamento.getId() == null || orcamento.getId().isEmpty()) {
            orcamento.setCriado_em(LocalDateTime.now());

            DocumentReference docRef =
                    firestore.collection(COLLECTION).document();
            orcamento.setId(docRef.getId());
            docRef.set(orcamento).get();
            return docRef.getId();
        }
        firestore.collection(COLLECTION)
                 .document(orcamento.getId())
                 .set(orcamento)
                 .get();
        return orcamento.getId();
    }
    public Orcamentos buscarPorId(String id) throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();
        DocumentSnapshot document =
                firestore.collection(COLLECTION)
                         .document(id)
                         .get()
                         .get();
        if (document.exists()) {
            return document.toObject(Orcamentos.class);
        }
        return null;
    }

    public List<Orcamentos> listarTodos() throws Exception {

        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future =
                firestore.collection(COLLECTION).get();

        List<QueryDocumentSnapshot> documents =
                future.get().getDocuments();

        List<Orcamentos> orcamentos = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            Orcamentos orcamento =
                    document.toObject(Orcamentos.class);
            if (orcamento != null) {
                orcamentos.add(orcamento);
            }
        }
        return orcamentos;
    }

    public void excluir(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        firestore.collection(COLLECTION)
                 .document(id)
                 .delete()
                 .get();
    }
}