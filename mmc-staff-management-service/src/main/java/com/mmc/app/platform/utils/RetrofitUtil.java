package com.mmc.app.platform.utils;


import com.mmc.app.platform.constants.StaffServiceConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
	
	private static Retrofit retrofit;
	
	public static Retrofit getRetrofitInstance() {
		
		if(retrofit == null) {
			retrofit =new Retrofit.Builder()
					.baseUrl(StaffServiceConstants.RETROFIT_BASE_URL)
					.addConverterFactory(GsonConverterFactory.create()).build();
		}
		return retrofit;
		
	}

}
