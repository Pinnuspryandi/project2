package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Reviews extends AppCompatActivity {
    private TextView lblReviewId;
    private TextView lblMemberId;
    private TextView lblLibraryId;
    private TextView lblReviewTittle;
    private TextView lblReviewDesc;
    private Librarysingleton librarysingleton = Librarysingleton.getInstance();
    private Singleton singleton = Singleton.getInstance();
    private ReviewSingleton reviewSingleton = ReviewSingleton.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        lblReviewTittle = findViewById(R.id.lblReviewTittle);
        lblReviewDesc = findViewById(R.id.lblReviewDesc);

        ListView lv = findViewById(R.id.reviewListView);
        ReviewsAdapter ra =new ReviewsAdapter();
        lv.setAdapter(ra);

    }

    public class ReviewsAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return reviewSingleton.getReviewss().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.rowlayout_review,null);
            TextView lblReviewTitle = view.findViewById(R.id.lblReviewTittle);
            TextView lblReviewDesc =view.findViewById(R.id.lblReviewDesc);
            Button bRem =view.findViewById(R.id.bRemove);

            lblReviewTitle.setText(reviewSingleton.getReviewss().get(position).getReviewtittle());
            lblReviewDesc.setText(reviewSingleton.getReviewss().get(position).getReviewDesc());
            bRem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reviewSingleton.getReviewss().remove(position);
                    notifyDataSetChanged();
                }
            });

            return view;
        }
    }
}
