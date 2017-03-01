package com.example.savi.auth.modules.alluser.operation;

import com.example.savi.auth.constant.Constants;
import com.example.savi.auth.operation.BaseOperation;
import com.example.savi.auth.pojo.User;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class GetAllUserOperation extends BaseOperation {

    public interface OnGetAllUserListener{
        void onUserAdded(User user);
        void onUserUpdated(User user);
        void onUserRemoved(User user);
        void onCancelled(FirebaseError error);
    }

    public int limit = 2;
    public int count = 0;
    public GetAllUserOperation(final OnGetAllUserListener listener){
        Firebase fireBaseRef =  new Firebase(Constants.TODOCLOUD_ROOT_FIREBASE_URL + Constants.USER_DETAIL);
        fireBaseRef.orderByPriority().limitToFirst(limit).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String key) {
             if(isEmpty(dataSnapshot)||listener==null)return;
                User user = dataSnapshot.getValue(User.class);
                if (count++ == limit - 1) {
                    user.setLast(true);
                    count=0;
                }
                listener.onUserAdded(user);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String key) {
                if(isEmpty(dataSnapshot)||listener==null)return;
                listener.onUserUpdated(dataSnapshot.getValue(User.class));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                if(isEmpty(dataSnapshot)||listener==null)return;
                listener.onUserRemoved(dataSnapshot.getValue(User.class));
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                if(listener!=null)listener.onCancelled(firebaseError);
            }
        });
    }
}
