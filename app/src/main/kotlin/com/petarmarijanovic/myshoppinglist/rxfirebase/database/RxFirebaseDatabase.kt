package com.petarmarijanovic.myshoppinglist.rxfirebase.database

import android.support.annotation.CheckResult
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query
import com.petarmarijanovic.myshoppinglist.rxfirebase.database.observables.QueryChangesOnSubscribe
import com.petarmarijanovic.myshoppinglist.rxfirebase.database.observables.RemoveValueOnSubscribe
import com.petarmarijanovic.myshoppinglist.rxfirebase.database.observables.SetValueOnSubscribe
import io.reactivex.Completable
import io.reactivex.Observable

/** Created by petar on 09/07/2017. */
@CheckResult
fun <T> setValue(ref: DatabaseReference, value: T): Completable =
    Completable.create(SetValueOnSubscribe(
        ref,
        value))

@CheckResult
fun observe(query: Query): Observable<DataSnapshot> =
    Observable.create(QueryChangesOnSubscribe(
        query))

@CheckResult
fun remove(ref: DatabaseReference): Completable = Completable.create(RemoveValueOnSubscribe(
    ref))
