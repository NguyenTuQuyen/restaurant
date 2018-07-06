package vn.a3dbuilder.quyennguyen.restaurant.Main;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.InputStream;

import vn.a3dbuilder.quyennguyen.restaurant.Account.AccountMain;
import vn.a3dbuilder.quyennguyen.restaurant.Login.ProfileCallbackInterface;

public class Storage {
    private static Storage storage;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageRef;
    private Storage() {
        firebaseStorage = FirebaseStorage.getInstance();
        storageRef = firebaseStorage.getReference();
    }
    public static Storage initStorage() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }
    public void uploadImageToStorage(Uri file) {
        if (file != null) {

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference ref = storage.getReference().child("images/");
            ref.putFile(file)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {


                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            //set to progress bar

                        }
                    });
        }
    }

    public void downloadImageFromStorage(String path, final String imageName, final ProfileCallbackInterface profileCallback) {
        storageRef.child(path).getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

                if (imageName.equals("avatar")) {
                    profileCallback.setAvatar(bitmap);
                }
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                if (imageName.equals("avatar")) {
                    profileCallback.setAvatar(null);
                }
            }
        });
    }
}
