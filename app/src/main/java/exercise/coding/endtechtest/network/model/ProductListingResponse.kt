package exercise.coding.endtechtest.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ProductListingResponse (
    @SerializedName("products") val products : List<Product>,
    @SerializedName("title") val title : String,
    @SerializedName("product_count") val product_count : Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Product),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(products)
        parcel.writeString(title)
        parcel.writeInt(product_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductListingResponse> {
        override fun createFromParcel(parcel: Parcel): ProductListingResponse {
            return ProductListingResponse(parcel)
        }

        override fun newArray(size: Int): Array<ProductListingResponse?> {
            return arrayOfNulls(size)
        }
    }
}