package com.example.jsteam;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class PopUpEditReviewActivity {
    public void popUpEditReview(final View view) {
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
            //TO DO : Update Database Edit Review
            Toast.makeText(view.getContext(), "Review Content Updated", Toast.LENGTH_SHORT).show();
            popupWindow.dismiss();
        });

        popupShow.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            return true;
        });
    }

}