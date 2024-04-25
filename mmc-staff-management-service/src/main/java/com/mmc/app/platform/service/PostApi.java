package com.mmc.app.platform.service;

import com.mmc.app.platform.outbound.Post;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;


public interface PostApi {

	@GET("/posts/1")	
	Call<Post> fetchPosts();
}
