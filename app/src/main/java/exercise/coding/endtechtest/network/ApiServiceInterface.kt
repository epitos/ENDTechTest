package example.coding.repositories.api

import exercise.coding.endtechtest.network.model.ProductListingResponse
import exercise.coding.endtechtest.utils.Constants
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceInterface {

    @GET(Constants.GET_PRODUCT_LISTING_ENDPOINT)
    fun getProductListing(): Observable<ProductListingResponse>

    companion object {
        fun create(): ApiServiceInterface {
            val requestInterface = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return requestInterface.create(ApiServiceInterface::class.java)
        }
    }
}