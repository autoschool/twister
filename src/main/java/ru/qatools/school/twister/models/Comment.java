package ru.qatools.school.twister.models;

import java.sql.Timestamp;

import org.javalite.activejdbc.Model;

public class Comment extends Model {
	
	public int getPost() {
        return getInteger("post_id");
    }

    public void setPost(int fPostId) {
        setInteger("post_id", fPostId);
    }

    public String getBody() {
        return getString("body");
    }

    public void setBody(String fBody) {
        setString("body", fBody);
    }

    public Timestamp getUpdatedAt() {
        return getTimestamp("updated_at");
    }

    public Timestamp getCreatedAt() {
        return getTimestamp("created_at");
    }
}
