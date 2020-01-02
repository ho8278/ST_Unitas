package com.hyoungwoong.stunitas

import com.hyoungwoong.stunitas.data.DataSourceImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val test = DataSourceImpl()
        test.getImages("금오공과대학교 컴퓨터")
            .subscribe({
                assertNotNull(it.images)
            },{
                assertTrue(false)
            })
    }
}
