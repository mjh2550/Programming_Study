package com.mjh.inflean_kotlin.p2_act.intent

import android.os.Parcel
import android.os.Parcelable

class parcelableClass() : Parcelable {
    var data1 : Int = 0;
    var data2 : String? = "";

    constructor(parcel: Parcel) : this() {
        data1 = parcel.readInt()
        data2 = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(data1)
        parcel.writeString(data2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<parcelableClass> {
        //getParcelableExtra 호출시 함수 호출되는 매서드
        //객체 생성후 parcel에 저장되어있는 데이터 추출해 객체의 변수에 담아준다.
        //그후 객체 반환한다.
        override fun createFromParcel(parcel: Parcel): parcelableClass {
            return parcelableClass(parcel)
        }

        override fun newArray(size: Int): Array<parcelableClass?> {
            return arrayOfNulls(size)
        }
    }


}