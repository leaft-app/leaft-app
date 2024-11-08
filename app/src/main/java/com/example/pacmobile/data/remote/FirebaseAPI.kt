package com.example.pacmobile.data.remote

import com.google.firebase.firestore.FirebaseFirestore

object FirebaseAPI {
    private val firestoreInstance: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    fun retrieveFirestoreInstance(): FirebaseFirestore {
        return firestoreInstance
    }
}
