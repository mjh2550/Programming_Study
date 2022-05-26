# 요약

## 앱의 구성요소는 다음과 같습니다.

* MainActivity: RecyclerView와 WordListAdapter를 사용하여 목록에 단어를 표시합니다. MainActivity에는 데이터베이스의 단어를 관찰하고 변경될 때 알림을 받는 Observer가 있습니다.
* NewWordActivity: 새 단어를 목록에 추가합니다.
* WordViewModel: 데이터 영역에 액세스하는 메서드를 제공하고 MainActivity에서 관찰자 관계를 설정할 수 있도록 LiveData를 반환합니다.*
* LiveData<List<Word>>: UI 구성요소에서 자동 업데이트를 가능하게 합니다. flow.toLiveData()를 호출하여 Flow에서 LiveData로 변환할 수 있습니다.
* Repository: 하나 이상의 데이터 소스를 관리합니다. Repository는 ViewModel이 기본 데이터 제공자와 상호작용하는 메서드를 노출합니다. 이 앱에서는 백엔드가 Room 데이터베이스입니다.
* Room: SQLite 데이터베이스의 래퍼이고 이를 구현합니다. Room은 개발자가 직접 해야 했던 많은 작업을 처리합니다.
* DAO: 메서드 호출을 데이터베이스 쿼리에 매핑하므로 저장소가 getAlphabetizedWords()와 같은 메서드를 호출할 때 Room에서 SELECT * FROM word_table ORDER BY word ASC를 실행할 수 있습니다**.**
* DAO는 데이터베이스의 변경사항에 관한 알림을 받으려고 할 때 일회성 요청의 suspend 쿼리와 Flow 쿼리를 노출할 수 있습니다.
* Word: 단일 단어가 포함되는 항목 클래스입니다.
* Views, Activities, Fragments는 ViewModel을 통해서만 데이터와 상호작용합니다. 따라서 데이터의 출처는 중요하지 않습니다.


## 자동 UI 업데이트를 위한 데이터 흐름(반응형 UI)

* LiveData를 사용하고 있으므로 자동 업데이트가 가능합니다. MainActivity에는 데이터베이스에서 단어 LiveData를 관찰하고 변경될 때 알림을 받는 Observer가 있습니다. 변경사항이 있으면 관찰자의 onChange() 메서드가 실행되고 WordListAdapter에서 mWords가 업데이트됩니다.

* 데이터가 LiveData이므로 관찰할 수 있습니다. 관찰되는 것은 WordViewModel allWords 속성에서 반환하는 LiveData<List<Word>>입니다.

* WordViewModel은 UI 레이어에서 백엔드에 관한 모든 것을 숨깁니다. 데이터 영역에 액세스하는 메서드를 제공하고 MainActivity에서 관찰자 관계를 설정할 수 있도록 LiveData를 반환합니다. Views, Activities, Fragments는 ViewModel을 통해서만 데이터와 상호작용합니다. 따라서 데이터의 출처는 중요하지 않습니다.

* 이 경우 데이터의 출처는 Repository입니다. ViewModel은 이 저장소가 상호작용하는 대상을 알 필요가 없습니다. Repository와 상호작용하는 방법만 알면 되며 그 방법은 Repository에서 노출된 메서드를 통해서입니다.

* 저장소는 하나 이상의 데이터 소스를 관리합니다. WordListSample 앱에서는 백엔드가 Room 데이터베이스입니다. Room은 SQLite 데이터베이스의 래퍼이고 이를 구현합니다. Room은 개발자가 직접 해야 했던 많은 작업을 처리합니다. 예를 들어 Room은 개발자가 SQLiteOpenHelper 클래스를 사용하여 했던 모든 작업을 처리합니다.

* DAO는 메서드 호출을 데이터베이스 쿼리에 매핑하므로 저장소가 getAllWords()와 같은 메서드를 호출할 때 Room에서 SELECT * FROM word_table ORDER BY word ASC를 실행할 수 있습니다.

* 쿼리에서 반환된 결과가 관찰된 LiveData이므로 Room의 데이터가 변경될 때마다 Observer 인터페이스의 onChanged() 메서드가 실행되고 UI가 업데이트됩니다.