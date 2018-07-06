package vn.a3dbuilder.quyennguyen.restaurant.Account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import vn.a3dbuilder.quyennguyen.restaurant.Login.DataBase;
import vn.a3dbuilder.quyennguyen.restaurant.Login.ProfileCallbackInterface;
import vn.a3dbuilder.quyennguyen.restaurant.Login.User;
import vn.a3dbuilder.quyennguyen.restaurant.Main.RoundImage;
import vn.a3dbuilder.quyennguyen.restaurant.Main.Storage;
import vn.a3dbuilder.quyennguyen.restaurant.R;
import vn.a3dbuilder.quyennguyen.restaurant.databinding.AccountMainBinding;



/**
 * Created by HV on 5/30/2018.
 */

public class AccountMain extends AppCompatActivity {
    private AccountMainBinding binding;
    private User profile;
    private DataBase database;
    private Storage storage;
    private ProfileCallbackInterface callback;
    private final int RESULT_LOAD_IMAGE = 0;
    private ProgressDialog progressDialog;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            initProfileCallbackMethods();
            database = DataBase.initDataBase();

            FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();
            database.getCurrentProfile(callback, auth.getUid());

        binding = DataBindingUtil.setContentView(this, R.layout.account_main);
        //ItemBookmarkList itemBookmarkList = new ItemBookmarkList(list.get(0), "Đẹp nhất VN", 12,150,"restaurant_photo_bookmark");
        ArrayList<ItemAccountList> list = new ArrayList<>();
        list.add(new ItemAccountList("Khach san Huong Lan", 150, R.drawable.restaurant_photo_account, 10));
        list.add(new ItemAccountList("Khach san Huong Lai", 200, R.drawable.restaurant_photo_account,9));
        list.add(new ItemAccountList("Khach san Huong Buoi", 300, R.drawable.restaurant_photo_account, 8));
        list.add(new ItemAccountList("Khach san Huong Oi", 120, R.drawable.restaurant_photo_account, 7));
        list.add(new ItemAccountList("Khach san Huong Chanh", 50, R.drawable.restaurant_photo_account, 6));
        list.add(new ItemAccountList("Khach san Huong Sunlight", 200, R.drawable.restaurant_photo_account, 5));
        list.add(new ItemAccountList("Khach san Huong Hoa Hong", 150, R.drawable.restaurant_photo_account,8));
        list.add(new ItemAccountList("Khach san Huong Thom", 150, R.drawable.restaurant_photo_account,5));

        ItemAccount adapter = new ItemAccount(list);
        binding.recyclerView3.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false );
        binding.recyclerView3.setLayoutManager(linearLayoutManager);

        binding.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choseImageFromMedia(RESULT_LOAD_IMAGE);
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void choseImageFromMedia(final int loadImage) {
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, loadImage);
    }

    private void initProfileCallbackMethods() {
        callback = new ProfileCallbackInterface() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void responseProfile(User prf) {
                profile = prf;
                storage = Storage.initStorage();
                File avatarImage = new File(Environment.getExternalStorageDirectory().getPath() + "/avatar");

                if ( !(avatarImage.exists())) {
                    storage.downloadImageFromStorage(profile.avata, "avatar", callback);
                } else {
                    Bitmap avatarBitmap = BitmapFactory.decodeFile(avatarImage.getAbsolutePath());
                    callback.setAvatar(avatarBitmap);

                }

                binding.textView20.setText(profile.name);
                binding.textView23.setText(profile.email);
                binding.textView24.setText(profile.location);

            }

            @Override
            public void changeImage(String path, String imageName) {
                if (imageName == "avatar") {
                    database.changeProfileAvatar(path);
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)


            @Override
            public void setAvatar(Bitmap imageBitmap) {
                if (imageBitmap != null) {

                        File file = new File(Environment.getExternalStorageDirectory().getPath() + "avatar");
                        if (file.exists()) {
                            file.delete();
                        }
                        try {
                            file.createNewFile();
                            FileOutputStream ostream = new FileOutputStream(file);
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                            ostream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    imageBitmap = quadraticImage(imageBitmap);
                    RoundImage roundedImage = new RoundImage(imageBitmap);
                    binding.imageView6.setImageDrawable(roundedImage);
                } else {
                    binding.imageView6.setImageResource(R.drawable.ic_menu_camera);
                }
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        progressDialog = new ProgressDialog(getApplicationContext());
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String path = getRealPathFromURI(selectedImage);

            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            storage.uploadImageToStorage(Uri.parse(path));
            Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();


        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String thePath = "no-path-found";
        String[] filePathColumn = {MediaStore.Images.Media.DISPLAY_NAME};
        Cursor cursor = this.getParent().getContentResolver().query(contentURI, filePathColumn, null, null, null);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            thePath = cursor.getString(columnIndex);
        }
        cursor.close();
        return thePath;
    }
    private Bitmap quadraticImage(Bitmap bitmap) {
        if (bitmap.getWidth() >= bitmap.getHeight()) {
            bitmap = Bitmap.createBitmap(
                    bitmap,
                    bitmap.getWidth() / 2 - bitmap.getHeight() / 2,
                    0,
                    bitmap.getHeight(),
                    bitmap.getHeight());
        } else {
            bitmap = Bitmap.createBitmap(
                    bitmap,
                    0,
                    bitmap.getHeight() / 2 - bitmap.getWidth() / 2,
                    bitmap.getWidth(),
                    bitmap.getWidth());
        }
        return bitmap;
    }


}
