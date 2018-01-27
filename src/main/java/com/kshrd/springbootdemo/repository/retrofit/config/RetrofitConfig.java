package com.kshrd.springbootdemo.repository.retrofit.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

	@Value("${api.base.url:http://localhost:8282}")
	private String API_BASE_URL;
	
	@Bean
    @Autowired
    public Retrofit retrofit(OkHttpClient client) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        return retrofit;
    }
	
	@Bean
    public OkHttpClient client() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        
        return okHttpClientBuilder.addInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request original = chain.request();
				Request request = original.newBuilder()
										  .header("Content-Type", "application/json")
										  .header("Authorization", "Basic dXNlcjoxMjM=")
										  .method(original.method(), original.body()).build();
				return chain.proceed(request);
			}
		}).build();
    }
	
}
