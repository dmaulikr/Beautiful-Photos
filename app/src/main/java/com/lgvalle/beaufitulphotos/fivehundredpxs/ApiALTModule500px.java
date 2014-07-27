package com.lgvalle.beaufitulphotos.fivehundredpxs;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by lgvalle on 21/07/14.
 *
 * Retrofit api module.
 * Builds a rest client based on api interface description
 */
public class ApiALTModule500px {
	private static final String END_POINT = "https://api.500px.com/v1";
	private static final String CONSUMER_KEY_PARAM = "consumer_key";
	private static final String CONSUMER_KEY_VALUE = "B2VtIGTPFrbg1YXUVujHhKIo5I9lVjBxgPIFk7A4";
	private static final ApiService500px service;

	static {
		// Interceptor to append consumer key on every request
		RequestInterceptor requestInterceptor = new RequestInterceptor() {
			@Override
			public void intercept(RequestFacade request) {
				request.addQueryParam(CONSUMER_KEY_PARAM, CONSUMER_KEY_VALUE);
			}
		};





		// Configure an adapter for this client
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(END_POINT)
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setRequestInterceptor(requestInterceptor)
				.build();

		// Create rest client
		service = restAdapter.create(ApiService500px.class);
	}

	/**
	 * Hide constructor
	 */
	private ApiALTModule500px() {}

	/**
	 * Expose rest client
	 */
	public static ApiService500px getService() {
		return service;
	}

}