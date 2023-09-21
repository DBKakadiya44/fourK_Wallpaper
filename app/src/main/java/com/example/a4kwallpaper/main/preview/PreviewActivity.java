package com.example.a4kwallpaper.main.preview;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.a4kwallpaper.databinding.ActivityPreviewBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class PreviewActivity extends AppCompatActivity {

    ActivityPreviewBinding binding;
    String img = "";
    public static ArrayList Favimage = new ArrayList();
    public static ArrayList Downloadimage = new ArrayList();
    WallpaperManager wallpaperManager;
    int cnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        img = getIntent().getStringExtra("img");

        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher();
        onBackPressedDispatcher.onBackPressed();

        if (!img.equals("")) {
            Picasso.with(PreviewActivity.this)
                    .load(img)
                    .into(binding.ivPreviewFullImage);
            Picasso.with(PreviewActivity.this)
                    .load(img)
                    .into(binding.ivPreviewFullImage2);
        }

        ProgressDialog progressDialog = new ProgressDialog(PreviewActivity.this);
        progressDialog.setMessage("Setting Wallpaper..."); // Set your loading message
        progressDialog.setCancelable(false);

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.ivFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Favimage.contains(img)) {
                    Toast.makeText(PreviewActivity.this, "Already Added in Favourite", Toast.LENGTH_SHORT).show();
                } else {
                    Favimage.add(img);
                    Toast.makeText(PreviewActivity.this, "Add to Favourites...", Toast.LENGTH_SHORT).show();
                }
                onBackPressedDispatcher.onBackPressed();
            }
        });

        binding.ivDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    URL url = new URL(img);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream input = connection.getInputStream();

                        // Create a directory to save the image (optional)
                        File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "4K Wallpaper");
                        if (!directory.exists()) {
                            directory.mkdirs();
                        }

                        Random r = new Random();
                        int randomNumber = r.nextInt();

                        // Create a file to save the image
                        File file = new File(directory, randomNumber + "image.jpg");

                        // Create an output stream to write the image data to the file
                        OutputStream output = new FileOutputStream(file);

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = input.read(buffer)) != -1) {
                            output.write(buffer, 0, bytesRead);
                        }

                        input.close();
                        output.close();

                        // Notify the Android MediaStore
                        MediaScannerConnection.scanFile(
                                PreviewActivity.this,
                                new String[]{file.getAbsolutePath()},
                                new String[]{"image/jpeg"}, // Adjust the MIME type if necessary
                                null
                        );

                        if (Downloadimage.contains(img)) {
                            Toast.makeText(PreviewActivity.this, "Already Downloaded", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PreviewActivity.this, "Image downloaded and saved to gallery", Toast.LENGTH_SHORT).show();
                            Downloadimage.add(img);

                        }
                        // Display a success message or perform other actions as needed
                    } else {
                        // Handle unsuccessful HTTP response
                        // Display an error message to the user
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle exceptions (e.g., network errors, file I/O errors)
                }
                onBackPressedDispatcher.onBackPressed();

            }

        });

        binding.ivSetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cnt == 1) {
                    binding.ivFav.setVisibility(View.INVISIBLE);
                    binding.ivPreview.setVisibility(View.INVISIBLE);
                    binding.ivDownload.setVisibility(View.INVISIBLE);
                    binding.setOptions.setVisibility(View.VISIBLE);
                    binding.ivCancel.setVisibility(View.VISIBLE);
                    cnt = 2;
                } else {
                    binding.ivFav.setVisibility(View.VISIBLE);
                    binding.ivPreview.setVisibility(View.VISIBLE);
                    binding.ivDownload.setVisibility(View.VISIBLE);
                    binding.setOptions.setVisibility(View.INVISIBLE);
                    binding.ivCancel.setVisibility(View.INVISIBLE);
                    cnt = 1;
                }

                binding.llHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        progressDialog.show();

                        Glide.with(PreviewActivity.this)
                                .asBitmap().load(img)
                                .listener(new RequestListener<Bitmap>() {
                                              @Override
                                              public boolean onLoadFailed(GlideException e, Object o, Target<Bitmap> target, boolean b) {
                                                  Toast.makeText(PreviewActivity.this, "Fail to load image..", Toast.LENGTH_SHORT).show();
                                                  return false;
                                              }

                                              @Override
                                              public boolean onResourceReady(Bitmap bitmap, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {

                                                  try {
                                                      wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM);
                                                      progressDialog.setMessage("Wallpaper Set at Home Screen Sucessfully");

                                                      Runnable runnable = new Runnable() {
                                                          @Override
                                                          public void run() {
                                                              progressDialog.dismiss();
                                                              onBackPressed();
                                                          }
                                                      };
                                                      Handler handler = new Handler();
                                                      handler.postDelayed(runnable, 2000);

                                                  } catch (IOException e) {
                                                      Toast.makeText(PreviewActivity.this, "Fail to set wallpaper", Toast.LENGTH_SHORT).show();
                                                      e.printStackTrace();
                                                  }
                                                  return false;
                                              }
                                          }
                                ).submit();

                        onBackPressedDispatcher.hasEnabledCallbacks();

                    }
                });

                binding.llLock.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        progressDialog.show();

                        Glide.with(PreviewActivity.this)
                                .asBitmap().load(img)
                                .listener(new RequestListener<Bitmap>() {
                                              @Override
                                              public boolean onLoadFailed(GlideException e, Object o, Target<Bitmap> target, boolean b) {
                                                  Toast.makeText(PreviewActivity.this, "Fail to load image..", Toast.LENGTH_SHORT).show();
                                                  return false;
                                              }

                                              @Override
                                              public boolean onResourceReady(Bitmap bitmap, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {

                                                  try {
                                                      wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK);
                                                      progressDialog.setMessage("Wallpaper Set at Lock Screen Sucessfully");

                                                      Runnable runnable = new Runnable() {
                                                          @Override
                                                          public void run() {
                                                              progressDialog.dismiss();
                                                              onBackPressed();
                                                          }
                                                      };
                                                      Handler handler = new Handler();
                                                      handler.postDelayed(runnable, 2000);

                                                  } catch (IOException e) {
                                                      Toast.makeText(PreviewActivity.this, "Fail to set wallpaper", Toast.LENGTH_SHORT).show();
                                                      e.printStackTrace();
                                                  }
                                                  return false;
                                              }
                                          }
                                ).submit();

                        onBackPressedDispatcher.hasEnabledCallbacks();

                    }
                });

                binding.llboth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        progressDialog.show();

                        Glide.with(PreviewActivity.this)
                                .asBitmap().load(img)
                                .listener(new RequestListener<Bitmap>() {
                                              @Override
                                              public boolean onLoadFailed(GlideException e, Object o, Target<Bitmap> target, boolean b) {
                                                  Toast.makeText(PreviewActivity.this, "Fail to load image..", Toast.LENGTH_SHORT).show();
                                                  return false;
                                              }

                                              @Override
                                              public boolean onResourceReady(Bitmap bitmap, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {

                                                  try {
                                                      wallpaperManager.setBitmap(bitmap);
                                                      progressDialog.setMessage("Wallpaper Set Sucessfully");

                                                      Runnable runnable = new Runnable() {
                                                          @Override
                                                          public void run() {
                                                              progressDialog.dismiss();
                                                              onBackPressed();
                                                          }
                                                      };
                                                      Handler handler = new Handler();
                                                      handler.postDelayed(runnable, 2000);

                                                  } catch (IOException e) {
                                                      Toast.makeText(PreviewActivity.this, "Fail to set wallpaper", Toast.LENGTH_SHORT).show();
                                                      e.printStackTrace();
                                                  }
                                                  return false;
                                              }
                                          }
                                ).submit();

                        onBackPressedDispatcher.hasEnabledCallbacks();

                    }
                });

            }
        });

        binding.ivPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.ivPreviewFullImage.setVisibility(View.INVISIBLE);
                binding.ivPreviewFullImage2.setVisibility(View.VISIBLE);

                binding.ivFav.setVisibility(View.INVISIBLE);
                binding.ivBack.setVisibility(View.INVISIBLE);
                binding.ivPreview.setVisibility(View.INVISIBLE);
                binding.ivSetWallpaper.setVisibility(View.INVISIBLE);
                binding.ivDownload.setVisibility(View.INVISIBLE);
                binding.ivCancel.setVisibility(View.VISIBLE);
                binding.ivTime.setVisibility(View.VISIBLE);
                binding.ivDate.setVisibility(View.VISIBLE);

                onBackPressedDispatcher.onBackPressed();
            }
        });

        binding.ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.ivPreviewFullImage2.setVisibility(View.INVISIBLE);
                binding.ivPreviewFullImage.setVisibility(View.VISIBLE);

                binding.ivFav.setVisibility(View.VISIBLE);
                binding.ivBack.setVisibility(View.VISIBLE);
                binding.ivPreview.setVisibility(View.VISIBLE);
                binding.ivSetWallpaper.setVisibility(View.VISIBLE);
                binding.ivDownload.setVisibility(View.VISIBLE);
                binding.ivCancel.setVisibility(View.INVISIBLE);
                binding.ivTime.setVisibility(View.INVISIBLE);
                binding.ivDate.setVisibility(View.INVISIBLE);
                binding.setOptions.setVisibility(View.INVISIBLE);

                cnt = 1;

                onBackPressedDispatcher.onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(PreviewActivity.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

}