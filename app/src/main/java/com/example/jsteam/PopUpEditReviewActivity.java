package com.example.jsteam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jsteam.model.DatabaseConfiguration;

public class PopUpEditReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_review_popup);
    }

    public void popUpEditReview(final View view, Context context, String username, int index) {
        LayoutInflater inflater = (LayoutInflater) view.getContext()
                .getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupShow = inflater.inflate(R.layout.activity_edit_review_popup, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupShow, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);

        Button buttonEditReviewPopup = popupShow.findViewById(R.id.button_edit_review_popup);

        buttonEditReviewPopup.setOnClickListener(v -> {
            EditText newContent = popupShow.findViewById(R.id.pt_edit_review_pop_up);

            if(!String.valueOf(newContent.getText()).isEmpty()){
                Intent intent = new Intent(context, ReviewSectionActivity.class);

                DatabaseConfiguration.updateDatabaseReviewComment(username, index, String.valueOf(newContent.getText()));
                Toast.makeText(view.getContext(), "Review Content Updated", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();

                intent.putExtra("username", username);
                context.startActivity(intent);
            } else {
                Toast.makeText(view.getContext(), "The content must not be empty!", Toast.LENGTH_SHORT).show();
            }
        });

        popupShow.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            return true;
        });
    }

}