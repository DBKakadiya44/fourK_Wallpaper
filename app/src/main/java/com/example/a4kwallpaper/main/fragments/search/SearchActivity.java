package com.example.a4kwallpaper.main.fragments.search;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4kwallpaper.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        binding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int keyAction, KeyEvent keyEvent) {
//                if (
//                    //Soft keyboard search
//                        keyAction == EditorInfo.IME_ACTION_SEARCH ||
//                                //Physical keyboard enter key
//                                (keyEvent != null && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode()
//                                        && keyEvent.getAction() == KeyEvent.ACTION_DOWN)) {
//                    new SearchForEquipmentTask(false, viewHolder.mTextSearch
//                            .getQuery().toString()).execute();
//                    return true;
//                }
//                return false;
//            }
//        });

        binding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Toast.makeText(SearchActivity.this, ""+binding.editText.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}