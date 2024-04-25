package com.mmc.app.platform.service;

import java.io.IOException;
import java.util.List;

import com.mmc.app.platform.outbound.Post;
import com.mmc.app.platform.utils.RetrofitUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;


@Service
public class PostServiceImpl implements PostService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);
	
	private Retrofit retrofit;
	private PostApi postApi;
	
	public PostServiceImpl() {
		retrofit = RetrofitUtil.getRetrofitInstance();
		postApi = retrofit.create(PostApi.class);
	}

	@Override
	public Post fetchPosts() {
		Post postResponse = null;
		Call<Post> fetchPostCall= postApi.fetchPosts();
		try {
			Response<Post> response = fetchPostCall.execute();
			if(response.isSuccessful() && response.body()!=null) {
				postResponse = response.body();
				LOGGER.info("Response from 3rd party api: {} ", response.body());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return postResponse;
	}

}
