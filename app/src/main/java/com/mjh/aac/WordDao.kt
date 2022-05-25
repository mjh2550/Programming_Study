package com.mjh.aac

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    /*@Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): List<Word>*/

    /**
     * Flow는 값의 비동기 시퀀스입니다.
    Flow는 네트워크 요청이나 데이터베이스 호출, 기타 비동기 코드 등의 비동기 작업에서
    값을 생성할 수 있는 값을 한 번에 모두가 아니라 한 번에 하나씩 생성합니다.
    API 전체에서 코루틴을 지원하므로 코루틴을 사용하여 흐름도 변환할 수 있습니다.

    뒷부분에서 Flow를 ViewModel의 LiveData로 변환합니다.
     */

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}

/**
WordDao는 인터페이스입니다. DAO는 인터페이스 또는 추상 클래스여야 합니다.
@Dao 주석은 Room의 DAO 클래스로 식별합니다.
suspend fun insert(word: Word): 한 단어를 삽입하는 정지 함수를 선언합니다.
@Insert 주석은 SQL을 제공하지 않아도 되는 특수 DAO 메서드 주석입니다. 행을 삭제하고 업데이트하는 @Delete 및 @Update 주석도 있지만 이 앱에서는 사용하지 않습니다.
onConflict = OnConflictStrategy.IGNORE: 선택된 onConflict 전략은 이미 목록에 있는 단어와 정확하게 같다면 새 단어를 무시합니다. 사용 가능한 충돌 전략에 관한 자세한 내용은 문서를 참고하세요.
suspend fun deleteAll(): 모든 단어를 삭제하는 정지 함수를 선언합니다.
여러 항목을 삭제하는 편의 주석은 없으므로 일반적인 @Query로 주석 처리됩니다.
@Query("DELETE FROM word_table"): @Query에서는 문자열 매개변수로 SQL 쿼리를 주석에 제공하여 복잡한 읽기 쿼리와 기타 작업을 허용해야 합니다.
fun getAlphabetizedWords(): List<Word>: 모든 단어를 가져와서 Words의 List를 반환하도록 하는 메서드입니다.
@Query("SELECT * FROM word_table ORDER BY word ASC"): 오름차순으로 정렬된 단어 목록을 반환하는 쿼리입니다.
 */