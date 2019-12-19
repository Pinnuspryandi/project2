package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ReviewDB  {
    int LibraryId,reviewid;
    String  memberid,Reviewtittle,ReviewDesc;

    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        LibraryId = libraryId;
    }

    public int getReviewid() {
        return reviewid;
    }

    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }

    public String getMemberid() {
        return memberid;
    }

    public ReviewDB() {
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getReviewtittle() {
        return Reviewtittle;
    }

    public void setReviewtittle(String reviewtittle) {
        Reviewtittle = reviewtittle;
    }

    public String getReviewDesc() {
        return ReviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        ReviewDesc = reviewDesc;
    }

    public ReviewDB(int libraryId, int reviewid, String memberid, String reviewtittle, String reviewDesc) {
        LibraryId = libraryId;
        this.reviewid = reviewid;
        this.memberid = memberid;
        Reviewtittle = reviewtittle;
        ReviewDesc = reviewDesc;
    }
}
