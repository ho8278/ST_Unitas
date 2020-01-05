package com.hyoungwoong.stunitas.util

import java.net.SocketTimeoutException
import java.net.UnknownHostException

class CustomException(){
    companion object{
        fun mapException(exception:Throwable):String=
            when(exception){
                is UnknownHostException ->{
                    "네트워크가 연결되어 있는지 확인하세요"
                }
                is SocketTimeoutException ->{
                    "네트워크가 연결되어 있는지 확인하세요"
                }
                else -> "오류가 발생하였습니다."
            }

    }
}